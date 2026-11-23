package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.Warrior;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {

    private Warrior warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Warrior");
    }

    @Test
    void testWarriorHp() {
        assertEquals(120, warrior.getHp());
    }

    @Test
    void testShield() {
        warrior.useShield();
        warrior.takeDamage(20);

        assertEquals(120, warrior.getHp());
    }
}