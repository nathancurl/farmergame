package package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    UI ui = new UI();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPosition1, nextPosition2;

    public static void main(String[] args) {
        new Game();
    }
    public Game(){
        ui.createUI(choiceHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch(yourChoice){
                case "start": vm.titleToBattle(); story.battleScene(); break;
                case "c1": story.selectPosition(nextPosition1);break;
                case "c2": story.selectPosition(nextPosition2);break;

            }

        }
    }
}
