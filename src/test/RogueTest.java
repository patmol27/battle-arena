package test;


    import org.junit.jupiter.api.BeforeEach;

    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

import game.Rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertTrue;

public class RogueTest {

        Rogue rogue;


        @BeforeEach void setUp(){
            rogue = new Rogue("Rogue");
        }




        @DisplayName("make sure damage is between 10-20")
        @Test void makeSureRogueDamageIsBalanced(){

            int damage = rogue.giveDamage(rogue.getMinimumDamage(),rogue.getMaximumDamage());

            System.out.println("Excepcted: Damage between 10-20");
            System.out.println("actual Damage:" + damage);

            assertTrue(damage >= 10 && damage <=20);





        }






    }
