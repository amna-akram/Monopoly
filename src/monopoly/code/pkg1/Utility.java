/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import com.sun.xml.internal.ws.api.addressing.NonAnonymousResponseProcessor;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Utility extends Non_Upgradeable {

    public Utility(int id, String name, String GroupName, int cost, int SellingPrice,
            int RentCost, boolean occupied, Player occupiedby, boolean mortgaged, int mortgage_cost, int un_mortgagePrice) {
        super(id, name, GroupName, cost, SellingPrice, RentCost, occupied, occupiedby, mortgaged, mortgage_cost, un_mortgagePrice);
    }
   

   
    public int diceVal;
   
   
    @Override
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
        
        if(this.occupiedby==p[turn]) //check if porperty is owned by the user
        {
            if(this.mortgaged==true)
            {
                System.out.println("Press U to Un-Mortgage");
              char option = JOptionPane.showInputDialog("Press U to un-mortgage").charAt(0);
                
                if(option=='U')
                {
                    Un_MortageProperty (p[turn],b[0]);
                    System.out.println("Property Un-Mortgaged");
                    Game.field.append("Prperty un-Mortgaged");
                }
                
            }
            else{
                
            System.out.println("Press S to Sell ");
            System.out.println("Press M to Mortgage");
            char option = JOptionPane.showInputDialog("Press S to Sell, Press M to Mortgage").charAt(0);
            
            if(option=='S')
            {
                Sell(p[turn],b[0]);
            }
            else if(option=='M')
            {
                 if(Check_Bankruptcy(p[turn])==true)
                 {
                     JOptionPane.showMessageDialog(null,"Player "+p[turn].getID()+ "is Bankrupted");
                 }
                 else
                 {
                MortageProperty(p[turn],b[0]);
                 }
                 }
        
            }
            
        }
        
        else{
            
            if(this.occupied==false)
            {
                
                System.out.println("Press B to Buy ");
              char option = JOptionPane.showInputDialog("Press B to buy").charAt(0);

                 if(option=='B')
                 {
                      if(Check_Bankruptcy(p[turn])==true)
                 {
                     JOptionPane.showMessageDialog(null,"Player "+p[turn].getID()+ "is Bankrupted");
                 }
                 else
                      {
                    Buy( p[turn], b[0] );
                      }
                      
                    if(ID == 10){
                        ArrayList<Integer> arr = p[turn].getOwned();
                        
                        for(int i=0;i<p[turn].getNo_of_owned(); i++){   
                            if(arr.get(i) == 28){
                                p[turn].both_owned = true;
                                
                            }
                        }
                        
                    }
                    else if(ID == 38){
                       ArrayList<Integer> arr = p[turn].getOwned();
                       
                        
                        for(int i=0;i<p[turn].getNo_of_owned(); i++){   
                            if(arr.get(i) == 10){
                                p[turn].both_owned = true;
                            }
                        }
                    }
                   
                    
                 }
                 else
                 {
                     //if player chooses not to buy

                     Bid(p,b[0]);
                 }
             
            }
            
            else
            {
                // if this property is owned by some other player
                 if(Check_Bankruptcy(p[turn])==true)
                 {
                     JOptionPane.showMessageDialog(null,"Player "+p[turn].getID()+ "is Bankrupted");
                 }
                 else{
                PayRent(p[turn], occupiedby);            
                diceVal = dice;
                 }
            }
        }
        
    }

    
    
    
    public void PayRent(Player payer, Player receiver) {
        if(receiver.both_owned){
            
            payer.sub_money(diceVal*4);
            receiver.add_money(diceVal*4);
            Game.field.append("rent of " + diceVal*4 + " deducted"+ "\n");
        }
        else{
            payer.sub_money(diceVal*2);
            receiver.add_money(diceVal*2);
            Game.field.append("rent of " + diceVal * 4 + " deducted" + "\n");
        }
        
    }

    

}
