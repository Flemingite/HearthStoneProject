package com.game;
import com.game.deck.Card;
import com.game.deck.Deck;
import com.game.heroes.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Deck deck;
    private Hero hero;
    private Hand hand;
    private int actionPoints = 0;

    public Player(Deck deck, Hero hero, Hand hand) {
        this.deck = deck;
        this.hero = hero;
        this.hand = hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public static int chooseClass(int playerNumber) {
        int input = 0;
        while ((input != 1) && (input != 2)) {
            System.out.println("Classe joueur "+playerNumber+"?");
            System.out.println("Paladin      = 1");
            System.out.println("Warlock      = 2");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            if ((input != 1) && (input != 2)) {
                System.out.println("Mauvaise commande");
            }
        }
        return input;
    }

    public void handInitialisation(int cardsNumber) {
        List<Card> cards = new ArrayList<Card> ();
        for (int i = 0; i < cardsNumber; i++) {
            int oneCard = (int) (Math.random() * (deck.getCards().size()));
            cards.add(deck.getCards().get(oneCard));
            deck.removeCardToDeck(deck.getCards().get(oneCard));
        }
        Hand hand = new Hand(cards);
        this.hand = hand;
    }

    public void dropACard(){
        int cardsNumber = deck.getCards().size();
        int oneCard = (int)(Math.random() * (cardsNumber));

        int cardsIntheHand = hand.getCards().size();
        if(cardsIntheHand < 10 && deck.getCards().size() != 0) {
            hand.addCardToHand(deck.getCards().get(oneCard));
            deck.removeCardToDeck(deck.getCards().get(oneCard));
        }
        else{
            if (deck.getCards().size() == 0){
                System.out.println("Votre deck est vide");
            }
            else {
                System.out.println("Trop de cartes en main, la carte est détruite");
                deck.removeCardToDeck(deck.getCards().get(oneCard));
            }
        }
    }

    public void printActionPoints(){

        System.out.println("\nIl vous reste "+actionPoints+" points d'action\n");
    }
}

