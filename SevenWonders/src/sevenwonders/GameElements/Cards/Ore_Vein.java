package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Ore_Vein extends Card {
    public Ore_Vein(){
        super(4,"Ore Vein","Brown",1);
    }
    public void build(Player p){
        p.addResource(4,1); //ore
    }
}
