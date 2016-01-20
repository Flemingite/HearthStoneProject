package com.game.deck;

import com.game.heroes.Hero;

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
            healthPoints =-card.getAttack();
        }
    }
    @Override
    public void specialEffect() {

    }
}
