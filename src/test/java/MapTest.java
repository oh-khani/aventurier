import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private Map map;
    private char[][] terrain;

    @BeforeEach
    void setUp() throws IOException {
        // Création d'un terrain simple pour les tests
        terrain = new char[][] {
                {' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#'},
                {'#', ' ', ' ', ' ', ' '},
                {'#', ' ', '#', '#', ' '},
                {'#', '#', '#', ' ', ' '}
        };
        map = new Map(terrain);
    }

    @Test
    void testIsWood() {
        // Tester les cases avec du bois
        assertTrue(map.isWood(2, 0));
        assertTrue(map.isWood(4, 1));

        // Tester les cases sans bois
        assertFalse(map.isWood(1, 2));
        assertFalse(map.isWood(3, 1));
    }

    @Test
    void testIsMoveInDirectionPossible() {
        // À partir de (0,0)
        assertTrue(map.isMoveInDirectionPossible(0, 0, 'E'));
        assertFalse(map.isMoveInDirectionPossible(0, 0, 'S'));
        assertFalse(map.isMoveInDirectionPossible(0, 0, 'N'));
        assertFalse(map.isMoveInDirectionPossible(0, 0, 'O'));

        // À partir de (1,1)
        assertFalse(map.isMoveInDirectionPossible(1, 1, 'E'));
        assertTrue(map.isMoveInDirectionPossible(1, 1, 'S'));
        assertTrue(map.isMoveInDirectionPossible(1, 1, 'N'));
        assertFalse(map.isMoveInDirectionPossible(1, 1, 'O'));

        // À partir de (3,2)
        assertTrue(map.isMoveInDirectionPossible(3, 2, 'E'));
        assertFalse(map.isMoveInDirectionPossible(3, 2, 'S'));
        assertTrue(map.isMoveInDirectionPossible(3, 2, 'N'));
        assertTrue(map.isMoveInDirectionPossible(3, 2, 'O'));
    }
}