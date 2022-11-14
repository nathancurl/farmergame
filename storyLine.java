package package02;

import java.util.ArrayList;

public class storyLine {
    storyLineGui slg;
    sUI sui;
    VisibilityManagerSUI vm;
    int counter = 0;
    ArrayList<String> text;


    public storyLine(storyLineGui slg2, sUI ui, VisibilityManagerSUI vManager) {
        slg = slg2;
        sui = ui;
        vm = vManager;
        ArrayList<String> text = new ArrayList<>();
        this.text = text;
        text.add("hi");
        text.add("hi!");
        text.add("hi!!!");


    }


    public void selectPosition(String nextPosition) {
        if ("next".equals(nextPosition)) {
            continueOn();
        }
    }

    public void continueOn() {
        sui.mainTextArea.setText("pleaseeeeeeeeeeeeeeee");
        counter++;
        slg.nextPosition = "next";
    }

}