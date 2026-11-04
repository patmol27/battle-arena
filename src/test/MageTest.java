package test;

import org.junit.jupiter.api.BeforeEach;

public class MageTest {
    private Mage mage;

    @BeforeEach
    void setUp() {
        mage = new Mage(90, "Mage");
    }
}
