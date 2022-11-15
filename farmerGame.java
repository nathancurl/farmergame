import javax.swing.*;
import java.awt.*;
import java.util.Random;

//import java.util.ArrayList;
//
public class farmerGame {
        Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
        int curDay = 5;
        int money;
        String[] crops;{
                crops = new String[3];
                crops[0] = "Corn";
                crops[1] = "Wheat";
                crops[2] = "Basil";

        }

        //    //Overarching questions: Should I make a data structure of some kind to store the player's money
//    int money;
        public void intializeGame() {
                JFrame console = new JFrame();
                console.setBounds(0, 1200, 900, 400);
                console.setVisible(true);

                //Welcomes user to the game
                //System.out.print("Hello and welcome to the first mini-game of our Final Project! ");
                //Explains the concept etc...
                System.out.print("\nThe concept of this game is simple. You are playing as Ben who is a farmer.\n" +
                        "Ben's son Milo has just been abducted by Aliens.\n" +
                        "In order to rescue his son, Ben has to raise some money first!\n" +
                        "Luckily it's harvesting season, and Ben has a full field of Corn, Wheat, and Basil.\n" +
                        "Your job is to pick which crop you'd like to sell on any given day and watch the money roll in.\n");
        }

        public void pickPlant() {
//        //Questions for this method: How do I turn a user click into the correct string being sent to checkPrice()?
//        //GUI pops up
                
//        //User clicks a plant

//        //Their input is used to then stored and sent to checkPrice()
        }
        public String sellPlant() {
//        //Computer randomly chooses a plant from crops[]
                Random random = new Random();
                //System.out.println(crops[random.nextInt(crops.length)]);
                return crops[random.nextInt(crops.length)];
//              //sends that choice to checkPrice()
        }

        public String checkPrice(String crop) {
                curDay--;
                if (crop.equals(sellPlant())){
                        money += 100;
                        return ("The merchants at the market were looking to buy a bunch of " + crop + " so they gave you $100!");
                }
//                if (!crop.equals(sellPlant())){
                else {
                        money += 25;
                        return ("Sorry. The merchants at the market were not interested in buying much " + crop + " so they only gave you $25 :(");
                }
        }

}
