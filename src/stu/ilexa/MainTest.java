package stu.ilexa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getRandomInts() {
        assert(Main.getRandomInts(0).length==0);
        assertEquals(new int[0],Main.getRandomInts(-1));
    }

}