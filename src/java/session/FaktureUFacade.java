/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.FaktureU;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class FaktureUFacade extends AbstractFacade<FaktureU> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FaktureUFacade() {
        super(FaktureU.class);
    }
    
}
