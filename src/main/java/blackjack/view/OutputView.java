package blackjack.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR]";

    public void printErrorMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
