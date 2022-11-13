import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonGrid1 bg1 = new ButtonGrid1 (5,5);//runs the light game
                ButtonGrid2 bg2 = new ButtonGrid2(3,3);//runs the memory game
                GameWindow game = new GameWindow(); //runs the maze game
            }
        });
    }
}