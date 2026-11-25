package game;

import java.util.*;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int playerCooldown = 0;
    private int computerCooldown = 0;
    private boolean gameEnd = false;

    public Character setUpPlayerCharacter() {
        System.out.println("Enter your name.");
        String playerName = scanner.nextLine();

        Character chosenPlayerCharacter;

        while (true) {
            System.out.println("Choose a character. The characters are:\n1. Warrior\n2. Mage\n3. Rogue\n" +
                    "----------\n4. Character information");
            String playerCharacter = scanner.nextLine();

            if (playerCharacter.trim().equals("4")) {
                CharacterStats characterStats = new CharacterStats();
                characterStats.showStats();
                continue;
            }
            else if (!playerCharacter.trim().equalsIgnoreCase("Warrior") &&
                    !playerCharacter.trim().equalsIgnoreCase("Mage") &&
                    !playerCharacter.trim().equalsIgnoreCase("Rogue") &&
                    !playerCharacter.trim().equals("1") &&
                    !playerCharacter.trim().equals("2") &&
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

    public boolean gameOver(Character player, Character computer){
        if (player.getHp() <= 0) {
            System.out.println("Game is overqw! " + computer.getName() +
                    " have won with " + computer.getHp() + " remaining");
            return true;

        } else if (computer.getHp() <= 0) {
            System.out.println("Game is overqq! " + player.getName() +
                    " have won with " + player.getHp() + " remaining");
            return true;
        }

        return false;
    }

    public void match() {
        Character playerCharacter = setUpPlayerCharacter();
        Character computerCharacter = setUpComputerCharacter();

        System.out.println("Your character: " + playerCharacter.getCharacterType().toString().toLowerCase() +
                "\nThe computer's character: " +
                computerCharacter.getCharacterType().toString().toLowerCase());
        System.out.println("\nEach character will start each turn by attacking.\n" +
                "Then they will get to choose one additional\naction before their turn ends.\n");
        System.out.println("Let's begin the battle!\n");

        while (true) {
            System.out.println(playerCharacter.getName() + "'s turn!\n");

            playerCooldown = act("1", playerCharacter, computerCharacter, playerCooldown);
            if (gameEnd) {
                break;
            }

            if (playerCooldown > 0) {
                playerCooldown = blockSpecialAbility(playerCooldown, playerCharacter, computerCharacter);
                if (gameEnd) {
                    break;
                }
            } else {
                while (true) {
                    System.out.println("Choose an action. You can pick between:\n1. Attack\n2. Special ability\n" +
                            "(3. Character information)");
                    String chosenPlayerAction = scanner.nextLine();

                    if (chosenPlayerAction.equals("1") || chosenPlayerAction.equals("2")) {
                        playerCooldown = act(chosenPlayerAction, playerCharacter, computerCharacter, playerCooldown);
                        break;
                    } else {
                        System.out.println("You didn't pick a valid action! Try again.");
                    }
                }
                if (gameEnd) {
                    break;
                }
            }

            if (gameOver(playerCharacter,computerCharacter)){
                break;
            }

            System.out.println(computerCharacter.getName() + "'s turn!\n");

            computerCooldown = act("1", computerCharacter, playerCharacter, computerCooldown);
            if (gameEnd) {
                break;
            }

            if (computerCooldown > 0) {
                computerCooldown = blockSpecialAbility(computerCooldown, computerCharacter, playerCharacter);
                if (gameEnd) {
                    break;
                }
            } else {
                String randomisedComputerAction = String.valueOf(random.nextInt(1, 3));
                computerCooldown = act(randomisedComputerAction, computerCharacter, playerCharacter, computerCooldown);
            }
        }

        if (playerCharacter.getHp() == 0) {
            System.out.println("Game is over! " + computerCharacter.getName() + " has won with " + computerCharacter.getHp() + " HP remaining.");

        } else if (computerCharacter.getHp() == 0) {
            System.out.println("Game is over! " + playerCharacter.getName() + " has won with " + playerCharacter.getHp() + " HP remaining.");
        }
    }

    public int act(String chosenAction, Character attackingCharacter, Character defendingCharacter, int attackerCooldown) {
        if (chosenAction.equals("1")) {
            int damageByPlayer = attackingCharacter.giveDamage();
            System.out.println(attackingCharacter.getName() + " (" +
                    attackingCharacter.getCharacterType().toString().toLowerCase() +
                    ") attacks and deals " + damageByPlayer + " damage!");

            int computerHp = defendingCharacter.takeDamage(damageByPlayer);
            System.out.println(defendingCharacter.getName() + " (" +
                    defendingCharacter.getCharacterType().toString().toLowerCase() +
                    ") is currently at " + computerHp + " HP.\n");
            defendingCharacter.setHp(computerHp);

        } else if (chosenAction.equals("2")) {
            int specialAbilityResult = attackingCharacter.specialAbility();
            if (attackingCharacter.getCharacterType().equals(AlternateCharacter.WARRIOR)) {
                System.out.println(attackingCharacter.getName() + " (" +
                        attackingCharacter.getCharacterType().toString().toLowerCase() +
                        ") uses shield!\n");

            } else if (attackingCharacter.getCharacterType().equals(AlternateCharacter.MAGE)) {
                int playerHealingAmount = specialAbilityResult;
                System.out.println(attackingCharacter.getName() + " (" +
                        attackingCharacter.getCharacterType().toString().toLowerCase() +
                        ") heals for " + playerHealingAmount + " HP!");
                System.out.println(attackingCharacter.getName() + " (" +
                        attackingCharacter.getCharacterType().toString().toLowerCase() +
                        ") is currently at " + attackingCharacter.getHp() + " HP.\n");

            } else if (attackingCharacter.getCharacterType().equals(AlternateCharacter.ROGUE)) {
                int specialAbilityDamage = specialAbilityResult;
                System.out.println(attackingCharacter.getName() + " (" +
                        attackingCharacter.getCharacterType().toString().toLowerCase() +
                        ") uses special ability!");
                System.out.println(attackingCharacter.getName() + " (" +
                        attackingCharacter.getCharacterType().toString().toLowerCase() +
                        ") deals " + specialAbilityDamage + " damage.");

                int computerHp = defendingCharacter.takeDamage(specialAbilityDamage);
                System.out.println(defendingCharacter.getName() + " (" +
                        defendingCharacter.getCharacterType().toString().toLowerCase() +
                        ") is currently at " + computerHp + " HP.\n");
                defendingCharacter.setHp(computerHp);
            }

            attackerCooldown = 2;
        }

        if (defendingCharacter.getHp() == 0) {
            gameEnd = true;
        }

        return attackerCooldown;
    }

    public int blockSpecialAbility(int attackerCooldown, Character attackingCharacter, Character defendingCharacter) {
        System.out.println("Special ability is currently on a cooldown and can't be used this turn, so " +
                attackingCharacter.getName() + " attacks again!");
        if (attackerCooldown == 1) {
            System.out.println("(" + attackerCooldown + " turn left until special ability can be used.)");
        } else {
            System.out.println("(" + attackerCooldown + " turns left until special ability can be used.)");
        }
        attackerCooldown = act("1", attackingCharacter, defendingCharacter, attackerCooldown);

        attackerCooldown--;

        return attackerCooldown;
    }
}
