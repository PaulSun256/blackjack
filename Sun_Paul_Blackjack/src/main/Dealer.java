/*
+========================================+
|              Dealer class              |
+========================================+
|          Paul Sun, 2020/10/20          |
+========================================+
|              ICS3U Ms. S               |
+========================================+
|   This is the class for the dealer in  |
|   blackjack. He / she can deal cards,  |
|  and you cannot see all of their cards |
|       using the showHand method.       |
+========================================+
*/

public class Dealer	extends Player{
    
    public Dealer() {

        super("Dealer", 999999999);
    }

// methods
// --------------------------------------------------------------------------------------------------------------------------------------------------
    public String showHand()    {
        
        // we aren't supposed to see the dealer's hand
        return getSuits(hand[0]) + "?";
    }

    public String showRealHand()    {
        
        String handShow = "";

        // loop through the player's hand and 'translates' the card IDs to text
        for (int i = 0; i <= totalCards; i++)   handShow += getSuits(hand[i]);

        return handShow;
    }
}