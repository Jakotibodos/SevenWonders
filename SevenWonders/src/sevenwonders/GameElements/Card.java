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
public class Card implements Buildable{
    
    private CardEffect buildAction;
    private final int id; //ID > 0
    private String name;
    private int age;
    private int colorid;
    private int[] cost; //{coins,wood,stone,bricks,ore,glass,papyrus,textile}
    private Card prereq;
    private int freeIfID;
    
    private final String[] res2id = {"coins","wood","stone","bricks","ore","glass","papyrus","textile"};
    private final String[] type2id = {"Brown","Grey","Blue","Yellow","Red","Green","Purple"};
    
    
    public Card(){ //Used for temp
        this.id = 0;
    }
    
    public Card(int id,String name,int type, int[] cost,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = type;
    }
    
    public Card(int id,String name,int type, int[] cost,int age, CardEffect buildAction){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = type;
        this.buildAction = buildAction;
    }

    public Card(int id,String name,int type ,int age, CardEffect buildAction){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = type;
        this.buildAction = buildAction;
    }
    //for free cards
    public Card(int id,String name,int type,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = type;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public int getColorid(){
        return colorid;
    }
    
    public int[] getCost(){
        return cost;
    }
    
    public Card getPrereq(){
        return prereq;
    }
    
    public void setPrereq(Card previous){
        prereq = previous;
    }

    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Cost: " + printCost(cost));
        System.out.println("FreeWith: " + prereq.getName());
    }
    
    public int[] priceToBuild(Player p){
        /*
        Returns [l,r] here l and r are the number of coins needed to pay to the left and right players
        If [-1,-1], building is impossible
        If [0,0], building is free
        If [2,1] 2 coins must be paid to the left and 1 to the right
        If [1] price is 1 coin for the bank
        If length > 2, then multiple choices for paying are possible ([l1,r1,l2,r2])
         */

        if(p.getBuilt().contains(this.freeIfID)) //Check if can afford with free card
            return new int[] {0,0};
        if(this.cost[0] == 1)
            return (p.getResources()[0]>0)?new int[] {1}: new int[] {-1,-1}; //If costs 1 coin, return [1] if can afford

        //Check and update cost with available normal resources
        int[] brownCost = new int[4];
        int[] greyCost = new int[3];
        for(int i = 1;i<5;i++){
            brownCost[i-1] = (this.cost[i]-p.getResources()[i]<1)? 0 : this.cost[i]-p.getResources()[i];
        }
        for(int i = 5;i<8;i++){
            greyCost[i-5] = (this.cost[i]-p.getResources()[i]<1)? 0 : this.cost[i]-p.getResources()[i];
        }
        boolean allZeroes = true;
        for(int bcost : brownCost)
            if (bcost>0){
                allZeroes = false;
                break;
            }
        for(var gcost : greyCost)
            if (gcost>0){
                allZeroes = false;
                break;
            }
        if(allZeroes)
            return new int[] {0,0};





        return new int[] {-1,-1};
    }

    public ArrayList<Integer[]> priceComps(int[] price, Player p){
        //separate into grey and brown resources (for ease of computation)
        ArrayList<Integer[]> brownComp = p.getBrownComp();
        ArrayList<Integer[]> greyComp = new ArrayList<>();
        for(Integer[] other: p.getOtherComp()) {
            if (other[0] == 1)
                brownComp.add(other);
            else
                greyComp.add(other);
        }
        int[] tempPrice = price;


        return
    }



    public void build(Player p){
        if (buildAction != null) 
           buildAction.apply(p);
        p.addCountColor(this.getColorid());  
    }


        
}
