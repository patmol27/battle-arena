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

            if (!playerCharacter.trim().equalsIgnoreCase("Warrior") &&
                    !playerCharacter.trim().equalsIgnoreCase("Mage") &&
                    !playerCharacter.trim().equalsIgnoreCase("Rogue") &&
                    !playerCharacter.trim().equals("1") && !playerCharacter.trim().equals("2") &&
                    !playerCharacter.trim().equals("3")) {
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

        if (chosenCharacter.trim().equalsIgnoreCase("Warrior") ||
                chosenCharacter.equals("1")) {
            character = new Warrior(chosenName);
        } else if (chosenCharacter.trim().equalsIgnoreCase("Mage") ||
                chosenCharacter.equals("2")) {
            character = new Mage(chosenName);
        } else if (chosenCharacter.trim().equalsIgnoreCase("Rogue") ||
                chosenCharacter.equals("3")) {
            character = new Rogue(chosenName);
        }

        return character;
    }

    public void match() {
        Character playerCharacter = setUpPlayerCharacter();
        Character computerCharacter = setUpComputerCharacter();

        System.out.println("Your character: " + playerCharacter.getCharacterType().toString().toLowerCase() +
                "\nThe computer's character: " +
                computerCharacter.getCharacterType().toString().toLowerCase() + "\nLet's begin the battle!");

        while (true) {
            System.out.println("Choose an action. You can pick between:\n1. Attack\n2. Special ability\n" +
                    "(3. Character information)");
            String chosenPlayerAction = scanner.nextLine();

            if (chosenPlayerAction.equals("1")) {
                int damageByPlayer = playerCharacter.giveDamage();
                System.out.println(playerCharacter.getName() + " (" +
                        playerCharacter.getCharacterType().toString().toLowerCase() +
                        ") deals " + damageByPlayer + " damage!");

                int computerHp = computerCharacter.takeDamage(damageByPlayer);
                System.out.println(computerCharacter.getName() + " (" +
                        computerCharacter.getCharacterType().toString().toLowerCase() +
                        ") is currently at " + computerHp + " HP.");
                computerCharacter.setHp(computerHp);

                break;

            } else if (chosenPlayerAction.equals("2")) {
                int specialAbilityResult = playerCharacter.specialAbility();
                if (playerCharacter.getCharacterType().equals(AlternateCharacter.WARRIOR)) {
                    System.out.println(playerCharacter.getName() + " (" +
                            playerCharacter.getCharacterType().toString().toLowerCase() +
                            ") uses shield!");

                } else if (playerCharacter.getCharacterType().equals(AlternateCharacter.MAGE)) {
                    int playerHealingAmount = specialAbilityResult;
                    System.out.println(playerCharacter.getName() + " (" +
                            playerCharacter.getCharacterType().toString().toLowerCase() +
                            ") heals for " + playerHealingAmount + " HP!");
                    System.out.println(playerCharacter.getName() + " (" +
                            playerCharacter.getCharacterType().toString().toLowerCase() +
                            ") is currently at " + playerCharacter.getHp() + " HP.");

                } else if (playerCharacter.getCharacterType().equals(AlternateCharacter.ROGUE)) {
                    int specialAbilityDamage = specialAbilityResult;
                    System.out.println(playerCharacter.getName() + " (" +
                            playerCharacter.getCharacterType().toString().toLowerCase() +
                            ") uses special ability!");
                    System.out.println(playerCharacter.getName() + " (" +
                            playerCharacter.getCharacterType().toString().toLowerCase() +
                            ") deals " + specialAbilityDamage + " damage.");

                    int computerHp = computerCharacter.takeDamage(specialAbilityDamage);
                    System.out.println(computerCharacter.getName() + " (" +
                            computerCharacter.getCharacterType().toString().toLowerCase() +
                            ") is currently at " + computerHp + " HP.");
                    computerCharacter.setHp(computerHp);
                }

                break;

            } else {
                System.out.println("You didn't pick a valid action. Try again.");
            }
        }
    }

}
