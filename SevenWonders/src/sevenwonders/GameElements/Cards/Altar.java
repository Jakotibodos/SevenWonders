package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Altar extends Card {

    public Altar(){
        super(16,"Altar",2,1);
    }

    public void build(Player p){
        p.addBluePoints(2);
    }
}
