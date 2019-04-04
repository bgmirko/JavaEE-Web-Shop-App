/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.StrankePs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class StrankePsFacade extends AbstractFacade<StrankePs> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StrankePsFacade() {
        super(StrankePs.class);
    }
    
}
