/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class Chance extends Unpurchaseable {
    String [] names;

    
    public Chance(int id, String name) {
        super(id,name);
        names=new String[26];
        names[0]= "Advance to Go and collect $200";
        names[1]="Pay poor tax of $15";
        names[2]=" IT'S YOUR BIRTHDAY!!! Everyone gives you $10.";
        names[3]="Pay school fees of $250";
        names[4]="Bank pays you $50";
        names[5]="Get Out of Jail Free";
        names[6]="Go Back 3 Spaces";
        names[7]="Go directly to Jail";
        names[8]="Make general repairs on "
                + "your property pay"
                + "$100";
        names[9]="Pay poor tax of $15";
        names[10]="You have been elected Chairman"
                + " of the Board–Pay each player $50";
        names[11]="You have won a crossword"
                + " competition—Collect $100";
        names[12]="Your building and loan matures"
                + "—Collect $150";
        names[13]="You have won a lottery."
                + "Collect $500 from bank";
        names[14]=" IT'S YOUR BIRTHDAY!!! Everyone gives you $10.";
        names[15]="You gain 10% interest"
                + " on all your cash, take 10% "
                + "of your total cash amount"
                + " from the bank.";
        
        
    }

   // private Card[][] c;
     public int rand_generator()
    {
        Random rand = new Random(); 
        int r = rand.nextInt(16);
        return r;
        
    }

     public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice)
     {
         Game.field.setText("selecting random chance card");
           int r=rand_generator();
        System.out.println(names[r]);
        Game.field.append(names[r]);
        if(r==0)
        {
            p[turn].change_location(0);
            p[turn].add_money(200);
            
        }
        else if(r==1)
        {
             p[turn].sub_money(15);
            
        }
        else if(r==2)
        {
              for(int i=0;i<num_players;i++)
            {
                if(i!=turn)
                {
                    p[turn].add_money(10);
                    p[i].sub_money(10);
                }
            }
            
        }
        else if(r==3)
        {
            p[turn].sub_money(250);
            
        }
        else if(r==4)
        {
            p[turn].add_money(50);
        }
        else if(r==5)
        {
            //GET OUT OF H=JAIL CARD
            
        }
        else if(r==6)
        {
           ////////            
        }
        else if(r==7)
        {
            //go to jail
            
            
        }
        else if(r==8)
        {
            p[turn].sub_money(100);
            
        }
        else if(r==9)
        {
            p[turn].sub_money(15);
            
        }
        else if(r==10)
        {
            for(int i=0;i<num_players;i++)
            {
                if(i!=turn)
                {
                    p[turn].sub_money(50);
                    p[i].add_money(50);
                }
            }
            
        }
        else if(r==11)
        {
            p[turn].add_money(100);
            
        }
        else if(r==12)
        {
            p[turn].add_money(150);
            
        }
        else if(r==13)
        {
            b[0].Take_Money(500);
            p[turn].add_money(500);
            
        }
        else if(r==14)
        {
             for(int i=0;i<num_players;i++)
            {
                if(i!=turn)
                {
                    p[turn].add_money(10);
                    p[i].sub_money(10);
                }
            }
            
        }
        else if(r==15)
        {
            double interest=0.1*p[turn].getMoney();
            p[turn].add_money(interest);
            
        }
         
     }
}
