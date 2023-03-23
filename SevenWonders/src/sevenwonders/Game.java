/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

/**
 *
 * @author jakot
 */
public class Game {
    
    ArrayList<Player> players;
    ArrayList<ArrayList<Card>> hands;
    
    public Game(){
        initializeGame();
    }
    
    public void initializeGame(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter number of players: ");
        int nplayers = input.nextInt();
        System.out.println("Enter number of bots: ");
        int nbots = input.nextInt();
        while(nplayers<0||nbots<0||nplayers+nbots<3||nplayers+nbots>7){
            System.out.println("Total number of players needs to be between 3 and 7 (and each needs to be positive)");
            System.out.println("Enter number of players: ");
            nplayers = input.nextInt();
            System.out.println("Enter number of bots: ");
            nbots = input.nextInt(); 
        }
        
        this.hands = createDeck(1,nplayers+nbots);       
        this.players = createPlayers(nplayers,nbots);
    }
    
    public ArrayList<Player> createPlayers(int nplayers, int nbots){
        this.players = new ArrayList<>();
        for(int i =1; i<=nplayers; i++){
            players.add(new Player(i,true)); //Add real players
        }
        for(int i = nplayers; i<=nplayers+nbots; i++){
            players.add(new Player(i,false)); //Add bots
        }
        
        setNeighbors(players);
        return players;
    }
    
    public void setNeighbors(ArrayList<Player> players){
        int nplayers = players.size();
        
        for (int i = 1; i < nplayers-1;i++){
            players.get(i).setLeftPlayer(players.get(i-1));
            players.get(i).setRightPlayer(players.get(i+1));
        }
        players.get(0).setLeftPlayer(players.get(nplayers-1));
        players.get(0).setRightPlayer(players.get(1));
        players.get(nplayers-1).setLeftPlayer(players.get(nplayers-2));
        players.get(nplayers-1).setRightPlayer(players.get(0));
    }
    
    public ArrayList createDeck(int age, int nbPlayers){
        Stack<Card> deck = new Stack<>();
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
        
        Collections.shuffle(deck);
        
        ArrayList<ArrayList<Card>> dealtHands = new ArrayList<>();
        for (int i = 0; i<nbPlayers;i++){
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = 0; j<7;j++){
                hand.add(deck.pop());
            }
            dealtHands.add(hand);
        }
        return dealtHands;
    }
    
}
