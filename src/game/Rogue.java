package game;

import java.util.Random;

public class Rogue extends Character{

    private static final int MAXIMUM_HP = 95;
    private static final int MINIMUM_DAMAGE = 10;
    private static final int MAXIMUM_DAMAGE = 20;



    public Rogue(String name) {

        super(MAXIMUM_HP, name,MINIMUM_DAMAGE,MAXIMUM_DAMAGE);
    }
    private Random random = new Random();
    

    @Override
    public int specialAbility() {
        int damage = giveDamage(MINIMUM_DAMAGE,MAXIMUM_DAMAGE);

        if (random.nextInt(100) < 80) {
            damage = damage *2;

            System.out.println("Critical Strike!");
        }else {
            System.out.println("abillity missed");
        }
        return damage;

    }

    @Override
    public AlternateCharacter getCharacterType() {
        return AlternateCharacter.ROGUE;
    }


}
