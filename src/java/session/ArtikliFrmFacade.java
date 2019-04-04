/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ArtikliFrm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class ArtikliFrmFacade extends AbstractFacade<ArtikliFrm> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtikliFrmFacade() {
        super(ArtikliFrm.class);
    }
    
}
