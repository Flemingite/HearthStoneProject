package com.game;

import com.game.deck.Card;
import com.game.deck.Deck;
import com.game.heroes.Hero;
import com.game.heroes.Paladin;
import com.game.heroes.Warlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        int hpHero = 10;

        //Choix des paramètres du duel
            //Player 1 choice
        int input = Player.chooseClass(1);
        Hero hero1 = Hero.chooseHero(input, hpHero);
            //Player 2 choice
        input = Player.chooseClass(2);
        Hero hero2 = Hero.chooseHero(input, hpHero);

        //Create card
        Card gnome = new Card(1, "gnome", 1, 2);
        Card raptor = new Card(2,"Raptor",2,3);
        //Deck 1 and 2
        List<Card> c1 = new ArrayList<Card> ();
        for (int i=0;i<10;i++){
            c1.add(gnome);
        }
        List<Card> c2 = new ArrayList<Card> ();

        for (int i=0;i<10;i++){
            c2.add(raptor);
        }
        Deck deck1 = new Deck(c1);
        Deck deck2 = new Deck(c2);

        //Players creation
        Player player1 = new Player(deck1, hero1, null);
        Player player2 = new Player(deck2, hero2, null);
        //board creation : empty
        Board board = new Board(player1,player2);
        board.printBoard();


        //Initialisation
        //Le joueur 1 pioche 3 cartes
        board.getPlayer1().handInitialisation(3);
        //Le joueur 2 pioche 4 cartes
        board.getPlayer2().handInitialisation(4);

        //Déroulement du jeu

        while(board.getPlayer1().getHero().getHpNumber() !=0 && board.getPlayer2().getHero().getHpNumber() !=0) {
            if (Lap.lapNumber < 11) {
                Lap.lapNumber++;
            }
            System.out.println("________");
            System.out.println("|Tour " + Lap.lapNumber + "|");
            System.out.println("________");
            //Tour du joueur 1
            System.out.println("Tour du joueur1 avec " + Lap.lapNumber + " points d'action");
            board.getPlayer1().setActionPoints(Lap.lapNumber);
            board.getPlayer1().dropACard();
            board.getPlayer1().getHand().printHand(board.getPlayer1().getHand().getCards().size());

            int lapFinished = Lap.askLapFinished();
            while (lapFinished != 1 && board.getPlayer1().getHero().getHpNumber() !=0 && board.getPlayer2().getHero().getHpNumber() !=0) {
                Lap.doAnAction(board.getPlayer1(), board.getPlayer2(), board);
                board.printBoard();
                board.getPlayer1().getHand().printHand(board.getPlayer1().getHand().getCards().size());
                lapFinished = Lap.askLapFinished();
            }
        }
            //Tour du joueur 2

        //}


        //Hand hand1 = new Hand(deck1.getCards());

        //player1.setHand(hand1);

        /*
        board.getHero1().heroicPower(2, board, null, null, board.getHero1());
        board.addCardToBoard(gnome,paladin);
        board.printBoard();

        board.addCardToBoard(deck2.cards.get(1), board.getHero2());
        board.printBoard();
        */
    }
}
