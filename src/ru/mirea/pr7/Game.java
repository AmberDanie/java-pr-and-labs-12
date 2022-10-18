package ru.mirea.pr7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Game extends JFrame {
    private final JFrame frame = new JFrame("Drunker");
    private final JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    private final JPanel northPanel = new JPanel(new GridLayout(1, 10));
    private final JPanel southPanel = new JPanel(new GridLayout(1, 10));
    private final JLabel northLabel = new JLabel("Choose 5 cards from these:");
    private final JLabel textLabel = new JLabel("");
    private final Stack<Game.Card> cards = new Stack<>();
    private final Stack<Game.Card> firstPlayerCards = new Stack<>();
    private final Stack<Game.Card> secondPlayerCards = new Stack<>();

    private int i = 1;
    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            i++;
            Card card1 = firstPlayerCards.firstElement();
            Card card2 = secondPlayerCards.firstElement();

            firstPlayerCards.remove(card1);
            secondPlayerCards.remove(card2);

            southPanel.remove(card1.imageLabel);
            northPanel.remove(card2.imageLabel);

            if ((card1.cardId == 0 && card2.cardId == 9) || (card1.cardId == 9 && card2.cardId == 0)) {
                if (card1.cardId == 0) {
                    southPanel.add(card1.imageLabel);
                    southPanel.add(card2.imageLabel);
                    firstPlayerCards.add(card1);
                    firstPlayerCards.add(card2);
                } else {
                    northPanel.add(card2.imageLabel);
                    northPanel.add(card1.imageLabel);
                    secondPlayerCards.add(card2);
                    secondPlayerCards.add(card1);
                }
            } else {
                if (card1.cardId > card2.cardId) {
                    southPanel.add(card1.imageLabel);
                    southPanel.add(card2.imageLabel);
                    firstPlayerCards.add(card1);
                    firstPlayerCards.add(card2);
                } else {
                    northPanel.add(card2.imageLabel);
                    northPanel.add(card1.imageLabel);
                    secondPlayerCards.add(card2);
                    secondPlayerCards.add(card1);
                }
            }
            if (firstPlayerCards.size() == 0) {
                textLabel.setText("Second");
                textLabel.setFont(new Font("Times new roman", Font.BOLD, 256));
                centerPanel.remove(textLabel);
                southPanel.add(textLabel);
                timer.stop();
                return;
            } else if(secondPlayerCards.size()==0){
                textLabel.setText("First");
                textLabel.setFont(new Font("Times new roman", Font.BOLD, 256));
                centerPanel.remove(textLabel);
                northPanel.add(textLabel);
                timer.stop();
                return;
            }
            if(i==106){
                textLabel.setText("BOTVA");
                textLabel.setFont(new Font("Times new roman", Font.BOLD, 64));
                timer.stop();
                return;
            }
            southPanel.revalidate();
            southPanel.repaint();
            northPanel.revalidate();
            northPanel.repaint();
            textLabel.setText("Round " + i);
        }
    });


    private class Card {
        private static int size = 256;
        private static int countOfChosenCards = 0;
        private final int cardId;
        private final JLabel imageLabel;
        private final ImageIcon imgIcon;

        private final MouseListener mouseClicked = new MouseAdapter() {
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
            Image newImg = image.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(newImg));
            imageLabel.setOpaque(false);

            MouseListener mouseChoose = new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    Image image = imgIcon.getImage();
                    Image newImg = image.getScaledInstance(size + (size / 16),
                            size + (size / 16), Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(newImg));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Image image = imgIcon.getImage();
                    Image newImg = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
                    imageLabel.setIcon(new ImageIcon(newImg));
                }
            };
            imageLabel.addMouseListener(mouseChoose);
            imageLabel.addMouseListener(mouseClicked);
        }
    }

    public Game() {
        northLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.setLayout(new BorderLayout());
        frame.setIconImage(new ImageIcon("src/ru/mirea/pr7/cards/icon.png").getImage());
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

    public void prepareCards(Stack<Game.Card> cards, JPanel panel) {
        for (Card card : cards) {
            JLabel imageLabel = card.imageLabel;
            Image image = card.imgIcon.getImage();
            Image newImg = image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            Card.size = 128;
            imageLabel.setIcon(new ImageIcon(newImg));
            imageLabel.setVisible(true);
            panel.add(imageLabel);
            imageLabel.removeMouseListener(card.mouseClicked);
        }
    }

    public void middle() {
        // Раскладываем выбранные карты
        prepareCards(firstPlayerCards, southPanel);
        prepareCards(secondPlayerCards, northPanel);

        frame.remove(northLabel);
        frame.add(centerPanel, BorderLayout.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.BOTTOM);
        textLabel.setFont(new Font("Times new roman", Font.BOLD, 64));
        textLabel.setText("Round 1");
        centerPanel.add(textLabel);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.SOUTH);
        timer.setRepeats(true);
        timer.start();
    }
}