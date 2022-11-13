import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // start the storyline gui

                //


                //with the storyline gui trigger each of the games


                        //start nathan's game


                        //start Blanche's game

                        ButtonGrid1 bg1 = new ButtonGrid1 (3,3);//runs the light game
                        ButtonGrid2 bg2 = new ButtonGrid2(3,3);//runs the memory game


                        //start George's game
                        MazeWindow game = new MazeWindow(); //runs the maze game


                        //start Prim's Game

                        
            }
        });
    }
}