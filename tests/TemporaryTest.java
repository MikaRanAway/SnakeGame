package snake.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import snake.TemporaryClass;


class TemporaryTest{

    @Test
    public static void temporaryTestFunction(){
        assertEquals(snake.TemporaryClass.temporaryMethod(), 2);
    }

    public static void main(String[] args) {
        System.out.println(TemporaryClass.temporaryMethod());

    }
}