package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Pawnshop extends Card {

    public Pawnshop(){
        super(14,"Pawnshop",2,1);
    }

    public void build(Player p){
        p.addBluePoints(3);
    }
}