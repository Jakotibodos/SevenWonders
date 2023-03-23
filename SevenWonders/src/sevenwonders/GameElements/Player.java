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
    private final int pid;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> built = new ArrayList<>();
    private int[] builtCardsByColor = {0,0,0,0,0,0,0};
    private WonderBoard wonderBoard = new WonderBoard();
    private int[] resources = {0,0,0,0,0,0,0,0};
    //{coins,wood,stone,bricks,ore,glass,papyrus,textile}
    private ArrayList<Integer[]> brownComp = new ArrayList<>(); //OR resources brown
    private ArrayList<Integer[]> yellowComp = new ArrayList<>(); //OR resources yellow
    private int bluePts = 0;
    private int yellowPts = 0;
    private int redPts = 0;
    private int greenPts = 0;
    private int purplePts = 0;
    
    private int[] tradingCosts = {2,2,2}; //0:leftBrown, 1:rightBrown 2:grey
    private int shields = 0;
    private int minusWarTokens = 0;
    
    private int[] science = {0,0,0,0}; //compass, gear, tablet, extra
    private boolean isBot;
    private ArrayList<CardEffect> conditionnalPointsUpdate = new ArrayList<>();
    
    private Player leftPlayer;
    private Player rightPlayer;
    
    
    public Player(int id, boolean isBot){
        this.addResource(0,3);
        this.pid = id;
        this.isBot = isBot;
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
    
    public void addYellowPoints(int amount){
        this.yellowPts += amount;
    }
    
    public void addRedPoints(int amount){
        this.redPts += amount;
    }
    
    public void addGreenPoints(int amount){
        this.greenPts += amount;
    }
    
    public void addPurplePoints(int amount){
        this.purplePts += amount;
    }

    public void addShields(int amount){
        this.shields += amount;
    }
    
    public void addminusToken(){
        this.minusWarTokens++;
    }
    //For trading posts and Marketplace
    //0:leftBrown, 1:rightBrown 2: grey
    public void lowerTradingCosts(int idx){
        this.tradingCosts[idx] = 1;
    }

    public void addScience(int idx){
        this.science[idx] += 1; //compass, gear, tablet
    }
    
    public void addCountColor(int colorIndex){
        this.builtCardsByColor[colorIndex]++;
    }
    
    public int getCountColor(int colorIndex){
        return this.builtCardsByColor[colorIndex];
    }
    
    public void printResources(){
        for(int resource : this.resources)
            System.out.print(String.valueOf(resource)+" ");
    }
    
    public WonderBoard getWonderBoard(){
        return this.wonderBoard;
    }
    
    public int getNumberMinusTokens(){
        return this.minusWarTokens;
    }
    
    public void setLeftPlayer(Player p){
        this.leftPlayer = p;
    }
    public void setRightPlayer(Player p){
        this.rightPlayer = p;
    }
    public Player getLeftPlayer(){
        return this.leftPlayer;
    }
    
    public Player getRightPlayer(){
        return this.rightPlayer;
    }
    
    public void addConditionalPointsToUpdate(CardEffect effect){
        this.conditionnalPointsUpdate.add(effect);
    }
    
    public int calcGreenPts(){
        return 0;
    }
    
    public void updateConditionalPoints(int age){
        this.greenPts = this.calcGreenPts();
        
        if (age == 3){
            this.yellowPts = 0;
            this.purplePts = 0;
            this.conditionnalPointsUpdate.forEach(effect -> {
                effect.apply(this);
            });
            
        }
    }
    
    public void printPoints(){
        System.out.println("Blue pts: "+String.valueOf(this.bluePts));
        System.out.println("Yellow pts: "+String.valueOf(this.yellowPts));
        System.out.println("Red pts: "+String.valueOf(this.redPts));
        System.out.println("Green pts: "+String.valueOf(this.greenPts));
        System.out.println("Purple pts: "+String.valueOf(this.purplePts));
    }
    
}
