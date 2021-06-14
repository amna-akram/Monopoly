/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1;
import java.awt.Component;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class Game {
    static Monopoly  monopoly;
    public static int num_players;
    JTextArea player_position;
    JButton die;
    JButton dice_button;
    JButton take_loan;
    JTextArea money;
    static JTextArea field;
    ImageIcon[] image = new ImageIcon[6];
    public Game() throws MalformedURLException {
        monopoly =new Monopoly();
        monopoly.setVisible(true);
        dice_button=monopoly.getjButton24();
        take_loan=monopoly.getjButton48();
        play_game();
    }
    private int no_of_player;
    private Player[][] p;
    static Area[] A;
    private Bank[] b;
     public boolean Check_Bankruptcy(Player p)
    {
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
    public void set_player(int n) {
        
    }
       public int roll_dice()
    {
        Random rand = new Random(); 
        int dice = rand.nextInt((7-1)+1)+1;
         
       if(dice==1)
       {
           image[0] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice1.png");
           dice_button.setIcon(image[0]);
       }
       else if(dice==2)
       {
           image[1] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice2.png");
           dice_button.setIcon(image[1]);
       }
       else if(dice==3)
       {
           image[2] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice3.png");
           dice_button.setIcon(image[2]);
       }
       else if(dice==4)
       {
           image[3] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice4.png");
           dice_button.setIcon(image[3]);
       }
       else if(dice==5)
       {
           image[4] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice5.png");
           dice_button.setIcon(image[4]);
       }
       else
       {
           image[5] = new ImageIcon("C:\\Users\\Dure Khan\\Documents\\NetBeansProjects\\monopoly code 1\\src\\monopoly\\code\\pkg1\\Die\\Dice6.png");
           dice_button.setIcon(image[5]);
       }
                   
      
        return dice;
        
    }
       
    public boolean Take_Loan(int money,int total)
    {
        if(total>money)
        {
        System.out.println("true flag "+money);
        b[0].Take_Money(money);
        return true;
        }
        else
        {
            System.out.println("false flag "+money);
            return false;
        }
    }
    public int Total_money(Player p)
    {
       int total=0;
       ArrayList<Integer> temp= p.getOwned();
       for(int i=0;i<p.getNo_of_owned();i++)
       {
           total=total+A[temp.get(i)].GetSellingPrice();
       }
       total=(int) (total+p.getMoney());
       System.out.println("totalmoney"+" "+total);
       return total;
    }
     //*********jail*********
        public void Proceed_Jail(int n,Player p)
        {
            if(n==1)
            {
                int money=Integer.parseInt( JOptionPane.showInputDialog("Pay the Jail fine"));
                b[0].Add_Money(money);
                p.setJail(false);
            }
            else if(n==2&&p.check_get_out_of_jail_card())
            {
                p.setJail(false);
            }
            else if(n==3)
            {
                
            }
         }
        //***************JAIL*********************************
    public void play_game() throws MalformedURLException  {
        //*******************Dice  Roll action **********************
    /*    int dice=roll_dice();
     
       
        */
        
        Player [] players=new Player[num_players];
        b=new Bank[1];
        b[0]=new Bank();
        
        for(int i=0;i<num_players;i++)
        {
            players[i]=new Player(i);
        }
        Area [] cells = new Area[40];
         System.out.println(num_players);
          Scanner in = new Scanner(System.in);  // Create a Scanner object
        //INITIALIZE ALL CELLS
          //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        cells[0]= new Go(0, "GO");
        cells[1]=new UpGradeable(1, "Mediterrenean avenue", "blue", 60, 70, 2, false, null, false,100, 150, 3,4,5,6,8);
        cells[2]=new Community(2, "Community Chest");
        cells[3]=new UpGradeable(3, "Baltic Avenue", "blue",60, 70,4, false, null,false, 100, 150, 5,6,7,8,10 );
        cells[4]=new Chance(4, "Chance");
        cells[5]=new Tax(5, "Income Tax");
         cells[6]=new Station(6,"Reading railroad", "station", 200, 210, 25, false, null, false, 100, 120); //station
        cells[7]=new UpGradeable(7, "Baltimore", "pink", 80, 90, 5, false, null, false, 110, 120, 6,7,8,9,11 );
        cells[8]=new UpGradeable(8, "Vermont Ave", "pink", 100, 110, 6, false, null, false, 110, 120, 7,8,9,10,12 );
        cells[9]=new UpGradeable(9, "Connecticut Ave", "pink", 120, 130, 8, false, null, false, 110, 120, 9,10,11,12,14 );
        cells[10]=new Jail(10, "Jail");
        cells[11]=new Utility(11,"Electric Company", "utility", 150, 160, 25, false, null, false, 100, 120); 
        cells[12]=new UpGradeable(12, "States Avenue", "purple", 140, 150, 10, false, null, false, 110, 120, 11,12,13,14,16 );
        cells[13]=  cells[11]=new UpGradeable(13, "St. Charles Place", "purple", 140, 150, 10, false, null, false, 110, 120, 11,12,13,14,16 );
        cells[14]=new UpGradeable(14, "Virginia Ave", "purple", 160, 170, 12, false, null, false, 110, 120, 13,14,15,16,18 );
         cells[6]=new Station(16,"Pennysalvania railroad", "station", 150, 160, 25, false, null, false, 100, 120); //station
        cells[16]=new UpGradeable(16, "St. James Ave", "orange", 180, 190, 14, false, null, false, 110, 120, 15,16,17,18,19 );
         cells[17]=new Community(17, "Community Chest");
        cells[18]=new UpGradeable(18, "Tennessee Ave.", "orange", 180, 190, 14, false, null, false, 110, 120, 15,16,17,18,19 );
        cells[19]=new UpGradeable(19, "NY Ave.", "orange", 200, 210, 16, false, null, false, 110, 120, 17,18,19,20,22 );
        cells[20]=new FreeParking(20, "Free Parking");
        cells[21]=new UpGradeable(21, "Kentucky Ave", "red", 220, 240, 18, false, null, false, 110, 120, 19,20,21,22,24 );
        cells[22]= new Chance(22, "Chance");
        cells[23]=new UpGradeable(23, "Indiana Ave", "red", 220, 240, 18, false, null, false, 110, 120, 19,20,21,22,24 );
        cells[24]=new UpGradeable(24, "Illinois Ave", "red", 240, 260, 20, false, null, false, 110, 120, 21, 22, 23, 24, 26);
         cells[25]=new Station(25,"Reading Railroad", "station", 200, 220, 25, false, null, false, 100, 120); //station
        cells[26]=new UpGradeable(26, "Atlantic Ave", "yellow", 260, 280, 22, false, null, false, 110, 120, 23, 24, 25, 26, 28);
        cells[27]=new UpGradeable(27, "Ventnor Ave", "yellow", 280, 290, 24, false, null, false, 110, 120, 25, 26, 27, 28, 30);
        cells[28]=new Utility(28,"Water works", "utility", 150, 160, 25, false, null, false, 100, 120); 
        cells[29]=new UpGradeable(29, "Marvin Gardens", "yellow", 280, 290, 24, false, null, false, 110, 120, 25, 26, 27, 28, 30);
        cells[30]=new Go_to_Jail(30, "Go to Jail");
        cells[31]=new UpGradeable(31, "Pacific Ave", "green", 300, 320, 26, false, null, false, 110, 120, 27, 28, 29, 30, 33);
        cells[32]=new UpGradeable(32, "Caroline Ave", "green", 300, 320, 26, false, null, false, 110, 120, 27, 28, 29, 30, 33);
        cells[33]=new Community(33, "Community Chest");
        cells[34]=new UpGradeable(34, "Croydon", "green", 320, 330, 28, false, null, false, 110, 120, 29, 30, 31, 32, 34);
        cells[35]=new Station(35,"Pennysylvania railroad", "station", 150, 160, 25, false, null, false, 100, 120); //station
        cells[36]=new UpGradeable(36, "Baltic Palace", "dark blue", 350, 370, 35, false, null, false, 110, 120, 36, 37, 38, 39, 41);
        cells[37]=new Tax(37, "Luxury Tax");
        cells[38]=new UpGradeable(38, "Noom Ave", "dark blue", 400, 450, 50, false, null, false, 110, 120, 51, 52, 53, 54, 56);
        cells[39]=new Chance(39, "Chance");
       
                
         
         
         //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        int turn=0;
        //******************************Take LOAN CODE***************************
        //get total money and properties of player
        int total=Total_money(players[turn]);
        
        //take loan action
        take_loan.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           int money=Integer.parseInt( JOptionPane.showInputDialog("Enter the amount of money"));
           if(Take_Loan(money,total)==true)
           {
               JOptionPane.showMessageDialog(null, "LoanGranted");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "you cant take loan");
           }
         }           
      });
        //*******************************TAKE LOAN END********************************
        player_position=monopoly.getjTextArea1();
        money=monopoly.getjTextArea2();
        field=monopoly.getjTextArea3();
        
    //    die=monopoly.getjButton24();
      //  die.setVisible(false);
        //die.setIcon(icon);
         //die.setVisible(true);
         
         int j=0;
         boolean bankrup=false;
        while(j<50)
        {
            turn =0;
            for(turn=0;turn<num_players;turn++)
            {
            player_position.setText("");
            for(int i=0;i<num_players;i++)
            {
                player_position.append("player"+ i+": ");
                int tem=players[i].getLocation();
                String pr=cells[tem].getArea_Name();
                player_position.append( pr+ "\n");   
            }
            money.setText("");
             for(int i=0;i<num_players;i++)
            {
               money.append("player"+ i+": ");
                money.append(String.valueOf(players[i].getMoney())+ "\n");   
            }
             Game.field.append("\n");
             Game.field.append("turn of player id: "+ turn+"\n");
             String p=JOptionPane.showInputDialog("enter 1 to roll dice");
             while(p==null)
             {
                 p=JOptionPane.showInputDialog("enter 1 to roll dice"); 
             }
            int tt= Integer.parseInt(p);
            
            while(tt!=1)
            {
                tt= Integer.parseInt(JOptionPane.showInputDialog("enter 1 to roll dice"));
            }
             
               int dice=roll_dice();
         
//         players[turn].move_add(dice);
//         int temp=players[turn].getLocation();
//         field.append("you landed on " + cells[temp].getArea_Name() );
//         cells[temp].action(players, b, cells, turn, num_players, dice);
         //jail options
         
         if(players[turn].getJail()==true)
         {
             
              
              cells[10].action(players, b, cells, turn, num_players, dice);
         }
         else
         {
              players[turn].move_add(dice);
         int temp=players[turn].getLocation();
         field.append("you landed on " + cells[temp].getArea_Name() );
         cells[temp].action(players, b, cells, turn, num_players, dice);
         }
            }
            
            
         
            j++;     
        }
        
    }

}

