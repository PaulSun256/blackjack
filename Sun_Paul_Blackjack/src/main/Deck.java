/*
+========================================+
|               Deck class               |
+========================================+
|          Paul Sun, 2020/10/20          |
+========================================+
|              ICS3U Ms. S               |
+========================================+
| Deck class. This contains all the cards|
|  in a standard poker deck, except for  |
|   jokers, and can distribute a random  |
|                  card.                 |
+========================================+
*/
import java.util.*;

public class Deck	{

    // creating the deck array and an integer that indicates which card to use next
    private int deck[] = new int[52];
    private int currentCard = 0;
    private static String suits[] = new String[4];
    private static String ranks[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 

    public Deck()   {
        
        // make a new deck
        newDeck();

        // I don't use windows, but the teacher does, so I have to be able to change to the proper
        // character encoding automatically.
        if(suits[0] == null)    {

            if (System.getProperty("os.name").startsWith("Windows"))    {

                suits[0] = Character.toString((char)6);
                suits[1] = Character.toString((char)3);
                suits[2] = Character.toString((char)5);
                suits[3] = Character.toString((char)4);
            } else  {

                suits[0] = "\u2660";
                suits[1] = "\u2665";
                suits[2] = "\u2663";
                suits[3] = "\u2666";
            }
        }
    }


// methods
// --------------------------------------------------------------------------------------------------------------------------------------------------
    public void newDeck()   {

        // fills the array with a sorted pile of cards, AKA a sorted array of consecutive integers
        for (int i = 0; i < 52; i++)    deck[i] = i;
    }

    public void shuffle()   {
        
        // we need a temporary variable to swap with
        int temp;
        int randomIndex;

        Random rand = new Random();
        
        for (int i = 0; i < 52; i++)    {
            
            // we pick a random index to swap our current index with, and we repeat this, and we get a shuffled deck
            randomIndex = rand.nextInt(52);
            temp = deck[randomIndex];
            deck[randomIndex] = deck[i];
            deck[i] = temp;
        }
    }

    public int nextCard()   {
        
        // we make a new deck if needed
        if (currentCard >= 41)   {

            System.out.println("We are running low on cards. Creating and shuffling new deck...");

            newDeck();
            shuffle();
            currentCard = 0;
        }
        // return the next card and increment. a ++ after the variable will increment AFTER running
        // eg:
        // i = 1
        // j = i++
        // i is now 2, but j is 1
        return deck[currentCard++];
    }

    public String toString() {
        
        String deckString = "";

        for (int i = 0; i < 52; i++)    {

            String rank = "";
            String suit = "";

            // using the static arrays up at the top, we can translate them
            suit = suits[deck[i] / 13];
            rank = ranks[deck[i] % 13];

            deckString += rank + suit + " ";
        }

        return deckString;
    }
}