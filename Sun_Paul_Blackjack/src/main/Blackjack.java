/*
+========================================+
|               Blackjack                |
+========================================+
|          Paul Sun, 2020/10/20          |
+========================================+
|              ICS3U Ms. S               |
+========================================+
|  Blackjack, but with a lot of classes  |
|               and stuff.               |
+========================================+
*/
import java.util.*;

public class Blackjack	{

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        
        int money;

        while (true)    {

            System.out.println("Please enter how much money you have: ");
            String moneyString = input.nextLine();

            try {
                
                money = Integer.parseInt(moneyString);
                break;
            } catch (Exception e)   {
            }
        }

        Player human = new Player(name, money);
        Player deal = new Dealer();
        Deck cards = new Deck();
        Jokes joker = new Jokes();
        String continuePlaying = "yes";

        while (continuePlaying.equalsIgnoreCase("yes"))  {

            System.out.println(cards);
            cards.shuffle();
            System.out.println(cards);

            System.out.println("")
        }
    }
}