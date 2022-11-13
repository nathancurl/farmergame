package package02;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

public class sUI{
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    JLabel titleNameLabel;
    JButton startButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(storyLineGui.ChoiceHandler cHandler) {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Color tan = new Color(210, 180, 140);
        window.getContentPane().setBackground(tan);
        window.setLayout(null);

        //title screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,500);
        titleNamePanel.setBackground(tan);
        titleNameLabel = new JLabel("Farmer Ben");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(tan);
        startButton = new JButton("Play");
        startButton.setBackground(tan);
        startButton.setForeground(black);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.setVisible(true);

        //game screen
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(tan);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("???");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(tan);
        mainTextArea.setForeground(white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

    }
}
