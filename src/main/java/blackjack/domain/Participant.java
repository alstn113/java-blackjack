package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.state.State;
import java.util.List;

public abstract class Participant {
    private final Name name;
    private State state;

    protected Participant(Name name, State state) {
        this.name = name;
        this.state = state;
    }

    public void draw(Deck deck) {
        if (!canDraw()) {
            state.stay();
        }
        state = state.draw(deck);
    }

    public abstract boolean canDraw();

    public void stay() {
        state = state.stay();
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public String getName() {
        return name.getValue();
    }

    public int calculateScore() {
        return state.calculateScore();
    }

    public List<Card> getCards() {
        return state.getCards();
    }
}
