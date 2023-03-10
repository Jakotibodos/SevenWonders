package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Theater extends Card {

    public Theater(){
        super(17,"Theater",2,1);
    }

    public void build(Player p){
        p.addBluePoints(2);
    }
}
