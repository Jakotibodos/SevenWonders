/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

import java.util.Arrays;

/**
 *
 * @author jakot
 */
public class Card {
    
    private final int id; //ID > 0
    private final String name;
    private final int age;
    private final int colorid;
    private final int[] cost = new int[8]; //[Coins,Clay,Ore,Stone,Wood,Glass,Papyrus,Textile]
    private Card prereq;
    
    private final String[] res2id = {"Coin","Clay","Ore","Stone","Wood","Cloth","Glass","Papyrus"};
    
    
    public Card(int id,String name,String type, String cost,int age){
        this.id = id;
        this.name = name;
        this.age = age;
        this.colorid = 0;
        setCost(cost);
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
    
    private void setCost(String cost){
        if (cost.equals("-")){
            return;
        }
        String[] costs = cost.split(" AND ");
        
        
        for (String singlecost: costs){
            String[] temp = singlecost.split(" ");
            int price = temp[0].charAt(0) - '0';
            
            this.cost[java.util.Arrays.asList(res2id).indexOf(temp[1])] = price;
        }   
        
    }
    
    public String printCost(){
        
        String outputString = "";
        
        for (int i = 0; i < 8; i++){
            int number = cost[i];
            if(number > 0){
                outputString  = outputString.concat(Integer.toString(number)+"x "+res2id[i]+" AND ");
            }
        }
        return ((outputString.length() == 0) ? "Free" : outputString.substring(0, outputString.length()-5));
    }
    
    public void print(){
        System.out.println("Name: "+name);
        System.out.println("Cost: "+printCost());
        System.out.println("FreeWith: "+prereq.getName());
    }
    
    
    
}
