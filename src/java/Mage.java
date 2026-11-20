package java;

import java.util.Random;

public class Mage extends Character {
    private static final int MAXIMUM_HP = 90;
    private static final int MINIMUM_DAMAGE = 8;
    private static final int MAXIMUM_DAMAGE = 18;
    public static final int MINIMUM_HEAL = 10;
    public static final int MAXIMUM_HEAL = 20;

    private Random random = new Random();

    public Mage(String name) {
        super(MAXIMUM_HP, name, MINIMUM_DAMAGE, MAXIMUM_DAMAGE);
    }

    @Override
    public int specialAbility() {
        int healingAmount = random.nextInt(MINIMUM_HEAL, MAXIMUM_HEAL);

        int hp = getHp();
        hp += healingAmount;
        if (hp > MAXIMUM_HP) {
            hp = MAXIMUM_HP;
        }
        setHp(hp);

        return healingAmount;
    }

    @Override
    public AlternateCharacter getCharacterType() {
        return AlternateCharacter.MAGE;
    }
}
