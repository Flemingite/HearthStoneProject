package com.game;

import com.game.deck.Card;

import com.game.Player;
import com.game.heroes.Hero;

public class Board {
    private Player player1;
    private Player player2;
    public Card plateau[][] = new Card[7][2];

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        Card empty = new Card();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                plateau[i][j] = empty;
            }
        }
    }

    public void printBoard() {

        //Hero1 Characteristics
        System.out.println(player1.getHero().getName() + " " + player1.getHero().getHpNumber() + " hp");

        //Print the first part of the board
        for (int i = 0; i < 121; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.print("|");
        System.out.print("|");
        for (int i = 0; i < 7; i++) {
            plateau[i][0].printActionPointsRequired();
            System.out.print("||");
        }
        System.out.println("");
        System.out.print("||");
        for (int i = 0; i < 7; i++) {
            plateau[i][0].printName();
            System.out.print("||");
        }
        System.out.println("");
        System.out.print("|");
        System.out.print("|");
        for (int i = 0; i < 7; i++) {
            plateau[i][0].printAttackAndHealthPoints();
            System.out.print("||");
        }
        System.out.println("");
        for (int i = 0; i < 121; i++) {
            System.out.print("_");
        }

        //Print the second part of the board
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 121; i++) {
            System.out.print("_");
        }
        System.out.println("");
        System.out.print("|");
        System.out.print("|");
        for (int i = 0; i < 7; i++) {
            plateau[i][1].printActionPointsRequired();
            System.out.print("||");
        }
        System.out.println("");
        System.out.print("|");
        System.out.print("|");
        for (int i = 0; i < 7; i++) {
            plateau[i][1].printName();
            System.out.print("||");
        }
        System.out.println("");
        System.out.print("|");
        System.out.print("|");
        for (int i = 0; i < 7; i++) {
            plateau[i][1].printAttackAndHealthPoints();
            System.out.print("||");
        }
        System.out.println("");
        for (int i = 0; i < 121; i++) {
            System.out.print("_");
        }
        System.out.println("");

        //Hero1 Characteristics
        System.out.println(player2.getHero().getName() + " " + player2.getHero().getHpNumber() + " hp");
        System.out.println("");
    }

    public void addCardToBoard(Card c, Hero hero) {
        int i = 0;
        int heroChosen;
        if (hero == player1.getHero()) {
            heroChosen = 0;
        }
        else {
            heroChosen = 1;
        }
        while ((i < 7) && (plateau[i][heroChosen].getName() != "")) {
            if (plateau[i][heroChosen].getName() == null) {
                plateau[i][heroChosen] = c;
                return;
            }
            i++;
            }
            System.out.println("Board plein, vous ne pouvez plus poser de créatures");
    }

    public void checkMonstersOnTheBoard(Hero hero) {
        int i = 0;
        int heroChosen;
        if (hero == player1.getHero()){
            heroChosen = 0;
        }
        else{
            heroChosen = 1;
        }
        while ((i < 7)) {
            if (plateau[i][heroChosen].getName() != null) {
                System.out.println("Monstre "+(i+1)+ " : "+plateau[i][heroChosen].getName()+" = "+(i+1));
            }
            i++;
        }
    }

    public void putCanAttackOfMonsterTrue(Hero hero){
        int i = 0;
        int heroChosen;
        if (hero == getPlayer1().getHero()){
            heroChosen = 0;
        }
        else{
            heroChosen = 1;
        }
        while ((i < 7)) {
            if (plateau[i][heroChosen].getName() != null) {
                plateau[i][heroChosen].setCanAttack(true);
            }
            i++;
        }
    }

    public boolean checkPlaceOnTheBoard(Hero hero) {
        int i = 0;
        int heroChosen;

        if (hero == player1.getHero()) {
            heroChosen = 0;
        }
        else {
            heroChosen = 1;
        }
        while ((i < 7) && (plateau[i][heroChosen].getName() != "")){

            if (plateau[i][heroChosen].getName() == null) {
                    return true;
            }
            i++;
        }
        return false;
    }

    public void attackGestion(){

    }
}

