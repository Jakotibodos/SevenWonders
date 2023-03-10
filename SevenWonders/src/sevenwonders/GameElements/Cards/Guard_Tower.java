package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Guard_Tower extends Card {

    public Guard_Tower(){
        super(24,"Guard_Tower",4,new int[] {0,0,0,0,1,0,0,0},1);
    }

    public void build(Player p){
        p.addShields(1);
    }
}
