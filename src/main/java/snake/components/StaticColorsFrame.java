package snake.src.main.java.snake.components;

import snake.src.main.java.snake.BodyPart;
import snake.src.main.java.snake.SnakeHead;
import snake.src.main.java.snake.UniversalColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaticColorsFrame implements ActionListener {

    //Frame
    JFrame staticColorFrame = new JFrame();

    //Buttons
    JButton red = new JButton("Red");
    JButton blue = new JButton("Blue");
    JButton green = new JButton("Green");
    JButton yellow = new JButton("Yellow");
    JButton white = new JButton("White");
    JButton purple = new JButton("Purple");

    //Constructor
    StaticColorsFrame(){
        red.setBounds(125,100,150,50);
        blue.setBounds(125,250,150,50);
        green.setBounds(125,400,150,50);
        yellow.setBounds(325,100,150,50);
        white.setBounds(325,250,150,50);
        purple.setBounds(325,400,150,50);
        red.addActionListener(this);
        blue.addActionListener(this);
        green.addActionListener(this);
        yellow.addActionListener(this);
        white.addActionListener(this);
        purple.addActionListener(this);
        staticColorFrame.setSize(600,600);
        staticColorFrame.getContentPane().setBackground(Color.decode("#3333"));
        staticColorFrame.setLayout(null);
        staticColorFrame.setVisible(true);
        staticColorFrame.setLocationRelativeTo(null);
        staticColorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staticColorFrame.add(red);
        staticColorFrame.add(blue);
        staticColorFrame.add(green);
        staticColorFrame.add(yellow);
        staticColorFrame.add(white);
        staticColorFrame.add(purple);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Color headColor = null;
    Color bodyColor = null;

        if(e.getSource() == red){
           headColor = Color.decode("#FF0000");
           bodyColor = Color.decode("#880808");
        }

        if(e.getSource() == blue){
            headColor = Color.decode("#0096FF");
            bodyColor = Color.decode("#0096FF");
        }

        if(e.getSource() == green){
            headColor = Color.decode("#50C878");
            bodyColor = Color.decode("#7CFC00");
        }

        if(e.getSource() == yellow){
            headColor = Color.decode("#FFC000");
            bodyColor = Color.decode("#FCF55F");
        }

        if(e.getSource() == white){
            headColor = Color.decode("#FFFFF0");
            bodyColor = Color.decode("#F0EAD6");
        }

        if(e.getSource() == purple){
            headColor = Color.decode("#BF40BF");
            bodyColor = Color.decode("#702963");
        }

        UniversalColor universalColor = new UniversalColor();
        universalColor.setColorHead(headColor, bodyColor);

        DifficultyFrame DifficultyFrame = new DifficultyFrame();
        staticColorFrame.dispose();
    }
}

