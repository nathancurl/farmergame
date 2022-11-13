
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

public abstract class Fight {
    protected int health;
    private int turnsSkipped;
    private String name;
    private int poisonAmount;
    private String oneName;
    private String twoName;
    private String threeName;
    public String movement;


    public Fight(String name, String oneName, String twoName
            , String threeName) {
        this.name = name;
        this.oneName = oneName;
        this.twoName = twoName;
        this.threeName = threeName;
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

//        public abstract void four(Fight agent2);


    public void takeDamage ( int num){
        health = health - (num);

    }

    public boolean isAlive () {
        return health > 0;
    }

    public int getHealth () {
        return health;
    }

    public String getName () {
        return name;
    }


    public void setHealth ( int health){
        this.health = health;
    }


    public void setTurnsSkipped ( int turnsSkipped){
        this.turnsSkipped = turnsSkipped;
    }

    public int getPoisonAmount() {
        return poisonAmount;
    }

    public void setPoisonAmount(int poisonAmount) {
        this.poisonAmount = poisonAmount;
    }

    public String getOneName() {
        return oneName;
    }

    public String getTwoName() {
        return twoName;
    }

    public String getThreeName() {
        return threeName;
    }


}


