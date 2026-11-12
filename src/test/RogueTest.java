package test;


    import org.junit.jupiter.api.BeforeEach;

    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

import java.Rogue;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class RogueTest {

        Rogue rogue;


        @BeforeEach void setUp(){
            rogue = new Rogue("Rogue");
        }




        @DisplayName("make sure damage is between 10-20")
        @Test void makeSureRogueDamageIsBalanced(){

            int damage = rogue.giveDamage(rogue.getMinimumDamage(),rogue.getMaximumDamage());

            assertEquals(damage,rogue.giveDamage(rogue.getMinimumDamage(),rogue.getMaximumDamage()));



        }


        @Test void makeSureEviscerateIsBalanced(){

            int damage = rogue.eviscerate(rogue.getMinEviscerateDamage(),rogue.getMaxEviscerateDamage());

            assertEquals(damage,rogue.eviscerate(rogue.getMinEviscerateDamage(),rogue.getMaxEviscerateDamage()));
        }



    }
