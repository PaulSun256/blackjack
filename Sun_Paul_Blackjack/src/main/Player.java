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

public class Player	{
    protected int hand[] = new int[11]; // 11 cards is the maximum number of cards you can get and stay in the game
    protected int totalCards;
    protected int totalValue;
    protected String name;
    protected int money;

    public Player(String aname, int amoney) {

        name = aname;
        money = amoney;

        totalCards = 0;
        totalValue = 0;
    }

    public void hit(int card)   {
        hand[totalCards] = card;
        totalCards++;
        totalValue += 
    }

    protected int getValue(int card)    {

    }
}