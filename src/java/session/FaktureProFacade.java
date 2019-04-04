/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.FakturePro;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class FaktureProFacade extends AbstractFacade<FakturePro> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaktureProFacade() {
        super(FakturePro.class);
    }
    
//    @RolesAllowed("prodavnicaDeloviAdmini")
    public FakturePro findByStranka(Object stranka){
        return (FakturePro)em.createNamedQuery("FakturePro.findByStranka").setParameter("idstr", stranka).getSingleResult();
    }
    
}
