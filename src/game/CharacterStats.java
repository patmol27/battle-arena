package game;

public class CharacterStats {

    public void showStats() {

        System.out.println("1. Warrior");
        System.out.println("HP: 120");
        System.out.println("Weapon: Sword | Damage: 9-19");
        System.out.println("Special Ability: Shield");
        System.out.println("Blocks the next attack.");
        System.out.println();

        System.out.println("2. Mage");
        System.out.println("HP: 90");
        System.out.println("Weapon: Wand | Damage: 8-18");
        System.out.println("Special Ability: Heal");
        System.out.println("Heals 10-20 HP.");
        System.out.println();

        System.out.println("3. Rogue");
        System.out.println("HP: 95");
        System.out.println("Weapon: Daggers | Damage: 10-20");
        System.out.println("Special Ability: Critical Strike");
        System.out.println("Has an 80% chance of landing a critical strike dealing double damage.");

        System.out.println();
    }
}