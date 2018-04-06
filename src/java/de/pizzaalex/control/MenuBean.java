
package de.pizzaalex.control;

import de.pizzaalex.db.DaoPizza_AW;
import de.pizzaalex.model.Pizza;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author AWagner
 */
public class MenuBean implements Serializable{
    private ArrayList<Pizza> menuList;
    
    public MenuBean() {
        menuList = new ArrayList<>();
        createMenu();
        
    /*    menuList.add(new Pizza("Margharita", 4.99));
        menuList.add(new Pizza("Salame", 5.99));
        menuList.add(new Pizza("Funghi", 5.99));
        menuList.add(new Pizza("Hawaii", 6.49));
        menuList.add(new Pizza("Speciale", 6.49));
        menuList.add(new Pizza("Quattre Stagione", 6.79));
        menuList.add(new Pizza("ConTutti de Alex", 7.79));
    */ 
    }

    public void createMenu(){
        DaoPizza_AW daoP = new DaoPizza_AW();
        menuList.addAll(daoP.readMenu());
    }
    
    public ArrayList<Pizza> getMenuList() {
        return menuList;
    }

    
    public void setMenuList(ArrayList<Pizza> menuList) {
        this.menuList = menuList;
    }
    
    
    
    
}
