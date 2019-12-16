package pl.michal;

import java.util.*;

public class Main {
    static double highestRankingEver = 0;
    static double lowestRankingEver = 100;

    public static void main(String[] args) {
        System.out.println("Zadanie 1 \"Highest rating\":");
        task1();
        System.out.println("\nZadanie 2 \"Minimum element (with reduce)\":");
        task2();
        System.out.println("\nZadanie 3 \"Flater list of lists\":");
        task3();
    }

    private static void task3() {
        Integer[] int1 = {1, 2, 3, 4, 5, 6};
        Integer[] int2 = {9, 8, 7, 6, 5, 4};
        List<Integer> innerList1 = new ArrayList<>();
        List<Integer> innerList2 = new ArrayList<>();
        List<List> outerList = new ArrayList<>();
        innerList1.addAll(Arrays.asList(int1));
        innerList2.addAll(Arrays.asList(int2));
        outerList.add(innerList1);
        outerList.add(innerList2);

        outerList.stream()
                .flatMap(g -> g.stream())
                .forEach(System.out::println);
    }

    private static void task2() {
        Optional<BoardGame> game = BoardGame.GAMES.stream()
                .reduce(Main::findLowest);

        System.out.println(game.get().name);
    }

    private static BoardGame findLowest(BoardGame game, BoardGame game1) {
        if (game1.rating < game.rating)
            return game1;
        else
            return game;
    }

    private static void task1() {

        System.out.println("Finding - old way:");
        findOldWay();

        System.out.println("Finding - stream way:");
        findStreamWay();

        System.out.println("Finding - samouczek way:");
        samouczkeVersion();
    }

    private static void samouczkeVersion() {
        String n=BoardGame.GAMES.stream()
                .filter(g->g.name.contains("a"))
                .max(Comparator.comparingDouble(g->g.rating))
                .get().name;

        System.out.println(n);
    }

    private static void findStreamWay() {
        BoardGame.GAMES.stream()
                .filter(g -> g.name.contains("a"))
                .filter(Main::findHighest)
                .filter(g -> g.rating == highestRankingEver)
                .forEach(g -> System.out.println(g.name));
    }

    private static boolean findHighest(BoardGame game) {
        if (game.rating > highestRankingEver) {
            highestRankingEver = game.rating;
            return true;
        }
        return false;
    }

    private static void findOldWay() {
        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.GAMES) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        if (bestGame != null) {
            System.out.println(bestGame.name);
        }
    }
}
