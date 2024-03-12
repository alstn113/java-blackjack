package blackjack.domain;

import blackjack.domain.state.Hand;
import blackjack.domain.state.InitialState;

public class Dealer extends Participant {
    private static final String DEALER_NAME = "딜러";
    private static final int DEALER_DRAW_THRESHOLD = 16;

    public Dealer(Hand hand) {
        super(new Name(DEALER_NAME), new InitialState(hand));
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
