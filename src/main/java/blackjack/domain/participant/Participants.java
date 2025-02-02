package blackjack.domain.participant;

import blackjack.domain.card.Deck;
import java.util.List;

public class Participants {

    private static final int INITIAL_DRAW_COUNT = 2;

    private final Dealer dealer = new Dealer();
    private final List<Player> players;

    public Participants(List<String> playerNames) {
        validate(playerNames);

        this.players = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> playerNames) {
        validatePlayerSize(playerNames);
        validateDuplicatedPlayerNames(playerNames);
        validateInvalidPlayerName(playerNames, dealer.getName());
    }

    private void validatePlayerSize(List<String> playerNames) {
        if (playerNames.isEmpty()) {
            throw new IllegalArgumentException("플레이어가 존재하지 않습니다.");
        }
    }

    private void validateDuplicatedPlayerNames(List<String> playerNames) {
        if (getUniqueSize(playerNames) != playerNames.size()) {
            throw new IllegalArgumentException("플레이어 이름이 중복되었습니다.");
        }
    }

    private long getUniqueSize(List<String> playerNames) {
        return playerNames.stream()
                .distinct()
                .count();
    }

    private void validateInvalidPlayerName(List<String> playerNames, String dealerName) {
        if (playerNames.contains(dealerName)) {
            throw new IllegalArgumentException(String.format("플레이어 이름은 '%s'가 될 수 없습니다.", dealerName));
        }
    }

    public void drawInitialCards(Deck deck) {
        drawInitialCardForParticipant(deck, dealer);
        players.forEach(player -> drawInitialCardForParticipant(deck, player));
    }

    private void drawInitialCardForParticipant(Deck deck, Participant participant) {
        for (int i = 0; i < INITIAL_DRAW_COUNT; i++) {
            participant.hit(deck.draw());
        }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
