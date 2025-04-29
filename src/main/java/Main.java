import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Erreur : nombre d'argument incorrect !");
            System.exit(1);
        }

        Map carte = new Map("src/ressources/carte.txt");

        CharacterFile characterFile = new CharacterFile(args[0]);

        Character aventurier = new Character(characterFile.getCharacterInitialX(), characterFile.getCharacterInitialY());
        char[] deplacements = characterFile.getCharacterMovementSequence().toCharArray();

        for(char direction: deplacements) {
            if (carte.isMoveInDirectionPossible(aventurier.getX(), aventurier.getY(), direction)) {
                aventurier.move(direction);
            }
        }

        System.out.println("Le personnage se trouve en (" +  aventurier.getX() + "," + aventurier.getY() + ").");
    }
}