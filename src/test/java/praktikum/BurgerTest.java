package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Ingredient mockFirstIngredient;

    @Mock
    private Ingredient mockSecondIngredient;

    @Mock
    private Bun bun;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsShouldSetBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientShouldAddIngredientTest() {
        burger.addIngredient(mockFirstIngredient);
        assertTrue(burger.ingredients.contains(mockFirstIngredient));
    }

    @Test
    public void removeIngredientShouldRemoveIngredientTest() {
        burger.addIngredient(mockFirstIngredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientShouldMoveIngredientTest() {
        burger.addIngredient(mockFirstIngredient);
        burger.addIngredient(mockSecondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals(mockFirstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceShouldGetCorrectPrice() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(mockFirstIngredient.getPrice()).thenReturn(200F);
        Mockito.when(mockSecondIngredient.getPrice()).thenReturn(300F);
        burger.addIngredient(mockFirstIngredient);
        burger.addIngredient(mockSecondIngredient);
        float expectedPrice = 700F;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }
}