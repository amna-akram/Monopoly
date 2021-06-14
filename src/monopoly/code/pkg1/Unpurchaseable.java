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
public abstract class Unpurchaseable extends Area {

    public Unpurchaseable(int id, String name) {
        super(id, name);
    }

    
    
    public abstract void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice);

}
