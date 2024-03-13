package blackjack.view;

import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.card.Card;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String DEALER_NAME = "딜러";

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }

    public void printInitialDraw(Dealer dealer, List<Player> players) {
        System.out.println();
        System.out.printf("%s와 %s에게 2장을 나누었습니다.%n", DEALER_NAME, buildPlayerNameMessage(players));

        printCards(DEALER_NAME, dealer.getVisibleCards());
        for (Player player : players) {
            printCards(player.getName(), player.getCards());
        }
    }

    private String buildPlayerNameMessage(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }

    public void printCards(String name, List<Card> cards) {
        System.out.printf("%s카드: %s%n", name, buildCardsMessage(cards));
    }

    private String buildCardsMessage(List<Card> cards) {
        return cards.stream()
                .map(Card::getName)
                .collect(Collectors.joining(", "));
    }

    public void printDealerHitMessage() {
        System.out.println();
        System.out.printf("%s는 16이하라 한장의 카드를 더 받았습니다.%n", DEALER_NAME);
    }

    public void printAllCardsWithScore(Dealer dealer, List<Player> players) {
        System.out.println();
        System.out.println(buildCardsWithScoreMessage(DEALER_NAME, dealer.getCards(), dealer.calculateScore()));
        for (Player player : players) {
            System.out.println(
                    buildCardsWithScoreMessage(player.getName(), player.getCards(), player.calculateScore()));
        }
    }

    private String buildCardsWithScoreMessage(String name, List<Card> cards, int score) {
        return String.format("%s카드: %s - 결과: %d",
                name,
                buildCardsMessage(cards),
                score);
    }
}
