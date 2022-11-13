import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyButton1 extends JButton {
    int x;
    int y;
    boolean on;
    ButtonGrid1 source;
    ArrayList<MyButton1> neighbours;

    public MyButton1(int x, int y, ButtonGrid1 source) {
        this.x = x;
        this.y = y;
        on = false;
        this.neighbours= new ArrayList<MyButton1>();
        this.source = source;
        setBackground(Color.RED);
        setOpaque(true);

        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                MyButton1 sourceBtn = (MyButton1) e.getSource();
                if (!sourceBtn.source.win) {
                    for (MyButton1 b : sourceBtn.neighbours) {
                        b.changeColor();
                    }
                    sourceBtn.changeColor();
                    if (ButtonGrid1.checkWin1(sourceBtn.source.grid)) {
                        ButtonGrid1.youWin(sourceBtn.source);
                        sourceBtn.source.win = true;
                    }
                } else{sourceBtn.source.frame.dispose(); }
            }
        });
    }
    public void changeColor(){
        if (this.on){
            this.setBackground(Color.RED);
            this.on = false;
        } else{
            this.setBackground(Color.GREEN);
            this.on = true;
        }
    }
    public void addNeighbour(MyButton1 b){
        this.neighbours.add(b);
    }

}
