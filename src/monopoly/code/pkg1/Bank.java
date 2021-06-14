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
public class Bank {

    public Bank() {
    }

    private int money;

    private int total_properties;

    
    private int[] properties;


    public void Add_Money(int n) {
       
        money=money+n;
    }

    
    public void Take_Money(int n) {
       
    money=money-n;
    }

}
