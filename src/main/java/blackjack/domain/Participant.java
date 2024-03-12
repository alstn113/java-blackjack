package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.state.State;

public abstract class Participant {
    private final Name name;
    private State state;

    protected Participant(Name name, State state) {
        this.name = name;
        this.state = state;
    }

    public void draw(Card card) {
        state = state.draw(card);
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public String getName() {
        return name.getValue();
    }
}
