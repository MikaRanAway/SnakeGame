package org.example.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeFrame extends JFrame implements ActionListener {
    //Frames
    JFrame welcomeWindow = new JFrame();

    //========== Creating the Welcome Frame components (Buttons) ==========
    JButton difficultyLevel = new JButton("Difficulty Level");
    JButton customization = new JButton(("Customization"));
    JLabel welcomeMessage = new JLabel("Welcome to Wild Snake Game");
    //========== Defining the interface components ==========
    public WelcomeFrame(){
        welcomeWindow.setSize(600,600);
        welcomeWindow.getContentPane().setBackground(Color.decode("#333333"));
        welcomeWindow.setLayout(null);welcomeWindow.setVisible(true);
        welcomeWindow.setLocationRelativeTo(null);
        welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeWindow.add(difficultyLevel);
        welcomeWindow.add(customization);
        welcomeWindow.add(welcomeMessage);
        welcomeMessage.setBounds(200,50,400,150);
        welcomeMessage.setForeground(Color.white);
        difficultyLevel.setBounds(170,250,250,50);
        customization.setBounds(170,150,250,50);
        difficultyLevel.addActionListener(this);
        customization.addActionListener(this);
    }

    //========== Either moving Difficulty frame or to Customization frame ==========
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==difficultyLevel){
            welcomeWindow.dispose();
            DifficultyFrame frame = new DifficultyFrame();
        }
        if (e.getSource() == customization){
            welcomeWindow.dispose();
            CustomizationFrame frame = new CustomizationFrame();
        }
    }
}
