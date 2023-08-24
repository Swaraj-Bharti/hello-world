package com.test.practice;

import com.test.practice.mymap.Dictionary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void getNull() {
        Dictionary<String,String> map = new Dictionary<>();
        map.put("Hello","World");
        assertEquals("World",map.get("Hello"));
    }
    @Test
    void putNullValue() {
        Dictionary<String,String> map = new Dictionary<>();
        map.put("Hello",null);
        assertNull(map.get("Hello"));
    }

    @Test
    void putNullKey() {
        Dictionary<String,String> map = new Dictionary<>();
        map.put(null,"World");
        assertEquals("World",map.get(null));
    }

    @Test
    void putNonNull() {
        Dictionary<String,String> map = new Dictionary<>();
        map.put("Hello","World");
        assertEquals("World",map.get("Hello"));
    }

    @Test
    void putMultiple() {
        Dictionary<String,String> map = new Dictionary<>();
        map.put("Hello","World");
        map.put("Hello1","World1");
        map.put("Hello2","World2");
        map.put("Hello3","World3");
        map.put("Hello11","World11");
        map.put("Hello17","World17");
        map.put("Hello23","World23");
        map.put("Hello29","World29");
        map.put("Hello37","World37");
        map.put("Hello41","World41");
        assertEquals("World",map.get("Hello"));
        assertEquals("World1",map.get("Hello1"));
        assertEquals("World2",map.get("Hello2"));
        assertEquals("World3",map.get("Hello3"));

    }

    @Test
    void containsKey() {
        Dictionary<String,String> map = new Dictionary<>();
        for(int i=10; i<100 ; i++){
            String s = map.put("Hello" + i, "World" + i);
        }
        assertFalse(map.containsKey("Hello"));
        assertTrue(map.containsKey("Hello10"));
        assertTrue(map.containsKey("Hello91"));
        assertFalse(map.containsKey("Hello101"));
    }

    @Test
    void containsValue() {
        Dictionary<String,String> map = new Dictionary<>();
        for(int i=10; i<100 ; i++){
            String s = map.put("Hello" + i, "World" + i);
        }
        assertFalse(map.containsValue("World1"));
        assertTrue(map.containsValue("World11"));
        assertTrue(map.containsKey("Hello98"));
        assertTrue(map.containsValue("World98"));
        assertFalse(map.containsValue("World101"));
    }
    @Test
    void putSameKeyWillReplaceValue() {
        Dictionary<String,String> map = new Dictionary<>();
        String oldValue = map.put("Hello", "World");
        String oldValue1 = map.put("Hello", "World1");
        assertEquals("World1",map.get("Hello"));
        String oldValue2 = map.put("Hello", "NOT My World");
        assertEquals("NOT My World",map.get("Hello"));
        assertNull(oldValue);
        assertEquals("World",oldValue1);
        assertEquals("World1",oldValue2);
    }
}