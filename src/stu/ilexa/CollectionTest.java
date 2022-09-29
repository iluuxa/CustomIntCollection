package stu.ilexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void deleteEmptyElements(){
        Collection collection = new Collection();
        collection.deleteElement(0);
        collection.deleteElement(1);
    }
    @Test
    public void deleteElement() {
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
    }

    @Test
    public void emptyCollectionDataSearch(){
        Collection collection = new Collection();
        assertEquals(-1, collection.dataSearch(0));
    }
    public void noResultsDataSearch(){
        assertEquals(-1,base.dataSearch(-2));
    }
    @Test
    public void dataSearch() {
        assertEquals(2, base.dataSearch(1));
    }

    @Test
    public void emptyCollectionMinSearch() {
        Collection collection = new Collection();
        assertEquals(Integer.MAX_VALUE, collection.minSearch());
    }
    @Test
    public void minSearch() {
        assertEquals(Integer.MIN_VALUE,base.minSearch());
    }

    @Test
    public void emptyCollectionMaxSearch() {
        Collection collection = new Collection();
        assertEquals(Integer.MIN_VALUE, collection.maxSearch());
    }
    @Test
    public void maxSearch() {
        assertEquals(Integer.MAX_VALUE,base.maxSearch());
    }

    @Test
    public void emptyCollectionAverageCount() {
        Collection collection = new Collection();
        assertEquals(0, collection.averageCount());
    }
    @Test
    public void averageCount() {
        assertEquals((double)(11/8),base.averageCount());
    }

    @Test
    public void getLength() {
        assertEquals(8, base.getLength());
    }

    @Test
    public void getAddedLength() {
        base.addElement(1);
        assertEquals(9, base.getLength());
    }

    @Test
    public void getSubtractedLength() {
        base.addElement(1);
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
    }
    @Test
    public void emptyCollectionToMultilineString(){
        Collection collection = new Collection();
        assertEquals("",collection.toMultilineString());
    }
}