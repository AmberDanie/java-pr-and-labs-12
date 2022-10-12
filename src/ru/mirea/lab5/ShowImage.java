package ru.mirea.lab5;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class ShowImage extends JFrame {
    private JLabel imgLabel;
    private int imgNum = 1;

    ShowImage(){
        this.setSize(315, 312);
        imgLabel = new JLabel("", new ImageIcon(getClass().getResource("1.png")), SwingConstants.CENTER);

        getContentPane().add(imgLabel);

        Timer timer = new Timer(1000, e -> nextImg());
        timer.start();
    }
    private void nextImg(){
        imgLabel.setIcon(new ImageIcon(getClass().getResource((++imgNum)+".png")));
        if(imgNum == 2) imgNum = 0;

    }
}