package ru.mirea.pr9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LabClassUI {
    private final JFrame frame = new JFrame("Student list");
    private final ArrayList<Student> students = new ArrayList<>();
    private JTextField textA;
    private JPanel centerPanel;
    private JButton textButton;
    private final JButton returnButton = new JButton("Return to full list");
    private final JPanel eastPanel = new JPanel(new GridLayout(3, 1));
    private final JPanel westPanel = new JPanel(new GridLayout(3, 1));
    private final JPanel southPanel = new JPanel(new GridLayout(1, 3));
    private final JPanel buttonPanel = new JPanel(new GridLayout(1, 9));
    private final Color buttonColor = new Color(100, 240, 150);

    MouseListener sortScoreListener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            LabClass sorter = new LabClass();
            sorter.sortByScore(students, 0, students.size() - 1);
            refresh();
        }
    };

    MouseListener sortNameListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            LabClass sorter = new LabClass();
            sorter.sortByName(students, 0, students.size() - 1);
            refresh();
        }
    };

    MouseListener buttonListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            boolean flag = false;
            JLabel noFound = new JLabel("Not found");
            noFound.setHorizontalAlignment(SwingConstants.CENTER);
            noFound.setFont(new Font("Times new roman", Font.BOLD, 24));
            String studentSearch = textA.getText();
            if (studentSearch.isEmpty())
                return;
            if (studentSearch.toLowerCase(Locale.ROOT).equals("meow"))
                studentSearch = "Karpov";
            centerPanel.removeAll();
            for (int j = 0; j < 14; j++)
                centerPanel.add(Box.createVerticalStrut(0));
            try {
                for (Student student : students) {
                    if (student.getStudentLastname().equals(studentSearch)) {
                        JLabel stud = student.getStudentLabel();
                        centerPanel.add(stud);
                        flag = true;
                    }
                }
                if (!flag) {
                    centerPanel.add(noFound);
                    throw new StudentNotFoundException("Student not found");
                }
            }
            catch(StudentNotFoundException ex) {
                ex.printStackTrace();
            }
            southPanel.removeAll();
            southPanel.add(Box.createVerticalStrut(0));
            southPanel.add(textA);
            textA.setVisible(false);
            southPanel.add(returnButton);
            southPanel.add(Box.createVerticalStrut(0));
            southPanel.add(Box.createVerticalStrut(0));
            centerPanel.revalidate();
            centerPanel.repaint();
        }
    };

    MouseListener returnButtonListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            centerPanel.removeAll();
            southPanel.removeAll();
            buttonPanel.removeAll();
            southPanel.add(Box.createVerticalStrut(0));
            southPanel.add(textA);
            textA.setVisible(true);
            southPanel.add(buttonPanel);
            buttonPanel.add(textButton);
            for (int i = 0; i < 2; i++)
                buttonPanel.add(Box.createVerticalStrut(0));
            refresh();
        }
    };
    public void refresh() {
        centerPanel.removeAll();
        for (Student student : students)
            centerPanel.add(student.getStudentLabel());
        frame.remove(centerPanel);
        frame.add(centerPanel, JLabel.CENTER);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public LabClassUI() {
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        opening();
    }

    public void opening() {
        try {
            Scanner file = new Scanner(new File("src/ru/mirea/pr9/studentListBeforeSorting"));
            String line;

            while (file.hasNextLine()) {
                try {
                    line = file.nextLine();
                    if (line.isEmpty())
                        throw new EmptyStringException("Empty student raw");
                    else {
                        students.add(new Student(line));
                    }
                } catch (EmptyStringException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }

        centerPanel = new JPanel(new GridLayout(Math.min(students.size(), 30), (int)Math.ceil(students.size() / 30.0)));
        for (Student student : students)
            centerPanel.add(student.getStudentLabel());
        frame.add(centerPanel, JLabel.CENTER);

        JButton buttonSortByScore = new JButton("Sort by score");
        eastPanel.add(Box.createVerticalStrut(0));
        eastPanel.add(buttonSortByScore);
        buttonSortByScore.setBackground(buttonColor);
        buttonSortByScore.addMouseListener(sortScoreListener);
        eastPanel.add(Box.createVerticalStrut(2));

        JButton buttonSortByName = new JButton("Sort by name");
        buttonSortByName.setBackground(buttonColor);
        buttonSortByName.addMouseListener(sortNameListener);
        westPanel.add(Box.createVerticalStrut(0));
        westPanel.add(buttonSortByName);
        westPanel.add(Box.createVerticalStrut(2));

        southPanel.add(Box.createVerticalStrut(0));
        textA = new JTextField();
        textA.setFont(new Font("Times new roman", Font.BOLD, 24));
        southPanel.add(textA);

        southPanel.add(buttonPanel);
        textButton = new JButton("OK");
        textButton.setBackground(buttonColor);
        textButton.addMouseListener(buttonListener);

        returnButton.addMouseListener(returnButtonListener);
        returnButton.setBackground(buttonColor);

        buttonPanel.add(textButton);
        for (int i = 0; i < 2; i++)
            buttonPanel.add(Box.createVerticalStrut(0));

        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
