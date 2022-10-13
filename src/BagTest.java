/**
 * This class will test the Bag class
 * The methods used are all to test the bags class as well as calculate probabilities
 * @author Christopher Leach
 * @version 1.0
 */
public class BagTest {

    public static Coin penny = new Coin("penny", 0.01);
    public static Coin nickel = new Coin("nickel", 0.05);
    public static Coin dime = new Coin("dime", 0.10);
    public static Coin quarter = new Coin("quarter", 0.25);

    public static void main(String[] args) {
        BagInterface<Coin> coinBag = new ResizableArrayBag<>();
        // test the bag methods
        System.out.println("Testing the bag methods");
        testBagsMethods(coinBag);
        // run example one
        System.out.println("Running example one");
        exampleOne(coinBag);
        // run example two
        System.out.println("Running example two");
        exampleTwo(coinBag);
        // run example three
        System.out.println("Running example three");
        exampleThree(coinBag);
        // run example four
        System.out.println("Running example four");
        exampleFour(coinBag);
        // run example five
        System.out.println("Running example five");
        exampleFive(coinBag);

        /*
         * I'm going to put the output in each example method as the output is quite lengthy
         * and I don't want to clutter up the main method
         */
    } //ends main


    public static void testBagsMethods(BagInterface<Coin> aBag) {
        aBag.add(new Coin("penny", 0.01));
        aBag.add(new Coin("nickel", 0.05));
        aBag.add(new Coin("nickel", 0.05));
        aBag.add(new Coin("nickel", 0.05));
        aBag.add(new Coin("nickel", 0.05));
        aBag.add(new Coin("dime", 0.10));
        aBag.add(new Coin("dime", 0.10));
        aBag.add(new Coin("nickel", 0.05));

        displayBag(aBag);
        System.out.println("The number of coins in the bag are: " + aBag.getCurrentSize());

        System.out.println("Test remove() : " + aBag.remove());
        System.out.println("The number of coins in the bag are: " + aBag.getCurrentSize());

        System.out.println("Test remove(anItem) : " + aBag.remove(dime));
        System.out.println("The number of coins in the bag are: " + aBag.getCurrentSize());
        displayBag(aBag);
        aBag.add(new Coin("dime", 0.10));
        aBag.add(new Coin("nickel", 0.05));

        System.out.println("The bag contians penny: " + aBag.contains(penny));
        System.out.println("The bag contains quarter: " + aBag.contains(quarter));

        System.out.println("Get the frequency of a penny: " + aBag.getFrequencyOf(penny));
        System.out.println("Get the frequency of a quarter: " + aBag.getFrequencyOf(quarter));
        System.out.println("Get the frequency of a dime: " + aBag.getFrequencyOf(dime));
        System.out.println("Get the frequency of a nickel: " + aBag.getFrequencyOf(nickel));

        //clear the bag
        aBag.clear();

        /**
         * output:
         * Testing the bag methods
         * The bag contains 8 coin(s), as follows:
         * penny 0.01
         * nickel 0.05
         * nickel 0.05
         * nickel 0.05
         * nickel 0.05
         * dime 0.1
         * dime 0.1
         * nickel 0.05
         *
         * The number of coins in the bag are: 8
         * Test remove() : nickel 0.05
         * The number of coins in the bag are: 7
         * Test remove(anItem) : true
         * The number of coins in the bag are: 6
         * The bag contains 6 coin(s), as follows:
         * penny 0.01
         * nickel 0.05
         * nickel 0.05
         * nickel 0.05
         * nickel 0.05
         * dime 0.1
         *
         * The bag contians penny: true
         * The bag contains quarter: false
         * Get the frequency of a penny: 1
         * Get the frequency of a quarter: 0
         * Get the frequency of a dime: 2
         * Get the frequency of a nickel: 5
         */
    } //ends testBagsMethods

    // tests toarray method
    private static void displayBag(BagInterface<Coin> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize() + " coin(s), as follows:");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.println(bagArray[index] + " ");
        } // end for
        System.out.println();
    } // end displayBag

    // a method to add 8 random coins to the bag
    public static void addRandomCoins(BagInterface<Coin> aBag) {
        for (int i = 0; i < 8; i++) {
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0 -> aBag.add(penny);
                case 1 -> aBag.add(nickel);
                case 2 -> aBag.add(dime);
                case 3 -> aBag.add(quarter);
            }
        }
    }


    /**
     * Example one will add two of each coins to the bag, it will then remove one quarter and one dime
     * It will calculate the probability of picking a quarter, then the probability of picking a dime
     * Afterwards it will calculate the probablility of picking both a quarter and a dime one after the other
     * @param aBag bag of coins
     */
    public static void exampleOne(BagInterface<Coin> aBag) {
        //add all the coins to the bag twice
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(dime);
        aBag.add(dime);
        aBag.add(nickel);
        aBag.add(nickel);
        aBag.add(penny);
        aBag.add(penny);
        displayBag(aBag);
        // calculate the probability of picking a quarter
        double probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / (double)aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a dime
        double probabilityOfDime =  (double) aBag.getFrequencyOf(dime) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a quarter and a dime one after the other
        double probabilityOfQuarterAndDime = probabilityOfQuarter * probabilityOfDime;
        System.out.println("The probability of picking a quarter and a dime one after the other is: " + probabilityOfQuarterAndDime);

        aBag.clear();

        /*
         * output:
         * Running example one
         * The bag contains 8 coin(s), as follows:
         * quarter 0.25
         * quarter 0.25
         * dime 0.1
         * dime 0.1
         * nickel 0.05
         * nickel 0.05
         * penny 0.01
         * penny 0.01
         *
         * The probability of picking a quarter is: 0.25
         * The coin removed was: penny 0.01
         * The probability of picking a dime is: 0.2857142857142857
         * The coin removed was: penny 0.01
         * The probability of picking a quarter and a dime one after the other is: 0.07142857142857142
         */
    }

    /**
     * Example two will add 4 quarters to the bag and 2 dimes and one penny and nickel
     * it will calculate the probability of picking every coin then remove a random coin and display what was removed
     * it will then calculate the probability of picking every coin again and display the results
     * it will then remove another random coin and display what was removed
     * @param aBag a bag of coins
     */
    public static void exampleTwo(BagInterface<Coin> aBag) {
        //add all the coins to the bag twice
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(dime);
        aBag.add(dime);
        aBag.add(nickel);
        aBag.add(penny);
        displayBag(aBag);
        // calculate the probability of picking a quarter
        double probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        // calculate the probability of picking a dime
        double probabilityOfDime = (double) aBag.getFrequencyOf(dime) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        // calculate the probability of picking a nickel
        double probabilityOfNickel = (double) aBag.getFrequencyOf(nickel) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a nickel is: " + probabilityOfNickel);
        // calculate the probability of picking a penny
        double probabilityOfPenny = (double) aBag.getFrequencyOf(penny) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a penny is: " + probabilityOfPenny);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a quarter
        probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        // calculate the probability of picking a dime
        probabilityOfDime = (double) aBag.getFrequencyOf(dime) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        // calculate the probability of picking a nickel
        probabilityOfNickel = (double) aBag.getFrequencyOf(nickel) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a nickel is: " + probabilityOfNickel);
        // calculate the probability of picking a penny
        probabilityOfPenny = (double) aBag.getFrequencyOf(penny) / (double) aBag.getCurrentSize();
        System.out.println("The probability of picking a penny is: " + probabilityOfPenny);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        //calculate the probability of removing a quarter and a dime in a row
        double probabilityOfQuarterAndDime = probabilityOfQuarter * probabilityOfDime;
        System.out.println("The probability of picking a quarter and a dime one after the other is: " + probabilityOfQuarterAndDime);

        aBag.clear();

        /*
         * output:
         * Running example two
         * The bag contains 8 coin(s), as follows:
         * quarter 0.25
         * quarter 0.25
         * quarter 0.25
         * quarter 0.25
         * dime 0.1
         * dime 0.1
         * nickel 0.05
         * penny 0.01
         *
         * The probability of picking a quarter is: 0.5
         * The probability of picking a dime is: 0.25
         * The probability of picking a nickel is: 0.125
         * The probability of picking a penny is: 0.125
         * The coin removed was: penny 0.01
         * The probability of picking a quarter is: 0.5714285714285714
         * The probability of picking a dime is: 0.2857142857142857
         * The probability of picking a nickel is: 0.14285714285714285
         * The probability of picking a penny is: 0.0
         * The coin removed was: nickel 0.05
         * The probability of picking a quarter and a dime one after the other is: 0.16326530612244897
         */
    } //end example two

    //currently broken

    /**
     * Example three adds random coins to the bag, then displays the bag
     * It then removes
     * @param aBag a bag of coins
     */
    public static void exampleThree(BagInterface<Coin> aBag) {
        addRandomCoins(aBag);
        displayBag(aBag);
        //pick three random coins from the bag and calculate the probability of picking each coin one after another
        Coin coin1 = aBag.remove();
        Coin coin2 = aBag.remove();
        Coin coin3 = aBag.remove();
        double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / (double) aBag.getCurrentSize();
        double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / (double) aBag.getCurrentSize();
        double probabilityOfCoin3 = (double) aBag.getFrequencyOf(coin3) / (double) aBag.getCurrentSize();
        double probabilityOfCoin1Coin2Coin3 = probabilityOfCoin1 * probabilityOfCoin2 * probabilityOfCoin3;
        System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " then a " + coin3 + " is: " + probabilityOfCoin1Coin2Coin3);
        aBag.clear();

        /*
        * output:
        * Running example three
        *  The bag contains 8 coin(s), as follows:
        *  quarter 0.25
        *  nickel 0.05
        *  penny 0.01
        *  nickel 0.05
        *  dime 0.1
        *  dime 0.1
        *  penny 0.01
        *  dime 0.1

         * The probability of picking a dime 0.1 then a penny 0.01 then a dime 0.1 is: 0.008000000000000002
         */
    }

    /**
     * This method will add some more coins manually and pick three coins from it
     * It will then call probability methods to determine the probability of picking random coins from the bag
     * @param aBag a bag of coins
     */
    public static void exampleFour(BagInterface<Coin> aBag) {
        aBag.add(nickel);
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(nickel);
        aBag.add(dime);
        aBag.add(quarter);
        aBag.add(nickel);
        aBag.add(dime);
        displayBag(aBag);
        //the next method will remove three coins from the bag
        probabilityOfPickingThreeCoins(aBag);
        aBag.clear();

        /*
        * output:
        * Running example four
        * The bag contains 8 coin(s), as follows:
        * nickel 0.05
        * quarter 0.25
        * quarter 0.25
        * nickel 0.05
        * dime 0.1
        * quarter 0.25
        * nickel 0.05
        * dime 0.1

        * The probability of picking a dime 0.1 then a nickel 0.05 then a quarter 0.25 is: 0.01904761904761905
         */

    }

    /**
     * This method will add 8 random coins to the bag and remove three coins from the bag
     * @param aBag a bag of coins
     */
    public static void exampleFive(BagInterface<Coin> aBag) {
        addRandomCoins(aBag);
        displayBag(aBag);
        //the next method will remove three coins from the bag
        probabilityOfPickingThreeCoins(aBag);
        aBag.clear();
        /*
        * output:
        * Running example five
        * The bag contains 8 coin(s), as follows:
        * nickel 0.05
        * nickel 0.05
        * nickel 0.05
        * dime 0.1
        * quarter 0.25
        * nickel 0.05
        * nickel 0.05
        * nickel 0.05

        * The probability of picking a nickel 0.05 then a nickel 0.05 then a nickel 0.05 is: 0.2857142857142857
         */
    }

    /**
     * this coin will take a bag of coins and remove two coins from it and return the probability of picking those two coins
     * @param aBag a bag of coins
     * @return the probability of picking two coins from the bag
     */
    public static Double probabilityOfPickingTwoCoins(BagInterface<Coin> aBag) {
        double probabilityOfPickingTwoCoins = 0;
        Coin coin1 = aBag.remove();
        double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / (double) aBag.getCurrentSize();
        Coin coin2 = aBag.remove();
        double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / (double) aBag.getCurrentSize();
        probabilityOfPickingTwoCoins = probabilityOfCoin1 * probabilityOfCoin2;
        System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " is: " + probabilityOfPickingTwoCoins);
        return probabilityOfPickingTwoCoins;

    }
    /**
     * this coin will take a bag of coins and remove three coins from it and return the probability of picking those three coins
     * @param aBag a bag of coins
     * @return the probability of picking three coins from the bag
     */
    public static Double probabilityOfPickingThreeCoins(BagInterface<Coin> aBag) {
        double probabilityOfPickingThreeCoins = 0;
        Coin coin1 = aBag.remove();
        double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / (double) aBag.getCurrentSize();
        Coin coin2 = aBag.remove();
        double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / (double) aBag.getCurrentSize();
        Coin coin3 = aBag.remove();
        double probabilityOfCoin3 = (double) aBag.getFrequencyOf(coin3) / (double) aBag.getCurrentSize();
        probabilityOfPickingThreeCoins = probabilityOfCoin1 * probabilityOfCoin2 * probabilityOfCoin3;
        System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " then a " + coin3 + " is: " + probabilityOfPickingThreeCoins);
        return probabilityOfPickingThreeCoins;
    }





} //ends class
