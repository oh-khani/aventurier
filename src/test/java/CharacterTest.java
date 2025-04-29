import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character(1, 1);
    }

    @Test
    void testInitialPosition() {
        assertEquals(1, character.getX());
        assertEquals(1, character.getY());
    }

    @Test
    void testMoveNorth() {
        character.move('N');
        assertEquals(1, character.getX());
        assertEquals(0, character.getY());
    }

    @Test
    void testMoveSouth() {
        character.move('S');
        assertEquals(1, character.getX());
        assertEquals(2, character.getY());
    }

    @Test
    void testMoveEast() {
        character.move('E');
        assertEquals(2, character.getX());
        assertEquals(1, character.getY());
    }

    @Test
    void testMoveWest() {
        character.move('O');
        assertEquals(0, character.getX());
        assertEquals(1, character.getY());
    }

    @Test
    void testMultipleMoves() {
        character.move('N');
        character.move('E');
        character.move('E');
        character.move('S');
        character.move('S');
        character.move('O');

        assertEquals(2, character.getX());
        assertEquals(2, character.getY());
    }
}