package ru.mirea.lab5;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class ShowImage extends JFrame {
    private final JLabel imgLabel;
    private int imgNum = 0;

    ShowImage(){
        this.setSize(640, 480);
        ImageIcon img = new ImageIcon("src/ru/mirea/lab5/pepe/frame_0.png");
        imgLabel = new JLabel("", img, SwingConstants.CENTER);
        this.setIconImage(img.getImage());
        getContentPane().add(imgLabel);

        Timer timer = new Timer(25, e -> nextImg());
        timer.start();
    }
    private void nextImg(){
        imgLabel.setIcon(new ImageIcon("src/ru/mirea/lab5/pepe/frame_"+(imgNum++)+".png"));
        if(imgNum == 105) imgNum = 0;
    }
}