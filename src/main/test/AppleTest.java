package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import snake.Apple;


class TemporaryTest{

    @Test
    public void findsAvailableLocation(){
        Apple apple = new Apple();
        for(int i = 0; i < 100; i++){
            System.out.printf("x: %s, y:%s\n", apple.getX(), apple.getY());
        }
    }
}