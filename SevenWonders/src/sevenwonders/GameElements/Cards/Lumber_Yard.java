package sevenwonders.GameElements.Cards;


import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Lumber_Yard extends Card{

    public Lumber_Yard(){
        super(1,"Lumber Yard","Brown",1);
    }

    public void build(Player p){
        p.addResource(1,1); //wood
    }
}
