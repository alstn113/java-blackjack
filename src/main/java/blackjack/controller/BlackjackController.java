package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.domain.card.Deck;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {
    private final InputView inputView;
    private final OutputView outputView;

    public BlackjackController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = new Players(inputView.readPlayerNames());
        Dealer dealer = new Dealer();
        Deck deck = Deck.createShuffledDeck();

        initialDraw(players, dealer, deck);
        playersTurn(players, deck);
    }

    private void initialDraw(Players players, Dealer dealer, Deck deck) {
        players.draw(deck);
        dealer.draw(deck);

        outputView.printInitialDraw(dealer, players.getValue());
    }

    private void playersTurn(Players players, Deck deck) {
        players.getValue().forEach(player -> playerTurn(player, deck));
    }

    private void playerTurn(Player player, Deck deck) {
        while (player.canDraw()) {
            playerAction(player, deck);
        }

        outputView.printCards(player.getName(), player.getCards());
    }

    private void playerAction(Player player, Deck deck) {
        boolean wannaHit = inputView.readWantToDrawOneMoreCard(player.getName());

        if (wannaHit) {
            player.draw(deck);
            return;
        }

        player.stay();
    }
}
