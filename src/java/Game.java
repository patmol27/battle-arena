package java;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);

    public void setUpCharacters() {
        System.out.println("Enter your name.");
        String playerName = scanner.nextLine();

        while (true) {
            System.out.println("Choose a character. The characters are:\n1. Warrior\n2. Mage\n3. Rogue");
            String playerCharacter = scanner.nextLine();

            if (playerCharacter.equals("Warrior")) {
                Warrior warrior = new Warrior(120, playerName);
                break;
            } else if (playerCharacter.equals("Mage")) {
                Mage mage = new Mage(90, playerName);
                break;
            } else if (playerCharacter.equals("Rogue")) {
                Rogue rogue = new Rogue(100, playerName);
                break;
            } else {
                System.out.println("You didn't enter a valid character! Try again.");
            }
        }
    }

}
