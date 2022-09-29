package stu.ilexa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void getNoRandomInts() {
        assert(Main.getRandomInts(0).length==0);
    }
    @Test
    void getNegativeRandomInts(){
        assert(Main.getRandomInts(-1).length==0);
    }
    @Test
    void getRandomIntsLength(){
        assert(Main.getRandomInts(5).length==5);
    }

}