/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.code.pkg1.GUIFiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Kevin mason
 */
public final class Rules
        extends JPanel
{

    JFrame ruleFrame = new JFrame();
    private List<String> list = new ArrayList<String>();
    private String ruleText = new String();
    
    /**
    * Constructor which creates the Frame.  Adds all of the GUI components onto this frame 
    * so the user can read the rules.
    */
    public Rules()
    {
        try
        {
            readFiles();
        }
        catch (FileNotFoundException ex)
        {
           
            System.err.println(ex.getMessage());
            System.exit(0);
        }
        catch (IOException ex)
        {
            
            System.err.println(ex.getMessage());
            System.exit(0);
        }

        createGUI();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        ruleFrame.setSize(width / 2, height / 2);
        ruleFrame.setLocationRelativeTo(null);
        
        
        ruleFrame.setVisible(true);
        ruleFrame.setTitle("Monopoly Game");
        ruleFrame.setSize(800,
                615);
        ruleFrame.setResizable(false);
        ruleFrame.add(this);


    }

    /**
     * Method when called will create the GUI part of this Frame. Sets the text
     * from the string into the text area then adds that text area into a 
     * scroll pane so the user can scroll and read the rules of the game.
     */
    public void createGUI()
    {
        JTextArea ruleTextArea = new JTextArea();
        JScrollPane ruleScrollPane = new JScrollPane(ruleTextArea);
        JButton returnButton = new JButton("Return to Main Menu");

        returnButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                ruleFrame.dispose();
            }
        });

        Font font = new Font("Times New Roman",
                Font.PLAIN,
                14);

        ruleTextArea.setText(ruleText);
        ruleTextArea.setFont(font);
        ruleTextArea.setEditable(false);
        ruleTextArea.setColumns(70);
        ruleTextArea.setRows(32);
        ruleTextArea.setLineWrap(true);
        ruleTextArea.setWrapStyleWord(true);
        ruleTextArea.setBackground(Color.LIGHT_GRAY);
        ruleScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ruleScrollPane.setBorder(BorderFactory.createLineBorder(Color.black));



        this.add(returnButton);
        this.add(ruleScrollPane);
    }

    /**
     * Creates a buffered Reader to read the files in from a specific file 
     * name. It will continue to read until the file has no more lines in the 
     * file.  When the buffered reader read a line it will add that line to a
     * list.  Once the buffered Reader gets done reading it will then search
     * the list and add everything in that list to a string. Then it will
     * display that into a TextArea.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void readFiles()
            throws FileNotFoundException,
            IOException
    {


        String line;
        BufferedReader in = new BufferedReader(new FileReader("Rules.txt"));

        line = in.readLine();
        while (line != null)
        {
            list.add(line);
            line = in.readLine();
        }
        for (String s :
                list)
        {
            ruleText += s + "\n";
        }

    }
}
