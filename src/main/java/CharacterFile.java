import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterFile {
    private final String characterFile;
    private final String characterInitialCoord;
    private final String characterMovementSequence;


    public CharacterFile(String file) throws IOException {
        this.characterFile = file;
        String[] characterInfo = getCharacterInfoFromFile();
        this.characterInitialCoord = characterInfo[0];
        this.characterMovementSequence = characterInfo[1];
    }


    /**
     * Récupère les coordonnées initiales (première ligne)
     * et la séquence de déplacement (deuxième ligne) à partir d'un fichier.
     *
     * @return Un tableau de de chaîne de caractères contenant les coordonnées initiales et la séquence de déplacement.
     * @throws IOException Si un problème survient lors de la lecture du fichier.
     */
    private String[] getCharacterInfoFromFile() throws IOException {
        List<String> characterInfo = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.characterFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                characterInfo.add(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture : " + e.getMessage());
        }
        return characterInfo.toArray(new String[0]);
    }


    /**
     * @param coordinatesString Les coordonnées initiales en chaîne de caractères.
     * @return Un tableau d'entiers composé des coordinnées x et y.
     */
    private int[] coordStringToInt(String coordinatesString) {
        String[] coordSplit = coordinatesString.split(",");
        return new int[]{Integer.parseInt(coordSplit[0]), Integer.parseInt(coordSplit[1])};
    }


    public int getCharacterInitialX() {
        return this.coordStringToInt(this.characterInitialCoord)[0];
    }


    public int getCharacterInitialY() {
        return this.coordStringToInt(this.characterInitialCoord)[1];
    }


    public String getCharacterMovementSequence() {
        return this.characterMovementSequence;
    }
}
