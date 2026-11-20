package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.Mage;

import static org.junit.jupiter.api.Assertions.*;

public class MageTest {
    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage("Mage");
    }

    @Test
    void healShouldNotHealAboveMaximumHp() {
        mage.specialAbility();

        assertEquals(90, mage.getHp());
    }

    @Test
    void healShouldHealTheCorrectAmount() {
        mage.setHp(30);

        mage.specialAbility();

        assertTrue(mage.MINIMUM_HEAL + 30 < mage.getHp());
        assertTrue(mage.getHp() < mage.MAXIMUM_HEAL + 30);
    }
}
