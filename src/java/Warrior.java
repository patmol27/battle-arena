package java;

public class Warrior extends Character {

    private static final int MAXIMUM_HP = 120;

    private static final int MINIMUM_DAMAGE = 9;
    private static final int MAXIMUM_DAMAGE = 19;
    private boolean shield = false;
    private boolean canUseShield = true;

    public Warrior(String name) {
        super(MAXIMUM_HP, name, MINIMUM_DAMAGE, MAXIMUM_DAMAGE);
    }

    public void useShield () {
        if (canUseShield == true) {
            shield = true;
            canUseShield = false;
        }
    }

    @Override
    public int takeDamage (int damage) {
        if (shield == true) {
            shield = false;
        } else {
            super.takeDamage(damage);
            canUseShield = true;
        }

        return getHp();
    }

    public int specialAbility() {
        useShield();
        takeDamage();
    }
}