package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Timber_Yard extends Card {

    public Timber_Yard(){
        super(8,"Timber Yard","Brown",new int[] {1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        Integer[] comp = new Integer[2];
        comp[0] = 1; //wood
        comp[1] = 2; //stone
        p.addBrownComp(comp);
    }
}
