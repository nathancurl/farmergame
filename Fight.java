package package01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public abstract class Fight {
    protected long health = 100;

    public Fight() {
    }

    public void takeTurn(int action, Fight otherAgent) {

        if (action == 0) {
            this.two(otherAgent);
        } else if (action == 1) {
            this.three(otherAgent);

        }

    }

    public abstract void two(Fight agent2);

    public abstract void three(Fight agent2);

    public void takeDamage(long num) {
        health = health - (num);

    }
    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }




}


