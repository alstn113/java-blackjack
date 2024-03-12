package blackjack.domain.state;

import blackjack.domain.card.Card;

public abstract class FinishedState extends State {
    protected FinishedState(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Card card) {
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
