import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeWindow {
    //This class will hold a JFrame that holds all other  Jcomponents (MazePanel, JButtons)
    // will call the run() method from Mazel Panel

    public void startMG(){
        //todo set all the important window features
            //setSIze, close funciton...
        //setup the frame
        JFrame gWindow = new JFrame("Farmer Ben's Crazy Maze");
        gWindow.setSize(500,550);
        gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gWindow.setLocationRelativeTo(null);
        JPanel top = new JPanel();
        top.setBackground(Color.LIGHT_GRAY);
        gWindow.add(top, BorderLayout.NORTH);

        //autogenerate a maze
        MazeMaker maker = new MazeMaker();

        // create the game panel
        MazePanel maze = new MazePanel(maker.runMaker(10,10));
        
        maze.setBackground(Color.GRAY);
        gWindow.add(maze, BorderLayout.CENTER);

        //start button things
        JButton start = new JButton("Start : WASD keys to move");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   maze.runMaze();

            }
        });

        top.add(start);
        gWindow.setVisible(true);

    }
}
