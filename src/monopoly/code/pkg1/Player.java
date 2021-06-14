/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Player {

    public Player() {
    }

    
    public Player(int i) {
        loan=0;
        ID=i;
        money=1500;
        location=0;
        owned = new ArrayList<Integer>(); 
       
        i=0;
        no_of_owned=0;
        groups=new boolean[10];
        jail=false;
        Get_out_of_jail_card=false;
        Station_Count=0;
        both_owned=false;
        
    }

  
    private int loan;

    private int ID;

    private double money;

    private int location;

    int i=0;
    
     ArrayList<Integer> owned;

    private int no_of_owned;

    private boolean[] groups;

    private boolean jail;
    
    private boolean Get_out_of_jail_card;
    
    public int Station_Count;
    
    public Boolean both_owned;
    
    
    public Boolean check_get_out_of_jail_card(){
        return Get_out_of_jail_card;
    }

    public void set_get_out_of_jail_card(Boolean flag){
        Get_out_of_jail_card = flag;
    }


    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public ArrayList<Integer> getOwned() {
        return owned;
    }

    public void setOwned(ArrayList<Integer> owned) {
        this.owned = owned;
    }

    public int getNo_of_owned() {
        return no_of_owned;
    }

    public void setNo_of_owned(int no_of_owned) {
        this.no_of_owned = no_of_owned;
    }

    public boolean[] getGroups() {
        return groups;
    }

    public void setGroups(boolean[] groups) {
        this.groups = groups;
    }

    public boolean getJail() {
        return jail;
    }

    public void setJail(Boolean jail) {
        this.jail = jail;
    }
    


    public void update_groups(int x) {
        
    }
    
//////////////////////////////////////////////////////////////////////////////////////
    public void add_property(int p) {
   
       
        owned.add(p);
        
    }

    public void remove_property(int id)
    {
       int index= owned.indexOf(id);
        owned.remove(index);
        
        
    }
    
//////////////////////////////////////////////////////////////////////////////
    
    public void add_money(double m) {
        money=money+m;
        
    }

    public void sub_money(int m) {
        money=money-m;
        
    }

    public void move_add(int n) {
        location=location+n;
        
    }

    public void move_subtract(int n) {
        location=location-n;
       
    }
    public void change_location(int p)
    {
        location=p;
    }

    public void add_loan(int x) {
        
    }

    public void pay_loan(int n) {
        
    }

}
