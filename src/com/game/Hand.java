package com.game;

import com.game.deck.Card;

import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCardToHand(Card c){
        cards.add(c);
    }

    public void removeCardToHand(Card c){
        cards.remove(c);
    }

    public void printHand(int cardsNumber) {
        if (cards.size() == 0) {
            System.out.println("Votre main est vide");
        } else {
            System.out.println("Votre main :");
            System.out.print("|");
            for (int i = 0; i < cardsNumber - 1; i++) {
                cards.get(i).printActionPointsRequired();
                System.out.print("||");
            }
            cards.get(cardsNumber - 1).printActionPointsRequired();
            System.out.print("|");
            System.out.println("");
            System.out.print("|");
            for (int i = 0; i < cardsNumber - 1; i++) {
                cards.get(i).printName();
                System.out.print("||");
            }
            cards.get(cardsNumber - 1).printName();
            System.out.print("|");
            System.out.println("");
            System.out.print("|");
            for (int i = 0; i < cardsNumber - 1; i++) {
                cards.get(i).printCanAttack();
                System.out.print("||");
            }
            cards.get(cardsNumber - 1).printCanAttack();
            System.out.print("|");
            System.out.println("");
            System.out.print("|");
            for (int i = 0; i < cardsNumber - 1; i++) {
                cards.get(i).printAttackAndHealthPoints();
                System.out.print("||");
            }
            cards.get(cardsNumber - 1).printAttackAndHealthPoints();
            System.out.print("|");
            System.out.println("");
        }
    }
}
