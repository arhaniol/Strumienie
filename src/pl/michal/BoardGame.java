package pl.michal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BoardGame {
    public final String name;
    public final double rating;
    public final BigDecimal price;
    public final int minPlayer;
    public final int maxPlayer;

    public BoardGame(String name, double rating, BigDecimal price, int minPlayer, int maxPlayer) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
    }

    public final static List<BoardGame> GAMES = Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    );

}
