package com.game.heroes;

import com.game.Board;
import com.game.Player;

/**
 * Created by isen on 29/01/2016.
 */

    public class Priest extends Hero{

        public Priest (int hpNumber) {
            this.hpNumber = hpNumber;
            this.name = "Priest";
        }
        @Override
        public void heroicPower(Player player, Player playerAttacked, Board board) {
            player.getHero().setHpNumber(getHpNumber()+2);
        }

    }
