package org.example.components;

import org.example.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame implements ActionListener {
    JFrame difficultyWindow = new JFrame();
    JButton Easy = new JButton("Easy");
    JButton Medium = new JButton("Medium");
    JButton Hard = new JButton("Hard");

    DifficultyFrame(){
        Easy.setBounds(225,100,150,50);
        Medium.setBounds(225,250,150,50);
        Hard.setBounds(225,400,150,50);
        Easy.addActionListener(this);
        Medium.addActionListener(this);
        Hard.addActionListener(this);
        difficultyWindow.setSize(600,600);
        difficultyWindow.getContentPane().setBackground(Color.decode("#3333"));
        difficultyWindow.setLayout(null);
        difficultyWindow.setVisible(true);
        difficultyWindow.setLocationRelativeTo(null);
        difficultyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        difficultyWindow.add(Easy);
        difficultyWindow.add(Medium);
        difficultyWindow.add(Hard);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==Easy){
            difficultyWindow.dispose();
            Game.setTickSpeed(200);
        }else if (e.getSource() ==Medium){
            difficultyWindow.dispose();
            Game.setTickSpeed(100);
        }else if (e.getSource() ==Hard){
            difficultyWindow.dispose();
            Game.setTickSpeed(50);
        }
        Game game = new Game();
        game.start();
    }
}
