package package01;

import java.util.Random;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    Boss boss = new Boss();
    Random rand = new Random();

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;

    }

    public void defaultSetup() {
        player.health = 100;
        ui.hpNumberLabel.setText("" + player.health);
        boss.health = 100;
        ui.bossHPNumLabel.setText("" + boss.health);

    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "pitchfork" -> pitchfork();
            case "apple" -> apple();
            case "fight" -> battleScene();
            case "win" -> win();
            case "lose" -> lose();
            case "bossAttack" -> bossAttack();
            case "battleScene2" -> battleScene2();
            case "winscreen" -> winScreen();
            case "losescreen" -> loseScreen();
        }
    }

    public void battleScene() {
        ui.mainTextArea.setText("You have encountered the boss. \n You must fight the boss to get Milo back!");
        ui.choice1.setText("PitchFork");
        ui.choice2.setText("Apple");

        game.nextPosition1 = "pitchfork";
        game.nextPosition2 = "apple";
    }

    public void battleScene2() {
        ui.mainTextArea.setText("Choose your next move");
        ui.choice1.setText("PitchFork");
        ui.choice2.setText("Apple");

        game.nextPosition1 = "pitchfork";
        game.nextPosition2 = "apple";
    }

    public void pitchfork() {
        player.takeTurn(1, boss);
        ui.mainTextArea.setText(player.movement);
        ui.bossHPNumLabel.setText("" + boss.health);
        ui.hpNumberLabel.setText("" + player.health);


        ui.choice1.setText(">");
        ui.choice2.setText("");

        if (boss.health > 0) {
            game.nextPosition1 = "bossAttack";
            game.nextPosition2 = "";

        } else if (boss.health < 1) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
        }

    }

    public void apple() {
        player.takeTurn(0, boss);
        ui.mainTextArea.setText(player.movement);
        ui.bossHPNumLabel.setText("" + boss.health);
        ui.hpNumberLabel.setText("" + player.health);


        ui.choice1.setText(">");
        ui.choice2.setText("");

        if (boss.health > 0) {
            game.nextPosition1 = "bossAttack";
            game.nextPosition2 = "";

        } else if (boss.health < 1) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
        }
    }

    public void bossAttack() {

        int num = rand.nextInt(2);

        if (num == 0) {
            boss.takeTurn(num,player);
            ui.mainTextArea.setText(boss.movement);
            ui.hpNumberLabel.setText("" + player.health);
            ui.bossHPNumLabel.setText("" + boss.health);


        } else {
            boss.takeTurn(num, player);
            ui.mainTextArea.setText(boss.movement);
            ui.hpNumberLabel.setText("" + player.health);
            ui.bossHPNumLabel.setText("" + boss.health);

        }



        game.nextPosition1 = "";
        game.nextPosition2 = "";

        if (player.health > 0) {
            ui.choice1.setText(">");
            ui.choice2.setText("");

            game.nextPosition1 = "battleScene2";
            game.nextPosition2 = "";

        } else if(player.health < 1){

            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
        }
    }
    public void win(){
        ui.mainTextArea.setText("You've defeated the boss! You got Milo back!");
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(false);
        ui.choice1.setText(">");

        game.nextPosition1 = "winscreen";
    }
    public void winScreen(){
        ui.choiceButtonPanel.setVisible(false);
        ui.titleNameLabel.setText("YOU WIN!");
        ui.titleNamePanel.setVisible(true);

    }
    public void lose(){
        ui.mainTextArea.setText("So close, but so far...");
        ui.playerPanel.setVisible(false);
        ui.choice1.setText(">");

        game.nextPosition1 = "losescreen";
    }

    public void loseScreen(){
        ui.titleNameLabel.setText("GAMEOVER");
        ui.titleNamePanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(false);

    }

}
