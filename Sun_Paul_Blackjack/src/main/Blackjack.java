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
        
        int money = nextInt("Please enter how much money you have: ");

        // initialize all the objects and vaiables
        Player human = new Player(name, money);
        Dealer deal = new Dealer();
        Deck cards = new Deck();
        Jokes joker = new Jokes();
        String continuePlaying = "y";
        boolean hit;
        int wager;

        while (continuePlaying.equalsIgnoreCase("y"))  {
            
            // prints out the cards
            spacer();
            System.out.println(cards + "\n\n");
            cards.shuffle();
            System.out.println(cards);
            spacer();

            // keeps asking user for how much they want to bet as long as they don't enter a proper number
            wager = nextInt("How much do you want to bet: ");
            while (wager > human.getMoney())   {

                wager = nextInt("That's too much! Enter a realistic number: ");
            }

            spacer();
            
            // at the start of blackjack, players and dealers get 2 cards
            human.hit(cards.nextCard());
            human.hit(cards.nextCard());
            deal.hit(cards.nextCard());
            deal.hit(cards.nextCard());

            // show the hands
            System.out.println("Dealers hand: " + deal.showHand());
            System.out.println(human.getName() + "'s hand: " + human.showHand() + "  total: " + human.getTotal());

            spacer();

            // asks the user if they want to hit, this is to start the loop
            hit = hitOrStand();
            if(hit) human.hit(cards.nextCard());

            // if the player didn't want to stand, this will keep asking them if they want to hit so long as they remain under 21
            while (hit && human.getTotal() < 21)  {

                System.out.println("Dealers hand: " + deal.showHand());
                System.out.println(human.getName() + "'s hand: " + human.showHand() + "  total: " + human.getTotal());
                
                spacer();
                hit = hitOrStand();
                if(hit) human.hit(cards.nextCard());
            }

            // in blackjack, the dealer only starts to hit after the player is done. Here, the dealer keeps hitting till they are at or over 17
            if (human.getTotal() < 21)  {
                
                while (deal.getTotal() < 17)    {
                    
                    deal.hit(cards.nextCard());
                }
            }

// win conditions
// __________________________________________________________________________________________________________________________________________________

            // if the player got over 21, they bust and lose
            if (human.getTotal() > 21)  {

                showHands(deal, human);

                System.out.println("\nYou lost!");
                
                System.out.println("Dealer says: " + joker.nextFunny());

                System.out.println("\nYou lost $" + wager);
                human.setMoney(human.getMoney() - wager);
                System.out.println("Your balance: $" + human.getMoney());

            // if they got a blackjack, we need to check if the dealer also got one. The dealer always wins in a tie, so if the dealer also got blackjack, dealer wins.
            }else if (human.getTotal() == 21)   {

                showHands(deal, human);

                if(deal.getTotal() != 21)   {

                    System.out.println("\nYou won!");

                    System.out.println(joker.nextFunny());

                    System.out.println("\nYou won $" + wager);
                    human.setMoney(human.getMoney() + wager);

                }else   {

                    System.out.println("\nYou lost!");
                    
                    System.out.println("Dealer says: " + joker.nextFunny());

                    System.out.println("\nYou lost $" + wager);
                    human.setMoney(human.getMoney() - wager);
                }

                System.out.println("Your balance: $" + human.getMoney());

            // if the player got less than 21, then we need to check if the dealer got something equal or higher than the player, while being under 22
            }else if (human.getTotal() < 21)    {

                showHands(deal, human);

                if(deal.getTotal() < human.getTotal() || deal.getTotal() > 21)   {

                    System.out.println("\nYou won!");

                    System.out.println(joker.nextFunny());

                    System.out.println("\nYou won $" + wager);
                    human.setMoney(human.getMoney() + wager);

                }else   {

                    System.out.println("\nYou lost!");
                    
                    System.out.println("Dealer says: " + joker.nextFunny());

                    System.out.println("\nYou lost $" + wager);
                    human.setMoney(human.getMoney() - wager);
                }

                System.out.println("Your balance: $" + human.getMoney());
            }

            spacer();

            continuePlaying = playAgain();

            // we reset the players and cards after each round. Jokes automatically refill so thats fine
            human.reset();
            deal.reset();
            cards.newDeck();
        }
    }

    // a method to print a big line of hyphens, as a spacer
    public static void spacer()  {

        System.out.println("\n" + new String(new char[20]).replace("\0", "---") + "\n");
    }

    // this is to make sure the user doesn't crash the program by slipping on a key
    public static int nextInt(String prompt)    {

        Scanner input = new Scanner(System.in);

        while (true)    {

            System.out.println(prompt);
            String moneyString = input.nextLine();
            int money = 0;

            try {
                
                money = Integer.parseInt(moneyString);
                return money;
            } catch (Exception e)   {

                System.out.println("\nyou entered something thats not a number");
            }
        }
    }

    // this is to make sure the user doesn't accidentally type the wrong key when prompted to hit
    public static boolean hitOrStand()   {

        Scanner input = new Scanner(System.in); 

        System.out.println("Hit or stand? (h / s)");
        String hit = input.nextLine();

        while (!(hit.equalsIgnoreCase("h") || hit.equalsIgnoreCase("s")))   {

            System.out.println("Hit or stand? (h / s)");
            hit = input.nextLine();
        }

        return hit.equalsIgnoreCase("h");
    }

    // this stops the loop from exiting when the player makes a typo
    public static String playAgain()    {

        Scanner input = new Scanner(System.in); 

        System.out.println("Would you like to play again? (y / n)");
        String yesOrNo = input.nextLine();

        while (!(yesOrNo.equalsIgnoreCase("y") || yesOrNo.equalsIgnoreCase("n")))   {

            System.out.println("Would you like to play again? (y / n)");
            yesOrNo = input.nextLine();
        }

        return yesOrNo;
    }

    // shows the complete hand of the dealer and of the player
    public static void showHands(Dealer dealer, Player player)  {

        spacer();
        System.out.println("Dealers hand: " + dealer.showRealHand() + " total: " + dealer.getTotal());
        System.out.println(player.getName() + "'s hand: " + player.showHand() + "  total: " + player.getTotal());
    }
}