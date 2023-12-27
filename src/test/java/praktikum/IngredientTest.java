package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    public static final String ANY_NAME_INGREDIENT = DataForTests.ANY_NAME;
    public static final float ANY_PRICE_INGREDIENT = DataForTests.ANY_PRICE;
    public static Ingredient ingredient;
    private final IngredientType INGR_TYPE = IngredientType.SAUCE; //использую живой класс т.к. нельзя мокать enum

    @Before
    public void setUp() {
        ingredient = new Ingredient(INGR_TYPE, ANY_NAME_INGREDIENT, ANY_PRICE_INGREDIENT);
    }

    @Test
    public void getPriceRandomPriceReturnCorrectPrice() {
        assertEquals("цена не совпадает", ANY_PRICE_INGREDIENT, ingredient.getPrice(), DataForTests.CALCULATION_DEVIATION);
    }

    @Test
    public void getNameRandomNameReturnCorrectName() {
        assertEquals("имя не совпадает", ANY_NAME_INGREDIENT, ingredient.getName());
    }

    @Test
    public void getTypeSauceTypeReturnCorrectType() {
        assertEquals("соус не совпадает", INGR_TYPE, ingredient.getType());
    }
}