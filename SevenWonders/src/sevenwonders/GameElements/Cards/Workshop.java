package sevenwonders.GameElements.Cards;

import sevenwonders.GameElements.Card;
import sevenwonders.GameElements.Player;

public class Workshop extends Card {

    public Workshop() {
        super(26, "Workshop", 5, new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 1);
    }

    public void build(Player p) {
        p.addScience(1); //gear
    }
}
