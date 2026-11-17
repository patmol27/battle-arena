package java;

public class Warrior extends Character {

    private static final int MAXIMUM_HP = 120;
    private int minimumDamage = 5;
    private int maximumDamage = 15;

    private boolean shield = false;

    public Warrior(String name) { super(MAXIMUM_HP, name);
    }

    public void useShield() { shield = true;
    }

    @Override
    public int takeDamage(int damage) {
        if (shield == true) {
            shield = false;
            double reducedDamage = (0.8 * damage);
            damage = (int) Math.round(reducedDamage);
        }

        setHp(Math.max(0, getHp() - damage));
        return getHp();
    }
}