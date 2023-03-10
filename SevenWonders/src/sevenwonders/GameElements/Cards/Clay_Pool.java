package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Clay_Pool extends Card {
    public Clay_Pool(){
        super(3,"Clay Pool",0,1);
    }
    public void build(Player p){
        p.addResource(3,1); //bricks
    }
}
