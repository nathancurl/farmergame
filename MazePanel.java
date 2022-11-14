import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MazePanel extends JPanel {
    // takes a in[][] as an arugment. Draws the maze in a JPanel
    // the JPanel hold a Player (image) that moves through the maze, but can't go through walls


    private int[][] mazeRep;
    /*
        {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        };

      /*in the mazeRep; 0==open space 1 == wall , 2 = start, 3 = end point
       */
    private int xD;
    private int yD;


    //the index position of the player and the the end points in the matrix
    int curRow;
    int curCol;
    int endRow;
    int endCol;

    JButton btn;

    public MazePanel(int[][] mazeRep, JButton btn) {
        this.mazeRep = mazeRep;
        this.xD = mazeRep[0].length;
        this.yD = mazeRep.length;
        this.btn = btn;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //TODO make this function actually draw the maze

        int width = this.getWidth() / xD;
        int height = this.getHeight() / yD;

        //Draw the maze
        for (int y = 0; y < xD; y++) {
            for (int x = 0; x < yD; x++) {
                if (mazeRep[x][y] == 1) {
                    g.setColor(Color.black);
                    g.fillRect(y * width, x * height, width, height);
                } else if (mazeRep[x][y] == 0) {
                    g.setColor(Color.lightGray);
                    g.fillRect(y * width, x * height, width, height);
                } else if (mazeRep[x][y] == 2) {
                    g.setColor(Color.green);
                    g.fillRect(y * width, x * height, width, height);
                } else if (mazeRep[x][y] == 3) {
                    g.setColor(Color.red);
                    g.fillRect(y * width, x * height, width, height);
                }
            }

        }

    }


    public void runMaze() {


        //create the movement and win/lose things
        KeyListener key = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) { //move up
                    //System.out.println("w");
                    if (mazeRep[curRow - 1][curCol] == 0) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow - 1][curCol] = 2;
                        curRow--;
                    } else if (mazeRep[curRow - 1][curCol] == 3) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow - 1][curCol] = 2;
                        curRow--;
                    }
                    repaint();

                } else if (e.getKeyCode() == KeyEvent.VK_A) { //move left
                    //System.out.println("a");
                    if (mazeRep[curRow][curCol - 1] == 0) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow][curCol - 1] = 2;
                        curCol--;
                    } else if (mazeRep[curRow][curCol - 1] == 3) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow][curCol - 1] = 2;
                        curCol--;
                    }
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_S) { // move down
                    //System.out.println("s");
                    if (mazeRep[curRow + 1][curCol] == 0) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow + 1][curCol] = 2;
                        curRow++;
                    } else if (mazeRep[curRow + 1][curCol] == 3 ) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow + 1][curCol] = 2;
                        curRow++;
                    }
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_D) { // move right
                    //System.out.println("d");
                    if (mazeRep[curRow][curCol + 1] == 0) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow][curCol + 1] = 2;
                        curCol++;
                    } else if (mazeRep[curRow][curCol + 1] == 3 ) {
                        mazeRep[curRow][curCol] = 0;
                        mazeRep[curRow][curCol + 1] = 2;
                        curCol++;

                    }
                    repaint();
                }
                if (endCol == curCol && endRow == curRow) {
                    //System.out.println("congrats");
                    //System.exit(0);
                    end();
    
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        addKeyListener(key);
        setFocusable(true);
        requestFocus();

        for (int y = 0; y < xD; y++) {
            for (int x = 0; x < yD; x++) {
                if (mazeRep[x][y] == 2) {
                    curRow = x;
                    curCol = y;
                } else if (mazeRep[x][y] == 3) {
                    endRow = x;
                    endCol = y;
                }
            }

        }
        //System.out.println(mazeRep[endRow][endCol]);
        //System.out.println(mazeRep[curRow][curCol]);
    }


    private void end(){
        btn.setVisible(true);
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}