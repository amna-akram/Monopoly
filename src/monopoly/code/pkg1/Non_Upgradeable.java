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
public abstract class Non_Upgradeable extends Purchaseable {

    
    public Non_Upgradeable(int id, String name, String GroupName, int cost, int SellingPrice, int RentCost, boolean occupied, Player occupiedby, boolean mortgaged, int mortgage_cost, int un_mortgagePrice) {
        super(id, name, GroupName, cost, SellingPrice, RentCost, occupied, occupiedby, mortgaged, mortgage_cost, un_mortgagePrice);
    }

    
    
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){}
    

}