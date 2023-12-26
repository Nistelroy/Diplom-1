package praktikum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private static final Random random = new Random();
    public static final String ANY_NAME_INGREDIENT = "Any Name";
    public static final float ANY_PRICE_INGREDIENT = random.nextFloat();
    public static Ingredient ingredient;
    private final float CALCULATION_DEVIATION = 0.001F;
    private final IngredientType ingredientType = IngredientType.SAUCE; //использую живой класс т.к. нельзя мокать enum

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType, ANY_NAME_INGREDIENT, ANY_PRICE_INGREDIENT);
    }

    @Test
    public void getPrice() {
        assertEquals("цена не совпадает", ANY_PRICE_INGREDIENT, ingredient.getPrice(), CALCULATION_DEVIATION);
    }

    @Test
    public void getName() {
        assertEquals("имя не совпадает",ANY_NAME_INGREDIENT, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("соус не совпадает", ingredientType, ingredient.getType());
    }
}