
import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class UI {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, titleGamePanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, bossHPLabel, bossHPNumLabel,titleGameLabel;
    JButton startButton, choice1, choice2;

    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);

    public void createUI(Game.ChoiceHandler cHandler){
        //window
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //title screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Boss Battle");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,200,100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("Start");
        startButton.setBackground(white);
        startButton.setForeground(blue);
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
        mainTextPanel.setBackground(black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(black);
        mainTextArea.setForeground(white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(black);
        choiceButtonPanel.setLayout(new GridLayout(2, 1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("choice 1");
        choice1.setBackground(black);
        choice1.setForeground(blue);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("choice 2");
        choice2.setBackground(black);
        choice2.setForeground(blue);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(black);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);


        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(blue);
        playerPanel.add(hpLabel);
        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(blue);
        hpNumberLabel.setFont(normalFont);
        playerPanel.add(hpNumberLabel);

        bossHPLabel = new JLabel("Boss HP: ");
        bossHPLabel.setFont(normalFont);
        bossHPLabel.setForeground(blue);
        playerPanel.add(bossHPLabel);
        bossHPNumLabel = new JLabel();
        bossHPNumLabel.setForeground(blue);
        bossHPNumLabel.setFont(normalFont);
        playerPanel.add(bossHPNumLabel);


    }


}
