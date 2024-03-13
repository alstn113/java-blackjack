package blackjack.domain.card;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Deck {
    private final Queue<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = new ArrayDeque<>(cards);
    }

    public static Deck createShuffledDeck() {
        List<Card> cards = Card.getCards();

        Collections.shuffle(cards);

        return new Deck(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("더 이상 카드를 뽑을 수 없습니다.");
        }
        return cards.poll();
    }
}
