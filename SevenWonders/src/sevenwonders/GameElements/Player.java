/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

import java.util.ArrayList;
/**
 *
 * @author jakot
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> built = new ArrayList<>();
    private WonderBoard wonderBoard = new WonderBoard();
    private int[] resources = {0,0,0,0,0,0,0,0};
    //{coins,wood,stone,bricks,ore,glass,papyrus,textile}
    private ArrayList<Integer[]> brownComp = new ArrayList<>(); //OR resources brown
    private ArrayList<Integer[]> yellowComp = new ArrayList<>(); //OR resources yellow
    private int bluePts = 0;
    private int[] tradingCosts = {2,2,2}; //0:leftBrown, 1:rightBrown 2:grey

    private int shields = 0;

    private int[] science = {0,0,0}; //compass, gear, tablet
    public Player(){
        this.addResource(0,3);
    }

    public void addResource(int resIdx, int amount){
        this.resources[resIdx] =+ amount;
    }

    public void addBrownComp(Integer[] comp){
        this.brownComp.add(comp);
    }
    public void addYellowComp(Integer[] comp){
        this.yellowComp.add(comp);
    }

    public void addBluePoints(int amount){
        this.bluePts += amount;
    }

    public void addShields(int amount){
        this.shields += amount;
    }
    //For trading posts and Marketplace
    //0:leftBrown, 1:rightBrown 2: grey
    public void lowerTradingCosts(int idx){
        this.tradingCosts[idx] = 1;
    }

    public void addScience(int idx){
        this.science[idx] += 1; //compass, gear, tablet
    }
}
