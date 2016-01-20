package com.game.heroes;

import com.game.Board;
import com.game.Hand;
import com.game.Player;
import com.game.deck.Card;
import com.game.deck.Deck;

/**
 * Created by isen on 11/01/2016.
 */
public class Warlock extends Hero {

    public Warlock(int hpNumber) {
        this.hpNumber = hpNumber;
        this.name = "Warlock";
    }

    @Override
    public void heroicPower(Player player, Player playerAttacked, Board board) {
        hpNumber =-1;
        player.dropACard();

    }
}
