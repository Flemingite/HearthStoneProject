package com.game.deck;

import com.game.heroes.Hero;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Card implements CardCharacteristics {

    private int actionPointsRequired;
    private int attack;
    private int healthPoints;
    private String name;
    private boolean canAttack = false;

    public Card() {
    }

    public Card(int actionPointsRequired, String name, int healthPoints, int attack) {
        this.actionPointsRequired = actionPointsRequired;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attack = attack;
    }

    public static List<Card> loadCard() throws IOException {
        InputStream file = new FileInputStream("cardList.txt");
        InputStreamReader ipsr = new InputStreamReader(file);
        BufferedReader br = new BufferedReader(ipsr);
        List<Card> cardList = new ArrayList<>();
        String line;
        char carac =' ';

        while ((line = br.readLine()) != null) {
            int i = 0;
            carac = ' ';
            Card newCard = new Card();
            int checkAp = 0, checkName = 0, checkHp=0, checkAtp = 0;
            while(carac != ','){
                carac = line.charAt(i);
                i++;
                checkAp = i;
            }

            String actionPoint = line.substring(0, checkAp-1);
            int val = Integer.parseInt(actionPoint);
            newCard.actionPointsRequired = val;

            carac= line.charAt(checkAp);

            while(carac != ','){
                carac = line.charAt(i);
                i++;
                checkName = i;
            }

            String name = line.substring(checkAp,checkName-1);
            newCard.name = name;

            carac= line.charAt(checkName);

            while(carac != ','){
                carac = line.charAt(i);
                i++;
                checkHp = i;
            }

            String Hp = line.substring(checkName, checkHp-1);
            val = Integer.parseInt(Hp);
            newCard.healthPoints = val;

            carac= line.charAt(checkHp);

            while(carac != ','){
                carac = line.charAt(i);
                i++;
                checkAtp = i;
            }

            String Atp = line.substring(checkHp,checkAtp-1);
            val = Integer.parseInt(Atp);
            newCard.attack = val;


            cardList.add(newCard);

        }

        return cardList;

    }

    public int getActionPointsRequired() {
        return actionPointsRequired;
    }

    public void setActionPointsRequired(int actionPointsRequired) {
        this.actionPointsRequired = actionPointsRequired;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

    public void printActionPointsRequired(){
        System.out.printf("%-15d",actionPointsRequired);
    }

    public void printName(){
        System.out.printf("%-15s",name);
    }
    public void printCanAttack(){
        System.out.printf("%-15s",canAttack);
    }

    public void printAttackAndHealthPoints(){
        System.out.print(attack+"             "+healthPoints);
    }


    public void printCard(){
        System.out.print("|");
        printActionPointsRequired();
    }

    public void cardAttacks(Card card, Hero hero){
        if (card == null){
            hero.setHpNumber(hero.getHpNumber()-attack);
        }
        else{
            card.setHealthPoints(card.getHealthPoints()-attack);
            healthPoints -=card.getAttack();
        }
    }

    @Override
    public void battleCry() {

    }

    @Override
    public void enrage() {

    }

    @Override
    public void charge() {

    }

    @Override
    public void deathRattle() {

    }
}
