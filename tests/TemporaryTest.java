package snake.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import snake.TemporaryClass;


class TemporaryTest{

    @Test
    public void temporaryTestFunction(){
        assertEquals(snake.TemporaryClass.temporaryMethod(), 1);
    }
}