/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
                
                // REUSABLE ASSETS
            String[] ranks = {"ace", "two", "three", "four", "five", "six", 
                "seven", "eight", "nine", "ten", "jack", "queen", "king"};
            String[] suits = {"clubs", "hearts", "diamonds", "spades"};
            int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
            
            /***** EXAMPLE DECK 1 *****/
            System.out.println(" ---Testing Deck 1--- ");
            
            // create a deck
            Deck dMoney = new Deck(ranks, suits, pointValues);
            
            //test its size
            System.out.println("There are " + dMoney.size() + " Cards");
            
            // deal one card
            Card x = dMoney.deal();
            System.out.println("I just dealt this card: " + x);
            System.out.println("Now my deck size is " + dMoney.size());
            
            // test two strings
            System.out.println(dMoney);
            
            /***** EXAMPLE DECK 2 *****/
            System.out.println(" ---Testing Deck 2--- ");
            String[] job = {"plumber", "banker", "accountant", "manager", "ceo", "unemployed", 
                "pirate", "driller", "CEO", "stuntman", "actress", "actor", "surfer"};
            String[] wealth = {"poor", "Lower mid", "upper mid", "rich"};
            int[] dollars = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130};
            // create a deck
            Deck decky = new Deck(job, wealth, dollars);  
            
            //test its size
            System.out.println("There are " + decky.size() + " cards");
            
            // deal until empty
            while(!decky.isEmpty()){
                decky.deal();
            }
            System.out.println(decky);
            
	}
}

