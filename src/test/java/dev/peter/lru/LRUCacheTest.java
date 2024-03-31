package dev.peter.lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void givenLRU_shouldUpdate() {
        LRUCache<String, Integer> lru = new LRUCache<>(3);
        lru.update("foo", 5);

        assertEquals(1, lru.getLength());
        assertEquals(5, lru.getHead().getValue());
        assertEquals(5, lru.getTail().getValue());
    }

    @Test
    void givenLRU_shouldUpdateEveryTime() {
        LRUCache<String, Integer> lru = new LRUCache<>(3);
        lru.update("foo", 5);
        lru.update("bar", 7);
        lru.update("buz", 1);

        assertEquals(3, lru.getLength());
        assertEquals(1, lru.getHead().getValue());
        assertEquals(5, lru.getTail().getValue());
    }

    @Test
    void givenNonEmptyLRU_shouldGetReturnValue() {
        LRUCache<String, Integer> lru = new LRUCache<>(3);
        lru.update("foo", 5);

        assertEquals(5, lru.get("foo"));
    }

    @Test
    void givenEmptyLRU_shouldGetReturnNull() {
        LRUCache<String, Integer> lru = new LRUCache<>(3);

        assertNull(lru.get("foo"));
    }
}