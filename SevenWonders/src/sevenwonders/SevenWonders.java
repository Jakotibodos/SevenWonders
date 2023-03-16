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
public class SevenWonders{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Card> deck = createDeck(1,4);
        System.out.println(deck.size());
    }
    
    public static void createCards(){
        
        //AGE 1 deck
        
        //Age 1 Brown   deck
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
        
        //Age 1 Grey    deck
        Card c11 = new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)); //glass
        Card c12 = new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)); //papyrus
        Card c13 = new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)); //textile
        
        //Age 1 Blue    deck
        Card c14 = new Card(14,"Pawnshop",2,1,(Player p )->p.addBluePoints(3)); //3 blue points
        Card c15 = new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)); //3 blue points
        Card c16 = new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2)); //2 blue points
        Card c17 = new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)); //2 blue points
        
        //Age 1 Yellow  deck
        Card c18 = new Card(18,"Tavern",3,1,(Player p )->p.addResource(0,5)); //5 coins
        Card c19 = new Card(19,"Marketplace",3,1,(Player p )->p.lowerTradingCosts(2)); //lower both grey trading costs
        Card c20 = new Card(20,"West Trading Post",3,1,(Player p )->p.lowerTradingCosts(0)); //lower left brown trading costs
        Card c21 = new Card(21,"East Trading Post",3,1,(Player p )->p.lowerTradingCosts(1)); //lower right brown trading costs
        
        //Age 1 Red deck
        Card c22 = new Card(22,"Stockade",4,new int[] {0,1,0,0,0,0,0,0},1,(Player p)->p.addShields(1));
        Card c23 = new Card(23,"Barracks",4,new int[] {0,0,0,1,0,0,0,0},1,(Player p)->p.addShields(1));
        Card c24 = new Card(24,"Guard_Tower",4,new int[] {0,0,0,0,1,0,0,0},1,(Player p)->p.addShields(1));
        
        //Age 1 Green   deck
        Card c25 = new Card(25,"Apothecary",5,new int[] {0,0,0,0,0,0,0,1},1,(Player p)->p.addScience(0)); //compass
        Card c26 = new Card(26,"Workshop",5,new int[]{0,0,0,0,0,1,0,0},1,(Player p)->p.addScience(1)); //gear
        Card c27 = new Card(27,"Scriptorium",5,new int[]{0,0,0,0,0,0,1,0},1,(Player p)->p.addScience(2)); //tablet
        
        //AGE 2 deck
        
        //Age 2 Brown   deck
        Card c28 = new Card(28,"Sawmill",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(1,2)); //2 wood
        Card c29 = new Card(29,"Quarry",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(2,2)); //2 stone
        Card c30 = new Card(30,"Brickyard",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(3,2)); //2 brick
        Card c31 = new Card(31,"Foundry",0,new int[]{1,0,0,0,0,0,0,0},2,(Player p)->p.addResource(4,2)); //2 ore
        
        //Age 2 Grey    deck
        Card c32 = new Card(32,"Glassworks",1,2,(Player p )->p.addResource(5,1)); //glass
        Card c33 = new Card(33,"Press",1,2,(Player p )->p.addResource(6,1)); //papyrus
        Card c34 = new Card(34,"Loom",1,2,(Player p )->p.addResource(7,1)); //textile
        
        //Age 2 Blue    deck
        Card c35 = new Card(35,"Statue",2,new int[] {0,1,0,2,0,0,0,0},2,(Player p )->p.addBluePoints(4)); //4 Blue Points
        Card c36 = new Card(36,"Aqueduct",2,new int[] {0,0,3,0,0,0,0,0},2,(Player p )->p.addBluePoints(5)); //5 Blue Points
        Card c37 = new Card(37,"Temple",2,new int[] {0,1,0,1,0,1,0,0},2,(Player p )->p.addBluePoints(4)); //4 Blue Points
        Card c38 = new Card(38,"Courthouse",2,new int[] {0,0,0,2,0,0,0,1},2,(Player p )->p.addBluePoints(5)); //4 Blue Points
        
        //Age 2 Yellow  deck
        Card c39 = new Card(39,"Caravansery",3,new int[] {0,2,0,0,0,0,0,0},2,
                (Player p )->{Integer[] comp = new Integer[4];comp[0] = 1;comp[1] = 2;comp[2] = 3;comp[3] = 4;p.addYellowComp(comp);}); //Brown ressources composition
        Card c40 = new Card(40,"Forum",3,new int[] {0,0,0,2,0,0,0,0},2,
                (Player p )->{Integer[] comp = new Integer[3];comp[0] = 5;comp[1] = 6;comp[2] = 7;p.addYellowComp(comp);}); //Grey ressources composition
        Card c41 = new Card(41,"Vineyard",3,2,
                (Player p )->{int coinsToAdd = p.getLeftPlayer().getCountColor(0)+p.getRightPlayer().getCountColor(0)+p.getCountColor(0);
                        p.addResource(0, coinsToAdd);}); //Add coins = brown    deck of you and neighbors
        Card c42 = new Card(42,"Bazar",3,2,
                (Player p )->{int coinsToAdd = p.getLeftPlayer().getCountColor(1)+p.getRightPlayer().getCountColor(1)+p.getCountColor(1);
                        p.addResource(0, coinsToAdd*2);}); //Add coins = 2 x grey   deck of you and neighbors
        
        //Age 2 Red deck
        Card c43 = new Card(43,"Stables",4,new int[] {0,1,0,1,1,0,0,0},2,(Player p)->p.addShields(2));
        Card c44 = new Card(44,"Archery Range",4,new int[] {0,2,0,0,1,0,0,0},2,(Player p)->p.addShields(2));
        Card c45 = new Card(45,"Walls",4,new int[] {0,0,3,0,0,0,0,0},2,(Player p)->p.addShields(2));
        Card c46 = new Card(46,"Training Ground",4,new int[] {0,1,0,0,2,0,0,0},2,(Player p)->p.addShields(2));
        
        //Age 2 Green   deck
        Card c47 = new Card(47,"Dispensary",5,new int[] {0,0,0,0,2,1,0,0},2,(Player p)->p.addScience(0)); //compass
        Card c48 = new Card(48,"Laboratory",5,new int[]{0,0,0,2,0,0,1,0},2,(Player p)->p.addScience(1)); //gear
        Card c49 = new Card(49,"Library",5,new int[]{0,0,2,0,0,0,0,1},2,(Player p)->p.addScience(2)); //tablet
        Card c50 = new Card(50,"School",5,new int[]{0,1,0,0,0,0,1,0},2,(Player p)->p.addScience(2)); //tablet
        
        
        //AGE 3 deck
        
        //Age 3 Blue    deck
        Card c51 = new Card(51,"Pantheon",2,new int[] {0,0,0,2,1,1,1,1},3,(Player p )->p.addBluePoints(7)); //7 Blue Points
        Card c52 = new Card(52,"Gardens",2,new int[] {0,1,0,2,0,0,0,0},3,(Player p )->p.addBluePoints(5)); //5 Blue Points
        Card c53 = new Card(53,"Town Hall",2,new int[] {0,0,2,0,1,1,0,0},3,(Player p )->p.addBluePoints(6)); //6 Blue Points
        Card c54 = new Card(54,"Palace",2,new int[] {0,1,1,1,1,1,1,1},3,(Player p )->p.addBluePoints(8)); //8 Blue Points
        Card c55 = new Card(55,"Senate",2,new int[] {0,2,1,0,1,0,0,0},3,(Player p )->p.addBluePoints(6)); //6 Blue Points
        
        //Age 3 Yellow  deck
        Card c56 = new Card(56,"Lighthouse",3,new int[] {0,0,1,0,0,1,0,0},3,(Player p )->{
                p.addResource(0, p.getCountColor(3)); //Add coins = number of previous yellow   deck
                p.addConditionalPointsToUpdate( //Add points = number of previous yellow    deck
                    (Player q)-> {q.addYellowPoints(q.getCountColor(3));});}); 
        Card c57 = new Card(57,"Haven",3,new int[] {0,1,0,0,1,0,0,1},3,(Player p )->{
                p.addResource(0, p.getCountColor(0)); //Add coins = number of previous brown    deck
                p.addConditionalPointsToUpdate( //Add points = number of previous brown deck
                    (Player q)-> {q.addYellowPoints(q.getCountColor(0));});}); 
        Card c58 = new Card(58,"Chamber of Commerce",3,new int[] {0,0,0,2,0,0,1,0},3,(Player p )->{
                p.addResource(0, 2*p.getCountColor(1)); //Add coins = 2x number of previous grey    deck
                p.addConditionalPointsToUpdate( //Add points = 2x number of previous grey   deck
                    (Player q)-> {q.addYellowPoints(2*q.getCountColor(1));});}); 
        Card c59 = new Card(59,"Arena",3,new int[] {0,0,2,0,1,0,0,0},3,(Player p )->{
                p.addResource(0, 3*p.getWonderBoard().getWondersCompleted()); //Add coins = 3x number of completed wonders
                p.addConditionalPointsToUpdate( //Add points = number of completed wonders
                    (Player q)-> {q.addYellowPoints(p.getWonderBoard().getWondersCompleted());});});
        
        //Age 3 Red deck
        Card c60 = new Card(60,"Fortifications",4,new int[] {0,0,1,0,3,0,0,0},3,(Player p)->p.addShields(3));
        Card c61 = new Card(61,"Circus",4,new int[] {0,0,3,0,1,0,0,0},3,(Player p)->p.addShields(3));
        Card c62 = new Card(62,"Arsenal",4,new int[] {0,2,0,0,1,0,0,1},3,(Player p)->p.addShields(3));
        Card c63 = new Card(63,"Siege Workshop",4,new int[] {0,1,0,3,0,0,0,0},3,(Player p)->p.addShields(3));
        
        //Age 3 Green   deck
        Card c64 = new Card(64,"Lodge",5,new int[] {0,0,0,2,0,0,1,1},3,(Player p)->p.addScience(0)); //compass
        Card c65 = new Card(65,"Academy",5,new int[]{0,0,3,0,0,1,0,0},3,(Player p)->p.addScience(0)); //compass
        Card c66 = new Card(66,"Observatory",5,new int[]{0,0,0,0,2,1,0,1},3,(Player p)->p.addScience(1)); //gear
        Card c67 = new Card(67,"Study",5,new int[]{0,1,0,0,0,1,0,1},3,(Player p)->p.addScience(1)); //gear
        Card c68 = new Card(68,"University",5,new int[] {0,2,0,0,0,1,1,0},3,(Player p)->p.addScience(2)); //tablet
        
        //Age 3 purple  deck
        Card c69 = new Card(69,"Workers Guild",6,new int[] {0,1,1,1,2,0,0,0},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of brown  deck of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getCountColor(0)+q.getRightPlayer().getCountColor(0));});}); 
        Card c70 = new Card(70,"Craftmens Guild",6,new int[] {0,0,2,0,2,0,0,0},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = 2x number of grey    deck of neighbors
                    (Player q)-> {q.addPurplePoints(2*(q.getLeftPlayer().getCountColor(1)+q.getRightPlayer().getCountColor(1)));});});
        Card c71 = new Card(71,"Magistrates Guild",6,new int[] {0,3,1,0,0,0,0,1},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of blue   deck of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getCountColor(2)+q.getRightPlayer().getCountColor(2));});}); 
        Card c72 = new Card(72,"Traders Guild",6,new int[] {0,0,0,0,0,1,1,1},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of yellow deck of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getCountColor(3)+q.getRightPlayer().getCountColor(3));});}); 
        Card c73 = new Card(73,"Builders Guild",6,new int[] {0,0,2,2,0,1,0,0},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of completed wonders of player and neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getWonderBoard().getWondersCompleted()
                            +q.getRightPlayer().getWonderBoard().getWondersCompleted()
                            +q.getWonderBoard().getWondersCompleted());});}); 
        Card c74 = new Card(74,"Spies Guild",6,new int[] {0,0,0,3,0,1,0,0},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of red    deck of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getCountColor(4)+q.getRightPlayer().getCountColor(4));});}); 
        Card c75 = new Card(75,"Philosophers Guild",6,new int[] {0,0,0,3,0,0,1,1},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of green  deck of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getCountColor(5)+q.getRightPlayer().getCountColor(5));});}); 
        Card c76 = new Card(76,"Strategists Guild",6,new int[] {0,0,1,0,2,0,0,1},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of Minus Tokens of neighbors
                    (Player q)-> {q.addPurplePoints(q.getLeftPlayer().getNumberMinusTokens()+q.getRightPlayer().getNumberMinusTokens());});}); 
        Card c77 = new Card(77,"Scientists Guild",6,new int[] {0,2,0,0,2,0,1,0},3,(Player p)->p.addScience(3)); //Conditional science
        Card c78 = new Card(78,"Shipowners Guild",6,new int[] {0,3,0,0,0,1,1,0},3,(Player p )->{
                p.addConditionalPointsToUpdate( //Add points = number of brown, grey and purple deck owned
                    (Player q)-> {q.addPurplePoints(q.getCountColor(0)+q.getCountColor(1)+q.getCountColor(6));});});
        
        
        
        Player p = new Player();
        c1.build(p);
        p.updateConditionalPoints(3);
        p.printResources();
        p.printPoints();
        c78.build(p);
        p.updateConditionalPoints(3);
        p.printResources();
        p.printPoints();
        
        
        
        
    }
    
    public static ArrayList createDeck(int age, int nbPlayers){
        ArrayList<Card> deck = new ArrayList<>();
        switch (age) {
            case 1:
            switch (nbPlayers) {
                case 7: 
                    deck.add(new Card(14,"Pawnshop",2,1,(Player p )->p.addBluePoints(3)));
                    deck.add(new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)));
                    deck.add(new Card(18,"Tavern",3,1,(Player p )->p.addResource(0,5)));
                    deck.add(new Card(20,"West Trading Post",3,1,(Player p )->p.lowerTradingCosts(0)));
                    deck.add(new Card(21,"East Trading Post",3,1,(Player p )->p.lowerTradingCosts(1)));
                    deck.add(new Card(22,"Stockade",4,new int[] {0,1,0,0,0,0,0,0},1,(Player p)->p.addShields(1)));
                    deck.add(new Card(26,"Workshop",5,new int[]{0,0,0,0,0,1,0,0},1,(Player p)->p.addScience(1)));
                case 6: 
                    deck.add(new Card(5,"Tree Farm",0, new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 3;p.addBrownComp(comp);}));
                    deck.add(new Card(10,"Mine",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 4;p.addBrownComp(comp);}));
                    deck.add(new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)));
                    deck.add(new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)));
                    deck.add(new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)));
                    deck.add(new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)));
                    deck.add(new Card(19,"Marketplace",3,1,(Player p )->p.lowerTradingCosts(2)));
                case 5:
                    deck.add(new Card(2,"Stone Pit",0,1,(Player p )->p.addResource(2,1)));
                    deck.add(new Card(3,"Clay Pool",0,1,(Player p )->p.addResource(3,1)));
                    deck.add(new Card(9,"Forest Cave",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 4;p.addBrownComp(comp);}));
                    deck.add(new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2))); 
                    deck.add(new Card(18,"Tavern",3,1,(Player p )->p.addResource(0,5)));
                    deck.add(new Card(23,"Barracks",4,new int[] {0,0,0,1,0,0,0,0},1,(Player p)->p.addShields(1)));
                    deck.add(new Card(25,"Apothecary",5,new int[] {0,0,0,0,0,0,0,1},1,(Player p)->p.addScience(0)));
                case 4:
                    deck.add(new Card(1,"Lumber Yard",0,1,(Player p)->p.addResource(1,1)));
                    deck.add(new Card(4,"Ore Vein",0,1,(Player p )->p.addResource(4,1)));
                    deck.add(new Card(6,"Excavation",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 2;comp[1] = 3;p.addBrownComp(comp);}));
                    deck.add(new Card(14,"Pawnshop",2,1,(Player p )->p.addBluePoints(3)));
                    deck.add(new Card(18,"Tavern",3,1,(Player p )->p.addResource(0,5)));
                    deck.add(new Card(24,"Guard_Tower",4,new int[] {0,0,0,0,1,0,0,0},1,(Player p)->p.addShields(1)));
                    deck.add(new Card(27,"Scriptorium",5,new int[]{0,0,0,0,0,0,1,0},1,(Player p)->p.addScience(2)));
                default:  
                    deck.add(new Card(1,"Lumber Yard",0,1,(Player p)->p.addResource(1,1)));
                    deck.add(new Card(2,"Stone Pit",0,1,(Player p )->p.addResource(2,1)));
                    deck.add(new Card(3,"Clay Pool",0,1,(Player p )->p.addResource(3,1)));
                    deck.add(new Card(4,"Ore Vein",0,1,(Player p )->p.addResource(4,1)));
                    deck.add(new Card(7,"Clay_Pit",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 3;comp[1] = 4;p.addBrownComp(comp);}));
                    deck.add(new Card(8,"Timber Yard",0,new int[] {1,0,0,0,0,0,0},1,
                (Player p )->{Integer[] comp = new Integer[2];comp[0] = 1;comp[1] = 2;p.addBrownComp(comp);}));
                    deck.add(new Card(11,"Glassworks",1,1,(Player p )->p.addResource(5,1)));
                    deck.add(new Card(12,"Press",1,1,(Player p )->p.addResource(6,1)));
                    deck.add(new Card(13,"Loom",1,1,(Player p )->p.addResource(7,1)));
                    deck.add(new Card(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1,(Player p )->p.addBluePoints(3)));
                    deck.add(new Card(16,"Altar",2,1,(Player p )->p.addBluePoints(2))); 
                    deck.add(new Card(17,"Theatre",2,1,(Player p )->p.addBluePoints(2)));
                    deck.add(new Card(19,"Marketplace",3,1,(Player p )->p.lowerTradingCosts(2)));
                    deck.add(new Card(20,"West Trading Post",3,1,(Player p )->p.lowerTradingCosts(0)));
                    deck.add(new Card(21,"East Trading Post",3,1,(Player p )->p.lowerTradingCosts(1)));
                    deck.add(new Card(22,"Stockade",4,new int[] {0,1,0,0,0,0,0,0},1,(Player p)->p.addShields(1)));
                    deck.add(new Card(23,"Barracks",4,new int[] {0,0,0,1,0,0,0,0},1,(Player p)->p.addShields(1)));
                    deck.add(new Card(24,"Guard_Tower",4,new int[] {0,0,0,0,1,0,0,0},1,(Player p)->p.addShields(1))); 
                    deck.add(new Card(25,"Apothecary",5,new int[] {0,0,0,0,0,0,0,1},1,(Player p)->p.addScience(0)));
                    deck.add(new Card(26,"Workshop",5,new int[]{0,0,0,0,0,1,0,0},1,(Player p)->p.addScience(1)));
                    deck.add(new Card(27,"Scriptorium",5,new int[]{0,0,0,0,0,0,1,0},1,(Player p)->p.addScience(2)));
                    break;
            }
            break;
            /*
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
           */ 
        }
        
        return deck;
    }
    
    
}
