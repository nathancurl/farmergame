package package02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class storyLineGui {
    sUI sui = new sUI();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    VisibilityManagerSUI vm = new VisibilityManagerSUI(sui);

    public static void main(String[] args) {
        new storyLineGui();
    }
    public storyLineGui() {
        sui.createUI(choiceHandler);
        vm.startToStory();
        }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (yourChoice) {
                case "start":
                    vm.story();
                    break;
            }

        }
    }
}
