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
 * @author Admin
 */
public class Jail extends Unpurchaseable {

   
    
    int count = 0;
    public Jail(int id, String name) {
        super(id, name);
    }
     public Jail() {
        super(900, "aa");
    }
    
    private void menu(Player p[], int turn){
        System.out.print("Select from the options given below:\n");
        System.out.print("Press 1 to pay fine\n");
        Game.field.append("Select from the options given below:\n");
        Game.field.append("Press 1 to pay fine\n");
                  
        if(p[turn].check_get_out_of_jail_card()){
            System.out.print("Press 2 to use Get out of Jail Card\n");
            Game.field.append("Press 2 to use Get out of Jail Card\n");
        }
        System.out.print("OR wait for the completion of three turns\n");  
        Game.field.append("OR wait for the completion of three turns\n");
          int n= Integer.parseInt(JOptionPane.showInputDialog("enter option"));
        
        if(n==2 && p[turn].check_get_out_of_jail_card()){
            p[turn].setJail(false);
            p[turn].set_get_out_of_jail_card(false);
            count = 0;
        }
                
        if(n==1){
            p[turn].setJail(false);
            p[turn].sub_money(50);
            count = 0;
        }
    }
    public void action(Player[] p, Bank[] b, Area[] a, int turn, int num_players, int dice){
        
        if(p[turn].getJail()){
            if(count == 0){
                count += 1;
                menu(p,turn);
                
                return;
            }
            else if(count == 1){
                count += 1;
                menu(p,turn);
                return;
            }
            else if(count == 2){
                count += 1;
                menu(p,turn);
                return;
            }
            else if(count == 3){
                count = 0;
                p[turn].setJail(false);
                return;
            }
        }
    }
}
