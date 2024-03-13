package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;

public abstract class FinishedState extends State {
    protected FinishedState(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Deck deck) {
        throw new UnsupportedOperationException("이미 종료된 상태입니다.");
    }

    @Override
    public State stay() {
        throw new UnsupportedOperationException("이미 종료된 상태입니다.");
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
