import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp;
        ClearScreen clearScreen = new ClearScreen();
        Operation operation = new Operation();
        RankingTable rankingTable = new RankingTable();
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_CYAN = "\u001B[36m";
        while (true) {
            operation.displayMenu();
            System.out.println(ANSI_GREEN + "--> Enter your choice:" + ANSI_RESET);
            int option = Integer.parseInt(sc.nextLine());
            clearScreen.clrscr();
            if (option == 1) {
                System.out.println(ANSI_GREEN + "Enter the board's size (10 -> 20):" + ANSI_RESET);
                int size = Integer.parseInt(sc.nextLine());
                clearScreen.clrscr();
                Player player1 = new Player();
                Player player2 = new Player();
                player1.setBoardSize(size);
                player2.setBoardSize(size);
                player1.setMyBoard();
                player2.setMyBoard();
                System.out.println(ANSI_GREEN + "Enter Player 1's name: " + ANSI_RESET);
                player1.setName(sc.nextLine());
                System.out.println(ANSI_GREEN + "Enter Player 2's name: " + ANSI_RESET);
                player2.setName(sc.nextLine());
                clearScreen.clrscr();
                operation.displaySetUpOptions(player1);
                System.out.println(ANSI_GREEN + "-> Enter your choice:" + ANSI_RESET);
                int option1 = Integer.parseInt(sc.nextLine());
                clearScreen.clrscr();
                if (option1 == 1) {
                    player1.setUpBoats(sc);
                }
                else if (option1 == 2) {
                    operation.autoSetUpTheBoat(player1);
                }
                else {
                    System.out.println(ANSI_RED + "----> GOODBYE!!! <----" + ANSI_RESET);
                    break;
                }
                System.out.println();
                System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                tmp = sc.nextLine();
                clearScreen.clrscr();
                operation.displaySetUpOptions(player2);
                System.out.println(ANSI_GREEN + "-> Enter your choice:" + ANSI_RESET);
                option1 = Integer.parseInt(sc.nextLine());
                clearScreen.clrscr();
                if (option1 == 1) {
                    player2.setUpBoats(sc);
                }
                else if (option1 == 2) {
                    operation.autoSetUpTheBoat(player2);
                }
                else {
                    System.out.println(ANSI_RED + "----> GOODBYE!!! <----" + ANSI_RESET);
                    break;
                }
                System.out.println();
                System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                tmp = sc.nextLine();
                clearScreen.clrscr();
                Player activePlayer = player1;
                Player enemy = player2;
                while (true) {
                    System.out.println(ANSI_GREEN + "*** " + ANSI_RESET + activePlayer.getName() + ANSI_GREEN + "'s turn! ***" + ANSI_RESET);
                    System.out.println();
                    operation.displayCurrentStatus(activePlayer);
                    System.out.println();
                    operation.displayPlayerOptions();
                    System.out.println(ANSI_GREEN + "--> Enter your choice:" + ANSI_RESET);
                    int option2 = Integer.parseInt(sc.nextLine());
                    clearScreen.clrscr();
                    if (option2 == 1) {
                        operation.displayBoardOfPlayer(activePlayer);
                        System.out.println();
                        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                        tmp = sc.nextLine();
                        clearScreen.clrscr();
                        continue;
                    }
                    else if (option2 == 2) {
                        boolean check;
                        check = activePlayer.openFireAndCheck (sc, enemy);
                        if (check) {
                            operation.displayTheResults(player1, player2);
                            System.out.println();
                            System.out.println(ANSI_RED + "----> | " + ANSI_GREEN + activePlayer.getName() + ANSI_RED + " is the WINNER!!! | <----" + ANSI_RESET);
                            rankingTable.setListOfWinner(activePlayer);
                            System.out.println();
                            System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                            tmp = sc.nextLine();
                            clearScreen.clrscr();
                            break;
                        }
                    }
                    else {
                        System.out.println(ANSI_RED + "----> END GAME!!! <----" + ANSI_RED);
                        System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                        tmp = sc.nextLine();
                        clearScreen.clrscr();
                        break;
                    }
                    if (activePlayer == player1) {
                        activePlayer = player2;
                        enemy = player1;
                    }
                    else {
                        activePlayer = player1;
                        enemy = player2;
                    }
                }
            }
            else if (option == 2) {
                rankingTable.displayList();
                System.out.print(ANSI_CYAN + "Press Enter to continue..." + ANSI_RESET);
                tmp = sc.nextLine();
                clearScreen.clrscr();
            }
            else {
                System.out.println(ANSI_RED + "----> GOODBYE!!! <----" + ANSI_RESET);
                break;
            }
        }
    }
}