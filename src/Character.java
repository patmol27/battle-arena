import java.util.Random;

public class Character {

    private int hp;
    private String name;
    private int min_damage;
    private int max_damage;

    public Character(int hp, String name, int min_damage, int max_damage) {
        this.hp = hp;
        this.name = name;
        this.min_damage = min_damage;
        this.max_damage = max_damage;
    }

    Random damage = new Random();

    public int giveDamage(){

        int damagegiven = damage.nextInt(max_damage - min_damage + 1) + min_damage;
        return damagegiven;
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

    public int getMin_damage() {
        return min_damage;
    }

    public void setMin_damage(int min_damage) {
        this.min_damage = min_damage;
    }

    public int getMax_damage() {
        return max_damage;
    }

    public void setMax_damage(int max_damage) {
        this.max_damage = max_damage;
    }
}
