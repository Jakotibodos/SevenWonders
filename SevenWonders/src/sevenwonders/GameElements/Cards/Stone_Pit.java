package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Stone_Pit extends Card {

    public Stone_Pit(){
        super(1,"Stone Pit","Brown",'1');
    }

    public void build(Player p){
        p.addResource(2,1);
    }

}
