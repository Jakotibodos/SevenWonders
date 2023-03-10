package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Tavern extends Card {

    public Tavern(){
        super(18,"Tavern",3,1);
    }

    public void build(Player p){
        p.addResource(0,5); //coins
    }
}
