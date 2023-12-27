package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private final String ANY_NAME_BUN = DataForTests.ANY_NAME;
    private final float ANY_PRICE_BUN = DataForTests.ANY_PRICE;

    @Before
    public void setUp() {
        bun = new Bun(ANY_NAME_BUN, ANY_PRICE_BUN);
    }

    @Test
    public void testGetNameMethodNameCorrect() {
        String nameInBun = bun.getName();
        assertEquals("Ошибка в названия булки", ANY_NAME_BUN, nameInBun);
    }

    @Test
    public void testGetPriceMethodPriceCorrect() {
        float priseInBun = bun.getPrice();
        assertEquals("Ошибка в цене булки", ANY_PRICE_BUN, priseInBun, DataForTests.CALCULATION_DEVIATION);
    }
}