/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class UpGradeable extends Purchaseable {

    public int Price_one_house;
    public int Price_two_houses;
    public int Price_three_houses;
    public int Price_four_houses;
    public int Price_hotel;
    
    
    public int house_count=0;
    public Boolean hotel_count=false;
    public int housePrice=50;
    public int hotelPrice=50;
    
    //Action??????

    public UpGradeable(int id, String name, String GroupName, int cost, int SellingPrice, int RentCost, boolean occupied, Player occupiedby, boolean mortgaged, int mortgage_cost, int un_mortgagePrice
    ,int POneHouse, int PTwoHouses, int PThreeHouses, int PFourHouses, int PHotel) {
        super(id, name,GroupName, cost, SellingPrice, RentCost, occupied, occupiedby, mortgaged, mortgage_cost, un_mortgagePrice);
   
        Price_one_house= POneHouse;
        Price_two_houses=PTwoHouses;
        Price_three_houses= PThreeHouses;
        Price_four_houses= PFourHouses;
        Price_hotel=PHotel;
    
    }
    
    

   
    public void Ugrade(Player p, UpGradeable poprty)
    {
        if(poprty.house_count<4)
        {
           int n= Integer.parseInt(JOptionPane.showInputDialog("enter number of houses, can't add more than 4"));
            
             
             if( (n + poprty.house_count) <= 4 )
             { 
                 p.sub_money(poprty.housePrice * n);
                 poprty.house_count=n+ poprty.house_count;
                 Game.field.append("house(s) added");            
             
             }
            
             else{
             Game.field.append("You cannot have more than 4 houses" + "\n" );
                 
             }
            
        }
        else if(poprty.hotel_count==false)
        {
            p.sub_money(poprty.hotelPrice);
            poprty.hotel_count=true;
        }
        else
        {
             Game.field.append("Your Property is max upgraded, you cannot add more houses or hotels here" + "\n");
            
        }
        
    }
    
    @Override
    public void PayRent(Player p, Player q)
    {
        
        
        if( hotel_count==true)
        {
            p.sub_money(Price_hotel);
            q.add_money(Price_hotel);
             Game.field.append("Rent of " + Price_hotel+" deducted" + "\n");
        }
        else if(house_count== 1)
        {
            p.sub_money(Price_one_house);
            q.add_money(Price_one_house);
            Game.field.append("Rent of " + Price_one_house+" deducted" + "\n");
        
        }
        else if(house_count== 2)
        {
            p.sub_money(Price_two_houses);
            
            q.add_money(Price_two_houses);
            Game.field.append("Rent of " + Price_two_houses+" deducted" + "\n");
        
        }
        
        else if(house_count== 3)
        {
            p.sub_money(Price_three_houses);
            q.add_money(Price_three_houses);
            Game.field.append("Rent of " + Price_three_houses+" deducted" + "\n");
        }
        
        else if(house_count== 4)
        {
            p.sub_money(Price_four_houses);
            q.add_money(Price_four_houses);
            Game.field.append("Rent of " + Price_four_houses+" deducted" + "\n");
        }
        else{ //if property not upgraded
            p.sub_money(RentCost); //if property is not upgraded, simple rent is paid
            q.add_money(RentCost);
            Game.field.append("Rent of " + RentCost+" deducted" + "\n");
        }
        
        
    }
    
    
    //Action:
    
    @Override
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice) 
    {
         if(this.occupiedby==p[turn]) //check if porperty is owned by the user
        {
            if(this.mortgaged==true)
            {
                 char option = JOptionPane.showInputDialog("enter number of houses, can't add more than 4").charAt(0);
               
                
                if(option=='U')
                {
                    Un_MortageProperty (p[turn],b[0]);
                    Game.field.append("Property Un-Mortgaged" + "\n");
                    System.out.println("Property Un-Mortgaged");
                }
                
            }
            else{
                
            System.out.println("Press S to Sell ");
            System.out.println("Press M to Mortgage");
            System.out.println("Press P to Upgrade");
            
            char option = JOptionPane.showInputDialog("Press S to Sell, Press M to Mortgage, Press P to Upgrade").charAt(0);
            
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
        
            else if(option=='P')
            {
                //add check
                //////////////////////////////////////////////////
                 if(Check_Bankruptcy(p[turn])==true)
                 {
                     JOptionPane.showMessageDialog(null,"Player "+p[turn].getID()+ "is Bankrupted");
                 }
                 else
                 {
                     
                 ////////////////////////////////////////    
                     
                     
                     
                 //////////////////////////////////////////////////
                
                char input;
                    do{
                    Boolean access = false;
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Enter id of property"));
                    ArrayList<Integer> arr = p[turn].getOwned();
                    
                    
                    if(i == 40 || i== 41 || i== 43){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 40 ){
                                count++;
                            }
                            if(arr.get(k) == 41){
                                count++;
                            }
                            if(arr.get(k) == 43){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    
                    else if(i == 45 || i== 47){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 45 ){
                                count++;
                            }
                            if(arr.get(k) == 47){
                                count++;
                            }
                        }
                        if(count == 2){
                            access = true;
                        }
                    }
                    
                    else if(i == 2 || i== 3){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 2){
                                count++;
                            }
                            if(arr.get(k) == 3){
                                count++;
                            }
                        }
                        if(count == 2){
                            access = true;
                        }
                    }
                    else if(i == 6 || i== 7 || i== 8){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 6 ){
                                count++;
                            }
                            if(arr.get(k) == 7){
                                count++;
                            }
                            if(arr.get(k) == 8){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    else if(i == 11 || i== 12 || i==13){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 11 ){
                                count++;
                            }
                            if(arr.get(k) == 12){
                                count++;
                            }
                            if(arr.get(k) == 13){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    else if(i == 15 || i== 17 || i== 18){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 15 ){
                                count++;
                            }
                            if(arr.get(k) == 17){
                                count++;
                            }
                            if(arr.get(k) == 18){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    else if(i == 20 || i== 22 || i== 23){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 20 ){
                                count++;
                            }
                            if(arr.get(k) == 22){
                                count++;
                            }
                            if(arr.get(k) == 23){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    else if(i == 25 || i== 26 || i== 28){
                        int count = 0;
                        for(int k =0;k<p[turn].getNo_of_owned(); k++){   
                            if(arr.get(k) == 25 ){
                                count++;
                            }
                            if(arr.get(k) == 26){
                                count++;
                            }
                            if(arr.get(k) == 28){
                                count++;
                            }  
                        }
                        if(count == 3){
                            access = true;
                        }
                    }
                    if(access){
                        Area[] A= Game.A;
                        
                       
                        Ugrade(p[turn], (UpGradeable) A[i]);
                    }
                    
                    input = JOptionPane.showInputDialog("Press C to Continue upgrading property").charAt(0);
                    }while(input == 'C');
                    
                
                //////////////////////////////////////////////////
        
                
                
                ///////////////////////////////////////
                 }
                //////////////////////////////////////////////////
                
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
                 else
                 {
                PayRent(p[turn], occupiedby);
                 }
            }
            
      
        }
    
    
    }
    public boolean check_upgradeable()
    {
        boolean flag=false;
        
        
        return flag;
    }
    
    
    

}
