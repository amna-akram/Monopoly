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
public class FreeParking extends Unpurchaseable{
    public FreeParking(int id, String name){
    super(id, name);
    }

    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
        //NO ACTION
          Game.field.setText("Free Parking action");
    }
}
