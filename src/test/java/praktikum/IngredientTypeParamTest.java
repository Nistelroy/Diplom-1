package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private IngredientType ingredientType;
    private String expectedDescript;

    public IngredientTypeParamTest(IngredientType ingredientType, String expectedDescription) {
        this.ingredientType = ingredientType;
        this.expectedDescript = expectedDescription;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "соус"},
                {IngredientType.FILLING, "начинка"},
        });
    }

    @Test
    public void testDescriptionGiveTypeReturnCorrectDescription() {
        assertEquals(expectedDescript, getDescription(ingredientType));
    }

    private String getDescription(IngredientType ingredientType) {
        switch (ingredientType) {
            case SAUCE:
                return "соус";
            case FILLING:
                return "начинка";
            default:
                return "неизвестный тип";
        }
    }
}