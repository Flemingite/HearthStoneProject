package com.game;

import com.game.deck.Card;
import com.game.heroes.Hero;

import java.util.Scanner;

/**
 * Created by isen on 13/01/2016.
 */
public class Lap {
    public static int lapNumber = 0;

    public static int askLapFinished() {
        int lapFinished;
        do {
            System.out.println("Avez vous fini votre tour?");
            System.out.println("Non     = 0");
            System.out.println("Oui     = 1");
            Scanner sc = new Scanner(System.in);
            lapFinished = sc.nextInt();
            if ((lapFinished != 0) && (lapFinished != 1)) {
                System.out.println("Mauvaise commande");
            }
        }
        while (lapFinished != 1 && lapFinished != 0);
        return lapFinished;
    }
    public static void putAMonster(Player player, Board board){
        System.out.println("Quelle carte voulez vous poser?");
        for (int i=0;i<player.getHand().getCards().size();i++){
            System.out.println("Carte "+(i+1)+": "+player.getHand().getCards().get(i).getName()+ " = "+(i+1));
        }
        int input = 0;
        while ( input > player.getHand().getCards().size() || input == 0) {
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            if (input > player.getHand().getCards().size() || input == 0) {
                System.out.println("Mauvaise commande");
            }
        }
        // if (player.getActionPoints() >= player.getHand().getCards().get(input-1).getActionPointsRequired()) {
        int placeOntheBoard = board.checkPlaceOnTheBoard(player.getHero());
        if (placeOntheBoard == 1) {
            board.addCardToBoard(player.getHand().getCards().get(input - 1), player.getHero());
            player.getHand().removeCardToHand(player.getHand().getCards().get(input - 1));
            player.setActionPoints(player.getActionPoints()-player.getHand().getCards().get(input - 1).getActionPointsRequired());
        } else {
            System.out.println("Board plein, vous ne pouvez plus poser de créatures");
        }
        //}
            /*
            else{
                System.out.println("Vous n'avez pas assez de points d'action");
            }
            */
    }


    public static void doAnAction(Player player, Player playerAttacked, Board board){
        int input = 0;

        while (input!=1 && input != 2) {
            System.out.println("Quelle action voulez vous faire?");
            System.out.println("Poser une carte      = 1");
            System.out.println("Attaquer             = 2");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();
            if (input != 1 && input !=2) {
                System.out.println("Mauvaise commande");
            }
        }
        if (input ==1){
            putAMonster(player, board);
        }
        if (input == 2){
            System.out.println("Avec quelle créature voulez vous attaquer?");
            board.checkMonstersOnTheBoard(player.getHero());
            Scanner sc = new Scanner(System.in);
            int monsterAttack = sc.nextInt();
            //On a choisi quelle crea va attaquer, maintenant il faut le faire =)
            System.out.println("Que voulez vous attaquer?");
            System.out.println("Attaquer le héros   = 0");
            board.checkMonstersOnTheBoard(playerAttacked.getHero());
            Scanner sca = new Scanner(System.in);
            int monsterAttacked = sc.nextInt();
            if (monsterAttacked ==0){
                board.plateau[monsterAttack-1][0].cardAttacks(null,playerAttacked.getHero());
            }

        }
    }

    public static void playerLap(Player player, Board board, int lapNumber){

    }
}
