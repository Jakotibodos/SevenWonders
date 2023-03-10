package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Forest_Cave extends Card {

    public Forest_Cave(){
        super(9,"Forest Cave",0,new int[] {1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        Integer[] comp = new Integer[2];
        comp[0] = 1; //wood
        comp[1] = 4; //ore
        p.addBrownComp(comp);
    }
}
