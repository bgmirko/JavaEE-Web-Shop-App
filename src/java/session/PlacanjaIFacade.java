/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.PlacanjaI;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class PlacanjaIFacade extends AbstractFacade<PlacanjaI> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlacanjaIFacade() {
        super(PlacanjaI.class);
    }
    
}
