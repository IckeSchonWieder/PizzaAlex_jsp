
package de.pizzaalex.control;

import de.pizzaalex.db.DaoOrder;
import de.pizzaalex.model.Order;
import de.pizzaalex.model.Pizza;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AWagner
 */
public class OrderBean implements Serializable {
    private Order order;

    public OrderBean() {
        order = new Order();
        DaoOrder dao = new DaoOrder();
    }

   
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
     
    public void addOrder(Order ord) {
        DaoOrder dao = new DaoOrder();
        dao.storeOrder(ord);
    }
    
   
    public void setIpAndSession(HttpServletRequest req) {
        order.setIpAddr(req.getRemoteAddr());
        order.setSessId(req.getSession().getId());
    }
    
     
    /**
     * Changes the quantity of specified pizza on the cart. Count can also be 
     * negative to remove a pizza. If count is smaller than old count, the pizza
     * item is completely removed from hashmap.
     * @param pizza Specifies the pizza which shall be added/removed
     * @param count Count of added/removed items. Positive value means adding, 
     * negative value means removing
     */
    public void addPizza(Pizza pizza, int count) {
        Integer countold = order.getPizzas().get(pizza);
        if (countold == null) {countold = 0;}       
        
        if (count + countold > 0) {
            order.getPizzas().put(pizza, countold+count); 
            order.total += pizza.getPrice() * count;
        } else {
            order.getPizzas().remove(pizza);
            order.total -= pizza.getPrice() * countold;
        }
        
    }
    
    public void respSenden(HttpServletResponse resp, String url) {
        try {
            resp.sendRedirect(url);
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
