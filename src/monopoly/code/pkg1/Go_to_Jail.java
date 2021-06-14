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
public class Go_to_Jail extends Unpurchaseable {

   
    public Go_to_Jail(int id, String name) {
        super(id, name);
    }
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
       Jail jail = new Jail();
        p[turn].change_location(9);
        p[turn].setJail(true);
        
        jail.action(p, b, a, turn, num_players, dice);
    }

}