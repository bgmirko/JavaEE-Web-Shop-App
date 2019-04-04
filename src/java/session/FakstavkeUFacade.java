/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.FakstavkeU;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class FakstavkeUFacade extends AbstractFacade<FakstavkeU> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FakstavkeUFacade() {
        super(FakstavkeU.class);
    }
    
}
