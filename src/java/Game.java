package java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void setUpPlayerCharacter() {
        System.out.println("Enter your name.");
        String playerName = scanner.nextLine();

        while (true) {
            System.out.println("Choose a character. The characters are:\n1. Warrior\n2. Mage\n3. Rogue");
            String playerCharacter = scanner.nextLine();

            if (playerCharacter.equals("Warrior")) {
                Warrior warrior = new Warrior(playerName);
                break;
            } else if (playerCharacter.equals("Mage")) {
                Mage mage = new Mage(playerName);
                break;
            } else if (playerCharacter.equals("Rogue")) {
                Rogue rogue = new Rogue(playerName);
                break;
            } else {
                System.out.println("You didn't enter a valid character! Try again.");
            }
        }
    }

    public void setUpComputerCharacter() {
        int randomisedCharacterChoice = random.nextInt(3);
        List<String> characterList = new ArrayList<>();
        characterList.add("Warrior");
        characterList.add("Mage");
        characterList.add("Rogue");

    }

}
