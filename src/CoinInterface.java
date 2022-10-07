/**
     * interface that defines the methods that a GenericCoin must implement
     * @author Christopher Leach
*/
public interface CoinInterface {
     /**
      * toss method that will randomly select a side of the coin
      */
     void toss();
     /**
      * getSideUp method that will return the side that is currently up
      * @return String sideUp
      */
     String getSideUp();
} // end CoinInterface
