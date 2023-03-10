/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevenwonders;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import sevenwonders.GameElements.Cards.Card;
import java.util.ArrayList;
/**
 *
 * @author jakot
 */
public class SevenWonders {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File myObj = new File("Components/cards.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();

            ArrayList<Card> deck = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitted = data.split(",");

                int cardId = Integer.parseInt(splitted[0]);
                String cardName = splitted[1];
                String type = splitted[2];
                String cost = splitted[3];
                String provides = splitted[4];
                String fFree = splitted[5];
                String freeWith = splitted[6];
                int age = Integer.parseInt(splitted[7]);

                deck.add(new Card(cardId,cardName,type,cost,age));
                
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
