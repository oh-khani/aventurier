public class Character {
    private int x;
    private int y;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * Déplace le personnage d'une case dans la direction donnée.
     *
     * @param direction La direction cardinale dans laquelle le personnage se déplace.
     *
     */
    public void move(char direction){
        switch(direction){
            case 'N':
                this.y -= 1;
                break;

            case 'S':
                this.y += 1;
                break;

            case 'E':
                this.x += 1;
                break;

            case 'O':
                this.x -= 1;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
