import java.util.Scanner;

public class PlayerFunction {
    Operation operation = new Operation();
    ClearScreen clearScreen = new ClearScreen();
    String tmp;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public void playerSetsUpTheBoat (Scanner sc, Player player) {
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Setting up " + ANSI_RESET + "The Patrol Boat 1" + ANSI_YELLOW + "..." + ANSI_RESET);
        Boat thePatrolBoat1 = new Boat();
        thePatrolBoat1.setName("The Patrol Boat 1");
        thePatrolBoat1.setLength(2);
        Coordinates coordinates;
        coordinates = operation.chooseTheFirstSquare(sc, player, thePatrolBoat1);
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
        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Patrol Boat 1" + ANSI_GREEN + " has been set up in " + ANSI_RESET + thePatrolBoat1.getShape() + ANSI_GREEN + " form <---" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
        tmp = sc.nextLine();
        clearScreen.clrscr();
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Setting up " + ANSI_RESET + "The Patrol Boat 2" + ANSI_YELLOW + "..." + ANSI_RESET);
        Boat thePatrolBoat2 = new Boat();
        thePatrolBoat2.setName("The Patrol Boat 2");
        thePatrolBoat2.setLength(2);
        coordinates = operation.chooseTheFirstSquare(sc, player, thePatrolBoat2);
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
        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Patrol Boat 2" + ANSI_GREEN + " has been set up in " + ANSI_RESET + thePatrolBoat2.getShape() + ANSI_GREEN + " form <---" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
        tmp = sc.nextLine();
        clearScreen.clrscr();
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Setting up " + ANSI_RESET + "The Destroyer Boat" + ANSI_YELLOW + "..." + ANSI_RESET);
        Boat theDestroyerBoat = new Boat();
        theDestroyerBoat.setName("The Destroyer Boat");
        theDestroyerBoat.setLength(4);
        coordinates = operation.chooseTheFirstSquare(sc, player, theDestroyerBoat);
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
        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Destroyer Boat" + ANSI_GREEN + " has been set up in " + ANSI_RESET + theDestroyerBoat.getShape() + ANSI_GREEN + " form <---" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
        tmp = sc.nextLine();
        clearScreen.clrscr();
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Setting up " + ANSI_RESET + "The Submarine" + ANSI_YELLOW + "..." + ANSI_RESET);
        Boat theSubmarine = new Boat();
        theSubmarine.setName("The Submarine");
        theSubmarine.setLength(3);
        coordinates = operation.chooseTheFirstSquare(sc, player, theSubmarine);
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
        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Submarine" + ANSI_GREEN + " has been set up in " + ANSI_RESET + theSubmarine.getShape() + ANSI_GREEN + " form <---" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
        tmp = sc.nextLine();
        clearScreen.clrscr();
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Setting up " + ANSI_RESET + "The Battle Ship" + ANSI_YELLOW + "..." + ANSI_RESET);
        Boat theBattleShip = new Boat();
        theBattleShip.setName("The Battle Ship");
        theBattleShip.setLength(5);
        coordinates = operation.chooseTheFirstSquare(sc, player, theBattleShip);
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
        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Battle Ship" + ANSI_GREEN + " has been set up in " + ANSI_RESET + theBattleShip.getShape() + ANSI_GREEN + " form. <---" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
        tmp = sc.nextLine();
        clearScreen.clrscr();
        operation.displayBoardOfPlayer(player);
        System.out.println();
        System.out.println(ANSI_GREEN + "All boats have been commissioned. Ready for combat!" + ANSI_RESET);
    }
    public boolean playerOpensFireAndCheck (Scanner sc, Player player, Player enemy) {
        System.out.println(ANSI_YELLOW + "Shooting..." + ANSI_RESET);
        System.out.println();
        boolean mark = false;
        String location;
        StringBuilder number;
        int count;
        int size = player.getBoardSize();
        Coordinates coordinates = new Coordinates();
        while (true) {
            operation.displayTheBoardOfEnemy(enemy);
            System.out.println();
            System.out.println(ANSI_GREEN + "Select a square to open fire: " + ANSI_RESET);
            location = sc.nextLine();
            coordinates.row = location.charAt(0);
            count = 1;
            number = new StringBuilder();
            while (count < location.length()) {
                number.append(location.charAt(count));
                ++count;
            }
            coordinates.column = Integer.parseInt(number.toString()) - 1;
            while (coordinates.row - 'a' >= size || coordinates.column >= size) {
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
            while (enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] > '5') {
                System.out.println(ANSI_RED + "This square has already been shot. Please choose another square!" + ANSI_RESET);
                location = sc.nextLine();
                coordinates.row = location.charAt(0);
                count = 1;
                number = new StringBuilder();
                while (count < location.length()) {
                    number.append(location.charAt(count));
                    ++count;
                }
                coordinates.column = Integer.parseInt(number.toString()) - 1;
                while (coordinates.row - 'a' >= size || coordinates.column >= size) {
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
            player.setTheNumberOfSquaresShot(player.getTheNumberOfSquaresShot() + 1);
            if (enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] == '0') {
                System.out.println();
                System.out.println("--> You " + ANSI_BLACK + ANSI_RED_BACKGROUND + "missed" + ANSI_RESET + " your shot <--");
                System.out.println();
                System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                tmp = sc.nextLine();
                clearScreen.clrscr();
                enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] = 'm';
                break;
            }
            else {
                System.out.println();
                System.out.println("--> You " + ANSI_GREEN_BACKGROUND + "scored" + ANSI_RESET + " a hit <--");
                System.out.println();
                System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                tmp = sc.nextLine();
                clearScreen.clrscr();
                char tmp1 = enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column];
                enemy.getMyBoard()[coordinates.row - 'a'][coordinates.column] = 'h';
                boolean mark1 = true;
                for (int i = 0; i < size; ++i) {
                    for (int j = 0; j < size; ++j) {
                        if (enemy.getMyBoard()[i][j] == tmp1) {
                            mark1 = false;
                            break;
                        }
                    }
                    if (!mark1) {
                        break;
                    }
                }
                if (mark1) {
                    enemy.setTheNumberOfMyRemainingBoats(enemy.getTheNumberOfMyRemainingBoats() - 1);
                    player.setTheNumberOfBoatsHit(player.getTheNumberOfBoatsHit() + 1);
                    if (tmp1 == '1') {
                        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Patrol Boat 1" + ANSI_GREEN + " has been destroyed! <---" + ANSI_RESET);
                    }
                    else if (tmp1 == '2') {
                        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Patrol Boat 2" + ANSI_GREEN + " has been destroyed! <---" + ANSI_RESET);
                    }
                    else if (tmp1 == '3') {
                        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Destroyed Boat" + ANSI_GREEN + " has been destroyed! <---" + ANSI_RESET);
                    }
                    else if (tmp1 == '4') {
                        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Submarine" + ANSI_GREEN + " has been destroyed! <---" + ANSI_RESET);
                    }
                    else {
                        System.out.println(ANSI_GREEN + "---> " + ANSI_RESET + "The Battle Ship" + ANSI_GREEN + " has been destroyed! <---" + ANSI_RESET);
                    }
                    System.out.println();
                    System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                    tmp = sc.nextLine();
                    clearScreen.clrscr();
                    if (enemy.getTheNumberOfMyRemainingBoats() == 0) {
                        mark = true;
                        break;
                    }
                }
            }
        }
        return mark;
    }
}
