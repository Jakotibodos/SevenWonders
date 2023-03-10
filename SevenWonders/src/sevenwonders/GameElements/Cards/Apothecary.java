package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Apothecary extends Card {

    public Apothecary(){
        super(25,"Apothecary",5,new int[] {0,0,0,0,0,0,0,1},1);
    }

    public void build(Player p){
        p.addScience(0); //compass
    }
}
