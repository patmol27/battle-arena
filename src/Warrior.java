public class Warrior extends Character {

    private boolean shield = false;

    public Warrior(String name) {
        super(120, name, 5, 15);
    }

    public void useShield() {
        shield = true;
    }

    public void takeDamage(int damage) {
        if (shield == true) {
            shield = false;
        } else {
            setHp(Math.max(0, getHp() - damage));
        }
    }
}