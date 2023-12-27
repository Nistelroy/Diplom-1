package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public static final int FOUR_INGR = 4;
    @Spy
    private Burger spyBurger = new Burger();
    @Mock
    private Bun mocBun;
    @Mock
    private Ingredient mocIngredientOne;
    @Mock
    private Ingredient mocIngredientTwo;

    @Before
    public void setUp() {
        spyBurger.setBuns(mocBun);
    }

    @Test
    public void setBuns() {
        Mockito.verify(spyBurger).setBuns(mocBun);
    }

    @Test
    public void addIngredient() {
        spyBurger.addIngredient(mocIngredientOne);
        assertTrue(spyBurger.ingredients.contains(mocIngredientOne));
    }

    @Test
    public void removeIngredient() {
        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.removeIngredient(0);
        assertFalse(spyBurger.ingredients.contains(mocIngredientOne));
    }

    @Test
    public void moveIngredient() {
        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.addIngredient(mocIngredientTwo);
        spyBurger.moveIngredient(0, 1);

        assertEquals(spyBurger.ingredients.get(0), mocIngredientTwo);
    }

    @Test
    public void testGetPrice() {
        float anyPrice = DataForTests.ANY_PRICE;
        when(mocBun.getPrice()).thenReturn(anyPrice);
        when(mocIngredientOne.getPrice()).thenReturn(anyPrice);
        when(mocIngredientTwo.getPrice()).thenReturn(anyPrice);

        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.addIngredient(mocIngredientTwo);

        float expectedPrice = anyPrice * FOUR_INGR;
        assertEquals(expectedPrice, spyBurger.getPrice(), 0.001);
    }
}
