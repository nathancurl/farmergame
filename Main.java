import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    int curProgess;

    String level1 = "farming game";
    String level2 = " puzzel game";
    String level3 = "click next to start maze game";
    String level4 = "boss battle";
    String end = " thanks for playing";

        String[] story = {level1,level2,level3,level4,end};
    public Main() {

        //setup the frame
        JFrame sWindow = new JFrame("Farmer Ben Main Story");
        sWindow.setSize(500,550);
        sWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sWindow.setLocationRelativeTo(null);
        JButton text = new JButton();
        text.setText("Welcome");
        sWindow.add(text, BorderLayout.CENTER);
        JButton next = new JButton( "next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curProgess++;
                if(curProgess ==2){
                    //run nathan's game
                }else if(curProgess ==3){
                    //run blanche's game
                }else if(curProgess ==4){
                    //run george's game
                    MazeWindow maze = new MazeWindow();
                    maze.startMG(500, next);

                }else if(curProgess ==5){
                    //run prim's game
                    Game boss = new Game();
                }


                text.setText(story[curProgess-1]);


            }


        });

        sWindow.add(next,BorderLayout.NORTH);

        sWindow.setVisible(true);


}

    public static void main(String[] args) {
        Main g = new Main();
    }
}
