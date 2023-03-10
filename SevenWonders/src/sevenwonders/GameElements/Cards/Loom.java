package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Loom extends Card {
    //Can be present in age 1 and 2
    public Loom(int age) {
        super(12, "Loom", 1, age);
    }

    public void build(Player p) {
        p.addResource(7, 1); //textile
    }
}
