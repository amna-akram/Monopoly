/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public abstract class Purchaseable extends Area {

    /////////// variables //////////////////////////////////////////////
    
    public String GroupName;
    public int cost;
    public int SellingPrice;
    public int RentCost;
    public boolean occupied;
    public Player occupiedby; //Player who owns the property
    public boolean mortgaged;
    public int mortgage_cost;  
    public int un_mortgagePrice;
    public boolean upgraded;
    
    /////////////////////////////////////////////////////////////////
    
    ////////////////// abstract Opertaion /////////////////////////
    
    public abstract void  PayRent(Player y,Player x);
    //////////////////////////////////////////////////////////////
    
    //////////////// other  Operattions//////////////////////////////////////

    public Purchaseable(int id, String name, String GroupName, int cost, int SellingPrice, int RentCost, boolean occupied, Player occupiedby, boolean mortgaged, int mortgage_cost, int un_mortgagePrice) {
        super(id, name);
        this.GroupName = GroupName;
        this.cost = cost;
        this.SellingPrice = SellingPrice;
        this.RentCost = RentCost;
        this.occupied = occupied;
        this.occupiedby = occupiedby;
        this.mortgaged = mortgaged;
        this.mortgage_cost = mortgage_cost;
        this.un_mortgagePrice = un_mortgagePrice;
    }
    
    
    
    
    public void Buy(Player P, Bank b)
    {
        P.sub_money(this.cost);
        b.Add_Money(this.cost);
        this.occupied=true;
        this.occupiedby=P;
        P.add_property(ID);
         System.out.println("Property Bought");
    
        
    }
    
    public void Sell(Player P, Bank b)
    {
        this.occupied=false;
        this.occupiedby= null;  
        b.Take_Money(this.SellingPrice);
        P.add_money(SellingPrice);
         System.out.println("Property Sold");
    
       
    }
    public int GetSellingPrice(){
        return SellingPrice;
    }
    
    public void Bid(Player [] p, Bank b)
    {
        int HighestBiddingPrice=0;
        Player HighestBidder= new Player();
     System.out.println("Bidding Starts");
    for(int i=0; i<p.length; i++)
    {
     System.out.println("Player " + p[i].getID() + ", do you want to buy this Property? Press Y for yes");
     Scanner scan = new Scanner(System.in);
     char a= scan.next().charAt(0);
     
     if(a=='Y')
     {
         System.out.println("Player " + p[i].getID() + ", decided to Bid. Please state your amount:");
         int biddingcost= scan.nextInt();
         
         if(biddingcost>HighestBiddingPrice)
         {
             HighestBiddingPrice = biddingcost;
             HighestBidder=p[i];
         }
     }
    }
     System.out.println("Highest bidder is player" + HighestBidder.getID());
    
    
    if(HighestBiddingPrice!=0) //if atleast one player bids
    {
        Buy(HighestBidder,b); //Highest Bidder Gets Property
    }
    
    }
    
    public void MortageProperty(Player P, Bank b)
    {
        b.Take_Money(this.mortgage_cost);
        P.add_money(this.mortgage_cost);
        this.mortgaged= true;
         System.out.println("Property Mortgaged");
    
    }
    
    public void Un_MortageProperty(Player P, Bank b)
    {
        P.sub_money(this.un_mortgagePrice);
        b.Add_Money(this.un_mortgagePrice);
        this.mortgaged= false;
         System.out.println("Property Un mortgaged");
    
 
    }
    public boolean Check_Bankruptcy(Player p)
    {
        Area [] A=Game.A;
       int total=0;
        ArrayList<Integer> temp= p.getOwned();
       for(int i=0;i<p.getNo_of_owned();i++)
       {
           total=total+A[temp.get(i)].GetSellingPrice();
       }
       total=(int) (total+p.getMoney());
       if(total<p.getLoan())
       {
           return true;
       }
       else
           return false;
    }
    
    @Override
    public abstract void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice);
    
    
    
    ///////////////////////////////////////////////////////////////////
}
