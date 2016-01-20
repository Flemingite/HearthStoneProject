package com.game.heroes;

import com.game.Board;
import com.game.Hand;
import com.game.Player;
import com.game.deck.Card;
import com.game.deck.Deck;

/**
 * Created by isen on 11/01/2016.
 */
public class Paladin extends Hero {


    public Paladin(int hpNumber) {
        this.hpNumber = hpNumber;
        this.name = "Paladin";
    }
    @Override
    public void heroicPower(Player player, Player playerAttacked, Board board) {

        Card recrue = new Card (1,"Recrue",1,1);
        board.addCardToBoard(recrue, player.getHero());


    }
}
