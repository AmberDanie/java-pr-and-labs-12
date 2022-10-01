package ru.mirea.pr4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class matchResults extends JFrame {
    int acCounter = 0, rmCounter = 0;
    String[] winner = {"DRAW", "AC Milan", "Real Madrid"};
    int winnerId = 0;
    JButton buttonACMilan = new JButton("AC Milan");
    JButton buttonRM = new JButton("Real Madrid");
    JLabel labelCenter = new JLabel("Result: " + acCounter + " X " + rmCounter);
    JLabel labelSecond = new JLabel("Last Scorer: " + "N/A");
    Label labelWinner = new Label("Winner: " + winner[winnerId]);
    public matchResults() {
        super("AC Milan | Real Madrid");
        setSize(400, 400);
        setLayout(new BorderLayout());
        add(buttonACMilan, BorderLayout.WEST);
        buttonACMilan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                acCounter += 1;
                labelCenter.setText("Result: " + acCounter + " X " + rmCounter);
                labelSecond.setText("Last Scorer: " + "AC Milan");
                if (acCounter - rmCounter > 0) {
                    buttonACMilan.setBackground(Color.GREEN);
                    buttonRM.setBackground(Color.RED);
                    winnerId = 1;
                }
                if (rmCounter == acCounter) {
                    buttonRM.setBackground(Color.YELLOW);
                    buttonACMilan.setBackground(Color.YELLOW);
                    winnerId = 0;
                }
                labelWinner.setText("Winner: " + winner[winnerId]);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        buttonRM.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rmCounter += 1;
                labelCenter.setText("Result: " + acCounter + " X " + rmCounter);
                labelSecond.setText("Last Scorer: " + "Real Madrid");
                if (rmCounter - acCounter > 0) {
                    winnerId = 2;
                    buttonRM.setBackground(Color.GREEN);
                    buttonACMilan.setBackground(Color.RED);
                }
                if (rmCounter == acCounter) {
                    buttonACMilan.setBackground(Color.ORANGE);
                    buttonRM.setBackground(Color.ORANGE);
                    winnerId = 0;
                }
                labelWinner.setText("Winner: " + winner[winnerId]);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        add(buttonRM, BorderLayout.EAST);
        add(labelCenter, BorderLayout.CENTER);
        add(labelSecond, BorderLayout.NORTH);
        add(labelWinner, BorderLayout.SOUTH);
        labelSecond.setHorizontalAlignment(JLabel.CENTER);
        labelCenter.setHorizontalAlignment(JLabel.CENTER);
        labelWinner.setAlignment(Label.CENTER);
        buttonRM.setBackground(Color.ORANGE);
        buttonACMilan.setBackground(Color.ORANGE);
    }
}