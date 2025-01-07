import Classes.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    private Ingredient Below, Exact, Above, Zero;

    @BeforeEach
    void setUp() {
        Below = new Ingredient("this message is 29 characters", "--------------------------------------------------------------------------------------------------]",-1.0);
        Exact = new Ingredient("-this message is 30 characters", "--------------------------------------------------------------------------------------------------]-",100.0);
        Above = new Ingredient("this message is 31+ characters--", "--------------------------------------------------------------------------------------------------]-+", 101.0);
        Zero = new Ingredient("", "",-1.0);
    }

    @AfterEach
    void tearDown() {
        Below = Exact = Above = Zero = null;
    }

    @Nested
    class Getters {

        @Test
        void getName() {
            assertEquals("this message is 29 characters", Below.getName());
            assertEquals("-this message is 30 characters", Exact.getName());
            assertEquals("this message is 31+ characters", Above.getName());
            assertEquals("", Zero.getName());
        }

        @Test
        void getTexture() {
            assertEquals("--------------------------------------------------------------------------------------------------]", Below.getTexture());
            assertEquals("--------------------------------------------------------------------------------------------------]-", Exact.getTexture());
            assertEquals("--------------------------------------------------------------------------------------------------]-", Above.getTexture());
            assertEquals("", Zero.getTexture());
        }

        @Test
        void getAbv() {
            assertEquals(-1.0, Below.getAbv());
            assertEquals(100.0, Exact.getAbv());
            assertEquals(-1.0, Above.getAbv());
            assertEquals(-1.0, Zero.getAbv());
        }

    }

    @Nested
    class Setters {

        @Test
        void setName() {
            assertEquals("", Zero.getName());

            Below.setName("this message is 29 characters");
            assertEquals("this message is 29 characters", Below.getName());

            Exact.setName("-this message is 30 characters");
            assertEquals("-this message is 30 characters", Exact.getName());

            Above.setName("this message is 31+ characters--");
            assertEquals("this message is 31+ characters", Above.getName());
        }

        @Test
        void setTexture() {
            assertEquals("", Zero.getTexture());

            Below.setTexture("--------------------------------------------------------------------------------------------------]");
            assertEquals("--------------------------------------------------------------------------------------------------]", Below.getTexture());

            Exact.setTexture("--------------------------------------------------------------------------------------------------]-");
            assertEquals("--------------------------------------------------------------------------------------------------]-", Exact.getTexture());

            Above.setTexture("--------------------------------------------------------------------------------------------------]-+");
            assertEquals("--------------------------------------------------------------------------------------------------]-", Above.getTexture());
        }

        @Test
        void setAbv() {
            assertEquals(-1.0, Zero.getAbv());

            Below.setAbv(-1.0);
            assertEquals(-1.0, Below.getAbv());

            Exact.setAbv(100.0);
            assertEquals(100.0, Exact.getAbv());

            Above.setAbv(101.0000);
            assertEquals(-1.0, Above.getAbv());
        }
    }
}