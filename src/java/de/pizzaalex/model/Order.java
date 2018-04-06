
package de.pizzaalex.model;
import java.util.HashMap;


/**
 *
 * @author AWagner
 */
public class Order {
    public int id;
    public static int count = 0;
    public HashMap<Pizza, Integer> pizzas;
    public Customer cus;
    public String ipAddr;
    public String sessId;
    public double total;
    
    
    public Order(Customer cus) {
        this.id = ++count;
        this.pizzas = new HashMap<>();
        this.cus = cus;
        this.sessId = "";
        this.ipAddr = "";
        this.total = 0;
    }

    public Order() {
        this.id = ++count;
        this.pizzas = new HashMap<>();
        this.sessId = "";
        this.ipAddr = "";
        this.total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Pizza, Integer> getPizzas() {
        return pizzas;
    }

    public void setPizzas(HashMap<Pizza, Integer> pizzas) {
        this.pizzas = pizzas;
    }

    
    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }
    
      
      
    @Override
    public String toString() {
        String res = "";
        for (Pizza p:pizzas.keySet()) {
            res+= pizzas.get(p) + " mal " + p.toString() + "\n\r";
        }
        
        return res;
    }
    
    
}
