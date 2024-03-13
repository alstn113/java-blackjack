package blackjack.domain;

import blackjack.domain.card.Deck;
import java.util.HashSet;
import java.util.List;

public class Players {
    private final List<Player> value;

    public Players(List<String> playerNames) {
        validate(playerNames);

        this.value = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    private void validate(List<String> playerNames) {
        validatePlayersSize(playerNames);
        validateDuplicatePlayerName(playerNames);
    }

    private void validatePlayersSize(List<String> playerNames) {
        if (playerNames.isEmpty()) {
            throw new IllegalArgumentException("플레이어는 최소 한 명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatePlayerName(List<String> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("중복된 플레이어 이름이 있습니다.");
        }
    }

    public void draw(Deck deck) {
        value.forEach(player -> player.draw(deck));
    }

    public List<Player> getValue() {
        return value;
    }
}
