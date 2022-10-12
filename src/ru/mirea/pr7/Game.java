package ru.mirea.pr7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

public class Game extends JFrame {
    private final JPanel centerPanel = new JPanel(new GridLayout(2, 1));
    private final JLabel northPanel = new JLabel("Choose 5 cards from these:");
    private final Stack<Game.Card> cards = new Stack<Game.Card>();
    private final Stack<Game.Card> firstPlayerCards = new Stack<Game.Card>();
    private final Stack<Game.Card> secondPlayerCards = new Stack<Game.Card>();
    private class Card {
        private static int countOfChosenCards = 0;
        private final int cardId;
        private final JLabel imageLabel;

        public int getCardId() {
            return cardId;
        }

        public static int getCountOfChosenCards() {
            return countOfChosenCards;
        }

        public JLabel getImageLabel() {
            return imageLabel;
        }

        public Card(String path, int id) {
            this.cardId = id;
            ImageIcon imgIcon = new ImageIcon(path);
            Image image = imgIcon.getImage(); // изменяем размеры картинки под 256х256 для удобства
            Image newImg = image.getScaledInstance(256, 256,  java.awt.Image.SCALE_SMOOTH);
            imageLabel = new JLabel(new ImageIcon(newImg));
            imageLabel.setOpaque(false);
            imageLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (countOfChosenCards >= 5)
                        return;
                    countOfChosenCards++;
                    imageLabel.setVisible(false);
                    northPanel.setText("You chose card with number " + cardId + ". " +
                            (5 - countOfChosenCards) + " cards left to choose");
                    firstPlayerCards.add(this@)
                    if (countOfChosenCards == 5) {
                        while (cards.size() != 0) {
                            Card card = cards.pop();
                            card.getImageLabel().setVisible(false);
                            secondPlayerCards.add(card);
                        }
                        for (Card firstPlayerCard : firstPlayerCards)
                            System.out.print(firstPlayerCard.getCardId() + " ");
                        System.out.println();
                        for (Card secondPlayerCard : secondPlayerCards)
                            System.out.print(secondPlayerCard.getCardId() + " ");
                    }
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

        }
    }
    public Game() {
        opening();
    }
    public void opening() {
        JFrame frame = new JFrame("Drunker");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 10; i++) {
            String path = "src/ru/mirea/pr7/cards/"+i+".png";
            cards.add(new Card(path, i));
            centerPanel.add(cards.lastElement().getImageLabel());
        }

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
    }
}
