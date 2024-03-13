package blackjack.domain.state;

import blackjack.domain.card.Deck;

public class InitialState extends RunningState {
    private static final int INITIAL_DRAW_COUNT = 2;

    public InitialState() {
        super(new Hand());
    }

    @Override
    public State draw(Deck deck) {
        for (int i = 0; i < INITIAL_DRAW_COUNT; i++) {
            hand = hand.add(deck.draw());
        }

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
