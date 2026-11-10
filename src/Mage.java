import java.util.Random;

public class Mage extends Character {
    private static final int MAXIMUM_HP = 90;

    private int minimumDamage = 8;
    private int maximumDamage = 18;
    private int minimumHeal = 10;
    private int maximumHeal = 20;

    private Random random = new Random();

    public Mage(int hp, String name) {
        super(hp, name);
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

    public int getMinimumHeal() {
        return minimumHeal;
    }

    public void setMinimumHeal(int minimumHeal) {
        this.minimumHeal = minimumHeal;
    }

    public int getMaximumHeal() {
        return maximumHeal;
    }

    public void setMaximumHeal(int maximumHeal) {
        this.maximumHeal = maximumHeal;
    }

    public int attack(int minimumDamage, int maximumDamage) {
        int damage = random.nextInt(minimumDamage,maximumDamage);

        return damage;
    }

    public int heal(int minimumHeal, int maximumHeal) {
        int healingAmount = random.nextInt(minimumHeal, maximumHeal);

        int hp = getHP();
        hp += healingAmount;
        if (hp > MAXIMUM_HP) {
            hp = MAXIMUM_HP;
        }
        setHP(hp);

        return healingAmount;
    }
}
