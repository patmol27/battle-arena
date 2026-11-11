package java;

import java.util.Random;

public class Character {

    private int hp;
    private String name;


    public Character(int hp, String name ) {
        this.hp = hp;
        this.name = name;

    }

    Random damage = new Random();

    public int giveDamage(int minimumDamage, int maximumDamage){
        return damage.nextInt(minimumDamage,maximumDamage);
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
