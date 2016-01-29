package com.game.heroes;

import com.game.Board;
import com.game.Player;

import java.util.Scanner;

/**
 * Created by isen on 27/01/2016.
 */
public class Mage extends Hero{
    public Mage(int hpNumber) {
        this.hpNumber = hpNumber;
        this.name = "Mage";
    }
    @Override
    public void heroicPower(Player player, Player playerAttacked, Board board) {
        int otherHero;

        if (player.getHero() == board.getPlayer1().getHero()) {
            otherHero = 1;
        }
        else {
            otherHero = 0;
        }


        System.out.println("Que voulez vous attaquer ?");
        System.out.println("Attaquer le héros = 0");
        board.checkMonstersOnTheBoard(playerAttacked.getHero());
        Scanner sc = new Scanner(System.in);
        int monsterAttacked = sc.nextInt();
        if (monsterAttacked == 0) {
            playerAttacked.getHero().setHpNumber(getHpNumber()-1);
        }
        else {
            board.plateau[monsterAttacked-1][otherHero].setHealthPoints(board.plateau[monsterAttacked-1][otherHero].getHealthPoints()-1);
            if (board.plateau[monsterAttacked - 1][otherHero].getHealthPoints() <=0){
                board.removeCardToBoard(playerAttacked.getHero(),monsterAttacked-1);
            }
        }

    }
}
