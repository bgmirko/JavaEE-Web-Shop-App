/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PlacanjaU;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class PlacanjaUFacade extends AbstractFacade<PlacanjaU> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlacanjaUFacade() {
        super(PlacanjaU.class);
    }
    
}
