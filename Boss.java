
import java.util.Random;

public class Boss extends Fight {
    private Random rand= new Random();
    public String movement;

    public Boss() {
        super("Boss","Poison Fume", "Healing Stance", "Snake Bite");
        this.health = 100;
    }

    public void two(Fight otherAgent) {
        int percentage = rand.nextInt(3);
        if (percentage > 0) {
            movement = "The boss is starting his healing stance. \n The boss healed for 30 HP";
            this.setHealth(getHealth() + 30);
        } else {
            movement = "The boss is starting his healing stance.\n You were able to knock him out of focus. " +
                    "\nThe boss does not heal";
        }
    }
    public void three(Fight otherAgent) {
        int percentage = rand.nextInt(3);
        if (percentage == 0) {
            movement ="The boss used Snake Bite.\n The boss hit their Snake Bite for 25 damage.";
            otherAgent.takeDamage(25);
        } else {
            movement = "The boss used Snake Bite.\n The boss missed their Snake Bite.";
        }
    }

}

