package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class East_Trading_Post extends Card {

    public East_Trading_Post(){
        super(21,"East Trading Post",3,1);
    }

    public void build(Player p){
        p.lowerTradingCosts(1); //right Brown
    }
}
