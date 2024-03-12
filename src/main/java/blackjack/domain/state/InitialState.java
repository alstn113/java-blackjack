package blackjack.domain.state;

import blackjack.domain.card.Card;

public class InitialState extends State {
    public InitialState(Hand hand) {
        super(hand);
    }

    @Override
    public State draw(Card cad) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
