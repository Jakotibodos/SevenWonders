/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders.GameElements;

import sevenwonders.GameElements.Cards.Card;
import java.util.ArrayList;
/**
 *
 * @author jakot
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> built = new ArrayList<>();
    private Wonder wonderBoard = new Wonder();
    private int coins;

    private int[] resources; //[wood, stone, brick, ore, glass, papyrus, textile]


    public Player(){
        this.resources = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        this.coins = 3;
    }
}
