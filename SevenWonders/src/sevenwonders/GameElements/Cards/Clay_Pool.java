package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Clay_Pool extends Card {
    public Clay_Pool(){
        super(1,"Clay Pool","Brown",'1');
    }
    public void build(Player p){
        p.addResource(3,1);
    }
}
