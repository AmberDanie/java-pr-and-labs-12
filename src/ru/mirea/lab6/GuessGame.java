package ru.mirea.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class GuessGame extends JFrame {
    private final Vector<Number> nums = new Vector<>();
    private int tries = 3;
    private final JPanel centralPanel = new JPanel(new GridLayout(2, 10));
    private final JLabel messageNorthLabel = new JLabel("I made a number for you. Try to guess it.");
    private final JLabel messageSouthLabel = new JLabel("Number of attempts: " + tries);
    public class Number {
        private static int guessedNum;
        private final int id;
        private final Button textId;
        private final Font fontSmall = new Font("Times new roman", Font.BOLD, 32);
        private final Font fontBig = new Font("Times new roman", Font.BOLD, 40);
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                Number.this.textId.setFont(fontBig);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Number.this.textId.setFont(fontSmall);
            }
        };
        MouseListener ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (id == guessedNum) {
                    Number.this.textId.setForeground(new Color(0, 175, 0));
                    Number.this.textId.setBackground(new Color(0, 125, 0));
                    messageSouthLabel.setText("You right! It's " + guessedNum);
                    messageNorthLabel.setText("=)");
                    stop();
                }
                else {
                    if (id < guessedNum) {
                        for (int i = id - 1; i >= 0; i--) {
                            nums.get(i).textId.removeMouseListener(nums.get(i).ml);
                            nums.get(i).textId.setForeground(new Color(200, 0, 0));
                            nums.get(i).textId.setBackground(new Color(100, 0, 0));
                        }
                    }
                    else {
                        for (int i = id; i < nums.size(); i++) {
                            nums.get(i).textId.removeMouseListener(nums.get(i).ml);
                            nums.get(i).textId.setForeground(new Color(200, 0, 0));
                            nums.get(i).textId.setBackground(new Color(100, 0, 0));
                        }
                    }
                    Number.this.textId.removeMouseListener(Number.this.ml);
                    Number.this.textId.setFont(fontSmall);
                    Number.this.textId.setForeground(new Color(200, 0, 0));
                    Number.this.textId.setBackground(new Color(100, 0,0));
                    tries--;
                    if (tries == 0) {
                        messageNorthLabel.setText("=(");
                        messageSouthLabel.setText("You lose! It was number " + guessedNum);
                        stop();
                        return;
                    }
                    messageSouthLabel.setText("Number of attempts: " + tries);
                }
            }
        };
        Number(int numId) {
            id = numId;
            textId = new Button(String.valueOf(id));
            textId.setFont(fontSmall);
            textId.addMouseListener(ml);
            textId.addMouseListener(ma);
            centralPanel.add(textId);
            nums.add(this);
        }
    }
    public GuessGame() {
        Font font = new Font("Times new roman", Font.BOLD, 64);
        messageSouthLabel.setFont(font);
        JPanel southPanel = new JPanel();
        southPanel.add(messageSouthLabel);
        JFrame frame = new JFrame("Guesser");
        frame.setSize(1920, 830);
        frame.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(centralPanel, BorderLayout.CENTER);
        frame.add(southPanel, BorderLayout.SOUTH);
        northPanel.add(messageNorthLabel);
        messageNorthLabel.setHorizontalAlignment(JLabel.CENTER);
        messageNorthLabel.setFont(font);
        for (int i = 1; i <= 20; i++)
            new Number(i);
        Number.guessedNum = (int) Math.floor((Math.random() * 20));
        if (Number.guessedNum == 0)
            Number.guessedNum++;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void stop() {
        for (Number num : nums) {
            num.textId.setFocusable(false);
            num.textId.removeMouseListener(num.ma);
            num.textId.removeMouseListener(num.ml);
        }
    }
}
