package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import java.util.List;

public abstract class State {
    protected Hand hand;

    protected State(Hand hand) {
        this.hand = hand;
    }

    public abstract State draw(Deck deck);

    public abstract State stay();

    public abstract boolean isFinished();

    public int calculateScore() {
        return hand.calculateScore();
    }

    public List<Card> getCards() {
        return hand.getCards();
    }
}
