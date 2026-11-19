package java;

import java.util.Random;

public class Mage extends Character {
    private static final int MAXIMUM_HP = 90;
    public static final int MINIMUM_HEAL = 10;
    public static final int MAXIMUM_HEAL = 20;

    private int minimumDamage = 8;
    private int maximumDamage = 18;

    private Random random = new Random();

    public Mage(String name) {
        super(MAXIMUM_HP, name);
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

    public int heal() {
        int healingAmount = random.nextInt(MINIMUM_HEAL, MAXIMUM_HEAL);

        int hp = getHp();
        hp += healingAmount;
        if (hp > MAXIMUM_HP) {
            hp = MAXIMUM_HP;
        }
        setHp(hp);

        return healingAmount;
    }
}
