package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.state.InitialState;
import java.util.List;

public class Dealer extends Participant {
    private static final String DEFAULT_NAME = "딜러";
    private static final int STAND_BOUND = 17;
    private static final int HIDDEN_CARD_COUNT = 1;

    public Dealer() {
        super(new Name(DEFAULT_NAME), new InitialState());
    }

    @Override
    public boolean canDraw() {
        return !isFinished() && calculateScore() < STAND_BOUND;
    }

    public List<Card> getVisibleCards() {
        List<Card> cards = getCards();

        return cards.subList(HIDDEN_CARD_COUNT, cards.size());
    }
}
