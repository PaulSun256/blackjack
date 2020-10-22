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

public class Dealer	{
    
    public Dealer() {

        super("Dealer", 999999999);
    }

// methods
// --------------------------------------------------------------------------------------------------------------------------------------------------
    public String showHand()    {
        
        // we aren't supposed to see the dealer's hand
        return getSuits(hand[i]) + "?";
    }
}