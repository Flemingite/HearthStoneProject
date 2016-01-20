package com.game.heroes;

import com.game.Board;
import com.game.Player;

/**
 * Created by isen on 11/01/2016.
 */
public abstract class Hero {

    protected int hpNumber;
    protected String name;
    protected final int ACTIONPOINTSREQUIREDFORHEROICPOWER =2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHpNumber() {
        return hpNumber;
    }

    public void setHpNumber(int hpNumber) {
        this.hpNumber = hpNumber;
    }

    public int getACTIONPOINTSREQUIREDFORHEROICPOWER() {
        return ACTIONPOINTSREQUIREDFORHEROICPOWER;
    }

    public abstract void heroicPower(Player player, Player playerAttacked, Board board);

    public static Hero chooseHero(int input, int hpHero){
            Hero hero = null;
                switch (input) {
            case 1:
                hero = new Paladin(hpHero);
                break;
            case 2:
                hero = new Warlock(hpHero);
                break;
            default:
                break;
        }
        return hero;
    }
}
