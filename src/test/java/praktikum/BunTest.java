package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private static Random random = new Random();
    private Bun bun;
    private final String ANY_NAME_BUN = "anyName";
    private final float ANY_PRICE_BUN = random.nextFloat();
    private final float CALCULATION_DEVIATION = 0.001F;

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
        assertEquals("Ошибка в цене булки", ANY_PRICE_BUN, priseInBun, CALCULATION_DEVIATION);
    }
}