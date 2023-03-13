/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

import java.util.ArrayList;
import sevenwonders.GameElements.Card;
/**
 *
 * @author jakot
 */
public class CardCollection {
    
    ArrayList<Card> cards = new ArrayList<>();
    
    
    public CardCollection(int age, int nbPlayers){
        switch (age) {
            case 1:
            switch (nbPlayers) {
                case 7: 
                    cards.add(new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)));
                case 6: 
                    cards.add(new Card(5,"Tree Farm",0, new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 3;p.addBrownComp(comp);}));
                    cards.add(new Card(10,"Mine",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 4;p.addBrownComp(comp);}));
                    cards.add(new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)));
                    cards.add(new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)));
                    cards.add(new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)));
                    cards.add(new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)));
                case 5:
                    cards.add(new Card(2,"Stone Pit",0,1,(Player p )->p.addResource(2,1)));
                    cards.add(new Card(3,"Clay Pool",0,1,(Player p )->p.addResource(3,1)));
                    cards.add(new Card(9,"Forest Cave",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 4;p.addBrownComp(comp);}));
                    cards.add(new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2))); 
                case 4:
                    cards.add(new Card(1,"Lumber Yard",0,1,(Player p)->p.addResource(1,1)));
                    cards.add(new Card(4,"Ore Vein",0,1,(Player p )->p.addResource(4,1)));
                    cards.add(new Card(6,"Excavation",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 3;p.addBrownComp(comp);}));
                    cards.add(new Card(14,"Pawnshop",2,1,(Player p )->p.addBluePoints(3)));
                default:  
                    cards.add(new Card(1,"Lumber Yard",0,1,(Player p)->p.addResource(1,1)));
                    cards.add(new Card(2,"Stone Pit",0,1,(Player p )->p.addResource(2,1)));
                    cards.add(new Card(3,"Clay Pool",0,1,(Player p )->p.addResource(3,1)));
                    cards.add(new Card(4,"Ore Vein",0,1,(Player p )->p.addResource(4,1)));
                    cards.add(new Card(7,"Clay_Pit",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 3;comp[1] = 4;p.addBrownComp(comp);}));
                    cards.add(new Card(8,"Timber Yard",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 2;p.addBrownComp(comp);}));
                    cards.add(new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)));
                    cards.add(new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)));
                    cards.add(new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)));
                    cards.add(new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)));
                    cards.add(new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2))); 
                    cards.add(new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)));
                    break;
            }
            break;

            case 2:
            switch (nbPlayers) {
                case 7:
                case 6:                  
                case 5:
                case 4:
                default:  
                break;
            }
            break;
            
            case 3:
            switch (nbPlayers) {
                case 7:
                case 6:                  
                case 5:
                case 4:
                default:  
                break;
            }
            break;
            
        }
    }
    
    
    
    
}
