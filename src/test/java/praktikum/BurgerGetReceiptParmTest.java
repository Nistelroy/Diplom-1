package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParmTest {
    private Burger burger = new Burger();
    private Bun mocBun;
    private IngredientType[] ingredientTypes;
    private String expectedReceipt;
    private static float ingredientPrise = DataForTests.ANY_PRICE;
    private float expectedPrise;

    public BurgerGetReceiptParmTest(IngredientType[] ingredientTypes, String expectedReceipt, float expectedPrise) {
        this.ingredientTypes = ingredientTypes;
        this.expectedReceipt = expectedReceipt;
        this.expectedPrise = expectedPrise;
    }

    @Before
    public void setUp() {
        mocBun = Mockito.mock(Bun.class);
        burger.setBuns(mocBun);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new IngredientType[]{IngredientType.FILLING}, "filling mocName", ingredientPrise },
                {new IngredientType[]{IngredientType.SAUCE}, "sauce mocName", ingredientPrise},
                {new IngredientType[]{}, "", 0.0f}
        });
    }

    @Test
    public void testGetReceipt() {
        for (IngredientType type : ingredientTypes) {
            Ingredient mockIngredient = mock(Ingredient.class);
            when(mockIngredient.getType()).thenReturn(type);
            when(mockIngredient.getName()).thenReturn("mocName");
            when(mockIngredient.getPrice()).thenReturn(ingredientPrise);

            burger.addIngredient(mockIngredient);
        }
        when(mocBun.getName()).thenReturn("mocBun");

        assertTrue(burger.getReceipt().contains(expectedReceipt));

        assertEquals(expectedPrise, burger.getPrice(), DataForTests.CALCULATION_DEVIATION);
    }
}