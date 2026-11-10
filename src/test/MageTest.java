package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageTest {
    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage(90, "Mage");
    }

    @Test
    void healShouldNotHealAboveMaximumHp() {
        mage.heal();

        assertEquals(90, mage.getHp());
    }
}