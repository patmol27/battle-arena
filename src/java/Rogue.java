package java;

public class Rogue extends Character{

    private static final int MAXIMUM_HP = 95;

    private int minimumDamage = 10;
    private int maximumDamage = 20;



    public Rogue(int hp, String name) {
        super(hp, name);
    }

    public int getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public int getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }
}
