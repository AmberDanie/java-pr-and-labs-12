package ru.mirea.pr7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Game extends JFrame {
    private final JFrame frame = new JFrame("Drunker");
    private final JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    private final JPanel northPanel = new JPanel(new GridLayout(1, 10));
    private final JPanel southPanel = new JPanel(new GridLayout(1, 10));
    private final JLabel northLabel = new JLabel("Choose 5 cards from these:");
    private final JLabel centerLabel = new JLabel("");
    private final Stack<Game.Card> cards = new Stack<>();
    private final Stack<Game.Card> firstPlayerCards = new Stack<>();
    private final Stack<Game.Card> secondPlayerCards = new Stack<>();

    private int i = 0;
    Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            i++;
            Card card1 = firstPlayerCards.firstElement();
            Card card2 = secondPlayerCards.firstElement();
            if ((card1.cardId == 0 && card2.cardId == 9) || (card1.cardId == 9 && card2.cardId == 0)) {
                if (card1.cardId == 0) {
                    southPanel.remove(card1.imageLabel);
                    southPanel.add(card1.imageLabel);
                    southPanel.add(card2.imageLabel);
                    firstPlayerCards.add(card1);
                    firstPlayerCards.add(card2);
                    secondPlayerCards.remove(card2);
                } else {
                    northPanel.remove(card2.imageLabel);
                    northPanel.add(card2.imageLabel);
                    northPanel.add(card1.imageLabel);
                    secondPlayerCards.add(card2);
                    secondPlayerCards.add(card1);
                    firstPlayerCards.remove(card1);
                }
            } else {
                if (card1.cardId > card2.cardId) {
                    southPanel.remove(card1.imageLabel);
                    southPanel.add(card1.imageLabel);
                    southPanel.add(card2.imageLabel);
                    firstPlayerCards.add(card1);
                    firstPlayerCards.add(card2);
                    secondPlayerCards.remove(card2);
                } else {
                    northPanel.remove(card2.imageLabel);
                    northPanel.add(card2.imageLabel);
                    northPanel.add(card1.imageLabel);
                    secondPlayerCards.add(card2);
                    secondPlayerCards.add(card1);
                    firstPlayerCards.remove(card1);
                }
            }
            if (firstPlayerCards.size() == 0) {
                centerLabel.setText("Second");
                centerPanel.add(centerLabel);
                timer.setRepeats(false);
            } else if(secondPlayerCards.size()==0){
                centerLabel.setText("First");
                centerPanel.add(centerLabel);
                timer.setRepeats(false);
            }
            if(i==105){
                centerLabel.setText("Botva");
                centerPanel.add(centerLabel);
                timer.setRepeats(false);
            }
            southPanel.revalidate();
            southPanel.repaint();
            northPanel.revalidate();
            northPanel.repaint();
        }
    });


    private class Card {
        private static int size = 256;
        private static int countOfChosenCards = 0;
        private final int cardId;
        private final JLabel imageLabel;
        private final ImageIcon imgIcon;
        private final MouseListener ma = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Image image = imgIcon.getImage(); // изменяем размеры картинки под 256х256 для удобства
                Image newImg = image.getScaledInstance(size + (size / 16), size + (size / 16), java.awt.Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(newImg));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Image image = imgIcon.getImage(); // изменяем размеры картинки под 256х256 для удобства
                Image newImg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(newImg));
            }
        };

        private final MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                countOfChosenCards++;
                imageLabel.setVisible(false);
                northLabel.setText("You chose card with number " + cardId + ". " +
                        (5 - countOfChosenCards) + " cards left to choose");
                firstPlayerCards.add(Card.this);
                cards.remove(Card.this);
                if (countOfChosenCards == 5) {
                    while (cards.size() != 0) {
                        Card card = cards.firstElement();
                        secondPlayerCards.add(card);
                        card.imageLabel.setVisible(false);
                        cards.remove(card);
                    }
                    for (int i = 0; i < 5; i++) {
                        centerPanel.remove(firstPlayerCards.get(i).imageLabel);
                        centerPanel.remove(secondPlayerCards.get(i).imageLabel);
                    }
                    middle();
                }
            }
        };

        public Card(int id) {
            this.cardId = id;
            imgIcon = new ImageIcon("src/ru/mirea/pr7/cards/" + id + ".png");
            Image image = imgIcon.getImage(); // изменяем размеры картинки под 256х256 для удобства
            Image newImg = image.getScaledInstance(256, 256, java.awt.Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(newImg));
            imageLabel.setOpaque(false);
            imageLabel.addMouseListener(ma);
            imageLabel.addMouseListener(ml);
        }
    }

    public void prepareCards(Stack<Game.Card> cards, JPanel panel) {
        for (Card card : cards) {
            JLabel imageLabel = card.imageLabel;
            Image image = card.imgIcon.getImage(); // изменяем размеры картинки под 256х256 для удобства
            Image newImg = image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            Card.size = 128;
            imageLabel.setIcon(new ImageIcon(newImg));
            imageLabel.setVisible(true);
            panel.add(imageLabel);
            imageLabel.removeMouseListener(card.ml);
        }
    }

    public Game() {
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        opening();
    }

    public void opening() {
        for (int i = 0; i < 10; i++) {
            cards.add(new Card(i));
            centerPanel.add(cards.lastElement().imageLabel);
        }

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(northLabel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }

    public void middle() {
        // Раскладываем выбранные карты
        prepareCards(firstPlayerCards, southPanel);
        prepareCards(secondPlayerCards, northPanel);
        //
        frame.remove(northLabel);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        timer.setRepeats(true);
        timer.start();

    }


}