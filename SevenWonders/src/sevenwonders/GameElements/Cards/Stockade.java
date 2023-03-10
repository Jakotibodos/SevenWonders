package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Stockade extends Card {

    public Stockade(){
        super(22,"Stockade",4,new int[] {0,1,0,0,0,0,0,0},1);
    }

    public void build(Player p){
        p.addShields(1);
    }
}
