import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ButtonGrid2 {
    int width;
    int height;
    boolean start = true;
    boolean win = false;

    boolean lose = false;
    JFrame frame = new JFrame();
    MyButton2[][] grid;

    MyButton2[] order;

    MyButton2[] current = new MyButton2[6];
    Player ben;

    int currSpot = -1;

    public ButtonGrid2(int width, int length, Player ben) {
        this.width = width;
        this.height = length;
        this.ben = ben;
        this.order = new MyButton2 [6];
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.frame.setLayout(new GridLayout(length, width));
        this.grid = new MyButton2[width][length];
        for (int y = 0; y < length; ++y) {
            for (int x = 0; x < width; ++x) {
                this.grid[x][y] = new MyButton2(x, y, this);
                this.frame.add(this.grid[x][y]);
            }
        }
        this.frame.setDefaultCloseOperation(3);
        this.frame.setBackground(Color.gray);
        this.frame.setSize(500, 500);
        this.frame.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pickNextInt(0,this);

    }

    public static void pickNextInt(int i,ButtonGrid2 bg){
        Random rdm = new Random();
        MyButton2[] rdmRow = bg.grid[rdm.nextInt(bg.width)];
        MyButton2 rdmBtn = rdmRow[rdm.nextInt(bg.height)];
        if (i !=0){
            while (bg.order[i-1] == rdmBtn){
                rdmRow = bg.grid[rdm.nextInt(bg.width)];
                rdmBtn = rdmRow[rdm.nextInt(bg.height)];
            }
        }
        System.out.println(rdmBtn.x +" "+rdmBtn.y);
        rdmBtn.lightUp(Color.PINK);
        bg.order[i] = rdmBtn;
    }

    public static void youWin(ButtonGrid2 bg){
        for (MyButton2[] b: bg.grid){
            for(MyButton2 b2:b){
                b2.setOpaque(false);
                b2.repaint();
            }
        }
        JLabel label = new JLabel("You Win!");
        label.setVisible(true);
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setSize(200,100);
        label.setOpaque(true);
        bg.frame.add(label);
    }

    public static void youLose(ButtonGrid2 bg){
        for (MyButton2[] b: bg.grid){
            for(MyButton2 b2:b){
                b2.setOpaque(false);
                b2.repaint();
            }
        }
        bg.ben.health = 50;
        JLabel label = new JLabel("You Lose");
        label.setVisible(true);
        label.setFont(new Font("Serif", Font.PLAIN, 40));
        label.setSize(200,100);
        label.setOpaque(true);
        bg.frame.add(label);
    }

    public static void main(String[] args) {
        ButtonGrid2 bg = new ButtonGrid2(3,3);
    }
}
