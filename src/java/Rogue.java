package java;

import java.util.Random;

public class Rogue extends Character{

    private static final int MAXIMUM_HP = 95;

    private int minimumDamage = 10;
    private int maximumDamage = 20;
    private int minEviscerateDamage = 25;
    private int maxEviscerateDamage = 50;

    public Rogue(int hp, String name) {

        super(hp, name);
    }


    private Random random = new Random();

    public int attack(int minimumDamage,int maximumDamage){
        int damage = random.nextInt(minimumDamage,maximumDamage);
        return damage;
    }

    public int eviscerate(int minEviscerateDamage,int maxEviscerateDamage){
        int eviscerate = random.nextInt(minEviscerateDamage,maxEviscerateDamage);
        return eviscerate;
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

    public int getMinEviscerateDamage() {
        return minEviscerateDamage;
    }

    public void setMinEviscerateDamage(int minEviscerateDamage) {
        this.minEviscerateDamage = minEviscerateDamage;
    }

    public int getMaxEviscerateDamage() {
        return maxEviscerateDamage;
    }

    public void setMaxEviscerateDamage(int maxEviscerateDamage) {
        this.maxEviscerateDamage = maxEviscerateDamage;
    }
}
