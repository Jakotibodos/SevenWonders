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
    public Player(){
        this.addResource(0,3);
    }

    public void addResource(int residx, int amount){
        this.resources[residx] =+ amount;
    }

    public void addBrownComp(Integer[] comp){
        this.brownComp.add(comp);
    }
    public void addYellowComp(Integer[] comp){
        this.yellowComp.add(comp);
    }

}
