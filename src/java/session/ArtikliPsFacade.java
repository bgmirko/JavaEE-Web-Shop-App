/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.ArtikliPs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mirko
 */
@Stateless
public class ArtikliPsFacade extends AbstractFacade<ArtikliPs> {
    @PersistenceContext(unitName = "FotoDeloviProdavnicaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtikliPsFacade() {
        super(ArtikliPs.class);
    }
    
}
