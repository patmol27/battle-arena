package java;

public class Warrior extends Character {

    private static final int MAXIMUM_HP = 120;
    private int minimumDamage = 5;
    private int maximumDamage = 15;
    private boolean shield = false;

    public Warrior(String name) {
        super(MAXIMUM_HP, name);
    }

    public void useShield() {
        shield = true;
    }

    public void takeDamage(int damage) {
        if (shield == true) {
            shield = false;
        } else {
            setHp(Math.max(0, getHp() - damage));
        }
    }
}