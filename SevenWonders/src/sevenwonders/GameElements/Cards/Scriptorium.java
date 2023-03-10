package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Scriptorium extends Card {

    public Scriptorium() {
        super(27, "Scriptorium", 5, new int[]{0, 0, 0, 0, 0, 0, 1, 0}, 1);
    }

    public void build(Player p) {
        p.addScience(2); //tablet
    }
}