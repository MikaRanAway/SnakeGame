package org.example.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeFrame extends JFrame implements ActionListener {
    //Frames
    JFrame welcomeWindow = new JFrame();

    //========== Creating the Welcome Frame components (Buttons) ==========
    JButton difficultyLevelBtn = new JButton("Difficulty Level");
    JButton customizationBtn = new JButton(("Customization"));
    JLabel welcomeMessageLabel = new JLabel("Welcome to Wild Snake Game");
    //========== Defining the interface components ==========
    public WelcomeFrame(){
        welcomeWindow.setSize(600,600);
        welcomeWindow.getContentPane().setBackground(Color.decode("#333333"));
        welcomeWindow.setLayout(null);
        welcomeWindow.setLocationRelativeTo(null);
        welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeWindow.add(difficultyLevelBtn);
        welcomeWindow.add(customizationBtn);
        welcomeWindow.add(welcomeMessageLabel);
        welcomeMessageLabel.setBounds(200,50,400,150);
        welcomeMessageLabel.setForeground(Color.white);
        difficultyLevelBtn.setBounds(170,250,250,50);
        customizationBtn.setBounds(170,150,250,50);
        difficultyLevelBtn.addActionListener(this);
        customizationBtn.addActionListener(this);
    }

    public void showFrame(){
        welcomeWindow.setVisible(true);
    }

    //========== Either moving Difficulty frame or to Customization frame ==========
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficultyLevelBtn){
            welcomeWindow.dispose();
            new DifficultyFrame(); //creates and displays frame
        }
        else if (e.getSource() == customizationBtn){
            welcomeWindow.dispose();
            new CustomizationFrame(); //creates and displays frame
        }
    }
}
