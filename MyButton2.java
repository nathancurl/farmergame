import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyButton2 extends JButton {
    int x;
    int y;
    boolean on;
    ButtonGrid2 source;

    public MyButton2(int x, int y, ButtonGrid2 source) {
        this.x = x;
        this.y = y;
        on = false;
        this.source = source;
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.setContentAreaFilled(false);
        setBackground(Color.WHITE);
        setOpaque(true);

        this.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Thread() {
                    public void run() {
                        MyButton2 sourceBtn = (MyButton2) e.getSource();
                        if (sourceBtn.source.start){
                            sourceBtn.source.order[0].lightUp(Color.PINK);
                            sourceBtn.source.start = false;
                        } else{
                        if (sourceBtn.source.win || sourceBtn.source.lose){sourceBtn.source.frame.dispose();}
                        if (sourceBtn.source.currSpot<sourceBtn.source.current.length-1) {
                            sourceBtn.source.currSpot++;
                            sourceBtn.source.current[sourceBtn.source.currSpot] = sourceBtn;
                        }
                        if (checkButton(sourceBtn.source.order, sourceBtn.source.current, sourceBtn.source.currSpot)) {
                            sourceBtn.lightUp(Color.GREEN);
                        } else {
                            sourceBtn.lightUp(Color.RED);
                            sourceBtn.source.lose = true;
                        }
                        if(!checkWin(sourceBtn.source.order,sourceBtn.source.currSpot)) {
                            if (checkDone(sourceBtn.source.current, sourceBtn.source.currSpot)) {
                                for (int value = 0; value < sourceBtn.source.currSpot + 1; value++) {
                                    sourceBtn.source.current[value] = null;
                                }

                                for (int k = 0; k < sourceBtn.source.currSpot + 1; k++) {
                                    sourceBtn.source.order[k].lightUp(Color.PINK);
                                }
                                if (sourceBtn.source.currSpot<sourceBtn.source.current.length-1) {ButtonGrid2.pickNextInt(sourceBtn.source.currSpot + 1, sourceBtn.source);}
                                sourceBtn.source.currSpot = -1;
                            }
                        }else{ ButtonGrid2.youWin(sourceBtn.source); sourceBtn.source.win = true;}
                    }
                }
                }.start();
            }
        });
    }
    public void lightUp(Color c) {
        this.setBackground(c);
        this.repaint();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.setBackground(Color.WHITE);
    }

    public boolean checkButton(MyButton2[] order,MyButton2[] current, int i){
        if (order[i] == current [i]){
            return true;
        } else {return false;}
    }

    public boolean checkDone(MyButton2[] order,int i){
        int j =0;
        while (order[j]!= null){
            j++;
        }
        if(j == i+1){
            return true;
        } else {return false;}
    }

    public boolean checkWin (MyButton2[] order,int pos){
        if (order.length == pos+1){
            return true;
        } else {return false;}
    }
}
