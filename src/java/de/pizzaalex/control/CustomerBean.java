
package de.pizzaalex.control;

import de.pizzaalex.db.DaoCustomer;
import de.pizzaalex.model.Customer;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author AWagner
 */
public class CustomerBean implements Serializable {
    private ArrayList<Customer> customers;

    public CustomerBean() {
        customers = new ArrayList();
        DaoCustomer daoC = new DaoCustomer();
        customers.addAll(daoC.readCustomers());
    }

   
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    
    public Customer getCustById(int id){
        Customer found = null;
        
        for (Customer cus:customers) {
            if (cus.getId() == id) {
                found = cus;
                //System.out.println("Kunde gefunden: " + cus.id + " " + found.id);
            } 
        }
        return found;
    }
    
 
     
    public void addCustomer(Customer cus) {
        
        DaoCustomer dc = new DaoCustomer();
        dc.storeContact(cus);
        customers.add(cus);
    }
}
