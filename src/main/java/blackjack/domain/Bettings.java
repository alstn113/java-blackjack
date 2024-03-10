package blackjack.domain;

import java.util.LinkedHashMap;
import java.util.Map;

class Bettings {

    private static final int BETTING_MONEY_UNIT = 1000;
    private static final int MIN_BETTING_MONEY = 1000;
    private static final int MAX_BETTING_MONEY = 10000;

    private final Map<Player, Money> bettings;

    public Bettings() {
        this.bettings = new LinkedHashMap<>();
    }

    public void placeBet(Player player, Money bettingMoney) {
        validateBettingMoney(bettingMoney);

        bettings.put(player, bettingMoney);
    }

    private void validateBettingMoney(Money bettingMoney) {
        validateBettingMoneyRange(bettingMoney.getValue());
        validateBettingMoneyUnit(bettingMoney.getValue());
    }

    private void validateBettingMoneyRange(int betting) {
        if (betting < MIN_BETTING_MONEY || betting > MAX_BETTING_MONEY) {
            String message = String.format("베팅 금액은 %d원 이상 %d원 이하여야 합니다.", MIN_BETTING_MONEY, MAX_BETTING_MONEY);

            throw new IllegalArgumentException(message);
        }
    }

    private void validateBettingMoneyUnit(int betting) {
        if (betting % BETTING_MONEY_UNIT != 0) {
            String message = String.format("베팅 금액은 %d원 단위여야 합니다.", BETTING_MONEY_UNIT);

            throw new IllegalArgumentException(message);
        }
    }

    public Money getBettingMoney(Player player) {
        return bettings.computeIfAbsent(player, k -> {
            throw new IllegalArgumentException("베팅 정보가 없습니다.");
        });
    }
}
