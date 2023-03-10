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
    
    private final int id; //ID > 0
    private String name;
    private int age;
    private int colorid;
    private int[] cost; //[Coins,Clay,Ore,Stone,Wood,Glass,Papyrus,Textile]
    private Card prereq;
    
    private final String[] res2id = {"Coin","Clay","Ore","Stone","Wood","Cloth","Glass","Papyrus"};
    
    
    public Card(int id,String name,String type, int[] cost,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = 0;
    }

    //for free cards
    public Card(int id,String name,String type,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = 0;
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
    
}
