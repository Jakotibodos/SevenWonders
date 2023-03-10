package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Tree_Farm extends Card {

    public Tree_Farm(){
        super(5,"Tree Farm","Brown", new int[] {1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        Integer[] comp = new Integer[2];
        comp[0] = 1; //wood
        comp[1] = 3; //bricks
        p.addBrownComp(comp);
    }
}
