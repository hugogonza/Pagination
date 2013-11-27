/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author HugoCésar
 */
@Stateless
public class ProductManager {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Product> selectProducts(int from, int count) {
        TypedQuery<Product> q = em.createNamedQuery("Product.selectAll", Product.class);
        q.setFirstResult(from);
        q.setMaxResults(count);
        
        return q.getResultList();
        
    }
}
