/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

import java.util.ArrayList;
/*
 * @author jakot
 */
public class Player {
    private final int pid;
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Integer> built = new ArrayList<>(); //used for free cards in other ages
    private int[] builtCardsByColor = {0,0,0,0,0,0,0,0}; 
    //Brown, Grey, blue, yellow, red, green, purple, wonder
    private WonderBoard wonderBoard; //TODO
    private int[] resources = {0,0,0,0,0,0,0,0};
    //{coins,wood,stone,bricks,ore,glass,papyrus,textile}
    private ArrayList<Integer[]> brownComp = new ArrayList<>(); //OR resources brown
    private int freeChoiceBrown = 0;
    private int freeChoiceGrey = 0;
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
        //For Wood OR Clay, Wood OR Stone, Clay OR Ore
        //Combination will look something like {[1,1,3],[1,1,4],[1,2,3],[1,2,4],[3,1,3],[3,1,4],[3,2,3],[3,2,4]}
        //Then x2 the options and add at the end everytime you add a new comp (usually max 4??)
        if(this.brownComp.isEmpty()){
            //If first comp, just create the two first resources
            Integer[] comp1 = {comp[0]};
            Integer[] comp2 = {comp[1]};
            this.brownComp.add(comp1);
            this.brownComp.add(comp2);
        }
        else{
            ArrayList<Integer[]> newBrownComp = new ArrayList<>();
            for(Integer[] combination: this.brownComp){
                int n = combination.length; //Previous number of combination cards
                Integer[] newCombination1 = new Integer[n+1];
                Integer[] newCombination2 = new Integer[n+1];
                //Copy current combination twice
                for(int i = 0; i<combination.length; i++){
                    newCombination1[i] = combination[i];
                    newCombination2[i] = combination[i];
                }
                //Add each new OR ressources to the new each array
                newCombination1[n] = comp[0];
                newCombination2[n] = comp[1];
                newBrownComp.add(newCombination1);
                newBrownComp.add(newCombination2);
            }
            this.brownComp = newBrownComp;
        }
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
    
    public ArrayList<Integer> getBuilt(){
        return this.built;
    }
    
    public int[] getResources(){
        return this.resources;
    }

    public ArrayList<Integer[]> getBrownComp(){
        return this.brownComp;
    }
    
    public int getFreeChoiceGrey(){
        return this.freeChoiceGrey;
    }
    
    public int getFreeChoiceBrown(){
        return this.freeChoiceBrown;
    }
    
    public void addFreeChoiceBrown(){
        this.freeChoiceBrown++;
    }
    
    public void addFreeChoiceGrey(){
        this.freeChoiceGrey++;
    }
    
    public void build(Card c){
        c.build(this);
    }
}
