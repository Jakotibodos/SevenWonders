package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Glassworks extends Card {
    //Can be present in age 1 and 2
    public Glassworks(int age){
        super(9,"Glassworks","Grey",age);
    }
    public void build(Player p){
            p.addResource(5,1); //glass
    }
}
