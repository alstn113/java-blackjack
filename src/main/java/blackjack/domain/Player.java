package blackjack.domain;

import blackjack.domain.state.InitialState;

public class Player extends Participant {
    private static final int BLACKJACK_SCORE = 21;

    public Player(String name) {
        super(new Name(name), new InitialState());
    }

    @Override
    public boolean canDraw() {
        return !isFinished() && calculateScore() < BLACKJACK_SCORE;
    }
}
