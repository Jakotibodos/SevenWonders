/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import sevenwonders.GameElements.Card;
import java.util.ArrayList;
import sevenwonders.GameElements.Player;
/**
 *
 * @author jakot
 */
public class SevenWonders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        createCards();
    }
    
    public static void createCards(){
        
        //AGE 1 CARDS
        
        //Age 1 Brown cards
        Card c1 = new Card(1,"Lumber Yard",0,1,(Player p)->p.addResource(1,1)); //wood
        Card c2 = new Card(2,"Stone Pit",0,1,(Player p )->p.addResource(2,1)); //stone
        Card c3 = new Card(3,"Clay Pool",0,1,(Player p )->p.addResource(3,1)); //bricks
        Card c4 = new Card(4,"Ore Vein",0,1,(Player p )->p.addResource(4,1)); //ore
        Card c5 = new Card(5,"Tree Farm",0, new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 3;p.addBrownComp(comp);}); // wood\bricks
        Card c6 = new Card(6,"Excavation",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 3;p.addBrownComp(comp);}); // stone\bricks
        Card c7 = new Card(7,"Clay_Pit",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 3;comp[1] = 4;p.addBrownComp(comp);}); // ore\bricks
        Card c8 = new Card(8,"Timber Yard",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 2;p.addBrownComp(comp);}); // wood\stone
        Card c9 = new Card(9,"Forest Cave",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 4;p.addBrownComp(comp);}); // wood\ore
        Card c10 = new Card(10,"Mine",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 4;p.addBrownComp(comp);}); // stone\ore
        
        //Age 1 Grey cards
        Card c11 = new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)); //glass
        Card c12 = new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)); //papyrus
        Card c13 = new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)); //textile
        
        //Age 1 Blue cards
        Card c14 = new Card(14,"Pawnshop",2,1,(Player p )->p.addBluePoints(3)); //3 blue points
        Card c15 = new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)); //3 blue points
        Card c16 = new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2)); //2 blue points
        Card c17 = new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)); //2 blue points
        
        //Age 1 Yellow cards
        Card c18 = new Card(18,"Tavern",3,1,(Player p )->p.addResource(0,5)); //5 coins
        Card c19 = new Card(19,"Marketplace",3,1,(Player p )->p.lowerTradingCosts(2)); //lower both grey trading costs
        Card c20 = new Card(20,"West Trading Post",3,1,(Player p )->p.lowerTradingCosts(0)); //lower left brown trading costs
        Card c21 = new Card(21,"East Trading Post",3,1,(Player p )->p.lowerTradingCosts(1)); //lower right brown trading costs
        
        //Age 1 Red cards
        Card c22 = new Card(22,"Stockade",4,new int[] {0,1,0,0,0,0,0,0},1,(Player p)->p.addShields(1));
        Card c23 = new Card(23,"Barracks",4,new int[] {0,0,0,1,0,0,0,0},1,(Player p)->p.addShields(1));
        Card c24 = new Card(24,"Guard_Tower",4,new int[] {0,0,0,0,1,0,0,0},1,(Player p)->p.addShields(1));
        
        //Age 1 Green cards
        Card c25 = new Card(25,"Apothecary",5,new int[] {0,0,0,0,0,0,0,1},1,(Player p)->p.addScience(0)); //compass
        Card c26 = new Card(26,"Workshop",5,new int[]{0,0,0,0,0,1,0,0},1,(Player p)->p.addScience(1)); //gear
        Card c27 = new Card(27,"Scriptorium",5,new int[]{0,0,0,0,0,0,1,0},1,(Player p)->p.addScience(2)); //tablet
        
        //AGE 2 CARDS
        
        //Age 2 Brown cards
        Card c28 = new Card(28,"Sawmill",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(1,2)); //2 wood
        Card c29 = new Card(29,"Quarry",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(2,2)); //2 stone
        Card c30 = new Card(30,"Brickyard",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(3,2)); //2 brick
        Card c31 = new Card(31,"Foundry",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(4,2)); //2 ore
        
        //Age 2 Grey cards
        Card c32 = new Card(32,"Glassworks",1,2,(Player p )->p.addResource(5,1)); //glass
        Card c33 = new Card(33,"Press",1,2,(Player p )->p.addResource(6,1)); //papyrus
        Card c34 = new Card(34,"Loom",1,2,(Player p )->p.addResource(7,1)); //textile
    }
}
