public class Boat {
    private String name;
    private int length;
    private String shape;
    public void setName (String name) {
        this.name = name;
    }
    public String getName () {
        return this.name;
    }
    public void setLength (int length) {
        this.length = length;
    }
    public int getLength () {
        return this.length;
    }
    public void setShape (String shape) {
        this.shape = shape;
    }
    public String getShape () {
        return this.shape;
    }
    public String checkLocation (Coordinates firstCoordinates, Player player) {
        boolean checkRow = true, checkColumn = true;
        if (firstCoordinates.column + this.length > player.getBoardSize()) {
            checkRow = false;
        }
        else {
            for (int i = 0; i < this.length; ++i) {
                if (player.getMyBoard()[firstCoordinates.row - 'a'][ i + firstCoordinates.column] != '0') {
                    checkRow = false;
                    break;
                }
            }
        }
        if (firstCoordinates.row - 'a' + this.length > player.getBoardSize()) {
            checkColumn = false;
        }
        else {
            for (int i = 0; i < this.length; ++i) {
                if (player.getMyBoard()[i + firstCoordinates.row - 'a'][firstCoordinates.column] != '0') {
                    checkColumn = false;
                    break;
                }
            }
        }
        if (checkRow && checkColumn) {
            return "Both";
        }
        else if (checkRow) {
            return "Row";
        }
        else if (checkColumn) {
            return "Column";
        }
        else {
            return "None";
        }
    }
}
