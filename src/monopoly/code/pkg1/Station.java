/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author AYESHA NASEER
 */
public class Station extends Non_Upgradeable{

    
    public Station(int id, String name, String GroupName, int cost, int SellingPrice, int RentCost, boolean occupied,
            Player occupiedby, boolean mortgaged, int mortgage_cost, int un_mortgagePrice) {
        super(id, name, GroupName, cost, SellingPrice, RentCost, occupied, occupiedby, mortgaged, mortgage_cost, un_mortgagePrice);
    }

        @Override
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
        
        if(this.occupiedby!=null)
        {
       
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
                    Game.field.append("Property un=mortgaged"+ "]\n");
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
                    Buy( p[turn], b[0] );
                    
                    p[turn].Station_Count++;
                                        
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
                PayRent(p[turn], occupiedby);
            }
        }
        
    }

    
    @Override
    public void PayRent(Player y, Player x) 
    {
        int station_count= x.Station_Count; //get the reciever's station count
        
        if(station_count==1)
        {
            y.sub_money(this.RentCost);
            x.add_money(this.RentCost);
            Game.field.append("rent of " + RentCost + " paid" + "\n");
        }
        
        else if(station_count==2)
        {
            y.sub_money( (this.RentCost * 2) );
            x.add_money( (this.RentCost * 2) );  
            Game.field.append("rent of " + RentCost *2 + " paid" + "\n");
        }
    
        else if(station_count==3)
        {
            y.sub_money( (this.RentCost * 3) );
            x.add_money( (this.RentCost * 3) );  
            Game.field.append("rent of " + RentCost * 3 + " paid" + "\n");
        
            
        }
        
        else if(station_count==4)
        {
            y.sub_money( (this.RentCost * 4) );
            x.add_money( (this.RentCost * 4) ); 
            Game.field.append("rent of " + RentCost * 4 + " paid" + "\n");
        
        }
    
    
    }
    
    
}
