/**
 * Generic coin class that is supposed to represent a coin with no value or name
 * The coin is mean to have a heads and tails side and be tossed
 * You can then tell which side is up
 * @author Christopher Leach
 */

public class GenericCoin implements CoinInterface {
//this class is supposed to represent a coin with no value or name
    //the coin should have a heads side and a tails side and should be able to tell which side is up    
    private String sideUp;
    private final String heads = "heads";
    private final String tails = "tails";
    /**
     * Default constructor for the GenericCoin class
     * I left it as default to tails because heads only get counted
     */
    public GenericCoin() {
        sideUp = tails;
    }
    
    /**
     * toss method that will randomly select a side of the coin
     */
    public void toss() {
        if (Math.random() > 0.5) {
            sideUp = heads;
        } else {
            sideUp = tails;
        }
    } //end toss

    /**
     * getSideUp method that will return the side that is currently up
     * @return String sideUp
     */
    public String getSideUp() {
        return sideUp;
    }
}
