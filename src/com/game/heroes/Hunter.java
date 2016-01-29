package com.game.heroes;

import com.game.Board;
import com.game.Player;
import com.game.deck.Card;

/**
 * Created by isen on 27/01/2016.
 */
public class Hunter extends Hero{

    public Hunter(int hpNumber) {
        this.hpNumber = hpNumber;
        this.name = "Hunter";
    }
    @Override
    public void heroicPower(Player player, Player playerAttacked, Board board) {
        playerAttacked.getHero().setHpNumber(getHpNumber()-2);
    }
}
