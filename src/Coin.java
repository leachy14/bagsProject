/**
   * Coin class that extends the GenericCoin class
   * this can be used to represent a coin with a name and a value
   * @author Christopher Leach
 */
public class Coin extends GenericCoin {
    private String type;
    private double value;

    /**
     * Default constructor for the coin class
     * by default the coin has no value or name
     */
    public Coin() {
        type = "generic";
        value = 0;
    }
    /**
     * Alternative constructor that will allow the user to set the name and value of the coin
     * @param type the type of the coin
     * @param value the value of the coin
     */
    public Coin(String type, double value) {
        setType(type);
        setValue(value);
    }

    /**
     * These are getters and setters for the type and value of the coin 
     * @param type the type of the coin
     */
    private void setType(String type) {
        this.type = type;
    }
    private void setValue(double value) {
        this.value = value;
    }

    /**
     * These are getters for the type and value of the coin
     * @return the type and value of the coin
     */
    public String getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
    public String getString() {
        return toString();
    }

    public boolean equals(Object c) {
        boolean result = false;
        if(c instanceof Coin) {
            Coin coin = (Coin) c;
            result = value == coin.getValue();
        }
        return result;
    }
    /**
     * This method will return a string representation of the coin
     * @return a string representation of the coin
     */
    @Override
    public String toString() {
        return type + " " + value;
    }
}
