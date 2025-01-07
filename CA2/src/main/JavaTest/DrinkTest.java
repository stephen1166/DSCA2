import Classes.Drink;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrinkTest {

    private Drink Below, Exact, Above, Zero;

    @BeforeEach
    void setUp() {
        //author 9 chars, message 39 chars
        messagePostBelow = new MessagePost("Mairead M", "Programming fundamentals assignment due");
        //author 10 chars, message 40 chars
        messagePostExact = new MessagePost("SiobhanDro", "Objects and Classes Lecture starting now");
        //author 11 chars, message 41 chars
        messagePostAbove = new MessagePost("SiobhanRoch", "Computing and Maths Centre open from 9am.");
        //author 0 chars, message 0 chars
        messagePostZero = new MessagePost("", "");
    }

    @AfterEach
    void tearDown() {
        messagePostBelow = messagePostExact = messagePostAbove = messagePostZero = null;
    }

    @Nested
    class Getters {

        @Test
        void getMessage() {
            assertEquals("Programming fundamentals assignment due", messagePostBelow.getMessage());
            assertEquals("Objects and Classes Lecture starting now", messagePostExact.getMessage());
            assertEquals("Computing and Maths Centre open from 9am", messagePostAbove.getMessage());
            assertEquals("", messagePostZero.getMessage());
        }

        @Test
        void getAuthor() {
        }

        @Test
        void getLikes() {
        }

    }

    @Nested
    class Setters {

        @Test
        void setMessage() {
            assertEquals("Programming fundamentals assignment due", messagePostBelow.getMessage());

            messagePostBelow.setMessage("Programming fundamentals results -- out");   //39 chars - update performed
            assertEquals("Programming fundamentals results -- out", messagePostBelow.getMessage());

            messagePostBelow.setMessage("Programming fundamentals results are out");   //40 chars - update performed
            assertEquals("Programming fundamentals results are out", messagePostBelow.getMessage());

            messagePostBelow.setMessage("Programming fundamentals module now over!");   //41 chars - update ignored
            assertEquals("Programming fundamentals results are out", messagePostBelow.getMessage());
        }

        @Test
        void setAuthor() {
        }

        @Test
        void setLikes() {
        }

    }

    @Nested
    class DisplayMethods {

        @Test
        void testDisplay() {
            //testing the display when a post has no likes
            String toStringContents = messagePostExact.display();
            assertTrue(toStringContents.contains(messagePostExact.getAuthor()));
            assertTrue(toStringContents.contains(messagePostExact.getMessage()));
            assertTrue(toStringContents.contains("0 likes"));

            //testing the display when a post has likes
            messagePostExact.setLikes(1);
            assertTrue(messagePostExact.display().contains("1 people like this"));
        }

        @Test
        void testDisplayCondensed(){

        }
    }

    @Nested
    class LikesOnPosts {

        @Test
        void testingLikingOfPosts() {
            assertEquals(0, messagePostExact.getLikes());

            messagePostExact.likeAPost();
            assertEquals(1, messagePostExact.getLikes());

            messagePostExact.likeAPost();
            assertEquals(2, messagePostExact.getLikes());

        }

        @Test
        void testingUnLikingOfPosts() {
            assertEquals(0, messagePostExact.getLikes());

            messagePostExact.unlikeAPost();
            assertEquals(0, messagePostExact.getLikes());

            messagePostExact.setLikes(2);
            assertEquals(2, messagePostExact.getLikes());

            messagePostExact.unlikeAPost();
            assertEquals(1, messagePostExact.getLikes());
        }
    }

}
