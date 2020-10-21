/*
+========================================+
|              Player class              |
+========================================+
|          Paul Sun, 2020/10/20          |
+========================================+
|              ICS3U Ms. S               |
+========================================+
|   This is the class for the player. A  |
| play has their cards, the total number |
|  of cards they have, and the value of  |
|               their hand.              |
+========================================+
*/
import java.util.*;

public class Player	{

    protected int hand[] = new int[11]; // 11 cards is the maximum number of cards you can get and stay in the game
    protected static String suits[] = new String[4];
    protected static String ranks[] = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
    protected int totalCards;
    protected int totalValue;
    protected String name;
    protected int money;

    public Player(String aname, int amoney) {

        name = aname;
        money = amoney;

        totalCards = 0;
        totalValue = 0;

        // I don't use windows, but the teacher does, so I have to be able to change to the proper
        // character encoding automatically.
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

// methods
// --------------------------------------------------------------------------------------------------------------------------------------------------
    public void hit(int card)   {

        hand[totalCards++] = card;
        totalValue += getValue(card);
    }

    protected int getValue(int card)    {

        card = card % 13;
        
        // if it's a joker - king, it's value is 10
        if (card >= 10) card = 10;
        else if (card == 0) card = (totalValue + 11 > 21) ? 1 : 11; // determines which ace to use
        
        // otherwise we just add one to it, since 2 - 10 are indices 1 - 9, so we add one to the index (card ID comes as indices 0 - 51)
        else card += 1;

        return card;
    }

    protected String getSuits(int card)    {

        String rank = "";
        String suit = "";

        suit = suits[card / 13];
        rank = ranks[card % 13];

        return rank + suit;
    }

    public String showHand()    {
        
        String handShow = "";

        for (int i = 0; i <= totalCards; i++)   handShow += getSuits(hand[i]);

        return handShow;
    }


// the getters and setters
// --------------------------------------------------------------------------------------------------------------------------------------------------
    
    // gets the total value of the hand
    public int getTotal()   {

        return totalValue;
    }

    // gets the total number of cards
    public int getTotalCards()  {

        return totalCards;
    }

    // gets the player name
    public int getName()    {
        
        return name;
    }

    // gets their balance
    public int getMoney()   {
        
        return money;
    }

    // sets how much money they have now
    public void setMoney(int amount)   {

        money = amount;
    }
}