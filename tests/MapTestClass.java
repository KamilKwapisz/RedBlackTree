import map.RedBlackTree;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapTestClass {
    
    public MapTestClass() {
    }
    
//    @Before
//    public void setUp() {
//    }
    
    @Test
    public void testMapAsAStringIntDict(){
        RedBlackTree<String, Integer> map = new RedBlackTree<>();
        map.setValue("test", 17);
        map.setValue("test2", 21);    
        map.setValue("test3", -13);
        Integer value1 = map.getValue("test");   
        Integer value2 = map.getValue("test2");       
        Integer value3 = map.getValue("test3");
        assertEquals(value1, new Integer(17));
        assertEquals(value2, new Integer(21)); 
        assertEquals(value3, new Integer(-13));
    }
    
    @Test
    public void testGetMethodOnEmptyMap(){
        RedBlackTree<String, Integer> map = new RedBlackTree<>();
        assertNull(map.getValue("NotAKey"));
    }
    
    @Test
    public void testGetMethodWithUnknownKey(){
        RedBlackTree<String, Integer> map = new RedBlackTree<>();
        map.setValue("key", Integer.MIN_VALUE);
        assertNull(map.getValue("NotAKey"));
    }
    
    
}
