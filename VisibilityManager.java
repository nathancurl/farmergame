package package01;

public class VisibilityManager {
    UI ui;


    public VisibilityManager(UI userInterface){
        ui = userInterface;

    }
    public void showTitleScreen(){

        //show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // hide the game screen stuff
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

    }

    public void titleToBattle(){
        ui.window.remove(ui.titleNamePanel);
        ui.window.remove(ui.startButtonPanel);

        // hide the game screen stuff
        ui.mainTextPanel.setVisible(true);
        ui.window.add(ui.choiceButtonPanel);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }

}
