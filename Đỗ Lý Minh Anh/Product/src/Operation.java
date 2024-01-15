import java.util.Random;
import java.util.Scanner;

public class Operation {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public void displayMenu () {
        System.out.println("      " + ANSI_RED_BACKGROUND + ANSI_BLACK + "  MENU  " + ANSI_RESET + "      ");
        System.out.println("--------------------");
        System.out.println("|" + ANSI_RED + "     1. Play      " + ANSI_RESET + "|");
        System.out.println("--------------------");
        System.out.println("|" + ANSI_RED + " 2. Ranking Table " + ANSI_RESET + "|");
        System.out.println("--------------------");
        System.out.println("|" + ANSI_RED + "    3. Cancel     " + ANSI_RESET + "|");
        System.out.println("--------------------");
    }
    public void displaySetUpOptions (Player player) {
        System.out.println(ANSI_GREEN + "*** " + ANSI_RESET + player.getName() + ANSI_GREEN + " sets up the boat! ***" + ANSI_RESET);
        System.out.println();
        System.out.println("      " + ANSI_RED_BACKGROUND + ANSI_BLACK + "  OPTIONS  " + ANSI_RESET + "       ");
        System.out.println("------------------------");
        System.out.println("|" + ANSI_RED + "  1. Set up the boat  " + ANSI_RESET + "|");
        System.out.println("------------------------");
        System.out.println("|" + ANSI_RED + "      2. Random       " + ANSI_RESET + "|");
        System.out.println("------------------------");
        System.out.println("|" + ANSI_RED + "       3. Cancel      " + ANSI_RESET + "|");
        System.out.println("------------------------");
    }
    public void displayPlayerOptions () {
        System.out.println("   " + ANSI_RED_BACKGROUND + ANSI_BLACK + " PLAYER OPTIONS " + ANSI_RESET + "   ");
        System.out.println("----------------------");
        System.out.println("|" + ANSI_RED + "  1. View my board  " + ANSI_RESET + "|");
        System.out.println("----------------------");
        System.out.println("|" + ANSI_RED + "    2. Open fire    " + ANSI_RESET + "|");
        System.out.println("----------------------");
        System.out.println("|" + ANSI_RED + "     3. Cancel      " + ANSI_RESET + "|");
        System.out.println("----------------------");
    }
    public void displayBoardOfPlayer (Player player) {
        System.out.println("-> My Board:");
        int count = 4 * (player.getBoardSize() + 1) + 1;
        for (int i = 0; i < count; ++i) {
            if (i > 3) {
                System.out.print("_");
            }
            else System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i <= player.getBoardSize(); ++i) {
            for (int j = 0; j <= player.getBoardSize(); ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("____");
                }
                else if (i == 0) {
                    if (j < 10) {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + "_" + ANSI_RESET);
                    }
                    else {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + ANSI_RESET);
                    }
                }
                else if (j == 0) {
                    System.out.printf("|" + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + (char)(i + 'a' - 1) + "_" + ANSI_RESET);
                }
                else {
                    if (player.getMyBoard()[i - 1][j - 1] == 'm') {
                        System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "_m_" + ANSI_RESET);
                    }
                    else if (player.getMyBoard()[i - 1][j - 1] == 'h') {
                        System.out.print(ANSI_GREEN_BACKGROUND + "_h_" + ANSI_RESET);
                    }
                    else if (player.getMyBoard()[i - 1][j - 1] == '1' || player.getMyBoard()[i - 1][j - 1] == '2') {
                        System.out.print(ANSI_YELLOW_BACKGROUND + "_1_" + ANSI_RESET);
                    }
                    else if (player.getMyBoard()[i - 1][j - 1] == '3') {
                        System.out.print(ANSI_BLUE_BACKGROUND + "_2_" + ANSI_RESET);
                    }
                    else if (player.getMyBoard()[i - 1][j - 1] == '4') {
                        System.out.print(ANSI_PURPLE_BACKGROUND + "_3_" + ANSI_RESET);
                    }
                    else if (player.getMyBoard()[i - 1][j - 1] == '5') {
                        System.out.print(ANSI_CYAN_BACKGROUND + "_4_" + ANSI_RESET);
                    }
                    else {
                        System.out.print("_0_");
                    }
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println(ANSI_GREEN + "!! NOTE:" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + " m " + ANSI_RESET + ": Square shot missed");
        System.out.println(ANSI_GREEN_BACKGROUND + " h " + ANSI_RESET + ": Square has been hit");
        System.out.println(" 0 : Empty");
        System.out.println(ANSI_YELLOW_BACKGROUND + " 1 " + ANSI_RESET + ": Patrol Boat");
        System.out.println(ANSI_BLUE_BACKGROUND + " 2 " + ANSI_RESET + ": Destroyer Boat");
        System.out.println(ANSI_PURPLE_BACKGROUND + " 3 " + ANSI_RESET + ": Submarine");
        System.out.println(ANSI_CYAN_BACKGROUND + " 4 " + ANSI_RESET + ": Battle Ship");
    }
    public Coordinates chooseTheFirstSquare (Scanner sc, Player player, Boat boat) {
        String shape;
        String location;
        StringBuilder number;
        int count;
        Coordinates coordinates = new Coordinates();
        System.out.println(ANSI_GREEN + "Enter the first square of " + ANSI_RESET + boat.getName() + ANSI_GREEN + ":" + ANSI_RESET);
        location = sc.nextLine();
        coordinates.row = location.charAt(0);
        count = 1;
        number = new StringBuilder();
        while (count < location.length()) {
            number.append(location.charAt(count));
            ++count;
        }
        coordinates.column = Integer.parseInt(number.toString()) - 1;
        while (coordinates.row - 'a' >= player.getBoardSize() || coordinates.column >= player.getBoardSize()) {
            System.out.println(ANSI_RED + "Invalid. Please choose another square!" + ANSI_RESET);
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
        }
        while (player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != '0') {
            System.out.println(ANSI_RED + "This square has already been taken. Please choose another square!" + ANSI_RESET);
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= player.getBoardSize() || coordinates.column >= player.getBoardSize()) {
                System.out.println(ANSI_RED + "Invalid. Please choose another square!" + ANSI_RESET);
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
            }
        }
        shape = boat.checkLocation(coordinates, player);
        while (shape.equals("None")) {
            System.out.println(ANSI_RED + "Cannot set up the boat. Please choose another square!" + ANSI_RESET);
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= player.getBoardSize() || coordinates.column >= player.getBoardSize()) {
                System.out.println(ANSI_RED + "Invalid. Please choose another square!" + ANSI_RESET);
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
            }
            while (player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != '0') {
                System.out.println(ANSI_RED + "This square has already been taken. Please choose another square!" + ANSI_RESET);
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
                while (coordinates.row - 'a' >= player.getBoardSize() || coordinates.column >= player.getBoardSize()) {
                    System.out.println(ANSI_RED + "Invalid. Please choose another square!" + ANSI_RESET);
                    location = sc.nextLine();
                    coordinates.row = location.charAt(0);
                    count = 1;
                    number = new StringBuilder();
                    while (count < location.length()) {
                        number.append(location.charAt(count));
                        ++count;
                    }
                    coordinates.column = Integer.parseInt(number.toString()) - 1;
                }
            }
            shape = boat.checkLocation(coordinates, player);
        }
        if (shape.equals("Both")) {
            System.out.println(ANSI_GREEN + "Select the shape of " + ANSI_RESET + boat.getName() + ANSI_GREEN + ":" + ANSI_RESET);
            System.out.println(ANSI_RED + "-> 1: Row");
            System.out.println(ANSI_RED + "-> 2: Column" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Enter your choice:" + ANSI_RESET);
            int option = Integer.parseInt(sc.nextLine());
            if (option == 1) {
                boat.setShape("Row");
            }
            else {
                boat.setShape("Column");
            }
        }
        else {
            boat.setShape(shape);
        }
        return coordinates;
    }
    public void displayCurrentStatus (Player player) {
        System.out.println("My current status:");
        System.out.println(ANSI_BLUE + "** The number of squares shot on the enemy front: " + ANSI_CYAN + player.getTheNumberOfSquaresShot() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "** The number of boats hit: " + ANSI_CYAN + player.getTheNumberOfBoatsHit() + ANSI_RESET);
        System.out.println(ANSI_BLUE + "** The number of my remaining boats: " + ANSI_CYAN + player.getTheNumberOfMyRemainingBoats() + ANSI_RESET);
    }
    public void displayTheBoardOfEnemy (Player enemy) {
        System.out.println("-> Enemy's board:");
        int count = 4 * (enemy.getBoardSize() + 1) + 1;
        for (int i = 0; i < count; ++i) {
            if (i > 3) {
                System.out.print("_");
            }
            else System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i <= enemy.getBoardSize(); ++i) {
            for (int j = 0; j <= enemy.getBoardSize(); ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("____");
                }
                else if (i == 0) {
                    if (j < 10) {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + "_" + ANSI_RESET);
                    }
                    else {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + ANSI_RESET);
                    }
                }
                else if (j == 0) {
                    System.out.printf("|" + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + (char)(i + 'a' - 1) + "_" + ANSI_RESET);
                }
                else if (enemy.getMyBoard()[i - 1][j - 1] > '5') {
                    if (enemy.getMyBoard()[i - 1][j - 1] == 'm') {
                        System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "_m_" + ANSI_RESET);
                    }
                    else if (enemy.getMyBoard()[i - 1][j - 1] == 'h') {
                        System.out.print(ANSI_GREEN_BACKGROUND + "_h_" + ANSI_RESET);
                    }
                }
                else {
                    System.out.print("_0_");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println(ANSI_GREEN + "!! NOTE:" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + " m " + ANSI_RESET + ": Square shot missed");
        System.out.println(ANSI_GREEN_BACKGROUND + " h " + ANSI_RESET + ": Square has been hit");
        System.out.println(" 0 : Empty");
    }
    public void displayTheResults (Player player1, Player player2) {
        int size = player1.getBoardSize();
        System.out.print(ANSI_GREEN + player1.getName() + ANSI_RESET + "'s Board:");
        int cnt = 4 * (size + 1) + 2 - player1.getName().length();
        while (cnt-- > 0) {
            System.out.print(" ");
        }
        System.out.println(ANSI_GREEN + player2.getName() + ANSI_RESET + "'s Board:");
        int count = 4 * (size + 1) + 1;
        for (int i = 0; i < count; ++i) {
            if (i > 3) {
                System.out.print("_");
            }
            else System.out.print(" ");
        }
        System.out.print("          ");
        for (int i = 0; i < count; ++i) {
            if (i > 3) {
                System.out.print("_");
            }
            else System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i <= size; ++i) {
            for (int j = 0; j <= size; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("____");
                }
                else if (i == 0) {
                    if (j < 10) {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + "_" + ANSI_RESET);
                    }
                    else {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + ANSI_RESET);
                    }
                }
                else if (j == 0) {
                    System.out.printf("|" + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + (char)(i + 'a' - 1) + "_" + ANSI_RESET);
                }
                else {
                    if (player1.getMyBoard()[i - 1][j - 1] == 'm') {
                        System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "_m_" + ANSI_RESET);
                    }
                    else if (player1.getMyBoard()[i - 1][j - 1] == 'h') {
                        System.out.print(ANSI_GREEN_BACKGROUND + "_h_" + ANSI_RESET);
                    }
                    else if (player1.getMyBoard()[i - 1][j - 1] == '1' || player1.getMyBoard()[i - 1][j - 1] == '2') {
                        System.out.print(ANSI_YELLOW_BACKGROUND + "_1_" + ANSI_RESET);
                    }
                    else if (player1.getMyBoard()[i - 1][j - 1] == '3') {
                        System.out.print(ANSI_BLUE_BACKGROUND + "_2_" + ANSI_RESET);
                    }
                    else if (player1.getMyBoard()[i - 1][j - 1] == '4') {
                        System.out.print(ANSI_PURPLE_BACKGROUND + "_3_" + ANSI_RESET);
                    }
                    else if (player1.getMyBoard()[i - 1][j - 1] == '5') {
                        System.out.print(ANSI_CYAN_BACKGROUND + "_4_" + ANSI_RESET);
                    }
                    else {
                        System.out.print("_0_");
                    }
                }
                System.out.print("|");
            }
            System.out.print("          ");
            for (int j = 0; j <= size; ++j) {
                if (i == 0 && j == 0) {
                    System.out.print("____");
                }
                else if (i == 0) {
                    if (j < 10) {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + "_" + ANSI_RESET);
                    }
                    else {
                        System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + j + ANSI_RESET);
                    }
                }
                else if (j == 0) {
                    System.out.printf("|" + ANSI_WHITE_BACKGROUND + ANSI_BLACK + "_" + (char)(i + 'a' - 1) + "_" + ANSI_RESET);
                }
                else {
                    if (player2.getMyBoard()[i - 1][j - 1] == 'm') {
                        System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "_m_" + ANSI_RESET);
                    }
                    else if (player2.getMyBoard()[i - 1][j - 1] == 'h') {
                        System.out.print(ANSI_GREEN_BACKGROUND + "_h_" + ANSI_RESET);
                    }
                    else if (player2.getMyBoard()[i - 1][j - 1] == '1' || player2.getMyBoard()[i - 1][j - 1] == '2') {
                        System.out.print(ANSI_YELLOW_BACKGROUND + "_1_" + ANSI_RESET);
                    }
                    else if (player2.getMyBoard()[i - 1][j - 1] == '3') {
                        System.out.print(ANSI_BLUE_BACKGROUND + "_2_" + ANSI_RESET);
                    }
                    else if (player2.getMyBoard()[i - 1][j - 1] == '4') {
                        System.out.print(ANSI_PURPLE_BACKGROUND + "_3_" + ANSI_RESET);
                    }
                    else if (player2.getMyBoard()[i - 1][j - 1] == '5') {
                        System.out.print(ANSI_CYAN_BACKGROUND + "_4_" + ANSI_RESET);
                    }
                    else {
                        System.out.print("_0_");
                    }
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println(ANSI_GREEN + "!! NOTE:" + ANSI_RESET);
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + " m " + ANSI_RESET + ": Square shot missed");
        System.out.println(ANSI_GREEN_BACKGROUND + " h " + ANSI_RESET + ": Square has been hit");
        System.out.println(" 0 : Empty");
        System.out.println(ANSI_YELLOW_BACKGROUND + " 1 " + ANSI_RESET + ": Patrol Boat");
        System.out.println(ANSI_BLUE_BACKGROUND + " 2 " + ANSI_RESET + ": Destroyer Boat");
        System.out.println(ANSI_PURPLE_BACKGROUND + " 3 " + ANSI_RESET + ": Submarine");
        System.out.println(ANSI_CYAN_BACKGROUND + " 4 " + ANSI_RESET + ": Battle Ship");
    }
    public Coordinates autoChooseTheFirstSquare (Player player, Boat boat) {
        Random random = new Random();
        String shape;
        Coordinates coordinates = new Coordinates();
        coordinates.row = (char) random.nextInt('a', 'j');
        coordinates.column = random.nextInt(0, 9);
        shape = boat.checkLocation(coordinates, player);
        while (coordinates.row - 'a' >= player.getBoardSize() || coordinates.column >= player.getBoardSize() || player.getMyBoard()[coordinates.row - 'a'][coordinates.column] != '0' || shape.equals("None")) {
            coordinates.row = (char) random.nextInt('a', 'j');
            coordinates.column = random.nextInt(0, 9);
            shape = boat.checkLocation(coordinates, player);
        }
        if (shape.equals("Both")) {
            int randomOption = random.nextInt(1, 2);
            if (randomOption == 1) {
                boat.setShape("Row");
            }
            else {
                boat.setShape("Column");
            }
        }
        else {
            boat.setShape(shape);
        }
        return coordinates;
    }
    public void autoSetUpTheBoat (Player player) {
        Boat thePatrolBoat1 = new Boat();
        thePatrolBoat1.setName("The Patrol Boat 1");
        thePatrolBoat1.setLength(2);
        Coordinates coordinates;
        coordinates = autoChooseTheFirstSquare(player, thePatrolBoat1);
        if (thePatrolBoat1.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = '1';
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat1.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = '1';
            }
        }
        Boat thePatrolBoat2 = new Boat();
        thePatrolBoat2.setName("The Patrol Boat 2");
        thePatrolBoat2.setLength(2);
        coordinates = autoChooseTheFirstSquare(player, thePatrolBoat2);
        if (thePatrolBoat2.getShape().equals("Row")) {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = '2';
            }
        }
        else {
            for (int i = 0; i < thePatrolBoat2.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = '2';
            }
        }
        Boat theDestroyerBoat = new Boat();
        theDestroyerBoat.setName("The Destroyer Boat");
        theDestroyerBoat.setLength(4);
        coordinates = autoChooseTheFirstSquare(player, theDestroyerBoat);
        if (theDestroyerBoat.getShape().equals("Row")) {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = '3';
            }
        }
        else {
            for (int i = 0; i < theDestroyerBoat.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = '3';
            }
        }
        Boat theSubmarine = new Boat();
        theSubmarine.setName("The Submarine");
        theSubmarine.setLength(3);
        coordinates = autoChooseTheFirstSquare(player, theSubmarine);
        if (theSubmarine.getShape().equals("Row")) {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = '4';
            }
        }
        else {
            for (int i = 0; i < theSubmarine.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = '4';
            }
        }
        Boat theBattleShip = new Boat();
        theBattleShip.setName("The Battle Ship");
        theBattleShip.setLength(5);
        coordinates = autoChooseTheFirstSquare(player, theBattleShip);
        if (theBattleShip.getShape().equals("Row")) {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[coordinates.row - 'a'][i + coordinates.column] = '5';
            }
        }
        else {
            for (int i = 0; i < theBattleShip.getLength(); ++i) {
                player.getMyBoard()[i + coordinates.row - 'a'][coordinates.column] = '5';
            }
        }
        displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_GREEN + "All boats have been commissioned. Ready for combat!" + ANSI_RESET);
    }
}