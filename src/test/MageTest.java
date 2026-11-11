package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.Mage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MageTest {
    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage(90, "Mage");
    }

    @Test
    void healShouldNotHealAboveMaximumHp() {
        mage.heal(mage.getMinimumHeal(), mage.getMaximumHeal());

        assertEquals(90, mage.getHp());
    }

    @Test
    void healShouldHealTheCorrectAmount() {
        mage.setHp(30);

        mage.heal(mage.getMinimumHeal(), mage.getMaximumHeal());

        assertTrue(mage.getMinimumHeal() + 30 < mage.getHp());
        assertTrue(mage.getHp() < mage.getMaximumHeal() + 30);
    }
}
