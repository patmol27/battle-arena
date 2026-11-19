package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

            if (!playerCharacter.equals("Warrior") & !playerCharacter.equals("Mage") & !playerCharacter.equals("Rogue")) {
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

        if (chosenCharacter.equals("Warrior")) {
            character = new Warrior(chosenName);
        } else if (chosenCharacter.equals("Mage")) {
            character = new Mage(chosenName);
        } else if (chosenCharacter.equals("Rogue")) {
            character = new Rogue(chosenName);
        }

        return character;
    }

    public void match(Character attacker,Character defender){
        System.out.println("action 1");
        int action = scanner.nextInt();

        if (action == 1){
            int damageGiven = attacker.giveDamage(attacker.getMinimumDamage(),attacker.getMaximumDamage());
            System.out.println(attacker.getName() + " attackerar " + defender.getName());
            System.out.println(attacker.getName() + attacker.getHp());
            System.out.println(defender.getName() + defender.getHp());
            System.out.println("damage given: " + damageGiven);
            System.out.println(defender.takeDamage(damageGiven));
            System.out.println(defender.getName() + defender.getHp());
            //attacker.giveDamage(attacker.getMinimumDamage(),attacker.getMaximumDamage());

        } else if (action == 2){
            attacker.specialAbility();
            int damageGiven = attacker.specialAbility();
            System.out.println(attacker.getName() + " attackerar " + defender.getName());
            System.out.println(attacker.getName() + attacker.getHp());
            System.out.println(defender.getName() + defender.getHp());
            System.out.println("damage given: " + damageGiven);
            System.out.println(defender.takeDamage(damageGiven));
            System.out.println(defender.getName() + defender.getHp());
        }



    }


    public void game(){

        Character chosenPlayerCharacter = setUpPlayerCharacter();
        Character chosenComputerCharacter = setUpComputerCharacter();
        match(chosenPlayerCharacter,chosenComputerCharacter);
       // System.out.println(playerName);




    }
}
