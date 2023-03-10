package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Press extends Card {
    //Can be present in age 1 and 2
    public Press(int age){
        super(10,"Glassworks","Grey",age);
    }
    public void build(Player p){
        p.addResource(6,1); //papyrus
    }
}