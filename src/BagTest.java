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

    // a method to calculate the probability of getting a certain coin

    /**
     * Example one will add two of each coins to the bag, it will then remove one quarter and one dime
     * It will calculate the probability of picking a quarter, then the probability of picking a dime
     * Afterwards it will calculate the probablility of picking both a quarter and a dime one after the other
     * @param aBag
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
        double probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a dime
        double probabilityOfDime = (double) aBag.getFrequencyOf(dime) / aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a quarter and a dime one after the other
        double probabilityOfQuarterAndDime = probabilityOfQuarter * probabilityOfDime;
        System.out.println("The probability of picking a quarter and a dime one after the other is: " + probabilityOfQuarterAndDime);

        aBag.clear();
    }

    /**
     * Example two will add 4 quarters to the bag and 2 dimes and one penny and nickel
     * it will calculate the probability of picking every coin then remove a random coin and display what was removed
     * it will then calculate the probability of picking every coin again and display the results
     * it will then remove another random coin and display what was removed
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
        double probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        // calculate the probability of picking a dime
        double probabilityOfDime = (double) aBag.getFrequencyOf(dime) / aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        // calculate the probability of picking a nickel
        double probabilityOfNickel = (double) aBag.getFrequencyOf(nickel) / aBag.getCurrentSize();
        System.out.println("The probability of picking a nickel is: " + probabilityOfNickel);
        // calculate the probability of picking a penny
        double probabilityOfPenny = (double) aBag.getFrequencyOf(penny) / aBag.getCurrentSize();
        System.out.println("The probability of picking a penny is: " + probabilityOfPenny);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        // calculate the probability of picking a quarter
        probabilityOfQuarter = (double) aBag.getFrequencyOf(quarter) / aBag.getCurrentSize();
        System.out.println("The probability of picking a quarter is: " + probabilityOfQuarter);
        // calculate the probability of picking a dime
        probabilityOfDime = (double) aBag.getFrequencyOf(dime) / aBag.getCurrentSize();
        System.out.println("The probability of picking a dime is: " + probabilityOfDime);
        // calculate the probability of picking a nickel
        probabilityOfNickel = (double) aBag.getFrequencyOf(nickel) / aBag.getCurrentSize();
        System.out.println("The probability of picking a nickel is: " + probabilityOfNickel);
        // calculate the probability of picking a penny
        probabilityOfPenny = (double) aBag.getFrequencyOf(penny) / aBag.getCurrentSize();
        System.out.println("The probability of picking a penny is: " + probabilityOfPenny);
        //remove a random coin and display what was removed
        System.out.println("The coin removed was: " + aBag.remove());
        //calculate the probability of removing a quarter and a dime in a row
        double probabilityOfQuarterAndDime = probabilityOfQuarter * probabilityOfDime;
        System.out.println("The probability of picking a quarter and a dime one after the other is: " + probabilityOfQuarterAndDime);

        aBag.clear();
    } //end example two

    //currently broken
    public static void exampleThree(BagInterface<Coin> aBag) {
        addRandomCoins(aBag);
        displayBag(aBag);
        //pick three random coins from the bag and calculate the probability of picking each coin one after another
        Coin coin1 = aBag.remove();
        Coin coin2 = aBag.remove();
        Coin coin3 = aBag.remove();
        double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / aBag.getCurrentSize();
        double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / aBag.getCurrentSize();
        double probabilityOfCoin3 = (double) aBag.getFrequencyOf(coin3) / aBag.getCurrentSize();
        double probabilityOfCoin1Coin2Coin3 = probabilityOfCoin1 * probabilityOfCoin2 * probabilityOfCoin3;
        System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " then a " + coin3 + " is: " + probabilityOfCoin1Coin2Coin3);
        aBag.clear();
    }

    public static void exampleFour(BagInterface<Coin> aBag) {
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(quarter);
        aBag.add(dime);
        aBag.add(dime);
        aBag.add(dime);
        aBag.add(nickel);
        aBag.add(nickel);
        displayBag(aBag);
        //the next method will remove two coins
        probabilityOfPickingTwoCoins(aBag);
        //the next method will remove three coins from the bag
        probabilityOfPickingThreeCoins(aBag);
        aBag.clear();
    }

    public static Double probabilityOfPickingTwoCoins(BagInterface<Coin> aBag) {
        double probabilityOfPickingTwoCoins = 0;
        for (int i = 0; i < aBag.getCurrentSize(); i++) {
            Coin coin1 = aBag.remove();
            System.out.println("Coin removed: " + coin1);
            for (int j = 0; j < aBag.getCurrentSize(); j++) {
                Coin coin2 = aBag.remove();
                System.out.println("Coin removed: " + coin2);
                double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / aBag.getCurrentSize();
                double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / aBag.getCurrentSize();
                double probabilityOfCoin1Coin2 = probabilityOfCoin1 * probabilityOfCoin2;
                System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " is: " + probabilityOfCoin1Coin2);
                probabilityOfPickingTwoCoins += probabilityOfCoin1Coin2;
            }
        }
        return probabilityOfPickingTwoCoins;
    }

    public static Double probabilityOfPickingThreeCoins(BagInterface<Coin> aBag) {
        double probabilityOfPickingThreeCoins = 0;
        for (int i = 0; i < aBag.getCurrentSize(); i++) {
            Coin coin1 = aBag.remove();
            System.out.println("Coin removed: " + coin1);
            for (int j = 0; j < aBag.getCurrentSize(); j++) {
                Coin coin2 = aBag.remove();
                System.out.println("Coin removed: " + coin2);
                for (int k = 0; k < aBag.getCurrentSize(); k++) {
                    Coin coin3 = aBag.remove();
                    System.out.println("Coin removed: " + coin3);
                    double probabilityOfCoin1 = (double) aBag.getFrequencyOf(coin1) / aBag.getCurrentSize();
                    double probabilityOfCoin2 = (double) aBag.getFrequencyOf(coin2) / aBag.getCurrentSize();
                    double probabilityOfCoin3 = (double) aBag.getFrequencyOf(coin3) / aBag.getCurrentSize();
                    double probabilityOfCoin1Coin2Coin3 = probabilityOfCoin1 * probabilityOfCoin2 * probabilityOfCoin3;
                    System.out.println("The probability of picking a " + coin1 + " then a " + coin2 + " then a " + coin3 + " is: " + probabilityOfCoin1Coin2Coin3);
                    probabilityOfPickingThreeCoins += probabilityOfCoin1Coin2Coin3;
                }
            }
        }
        return probabilityOfPickingThreeCoins;
    }





} //ends class
