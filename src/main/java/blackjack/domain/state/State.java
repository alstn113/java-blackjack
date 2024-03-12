package blackjack.domain.state;

import blackjack.domain.card.Card;

public abstract class State {
    protected Hand hand;

    protected State(Hand hand) {
        this.hand = hand;
    }

    public abstract State draw(Card cad);

    public abstract State stay();

    public abstract boolean isFinished();
}
