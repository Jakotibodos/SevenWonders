package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Marketplace extends Card {

    public Marketplace(){
        super(19,"Marketplace",3,1);
    }

    public void build(Player p){
        p.lowerTradingCosts(2); //grey
    }
}
