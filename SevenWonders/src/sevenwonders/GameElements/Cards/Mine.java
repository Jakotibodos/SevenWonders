package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Mine extends Card {

    public Mine(){
        super(10,"Mine",0,new int[] {1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        Integer[] comp = new Integer[2];
        comp[0] = 2; //stone
        comp[1] = 4; //ore
        p.addBrownComp(comp);
    }
}
