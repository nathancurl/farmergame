import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static java.awt.Color.black;
import static java.awt.Color.white;


public class buttonPanel extends farmerGame {
    int curDay;
    //Player ben = new Player();
    JButton button = new JButton();
    buttonPanel(int curDay_, Player ben, JButton button) {
        JFrame f = new JFrame("Pick your crop");
        curDay = curDay_;
        this.button = button;
        // set to visible after dispose window* button.setVisible(false);
        JTextArea dayCounter = new JTextArea(String.format("Days remaining: %d", curDay));
        dayCounter.setBounds(10, 1000, 200, 100);
        dayCounter.setBackground(black);
        dayCounter.setForeground(white);
        dayCounter.setFont(normalFont);
        dayCounter.setWrapStyleWord(true);
        dayCounter.setLineWrap(true);
        dayCounter.setEditable(false);
        f.add(dayCounter);
        JTextArea mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(150, 50, 400, 100);
        mainTextArea.setBackground(black);
        mainTextArea.setForeground(white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        f.add(mainTextArea);
        mainTextArea.setText("Hello and welcome to the market. \n Good luck selling your crops! ");
//        f.validate();
//        f.repaint();
        JButton wheatButton = new JButton(new ImageIcon("wheat.jpg"));
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curDay>0) {
                    String a = checkPrice("Wheat", ben);
                    mainTextArea.setText(a);
                    curDay--;
                    dayCounter.setText(String.format("Current day: %d", curDay));
                }
            }
        };
        wheatButton.addActionListener(actionListener);
        wheatButton.setBounds(200, 200, 200, 200);
        TextField Wheat;
        Wheat = new TextField("Corn");
        Wheat.setFont(normalFont);
        Wheat.setBackground(black);
        Wheat.setForeground(white);
        Wheat.setBounds(255, 400, 150, 50);
        Wheat.setText("Wheat");
        Wheat.setEditable(false);
        f.add(wheatButton);
        f.add(Wheat);

        JButton cornButton = new JButton(new ImageIcon("corn.jpg"));
        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curDay>0){
                    String b = checkPrice("Corn" , ben);
                    //System.out.print("Corn");
                    mainTextArea.setText(b);
                    curDay--;
                    dayCounter.setText(String.format("Current day: %d", curDay));
                }
            }
        };
        cornButton.addActionListener(actionListener1);
        cornButton.setBounds(200, 450, 200, 200);
        TextField Corn;
        Corn = new TextField("Corn");
        Corn.setBackground(black);
        Corn.setForeground(white);
        Corn.setFont(normalFont);
        Corn.setBounds(265, 650, 150, 50);
        Corn.setText("Corn");
        Corn.setEditable(false);
        f.add(cornButton);
        f.add(Corn);

        JButton basilButton = new JButton(new ImageIcon("basil.jpg"));
        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (curDay>0){
                    String c = checkPrice("Basil", ben);
                    mainTextArea.setText(c);
                    curDay--;
                    dayCounter.setText(String.format("Current day: %d", curDay));
                }
            }
        };
        basilButton.addActionListener(actionListener2);
        basilButton.setBounds(200, 700, 200, 200);
        TextField Basil;
        Basil = new TextField("Corn");
        Basil.setFont(normalFont);
        Basil.setBackground(black);
        Basil.setForeground(white);
        Basil.setBounds(265, 900, 150, 50);
        Basil.setText("Basil");
        Basil.setEditable(false);
        f.add(basilButton);
        f.add(Basil);

        JButton finishButton = new JButton("Finish");
        ActionListener actionListener3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                }
        };
        finishButton.setBounds(450, 950, 150, 100);
        finishButton.setFont(normalFont);
        finishButton.setVisible(true);
        finishButton.setBackground(black);
        finishButton.addActionListener(actionListener3);
        f.add(finishButton);

        f.setSize(600, 1400);
        f.setBounds(1200, 0, 600, 1400);
        f.setLayout(null);
        f.getContentPane().setBackground(black);
        f.setForeground(black);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}