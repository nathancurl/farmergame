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
        Player ben = new Player();

        //setup the frame
        JFrame sWindow = new JFrame("Farmer Ben Main Story");
        sWindow.setSize(500,550);
        sWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sWindow.setLocationRelativeTo(null);

        //player info
        
        JPanel plyrInfo = new JPanel();
        sWindow.add(plyrInfo, BorderLayout.SOUTH);
        JButton healthB = new JButton("Health: "+ben.getHealth());
        JButton moneyB = new JButton("Money: "+ ben.getMoney());
        plyrInfo.add(moneyB);
        plyrInfo.add(healthB);

        //next button that triggers everything
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

                    ben.setMoney(500); //use this to export the money from nathan's game
                    moneyB.setText("Money:" + ben.getMoney());
                }else if(curProgess ==3){
                    //run blanche's game
                    ButtonGrid1 bg1 = new ButtonGrid1 (3,3,next);//runs the light game
                    ButtonGrid2 bg2 = new ButtonGrid2(3,3,ben);//runs the memory game
                    healthB.setText("Health: "+ben.getHealth());
                }else if(curProgess ==4){
                    //run george's game
                    MazeWindow maze = new MazeWindow();
                    maze.startMG(ben.getMoney(), next);

                }else if(curProgess ==5){
                    //run prim's game
                    Game boss = new Game(ben); 
                    sWindow.dispose();

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
