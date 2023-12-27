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
    public static final int ZERO_INDEX = 0;
    public static final int ONE_INDEX = 1;
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
    public void testSetBunsMethodCall() {
        Mockito.verify(spyBurger).setBuns(mocBun);
    }

    @Test
    public void testAddIngredientContainsInList() {
        spyBurger.addIngredient(mocIngredientOne);
        assertTrue("Ингредиент добавился", spyBurger.ingredients.contains(mocIngredientOne));
    }

    @Test
    public void testRemoveIngredientNoContains() {
        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.removeIngredient(ZERO_INDEX);
        assertFalse("Ингредиент не удалился", spyBurger.ingredients.contains(mocIngredientOne));
    }

    @Test
    public void testMoveIngredientSwitchIngredient() {
        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.addIngredient(mocIngredientTwo);
        spyBurger.moveIngredient(ZERO_INDEX, ONE_INDEX);

        assertEquals("Ингредиенты не поменялись местами", spyBurger.ingredients.get(0), mocIngredientTwo);
    }

    @Test
    public void testGetPriceSetPriceReturnCorrectPrice() {
        float anyPrice = DataForTests.ANY_PRICE;
        when(mocBun.getPrice()).thenReturn(anyPrice);
        when(mocIngredientOne.getPrice()).thenReturn(anyPrice);
        when(mocIngredientTwo.getPrice()).thenReturn(anyPrice);

        spyBurger.addIngredient(mocIngredientOne);
        spyBurger.addIngredient(mocIngredientTwo);
        float expectedPrice = anyPrice * FOUR_INGR;

        assertEquals("Цена не соответствует", expectedPrice, spyBurger.getPrice(), DataForTests.CALCULATION_DEVIATION);
    }
}
