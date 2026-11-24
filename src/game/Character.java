package game;

import java.util.Random;

public abstract class Character implements SpecialAbility {

    private int hp;
    private String name;
    private int minimumDamage;
    private int maximumDamage;


    public Character(int hp, String name, int minimumDamage, int maximumDamage ) {
        this.hp = hp;
        this.name = name;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;

    }

    Random random = new Random();

    public int giveDamage(){
        int damage = random.nextInt(minimumDamage,maximumDamage);
        return damage;
    }

    public int takeDamage(int damage){
        hp = hp -(damage);
        return hp;
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
  
    @Override
    public abstract int specialAbility();

    @Override
    public abstract AlternateCharacter getCharacterType();
}
