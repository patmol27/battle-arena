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

            if (!playerCharacter.equals("Warrior") & !playerCharacter.equals("Mage") & !playerCharacter.equals("Rogue")) {
                System.out.println("You didn't enter a valid character! Try again.");
                continue;
            }
            Character chosenPlayerCharacter = pickCharacter(playerCharacter, playerName);
            break;
        }
    }

    public void setUpComputerCharacter() {
        int randomisedCharacterChoice = random.nextInt(3);
        List<String> characterList = new ArrayList<>();
        characterList.add("Warrior");
        characterList.add("Mage");
        characterList.add("Rogue");

        String computerCharacter = characterList.get(randomisedCharacterChoice);
        Character chosenComputerCharacter = pickCharacter(computerCharacter, "Computer");
    }

    public Character pickCharacter(String chosenCharacter, String chosenName) {
        Character character = null;

        if (chosenCharacter.equals("Warrior")) {
            character = new Warrior(chosenName);
        } else if (chosenCharacter.equals("Mage")) {
            character = new Mage(chosenName);
        } else if (chosenCharacter.equals("Rogue")) {
            character = new Rogue(chosenName);
        }

        return character;
    }

}
