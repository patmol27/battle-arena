import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    void testWarriorHp() {
        Warrior warrior = new Warrior("Warrior");

        assertEquals(120, warrior.getHp());
    }

    @Test
    void testShield() {
        Warrior warrior = new Warrior("Warrior");

        warrior.useShield();
        warrior.takeDamage(20);

        assertEquals(120, warrior.getHp());
    }
}
