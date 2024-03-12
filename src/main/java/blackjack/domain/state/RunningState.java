package blackjack.domain.state;

public abstract class RunningState extends State {
    protected RunningState(Hand hand) {
        super(hand);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
