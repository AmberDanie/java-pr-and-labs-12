package ru.mirea.pr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Student {
    private final String studentLastname;
    private final float studentScore;
    private JLabel studentLabel;
    private Font defaultFont = new Font("Times new roman", Font.BOLD, 20);
    private Font biggerFont = new Font("Times new roman", Font.BOLD, 24);
    MouseListener textML = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            studentLabel.setFont(biggerFont);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            studentLabel.setFont(defaultFont);
        }
    };

    public Student(String studentLine) {
        studentLabel = new JLabel(studentLine);
        studentLabel.setHorizontalAlignment(JLabel.CENTER);
        studentLabel.setFont(defaultFont);
        studentLabel.addMouseListener(textML);
        this.studentLastname = studentLine.substring(0, studentLine.indexOf(" "));
        this.studentScore = Float.parseFloat(studentLine.substring(studentLine.indexOf(" ") + 1));
        System.out.println(studentLastname + "-" + studentScore);
    }

    public float getStudentScore() {
        return studentScore;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public JLabel getStudentLabel() {
        return studentLabel;
    }
}
