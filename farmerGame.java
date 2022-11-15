import javax.swing.*;
import java.awt.*;
import java.util.Random;

//import java.util.ArrayList;
//
public class farmerGame {
        Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
        int curDay = 5;
        //Player ben;
        String[] crops;{
                crops = new String[3];
                crops[0] = "Corn";
                crops[1] = "Wheat";
                crops[2] = "Basil";

        }
        public String sellPlant() {
//        //Computer randomly chooses a plant from crops[]
                Random random = new Random();
                //System.out.println(crops[random.nextInt(crops.length)]);
                return crops[random.nextInt(crops.length)];
//              //sends that choice to checkPrice()
        }

        public String checkPrice(String crop, Player ben) {
                curDay--;
                if (crop.equals(sellPlant())){
                        ben.setMoney(ben.getMoney() + 100) ;
                        return ("The merchants at the market were looking to buy a bunch of " + crop + " so they gave you $100!");
                }
//                if (!crop.equals(sellPlant())){
                else {
                        ben.setMoney(ben.getMoney() + 25) ;
                        return ("Sorry. The merchants at the market were not interested in buying much " + crop + " so they only gave you $25 :(");
                }
        }

}
