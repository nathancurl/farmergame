package package01;

import java.util.Random;

public class Boss extends Fight {
    private Random rand= new Random();
    public String movement;

    public Boss() {
        this.health = 100;
    }

    public void two(Fight otherAgent) {
        int percentage = rand.nextInt(4);
        if (percentage == 0) {
            movement = "The boss is starting his healing stance.\n You were able to knock him out of focus. " +
                    "\nThe boss does not heal";
        } else {
            int num = rand.nextInt(20,30);
            movement = "The boss is starting his healing stance. \n The boss healed for " + num + "HP";
            this.setHealth(getHealth() + num);
        }
    }
    public void three(Fight otherAgent) {
//        int percentage = rand.nextInt(10);
//        if (percentage > 7) {
//            movement = "The boss used Snake Bite.\n The boss missed their Snake Bite.";
//        } else {
            int num = rand.nextInt(15,35);
            movement ="The boss used Snake Bite.\n The boss hit their Snake Bite for " + num + " damage.";
            otherAgent.takeDamage(num);

        }
    }



