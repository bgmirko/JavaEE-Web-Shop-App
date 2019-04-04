/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.Artikli;
import entity.FakstavkePro;
import entity.FakstavkeProPK;
import entity.FakturePro;
import entity.Preduzece;
import entity.Stranke;
import entity.StrankeGrp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderManager {

    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;
    @Resource
    private SessionContext context;
    @EJB
    private ArtikliFacade artikliFacade;
    @EJB
    private FaktureProFacade faktureProFacade;
    @EJB
    private FakstavkeProFacade fakstavkeProFacade;
    @EJB
    private PreduzeceFacade preduzeceFacade;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int placeOrder(String name, String email, String phone, String address, String city, String country, ShoppingCart cart) {
        try {
            Stranke stranka = addCustomer(name, email, phone, address, city, country);
            FakturePro fakturaPro = addFakturu(stranka, cart);
            addFakStavkeProdaje(fakturaPro, cart);
            return fakturaPro.getId();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("GRESK greska Greska GRESKA");
            context.setRollbackOnly();
            return 0;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Stranke addCustomer(String name, String email, String phone, String address, String city, String country) {
        Stranke stranka = new Stranke();
        stranka.setOsoba(name);
        stranka.setKomentar(email);
        stranka.setTel1(phone);
        stranka.setAdresa(address);
        stranka.setGrad(city);
        stranka.setDrzava(country);

        em.persist(stranka);
        return stranka;
    }

    private FakturePro addFakturu(Stranke stranka, ShoppingCart cart) {

        FakturePro faktura = new FakturePro();

        faktura.setIdstr(stranka);

        Preduzece preduzece = preduzeceFacade.find(1);

        Random random = new Random();
        int i = random.nextInt(999999999);

        faktura.setUneo("Sajt");
        faktura.setValutnavaluta("eur");

        faktura.setIdpred(preduzece);
        // faktura na danasnji datum
        faktura.setDatum(new Date());

        faktura.setFakturisano("N");
        faktura.setStorno("N");

        // podesava datum na '0000-00-00 00:00:00'
        Date uneoDatum = new Date();
        uneoDatum.setTime(0);
        faktura.setUneoDatum(uneoDatum);

        Date valuta = new Date();
        valuta.setTime(0);
        faktura.setValuta(valuta);

        faktura.setValutnavaluta("eur");
        faktura.setIdmag(1);
        faktura.setKurs(1);
        faktura.setKomentar(Integer.toString(i));
        faktura.setVrednost(Double.valueOf(cart.getSubtotal()));

        em.persist(faktura);
        return faktura;
    }

    private void addFakStavkeProdaje(FakturePro faktura, ShoppingCart cart) {

        em.flush();
        List<ShoppingCartItem> items = cart.getItems();

//        Collection<FakstavkePro> fakStavkeColl = faktura.getFakstavkeProCollection();
            
       List<FakstavkePro> fakStavkeColl;
        fakStavkeColl = new ArrayList();
               
      

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

            Artikli artikal = scItem.getProduct();

            FakstavkePro fakstavkePro = new FakstavkePro();
            // set up primary key object
            FakstavkeProPK orderedProductPK = new FakstavkeProPK();

            orderedProductPK.setIdfak(faktura.getId());

            //  orderedProductPK.setProductId(productId);
            orderedProductPK.setIdart(artikal.getId());

            // create ordered item using PK object
            //    FakstavkePro orderedItem = new FakstavkePro(orderedProductPK);
            fakstavkePro.setFakstavkeProPK(orderedProductPK);
            fakstavkePro.setKolicina(scItem.getQuantity());
            fakstavkePro.setCena(artikal.getCena() * scItem.getQuantity());
            fakstavkePro.setNabavna(0);
            fakstavkePro.setCenaStr(0);
            fakstavkePro.setPdv(0);

            fakStavkeColl.add(fakstavkePro);

            Artikli artikalPorucen = artikliFacade.find(artikal.getId());
            Collection<FakstavkePro> artikalFakstvkePro = artikalPorucen.getFakstavkeProCollection();
            artikalFakstvkePro.add(fakstavkePro);
            artikalPorucen.setFakstavkeProCollection(fakStavkeColl);
            em.persist(artikalPorucen);

            fakstavkePro.setFakturePro(faktura);
            fakstavkePro.setArtikli(artikalPorucen);
            em.persist(fakstavkePro);

        }

        em.flush();
        em.persist(faktura);

    }

    public Map getOrderDetails(int orderId) {

        Map orderMap = new HashMap();

        FakturePro faktura;
        faktura = faktureProFacade.find(orderId);

        // get customer
        Stranke stranka = faktura.getIdstr();

        // get all ordered products
        Collection<FakstavkePro> fakStavkePro = faktura.getFakstavkeProCollection();
        List<FakstavkePro> fakstavkePro;
        fakstavkePro = new ArrayList(fakStavkePro);
     //   FakstavkePro p = fakstavkePro.get(1);
        //      p.getArtikli().get
        // get product details for ordered items
        List<Artikli> products = new ArrayList<Artikli>();

        for (FakstavkePro fp : fakstavkePro) {

            Artikli a = (Artikli) artikliFacade.find(fp.getArtikli().getId());
            products.add(a);
        }

        // add each item to orderMap
        orderMap.put("orderRecord", faktura);
        orderMap.put("customer", stranka);
        orderMap.put("orderedProducts", fakstavkePro);
        orderMap.put("products", products);

        return orderMap;
    }
}
