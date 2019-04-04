/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.StrankeCen;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class StrankeCenFacade extends AbstractFacade<StrankeCen> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StrankeCenFacade() {
        super(StrankeCen.class);
    }
    
}
