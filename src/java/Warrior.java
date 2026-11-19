package java;

public class Warrior extends Character {

    private static final int MAXIMUM_HP = 120;

    private int MINIMUM_DAMAGE = 9;
    private int MAXIMUM_DAMAGE = 19;
    private boolean shield = false;
    private boolean canUseShield = true;

    public Warrior(String name) {
        super(MAXIMUM_HP, name);
    }

    public int giveDamage() {

        return giveDamage(MINIMUM_DAMAGE, MAXIMUM_DAMAGE + 1);
    }

    public int specialAbility() {

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
    }
}