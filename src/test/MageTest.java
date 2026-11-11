package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.Mage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageTest {
    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage(90, "java.Mage");
    }

    @Test
    void healShouldNotHealAboveMaximumHp() {
        mage.heal();

        Assertions.assertEquals(90, mage.getHp());
    }
}
