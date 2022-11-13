package package01;

import java.util.Random;

public class Player extends Fight {
    private int money;
    private Random rand= new Random();
    public String movement;


    public Player(String name) {
        super(name, "Pitchfork", "Apple", "Plow");
        this.health = 100;
    }
    public void three(Fight agent2) {
        int percentage = rand.nextInt(10);
        if (percentage > 7) {
            movement = "You threw your pitchfork. You missed.";
        } else {
            movement = "You threw your pitchfork. You hit your opponent! Your opponent took 15 damage.";
            agent2.takeDamage(15);
            }
    }

    @Override
    public void two(Fight agent2) {
        int percentage = rand.nextInt(2);
        if (percentage == 0) {
            movement = "You take an apple out of your inventory.\nYou ate the apple.\n You gain 40 health";
            this.setHealth(getHealth() + 40);
        } else {
            movement = "You take an apple out of your inventory. \nYour opponent knocked it out.";
        }
    }





}
