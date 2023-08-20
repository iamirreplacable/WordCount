package com.aman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class word_count extends JFrame {
    private JTextArea inputTextArea;
    private JTextArea resultTextArea;
    private JComboBox<String> operationComboBox;

    public word_count() {
        setTitle("Word Count");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Panel for better organization
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 370, 340);
        panel.setBackground(new Color(240, 240, 240));
        add(panel);

        JLabel titleLabel = new JLabel("Word Count Application");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(70, 10, 250, 30);
        panel.add(titleLabel);

        JLabel inputLabel = new JLabel("Enter your statement or number of statements:");
        inputLabel.setBounds(20, 50, 350, 20);
        panel.add(inputLabel);

        inputTextArea = new JTextArea();
        inputTextArea.setBounds(20, 80, 330, 80);
        panel.add(inputTextArea);

        JButton countButton = new JButton("Count Words");
        countButton.setBounds(120, 180, 120, 30);
        panel.add(countButton);

        String[] operations = {"Select Operation", "Print Unique Words", "Print Words with Frequencies","count of words"};
        operationComboBox = new JComboBox<>(operations);
        operationComboBox.setBounds(20, 220, 330, 30);
        panel.add(operationComboBox);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextArea.getText();
                inputText = inputText.trim();
                if (inputText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid sentence.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int selectedOperationIndex = operationComboBox.getSelectedIndex();
                    switch (selectedOperationIndex) {
                        case 0:
                            JOptionPane.showMessageDialog(null, "Please select an operation.", "Error", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 1:
                            printUniqueWords(inputText);
                            break;
                        case 2:
                            printWordsWithFrequencies(inputText);
                            break;
                        case 3:
                            count(inputText);
                            break;
                    }
                }
            }
        });

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setBounds(20, 260, 330, 70);
        panel.add(resultTextArea);

        add(panel);
    }
    private void printUniqueWords(String input) {
        HashSet<String> set = new HashSet<>();
        String[] arr = input.split(" ");

        for (String word : arr) {
            if (word.matches("[.,?:;/']")) {
                continue;
            } else {
                set.add(word);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("List of unique words:\n");
        for (String ele : set) {
            result.append(ele).append(" ");
        }

        resultTextArea.setText(result.toString());
    }
    private void count(String input) {
        String[] arr = input.split(" ");
        int length=arr.length;
        StringBuilder result = new StringBuilder();

        result.append("coiunt of words is:"+length);


        resultTextArea.setText(result.toString());
    }
    private void printWordsWithFrequencies(String input) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = input.split(" ");

        for (String word : arr) {
            if (word.matches("[.,?:;/']")) {
                continue;
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("List of words with their frequency:\n");
        for (Map.Entry<String, Integer> ele : map.entrySet()) {
            result.append("Word: ").append(ele.getKey()).append(" - Frequency: ").append(ele.getValue()).append("\n");
        }

        resultTextArea.setText(result.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Set the look and feel to the system default
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                new word_count().setVisible(true);
            }
        });
    }
}
