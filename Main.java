import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //GameWindow holds the MazePanel and has buttons for start and stop
                GameWindow game = new GameWindow();
                    //call the MazeMaker class todo create a maze in Array form
                    //scall the MazePanel class todo the real gameplaysd
                //update the amount of money in the overarching player class.

            }
        });
    }
}