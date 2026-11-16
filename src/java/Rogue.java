package java;

import java.util.Random;

public class Rogue extends Character{

    private static final int MAXIMUM_HP = 95;

    private int minimumDamage = 10;
    private int maximumDamage = 20;


    public Rogue(String name) {

        super(MAXIMUM_HP, name);
    }
    private Random random = new Random();

    @Override
    public int giveDamage(int minimumDamage,int maximumDamage){
        int damage = random.nextInt(minimumDamage,maximumDamage);

        if (random.nextInt(100) < 40){
             damage = damage *2;
            System.out.println("Critical Strike");
        }
        return damage;
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
