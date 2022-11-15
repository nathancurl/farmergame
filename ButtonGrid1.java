import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;


public class ButtonGrid1 {
    int width;
    int height;
    JFrame frame = new JFrame();
    MyButton1[][] grid;
    JButton button;
    boolean win = false;

    public ButtonGrid1(int width, int length, JButton button) {
        this.width = width;
        this.height = length;
        this.button = button;
        button.setVisible(false);
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
        this.frame.setLayout(new GridLayout(length, width));
        this.grid = new MyButton1[width][length];
        for(int y = 0; y < length; ++y) {
            for(int x = 0; x < width; ++x) {
                this.grid[x][y] = new MyButton1(x,y,this);
                this.frame.add(this.grid[x][y]);
                }
            }
        for(int i=0;i<this.width;i++){
            for(int j=0;j<this.height;j++){
                if (i+1<this.width){
                    this.grid[i][j].addNeighbour(grid[i+1][j]);
                }
                if(i>0){
                    this.grid[i][j].addNeighbour(grid[i-1][j]);
                }
                if(j>0){
                    this.grid[i][j].addNeighbour(this.grid[i][j-1]);
                }
                if(j+1<this.height){
                    this.grid[i][j].addNeighbour(this.grid[i][j+1]);
                }
            }
        }
        this.frame.setDefaultCloseOperation(3);
        this.frame.setBackground(Color.gray);
        this.frame.setSize(500, 500);
        this.frame.setVisible(true);
    }
    public static boolean checkWin1(MyButton1[][] grid){
        for (int i=0;i<grid.length;i++){
            for(MyButton1 b:grid[i]){
                if(!b.on){
                    return false;
                }
            }
        }
        return true;
    }

    public static void youWin(ButtonGrid1 bg){
        for (MyButton1[] b: bg.grid){
            for(MyButton1 b2:b){
                b2.setOpaque(false);
                b2.repaint();
            }
        }
        bg.frame.dispose();
        bg.button.setVisible(true);
    }

    public static void main(String[] args) {
        ButtonGrid1 mainGrid = new ButtonGrid1(6,6);

    }
}

