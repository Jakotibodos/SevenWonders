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
public class WonderBoard {
    
    private int wondersCompleted = 0;
    private ArrayList<Card> wondersList; //Wonders are implemented as cards
    private int id;
    private char side;
    private String name;
    
    
    public WonderBoard(int id, String name, char side, ArrayList<Card> wondersList){
        this.id = id;
        this.side = side;
        this.wondersList = wondersList;
        this.name = name;
    }
    
    public int getWondersCompleted(){
        return this.wondersCompleted;
    }
    
    public boolean canBuild(Player p){
        return this.wondersList.get(wondersCompleted).canBuild(p);
    }
    
    public void build(Player p){
        if(this.canBuild(p)){
            this.wondersList.get(wondersCompleted).build(p);
            wondersCompleted++;
        }
    }
}
