/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.FakstavkeI;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class FakstavkeIFacade extends AbstractFacade<FakstavkeI> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FakstavkeIFacade() {
        super(FakstavkeI.class);
    }
    
}
