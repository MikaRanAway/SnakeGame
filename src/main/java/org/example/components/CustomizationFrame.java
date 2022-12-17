package org.example.components;

import org.example.UniversalColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class CustomizationFrame implements ActionListener {

    //Frames
    JFrame customizationFrame = new JFrame();

    //Universal Random Indicator
    public static boolean colorRandom = false;

    //Buttons
    JButton staticColors = new JButton("Static Colors");
    JButton random = new JButton("Random");
    JButton invisible = new JButton("Invisible");

    //Constructor
    CustomizationFrame(){
        staticColors.setBounds(225,100,150,50);
        random.setBounds(225,250,150,50);
        invisible.setBounds(225,400,150,50);
        staticColors.addActionListener(this);
        random.addActionListener(this);
        invisible.addActionListener(this);
        customizationFrame.setSize(600,600);
        customizationFrame.getContentPane().setBackground(Color.decode("#3333"));
        customizationFrame.setLayout(null);
        customizationFrame.setVisible(true);
        customizationFrame.setLocationRelativeTo(null);
        customizationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customizationFrame.add(staticColors);
        customizationFrame.add(random);
        customizationFrame.add(invisible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == staticColors){
        customizationFrame.dispose();
        StaticColorsFrame staticColorsFrame = new StaticColorsFrame();
    }
    if(e.getSource() == random) {
        colorRandom = true;
        DifficultyFrame difficultyFrame = new DifficultyFrame();
        customizationFrame.dispose();
    }

    if(e.getSource() == invisible){
        UniversalColor universalColor = new UniversalColor();
        universalColor.setColorHead(Color.BLACK, Color.BLACK);
        customizationFrame.dispose();
        DifficultyFrame difficultyFrame = new DifficultyFrame();
    }
    }

    public static void randomColor(){
        Random random = new Random();
        double r = random.nextFloat();
        double g = random.nextFloat();
        double b = random.nextFloat();
        Color randomColor = new Color((float) r, (float) g, (float) b);
        UniversalColor universalColor = new UniversalColor();
        universalColor.setColorHead(randomColor, randomColor);
    }
}
