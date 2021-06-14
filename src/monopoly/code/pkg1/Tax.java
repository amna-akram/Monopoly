/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

/**
 *
 * @author ronstevens83
 */
public class Tax extends Unpurchaseable{
    private int deductable_money;
    public Tax(int id, String name){
        super(id, name);
        deductable_money = 100;
    }

    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
         Game.field.setText("Tax of Rs 100 detected");
        p[turn].sub_money(deductable_money);
        b[0].Add_Money(deductable_money);
    }
}
