package blackjack.domain.state;

import blackjack.domain.card.Deck;

public class InitialState extends RunningState {
    public InitialState() {
        super(new Hand());
    }

    @Override
    public State draw(Deck deck) {
        hand = hand.add(deck.draw());
        hand = hand.add(deck.draw());

        if (hand.isBlackjack()) {
            return new BlackjackState(hand);
        }

        return new HitState(hand);
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException("초기 상태에서는 stay 할 수 없습니다.");
    }
}
