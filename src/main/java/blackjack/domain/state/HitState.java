package blackjack.domain.state;

import blackjack.domain.card.Card;

public class HitState extends RunningState {
    public HitState(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Card card) {
        hand = hand.add(card);

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
