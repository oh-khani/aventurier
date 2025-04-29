import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private char[][] terrain;

    public Map(String file) throws IOException {
        this.terrain = generateTerrainFromFile(file);
    }

    // Constructeur pour les tests
    public Map(char[][] terrain) {
        this.terrain = terrain;
    }

    /**
     * @param file Le chemin du fichier à partir duquel générer le terrain.
     * @return Un tableau 2D de caractère représentant le terrain chargé depuis le fichier.
     * @throws IOException Si un problème survient lors de la lecture du fichier.
     */
    private char[][] generateTerrainFromFile(String file) throws IOException {
        List<String> terrainList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
                terrainList.add(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
        }

        terrain = new char[terrainList.size()][];
        for (int i = 0; i < terrainList.size(); i++) {
            terrain[i] = terrainList.get(i).toCharArray();
        }

        return terrain;
    }

    public char[][] getTerrain(){
        return this.terrain;
    }

    /**
     * Détermine si la case (x,y) est un bois impénétrable.
     *
     *
     * @param x La position en x (colonne).
     * @param y La position en y (ligne).
     * @return true si la la case (x,y) est une case bois, false sinon.
     */
    public boolean isWood(int x, int y){
        return terrain[y][x] == '#';
    }

    /**
     * Vérifie si le déplacement d'une case dans la direction donnée est possible à partir de la position (x,y).
     *
     * @param x La position actuelle en x du personnage.
     * @param y La position actuelle en y du personnage.
     * @param direction La direction du prochain déplacement.
     * @return true si le prochain déplacement dans la direction donnée est possible, false sinon.
     */
    public boolean isMoveInDirectionPossible(int x, int y, char direction){
        switch (direction){
            case 'N':
                return x >= 0 && x < terrain.length && y-1 >= 0 && y-1 < terrain[x].length && !isWood(x, y-1);

            case 'S':
                return x >= 0 && x < terrain.length && y+1 >= 0 && y+1 < terrain[x].length && !isWood(x, y+1);

            case 'E':
                return x+1 >= 0 && x+1 < terrain.length && y >= 0 && y < terrain[x].length && !isWood(x+1, y);

            case 'O':
                return x-1 >= 0 && x-1 < terrain.length && y >= 0 && y < terrain[x].length && !isWood(x-1, y);

            default:
                return false;
        }
    }

    public void printMap() {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                System.out.print(terrain[i][j] + " ");
            }
            System.out.println();
        }
    }

}
