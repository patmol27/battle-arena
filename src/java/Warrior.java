package java;

public class Warrior extends Character {

    private static final int MAXIMUM_HP = 120;

    private int minimumDamage = 5;
    private int maximumDamage = 15;
    private boolean shield = false;

    public Warrior(String name) {
        super(MAXIMUM_HP, name);
    }

    public int attack() {
        return giveDamage(minimumDamage, maximumDamage + 1);
    }

    public void useShield() {
        shield = true;
    }

    @Override
    public int takeDamage(int damage) {
        if (shield == true) {
            shield = false;
        } else {
            super.takeDamage(damage);
        }

        return getHp();
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