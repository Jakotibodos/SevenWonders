package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Clay_Pit extends Card {

    public Clay_Pit(){
        super(7,"Clay_Pit",0,new int[] {1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        Integer[] comp = new Integer[2];
        comp[0] = 3; //bricks
        comp[1] = 4; //ore
        p.addBrownComp(comp);
    }
}
