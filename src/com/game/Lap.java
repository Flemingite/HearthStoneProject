package com.game;

import com.game.heroes.Hero;

import java.util.Scanner;

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
        boolean placeOntheBoard = board.checkPlaceOnTheBoard(player.getHero());
        if (player.getActionPoints()>=player.getHand().getCards().get(input - 1).getActionPointsRequired()) {
            if (placeOntheBoard == true) {
                player.setActionPoints(player.getActionPoints() - player.getHand().getCards().get(input - 1).getActionPointsRequired());
                board.addCardToBoard(player.getHand().getCards().get(input - 1), player.getHero());
                player.getHand().removeCardToHand(player.getHand().getCards().get(input - 1));
            } else {
                System.out.println("Board plein, vous ne pouvez plus poser de créatures");
            }
        }
        else{
            System.out.println("Vous n'avez pas assez de points d'action");
        }
    }

    public  static void tryToUseHeroicPower(Player player, Player playerAttacked, Board board){
        if (player.getActionPoints()>=player.getHero().getACTIONPOINTSREQUIREDFORHEROICPOWER()){
            player.getHero().heroicPower(player, playerAttacked, board);
            player.setActionPoints(player.getActionPoints()-player.getHero().getACTIONPOINTSREQUIREDFORHEROICPOWER());
        }
        else{
            System.out.println("Vous n'avez pas assez de points d'action");
        }

    }

    public static void monsterAttack(Player player, Player playerAttacked, Board board){

        int heroChosen;
        int otherHero;
        if (player.getHero() == board.getPlayer1().getHero()) {
            heroChosen = 0;
            otherHero = 1;
        }
        else {
            heroChosen = 1;
            otherHero = 0;
        }
        System.out.println("Avec quelle créature voulez vous attaquer?");
        board.checkMonstersOnTheBoard(player.getHero());
        Scanner sc = new Scanner(System.in);
        int monsterAttack = sc.nextInt();
        if (board.plateau[monsterAttack-1][heroChosen].isCanAttack() == true && board.plateau[monsterAttack-1][heroChosen].getName() != null) {
            System.out.println("Que voulez vous attaquer?");
            System.out.println("Attaquer le héros   = 0");
            board.checkMonstersOnTheBoard(playerAttacked.getHero());
            Scanner sca = new Scanner(System.in);
            int monsterAttacked = sc.nextInt();
            if (monsterAttacked == 0) {
                board.plateau[monsterAttack - 1][heroChosen].cardAttacks(null, playerAttacked.getHero());
                board.plateau[monsterAttack - 1][heroChosen].setCanAttack(false);
            } else {
                board.plateau[monsterAttack - 1][heroChosen].cardAttacks(board.plateau[monsterAttacked - 1][otherHero], null);
                board.plateau[monsterAttack - 1][heroChosen].setCanAttack(false);
                if (board.plateau[monsterAttack - 1][heroChosen].getHealthPoints() <=0){
                    board.removeCardToBoard(player.getHero(),monsterAttack-1);
                }
                if (board.plateau[monsterAttacked - 1][otherHero].getHealthPoints() <=0){
                    board.removeCardToBoard(playerAttacked.getHero(),monsterAttacked-1);
                }
            }
        }
        else{
            System.out.println("Cette créature a déjà attaqué ou a été posée à ce tour\n");
        }
    }

    public static void doAnAction(Player player, Player playerAttacked, Board board){
        int input = 0;

        while (input!=1 && input != 2 && input !=3) {
            System.out.println("Quelle action voulez vous faire?");
            System.out.println("Poser une carte               = 1");
            System.out.println("Attaquer                      = 2");
            System.out.println("Faire le pouvoir héroïque     = 3");
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
            monsterAttack(player, playerAttacked,board);
        }
        if (input == 3){
            tryToUseHeroicPower(player, playerAttacked, board);
        }
    }

    public static void playerLap(Player player, Player playerAttacked, Board board){
        int heroChosen;

        if (player == board.getPlayer1()){
            heroChosen = 1;
        }
        else{
            heroChosen = 2;
        }
        System.out.println("________");
        System.out.println("|Tour " + Lap.lapNumber + "|");
        System.out.println("________");

        //Tour du joueur 1
        player.setActionPoints(Lap.lapNumber);
        player.dropACard();
        board.putCanAttackOfMonsterTrue(player.getHero());
        board.printBoard();
        player.getHand().printHand(player.getHand().getCards().size());
        System.out.println("Tour du joueur"+heroChosen+" avec " + player.getActionPoints() + " points d'action");

        int lapFinished = Lap.askLapFinished();
        while (lapFinished != 1 && playerAttacked.getHero().getHpNumber() !=0) {
            Lap.doAnAction(player, playerAttacked, board);
            board.printBoard();
            player.getHand().printHand(player.getHand().getCards().size());
            player.printActionPoints();
            lapFinished = Lap.askLapFinished();
        }
    }
}
