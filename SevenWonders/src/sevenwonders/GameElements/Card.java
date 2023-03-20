/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

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
    
    public boolean canBuild(){
        return false;
    }
    
    public void build(Player p){
        if (buildAction != null) 
           buildAction.apply(p);
        p.addCountColor(this.getColorid());  
    }
        
}
