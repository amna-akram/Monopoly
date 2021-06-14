/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

/**
 *
 * @author Admin
 */
public class Card {

    
    public Card() {
    }

    
    private String name_card;

    private int amount;

    private int location;

    public void Add_Money(Bank[] b, Player[] p) {
        
        System.out.println(" Money is added");
    }

    
    public void Subtract_Money(Bank[] b, Player[] p) {
        
        System.out.println(" Money is deducted");
    }

    
    public void Change_Location(Player[] p) {
        System.out.println("Locatiom is changed");
    }

    
    public void Set_Location(int g) {
        System.out.println("Location is set");
    }

}