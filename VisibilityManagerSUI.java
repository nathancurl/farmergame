package package02;

import java.awt.*;

public class VisibilityManagerSUI{

    sUI sui;


    public VisibilityManagerSUI(sUI sui2){
        sui = sui2;

    } public void startToStory(){
        sui.titleNameLabel.setVisible(true);
        sui.startButtonPanel.setVisible(true);

        sui.mainTextPanel.setVisible(false);
        sui.nextButtonPanel.setVisible(false);
    }

    public void story(){
        sui.titleNameLabel.setVisible(false);
        sui.startButtonPanel.setVisible(false);

        sui.mainTextPanel.setVisible(true);
        sui.nextButtonPanel.setVisible(true);

    }
}
