package blackjack.domain.state;

import blackjack.domain.card.Deck;

public class HitState extends RunningState {
    public HitState(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Deck deck) {
        hand = hand.add(deck.draw());

        if (hand.isBust()) {
            return new BustState(hand);
        }

        return new HitState(hand);
    }

    @Override
    public State stay() {
        return new StandState(hand);
    }
}
