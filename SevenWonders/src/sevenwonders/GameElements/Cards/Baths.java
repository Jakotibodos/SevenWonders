package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Baths extends Card {

    public Baths(){
        super(15,"Baths",2,new int[] {0,0,1,0,0,0,0,0},1);
    }

    public void build(Player p){
        p.addBluePoints(3);
    }
}
