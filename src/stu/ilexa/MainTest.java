package stu.ilexa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getRandomInts() {
        assertEquals(new int[0],Main.getRandomInts(-1));
        assertEquals(new int[0],Main.getRandomInts(0));
    }

}