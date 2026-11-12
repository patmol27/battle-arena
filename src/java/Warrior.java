package java;

public class Warrior extends Character {

    private int minimumDamage = 5;
    private int maximumDamage = 15;
    private boolean shield = false;

    public Warrior(int hp, String name, int minimumDamage, int maximumDamage) {
        super(hp, name);
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
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