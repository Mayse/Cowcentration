package cowcentration.ui;

import cowcentration.gamelogic.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUi {

    public static void run() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Cowcentration");
        System.out.println("How many players?");

        List players = createPlayers(keyboard);

        System.out.println("how many card pairs?");
        int cardCount = Integer.parseInt(keyboard.nextLine());

        cowcentration.gamelogic.Game game = new Game(players, cardCount);

        System.out.println("game begins:");

        while (true) {
            System.out.println("current player: " + game.getCurrentPlayer());
            System.out.print("choose first card ");
            printAvailableCards(game);
            int first = Integer.parseInt(keyboard.nextLine());

            System.out.println("choose second card ");
            printAvailableCards(game);
            int second = Integer.parseInt(keyboard.nextLine());

            try {
                if (game.compareCards(first, second)) {
                    System.out.println("pair found");
                    game.removeCard(first);
                    game.removeCard(second);
                    game.addPoint();
                } else {
                    System.out.println("not a pair");
                    game.nextPlayer();
                }
            } catch (Exception e) {
                System.out.println("problematic!");
            }
            if (game.isOver()) {
                System.out.println("game is over final scores");
                printScore(game);
                break;
            }

        }
    }

    public static List createPlayers(Scanner lukija) {
        int playerCount = Integer.parseInt(lukija.nextLine());
        System.out.println("Naming players");
        List players = new ArrayList();
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            players.add(lukija.nextLine());
            System.out.println("");

        }
        return players;
    }

    private static void printAvailableCards(Game game) {
        List available = game.getAvailableCardIndexes();
        for (Object object : available) {
            System.out.print(object + " ");
        }
        System.out.println("");
    }

    private static void printScore(Game game) {
        for (String row : game.getScoreboard()) {
            System.out.println(row);
        }
    }
}
