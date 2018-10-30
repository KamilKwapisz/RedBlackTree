package tests;

import redblacktree.RedBlackTree;
import org.junit.Test;
import static org.junit.Assert.*;

public class RedBlackTreeTest {

    @Test
    public void testMapAsAStringIntDict() {
        // Given
        RedBlackTree<String, Integer> map = new RedBlackTree<>();
        map.setValue("test", 17);
        map.setValue("test2", 21);
        map.setValue("test3", -13);

        // When
        Integer value1 = map.getValue("test");
        Integer value2 = map.getValue("test2");
        Integer value3 = map.getValue("test3");

        // Then
        assertEquals(value1, new Integer(17));
        assertEquals(value2, new Integer(21));
        assertEquals(value3, new Integer(-13));
    }

    @Test
    public void testGetMethodOnEmptyMap() {
        // Given
        RedBlackTree<String, Integer> map = new RedBlackTree<>();

        // When 
        Integer value = map.getValue("NotAKey");

        // Then
        assertNull(value);
    }

    @Test
    public void testGetMethodWithUnknownKey() {
        // Given
        RedBlackTree<String, Integer> map = new RedBlackTree<>();
        map.setValue("key", Integer.MIN_VALUE);

        // When
        Integer value = map.getValue("NotAKey");

        // Then
        assertNull(value);
    }

    @Test
    public void testMapWithDoublesAsKeysAndValues() {
        // Givem
        RedBlackTree<Double, Double> map = new RedBlackTree<>();
        map.setValue(17.0, 13.1);

        // When
        Double value = map.getValue(17.0);
        Double expectedValue = new Double(13.1);

        // Then
        assertEquals(value, expectedValue);
    }

    @Test
    public void testMapWithObjectAsAValue() {
        // Given
        RedBlackTree<String, Object> map = new RedBlackTree<>();
        Object object = new Object();
        map.setValue("key", object);

        // When
        Object value = map.getValue("key");

        // Then
        assertEquals(value, object);
    }

    @Test
    public void testMapWithValueInheritatingFromObject() {
        // Given
        RedBlackTree<String, Object> map = new RedBlackTree<>();
        map.setValue("key", 32.2);

        // When
        Object value = map.getValue("key");
        Double expectedValue = new Double(32.2);

        // Then 
        assertEquals(value, expectedValue);
    }

}
