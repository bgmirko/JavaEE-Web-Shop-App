/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ArtikliGrp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


/**
 *
 * @author Mirko
 */
@Stateless
public class ArtikliGrpFacade extends AbstractFacade<ArtikliGrp> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtikliGrpFacade() {
        super(ArtikliGrp.class);
        System.out.println("Artikli Grp Facade prolazak");
    }
    
}
