package game;

import java.util.*;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public Character setUpPlayerCharacter() {
        System.out.println("Enter your name.");
        String playerName = scanner.nextLine();

        Character chosenPlayerCharacter;

        while (true) {
            System.out.println("Choose a character. The characters are:\n1. Warrior\n2. Mage\n3. Rogue");
            String playerCharacter = scanner.nextLine();

            if (!playerCharacter.equalsIgnoreCase("Warrior") &
                    !playerCharacter.equalsIgnoreCase("Mage") &
                    !playerCharacter.equalsIgnoreCase("Rogue") &
                    !playerCharacter.equals("1") & !playerCharacter.equals("2") &
                    !playerCharacter.equals("3")) {
                System.out.println("You didn't enter a valid character! Try again.");
                continue;
            }
            chosenPlayerCharacter = pickCharacter(playerCharacter, playerName);
            break;
        }

        return chosenPlayerCharacter;
    }

    public Character setUpComputerCharacter() {
        int randomisedCharacterChoice = random.nextInt(3);
        List<String> characterList = new ArrayList<>();
        characterList.add("Warrior");
        characterList.add("Mage");
        characterList.add("Rogue");

        String computerCharacter = characterList.get(randomisedCharacterChoice);
        Character chosenComputerCharacter = pickCharacter(computerCharacter, "Computer");

        return chosenComputerCharacter;
    }

    public Character pickCharacter(String chosenCharacter, String chosenName) {
        Character character = null;

        if (chosenCharacter.equalsIgnoreCase("Warrior") || chosenCharacter.equals("1")) {
            character = new Warrior(chosenName);
        } else if (chosenCharacter.equalsIgnoreCase("Mage") || chosenCharacter.equals("2")) {
            character = new Mage(chosenName);
        } else if (chosenCharacter.equalsIgnoreCase("Rogue") || chosenCharacter.equals("3")) {
            character = new Rogue(chosenName);
        }

        return character;
    }

    public void match() {
        Character playerCharacter = setUpPlayerCharacter();
        Character computerCharacter = setUpComputerCharacter();

        System.out.println("Your character: " + playerCharacter.getCharacterType().toString().toLowerCase());
    }

}
