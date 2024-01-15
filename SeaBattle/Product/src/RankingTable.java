import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankingTable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private ArrayList<Player> listOfWinner = new ArrayList<>();

    public void setListOfWinner(Player player) {
        this.listOfWinner.add(player);
    }
    public void displayList() {
        Collections.sort(listOfWinner, new Comparator<>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getTheNumberOfSquaresShot() - o2.getTheNumberOfSquaresShot();
            }
        });
        int maxLenName = "Name".length(), maxLenShot = "Shot".length(), maxLenBoat = "Remaining Boat".length();
        for (var i : listOfWinner) {
            if (maxLenName < i.getName().length()) {
                maxLenName = i.getName().length();
            }
            if (maxLenShot < (Integer.toString(i.getTheNumberOfSquaresShot())).length()) {
                maxLenShot = (Integer.toString(i.getTheNumberOfSquaresShot())).length();
            }
            if (maxLenBoat < (Integer.toString(i.getTheNumberOfMyRemainingBoats())).length()) {
                maxLenBoat = (Integer.toString(i.getTheNumberOfMyRemainingBoats())).length();
            }
        }
        int count = 14 + maxLenName + maxLenBoat + maxLenShot;
        for (int i = 0; i < listOfWinner.size(); ++i) {
            if (i == 0) {
                System.out.printf("%-" + 5 + "s" + " | " + "%-" + maxLenName + "s" + " | " + "%-" + maxLenShot + "s" + " | " + "%-" + maxLenBoat + "s%n", " " + ANSI_GREEN_BACKGROUND + "Rank" + ANSI_RESET, ANSI_GREEN_BACKGROUND + "Name" + ANSI_RESET, ANSI_GREEN_BACKGROUND + "Shot" + ANSI_RESET, ANSI_GREEN_BACKGROUND + "Remaining Boat" + ANSI_RESET);
                while (count-- >0) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.printf("%-" + 5 + "s" + " | " + "%-" + maxLenName + "s" + " | " + "%-" + maxLenShot + "s" + " | " + "%-" + maxLenBoat + "s%n", i+1, listOfWinner.get(i).getName(), listOfWinner.get(i).getTheNumberOfSquaresShot(), listOfWinner.get(i).getTheNumberOfMyRemainingBoats());
            while (count-- >0) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
