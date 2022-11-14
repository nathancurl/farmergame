import java.util.Scanner;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //create a player that so all the games can have the same player
                Player Ben = new Player();

                String loser = "I guess you don't love your son enough to save him. :(";
                String user;
                // start the storyline:
                Scanner gameScanner = new Scanner(System.in);
                
                System.out.println("Hello and welcome Farmer Ben. You are a Farmer and as such you must do farmer things ...\n" +
                 "Oh no. What's that over there? It's an alien!!!  Farmer Ben watch out, the Alien is kidnapping your son Milo\n " + 
                "Farmer Ben, you need to go rescue your son. It is your mission.\n*type y to accept the MILO rescue misson and start level 1");
                user = gameScanner.nextLine();
                
                if(!user.equals("y")){
                    System.out.println(loser);
                    System.exit(0);
                }

                
                System.out.println("We the game designers are so glad you decided to accept the mission. Only terrible parents would not rescue their child...\n" + 
                "But first things first, you are gonna need a spaceship to follow the Alien. There is a used one for sale. It costs $10000000." +
                 "You better start farming. Once you make enough money to buy the ship, you can move on. However, having a little extra cash in your pocket might be useful later. *hint hint*\n"+
                "*type y to start farming");
                user = gameScanner.nextLine();
                if(!user.equals("y")){
                    System.out.println(loser);
                    System.exit(0);
                }

                    // run nathan's game.
                
                

                System.out.println("Whelp, it looks like you bought a real lemon of a spaceship, this thing barely runs.\n You are gonna need to fix this puppy up if you're gonna rescue Milo in it. First, turn all the lights to green.\n Then follow the light pattern and you should be good to go!\n *type y to begin");

                user = gameScanner.nextLine();
                if(!user.equals("y")){
                    System.out.println(loser);
                    System.exit(0);
                }
                    // run Blacnche's puzzel games
                
                    //ButtonGrid1 bg1 = new ButtonGrid1 (3,3);//runs the light game
                    //ButtonGrid2 bg2 = new ButtonGrid2(3,3);//runs the memory game


                System.out.println("Nice work on those puzzles. It took you long enough. I bet those pesky aliens are torturing Milo.\n" +
                "Now it's time to fly through the maze of space to find him. Your ships navigation is not working perfectly.\n" +
                "If you have extra money it will increases you navigation system making the maze shorter. You money will automatically be applied to these upgrades.\n"+
                "*type y to begin the navigation system.");

                user = gameScanner.nextLine();
                if(!user.equals("y")){
                    System.out.println(loser);
                    System.exit(0);
                }

                    //run George's game
                   //MazeWindow game = new MazeWindow(); //runs the maze game
                   //game.startMG(50);
                   
                   //somehow wait till maze things are finished before the next print starts
                  
 /* */
                System.out.println("You made it to the Alien's home. You must fight to get Milo back.\n" +
                "Please use all of your wits and farming skills to defeat the boss! Good luck!\n" +
                "*type y to start battle");

                user = gameScanner.nextLine();
                if(!user.equals("y")){
                    System.out.println(loser);
                    System.exit(0);
                }
            
                        //run Prim's Game

                
                
                System.out.println("Congrats! You saved Milo. Time to return home and live off your days happy.");
/* */
                gameScanner.close();

                        
            }
        });
    }
}