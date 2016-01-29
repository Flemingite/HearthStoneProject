package com.game.heroes;

import com.game.Board;
import com.game.Player;
import com.game.deck.Card;

/**
 * Created by isen on 29/01/2016.
 */

public class Chaman extends Hero {
    public Chaman(int hpNumber) {
        this.hpNumber = hpNumber;
        this.name = "Chaman";
    }

    @Override
    public void heroicPower(Player player, Player playerattacked, Board board){
        Card totemDeSoins = new Card (1,"Totem de soins",1,0);
        Card totemIncendiaire = new Card (1,"Totem Incend",1,1);
        Card totemDeGriffeDePierre = new Card(1, "Totem Griffe",2,0);
        int r =(int)Math.random() % 3;
        switch (r){
            case 0:
                board.addCardToBoard(totemDeSoins, player.getHero());
                break;
            case 1:
                board.addCardToBoard(totemIncendiaire, player.getHero());
                break;
            case 2:
                board.addCardToBoard(totemDeGriffeDePierre, player.getHero());
                break;
        }
    }
}
