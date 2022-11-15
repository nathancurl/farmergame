import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    int curProgess;
    
     String s1 = "Oh no. What's that over there? It's an alien!!!"  ;
     String s2 = "Farmer Ben watch out, the Alien is kidnapping your son Milo.";
     String s3 = "Farmer Ben, you need to go rescue your son. It is your mission. ";
     String s4 ="click next to accept the Milo Rescue mission";
     String s5 ="We the game designers are so glad you decided to accept the mission. ";
     String s6 ="Only terrible parents would not rescue their child...";
     String s7 ="But first things first, you are gonna need a spaceship to follow the Alien.";
     String s8 ="There is a used one for sale. You better start farming.";
     String s9 ="Once you make enough money to buy the ship, you can move on.";
     String s10 = "However, having a little extra cash in your pocket might be useful later. *hint hint";
     String s11 = "click next to start farming";
     String s12 = "Whelp, it looks like you bought a real lemon of a spaceship, this thing barely runs.";
     String s13 = "You are gonna need to fix this puppy up if you're gonna rescue Milo in it.";
     String s14= "First, turn all the lights to green. Then follow the light pattern and you should be good to go!";
     String s15 ="click next to start the spaceship fixing puzzles.";
     String s16= "Nice work on those puzzles. It took you long enough. I bet those pesky aliens are torturing Milo.";
     String s17= "Now it's time to fly through the maze of space to find him.";
     String s18= "Your ship's navigation is not working perfectly.";
     String s19="If you have extra money it will increase your navigation system range making the maze shorter.";
     String s20= "Your money will automatically be applied to these upgrades.";
     String s21 = "click next to start the maze";
     String s22= "You made it to the Alien's home. You must fight to get Milo back.";
     String s23="Please use all of your wits and farming skills to defeat the boss! Good luck!";
     String s24="click next to start battle";
      
     /*
    String level1 = "farming game";
    String level2 = " puzzel game";
    String level3 = "click next to start maze game";
    String level4 = "boss battle";
    String end = " thanks for playing";
    */
    String[] story = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24};
    public Main() {
        Player ben = new Player();

        //setup the frame
        JFrame sWindow = new JFrame("Farmer Ben Main Story");
        sWindow.setSize(700,350);
        sWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sWindow.setLocationRelativeTo(null);

        //player info
        /* 
        JPanel plyrInfo = new JPanel();
        sWindow.add(plyrInfo, BorderLayout.SOUTH);
        JButton healthB = new JButton("Health: "+ben.getHealth());
        JButton moneyB = new JButton("Money: "+ ben.getMoney());
        plyrInfo.add(moneyB);
        plyrInfo.add(healthB);
*/
        //next button that triggers everything
        JButton text = new JButton();
        text.setText("Hello and welcome Farmer Ben. You are a Farmer and as such you must do farmer things ...");
        sWindow.add(text, BorderLayout.CENTER);
        JButton next = new JButton( "next");
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curProgess++;
                if(curProgess ==12){
                    //run nathan's game
                    new buttonPanel(5, ben, next);
                }else if(curProgess ==16){
                    //run blanche's game
                    ButtonGrid1 bg1 = new ButtonGrid1 (3,3,next);//runs the light game
                    ButtonGrid2 bg2 = new ButtonGrid2(3,3,ben);//runs the memory games
                }else if(curProgess ==22){
                    //run george's game
                    MazeWindow maze = new MazeWindow();
                    maze.startMG(ben.getMoney(), next);
                    //maze.startMG(5, next);

                }else if(curProgess ==25){
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
