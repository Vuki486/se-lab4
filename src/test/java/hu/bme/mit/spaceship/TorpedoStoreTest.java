package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test 
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(1, 1.0);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }
    
    @Test 
    void fire_IllegalArgumentException() {
        TorpedoStore store = new TorpedoStore(1);
        try {
            store.fire(2);
        } catch (IllegalArgumentException e) {
            assertEquals("numberOfTorpedos", e.getMessage());
        }
    }

    @Test 
    void isEmpty_getter_test() {
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(false, store.isEmpty());
        boolean result = store.fire(1);
        assertEquals(true, result);
        assertEquals(true, store.isEmpty());
    }

    @Test 
    void getTorpedoCount_getter_test() {
        TorpedoStore store = new TorpedoStore(2);
        assertEquals(2, store.getTorpedoCount());
        boolean result = store.fire(1);
        assertEquals(true, result);
        assertEquals(1, store.getTorpedoCount());
    }
}
