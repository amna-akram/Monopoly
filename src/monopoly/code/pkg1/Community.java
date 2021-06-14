/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Community extends Unpurchaseable {

    String [] names;
    
    public Community(int id, String name) {
        super(id,name);
        names= new String[16];
        names[0]="Bank error in your favor. Collect $200.";
        names[1]="Doctor's fee!!! Pay $50.";
        names[2]="From sale of stock you get $50";
        names[3]="Get out of Jail, Free!!!";
        names[4]="Grand Opera Night. Collect $50"
                + " from every player for opening night seats.";
        names[5]="Receive $25 consultancy fee";
        names[6]="You inherit $100";
        names[7]="Advance to Go (Collect $200)";
        names[8]="Life insurance matures – Collect $100";
        names[9]="Go directly to jail!!!";
        names[10]="You have won second prize in a beauty contest. Collect $10";
        names[11]="Income tax refund–Collect $20";
        names[12]="You are assessed for"
                + " street repairs pay $150!!!";
                
        names[13]="Pay school fees of $150";
        names[14]="Holiday Fund matures—Receive $100";
        names[15]="Pay hospital fees of $100";
        
    }
    //private Card[][] c;
    public int rand_generator()
    {
        Random rand = new Random(); 
        int r = rand.nextInt(16);
        return r;
        
    }

    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
          Game.field.setText("selecting random chance card");
        int r=rand_generator();
        System.out.println(names[r]);
          Game.field.append(names[r]);
        
        if(r==0)
        {
            p[turn].add_money(200);
            
        }
        else if(r==1)
        {
            p[turn].sub_money(50);
            
        }
        else if(r==2)
        {
             p[turn].add_money(50);
            
            
        }
        else if(r==3)
        {
            //get out pf jail card
            
        }
        else if(r==4)
        {
            for(int i=0;i<num_players;i++)
            {
                if(i!=turn)
                {
                    p[i].sub_money(50);
                    p[turn].add_money(50);
                }
                
            }
            
        }
        else if(r==5)
        {
            p[turn].add_money(25);
            
        }
        else if(r==6)
        {
            p[turn].add_money(100);
            
        }
        else if(r==7)
        {
            p[turn].change_location(0);
            p[turn].add_money(200);
            
        }
        else if(r==8)
        {
            p[turn].add_money(100);
            
        }
        else if(r==9)
        {
           //GO TO JAIL
            
        }
        else if(r==10)
        {
            p[turn].add_money(10);
            
        }
        else if(r==11)
        {
            p[turn].add_money(20);
            
        }
        else if(r==12)
        {
            p[turn].sub_money(150);
            
        }
        else if(r==13)
        {
            p[turn].sub_money(150);
            
        }
        else if(r==14)
        {
            p[turn].add_money(100);
            
        }
        else if(r==15)
        {
            p[turn].sub_money(100);
            
        }
       
        
    }

}