package stu.ilexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.zip.CheckedOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTest {
    private Collection base;

    @BeforeEach
    public void initialize() {
        base = new Collection();
        base.addElement(Integer.MAX_VALUE);
        base.addElement(Integer.MIN_VALUE);
        base.addElement(1);
        base.addElement(1);
        base.addElement(0);
        base.addElement(3);
        base.addElement(7);
        base.addElement(-1);
    }

    @Test
    public void addElement() {
        base.addElement(217);
        assertEquals(Integer.MAX_VALUE + "\n" +
                        (Integer.MIN_VALUE) + "\n"
                        + "1\n" +
                        "1\n" +
                        "0\n" +
                        "3\n" +
                        "7\n" +
                        "-1\n" +
                        "217"
                , base.toMultilineString());
    }

    @Test
    public void deleteElement() {
        Collection collection = new Collection();
        collection.deleteElement(0);
        collection.deleteElement(1);
        base.deleteElement(5);
        base.deleteElement(2);
        base.deleteElement(0);
        base.deleteElement(-1);
        base.deleteElement(12);
        assertEquals((Integer.MIN_VALUE) + "\n" +
                        "1\n" +
                        "0\n" +
                        "7\n" +
                        "-1"
                , base.toMultilineString());

    }

    @Test
    public void indexSearch() {

        assertEquals(Integer.MIN_VALUE, base.indexSearch(1));
        assertEquals(1, base.indexSearch(3));
    }

    @Test
    public void dataSearch() {
        assertEquals(2, base.dataSearch(1));
        assertEquals(-1,base.dataSearch(-2));
        assertEquals(0,base.dataSearch(Integer.MAX_VALUE));
        assertEquals(1,base.dataSearch(Integer.MIN_VALUE));
        assertEquals(7,base.dataSearch(-1));
        Collection collection = new Collection();
        assertEquals(-1, collection.dataSearch(0));
    }

    @Test
    public void minSearch() {
        assertEquals(Integer.MIN_VALUE,base.minSearch());
        Collection collection = new Collection();
        assertEquals(Integer.MAX_VALUE, collection.minSearch());
    }

    @Test
    public void maxSearch() {
        assertEquals(Integer.MAX_VALUE,base.maxSearch());
        Collection collection = new Collection();
        assertEquals(Integer.MIN_VALUE, collection.maxSearch());
    }

    @Test
    public void averageCount() {
        assertEquals(11/8,base.averageCount());
        Collection collection = new Collection();
        assertEquals(0, collection.averageCount());
    }

    @Test
    public void getLength() {
        assertEquals(8, base.getLength());
        base.addElement(1);
        assertEquals(9, base.getLength());
        base.deleteElement(0);
        base.deleteElement(0);
        assertEquals(7, base.getLength());
    }

    @Test
    public void toMultilineString() {
        assertEquals(Integer.MAX_VALUE + "\n" +
                        (Integer.MIN_VALUE) + "\n"
                        + "1\n" +
                        "1\n" +
                        "0\n" +
                        "3\n" +
                        "7\n" +
                        "-1"
                , base.toMultilineString());
        Collection collection = new Collection();
        assertEquals("",collection.toMultilineString());
    }
}