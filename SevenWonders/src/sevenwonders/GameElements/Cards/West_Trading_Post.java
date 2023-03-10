package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class West_Trading_Post extends Card {

    public West_Trading_Post(){
        super(20,"West Trading Post",3,1);
    }

    public void build(Player p){
        p.lowerTradingCosts(0); //Left Brown
    }
}
