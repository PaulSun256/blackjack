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

    public Deck()   {
        
        newDeck();
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
}