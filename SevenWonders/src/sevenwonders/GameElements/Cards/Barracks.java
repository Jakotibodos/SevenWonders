package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Barracks extends Card {

    public Barracks(){
        super(23,"Barracks",4,new int[] {0,0,0,1,0,0,0,0},1);
    }

    public void build(Player p){
        p.addShields(1);
    }
}
