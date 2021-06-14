/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1.GUIFiles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class WelcomeScreen {
    
     public JButton Welcome = new JButton("Play Monopoly");
    public JFrame frame = new JFrame();
    JPanel[] panels = new JPanel[2];
    JButton[] buttons = new JButton[5];
    String[] buttonNames = {
        "Play Monopoly",
        "Rules",
      
    };
    ImageIcon icon = new ImageIcon("monopoly-board.jpg");

    /**
     * Constructor which creates the Frame. Adds all of the GUI components onto
     * this frame so the user can play the game.
     */
    public WelcomeScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        
        frame.setSize(width / 2, height / 2);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Monopoly Game");
        frame.setSize(806,
                629);
        frame.setResizable(false);

        settingUpScreen();
        JLabel label = new JLabel(icon);
        label.setSize(icon.getIconWidth(),
                icon.getIconHeight());
        frame.add(label);
    }

    /**
     * Method when called will set up the GUI portion of the welcome screen.
     * adds buttons to the frame and when one of those buttons is clicked will
     * do what the button is supposed to do.
     */
    public void settingUpScreen() {
        int x = 200;

        for (int index = 0;
                index < panels.length;
                index++) {
            panels[index] = new JPanel();
            panels[index].setLayout(new BorderLayout());
            buttons[index] = new JButton(buttonNames[index]);
            panels[index].add(buttons[index]);

            panels[index].setSize(120,
                    40);
            panels[index].setLocation(350,
                    x);
            x += 50;
            frame.add(panels[index]);

            buttons[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == buttons[0]) {
                        frame.dispose();
                       SelectPlayers p=new SelectPlayers();
                       p.setVisible(true);
                    } else if (e.getSource() == buttons[1]) {

                        Rules rules = new Rules();

                    } 

                }
            });
        }
    }
}
