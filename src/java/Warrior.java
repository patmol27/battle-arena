package java;

public class Warrior extends Character {

    private int minimumDamage = 5;
    private int maximumDamage = 15;
    private boolean shield = false;

    public Warrior(String name) {
        super(120, name);
    }

    public int attack() {
        return giveDamage(minimumDamage, maximumDamage + 1);
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
