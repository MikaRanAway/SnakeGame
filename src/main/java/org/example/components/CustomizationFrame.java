package org.example.components;

import org.example.Settings;
import org.example.SnakeColorSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomizationFrame implements ActionListener {

    //Frames
    JFrame customizationFrame = new JFrame();

    //Universal Random Indicator

    //========== Creating the Customization frame components (Buttons) ==========
    JButton staticColorsBtn = new JButton("Static Colors");
    JButton randomColorsBtn = new JButton("Random");
    JButton invisibleOptionBtn = new JButton("Invisible");

    //========== Defining the Customization frame components(constructors) ==========
    CustomizationFrame() {
        staticColorsBtn.setBounds(225, 100, 150, 50);
        randomColorsBtn.setBounds(225, 250, 150, 50);
        invisibleOptionBtn.setBounds(225, 400, 150, 50);
        staticColorsBtn.addActionListener(this);
        randomColorsBtn.addActionListener(this);
        invisibleOptionBtn.addActionListener(this);
        customizationFrame.setSize(600, 600);
        customizationFrame.getContentPane().setBackground(Color.decode("#3333"));
        customizationFrame.setLayout(null);
        customizationFrame.setVisible(true);
        customizationFrame.setLocationRelativeTo(null);
        customizationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customizationFrame.add(staticColorsBtn);
        customizationFrame.add(randomColorsBtn);
        customizationFrame.add(invisibleOptionBtn);
    }

    //========== Three different buttons to set the snake's colour ==========
    //========== Choosing the static colour option will take the user to a another Customization colour frame  ==========
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == staticColorsBtn) {
            customizationFrame.dispose();
            new StaticColorsFrame();
        }

        //========== Choosing random colour will take the user to the difficulty frame==========
        if (e.getSource() == randomColorsBtn) {
            SnakeColorSettings.isRandomColor = true;
            customizationFrame.dispose();
            new DifficultyFrame();
        }

        //========== Choosing invisible colour(Colour the match the background) will take the user to the difficulty frame==========
        if (e.getSource() == invisibleOptionBtn) {
            Settings settings = Settings.getInstance();
            SnakeColorSettings.setColors(settings.gamePanelBackground, settings.gamePanelBackground);
            customizationFrame.dispose();
            new DifficultyFrame();
        }
    }


}
