import java.math.BigInteger;

/**
 * this class performs all computations and displays for factorials
 */
public class Factorial {
    public Factorial(){
    }

    /**
     * this will display the output to the user
     * @param value if value given by user
     */
    public void display(int value){
        if(checkNumberRange(value)){
            BigInteger facValue = calculateFactorial(value);
            System.out.printf("Factorial of %d is %d\n", value, facValue);
        }
    }

    /**
     * calculates the factorial
     * @param value is the value given by the user
     * @return the calculated factorial based of value given by user
     */
    public BigInteger calculateFactorial(int value){
        if(value < 2){//base case
            return new BigInteger("1");
        }
        return BigInteger.valueOf(value).multiply(calculateFactorial(value - 1));
    }

    /**
     * makes sure that the value given is within valid range
     * @param value is the value given by the user
     * @return true if its in range and false if it is out of range
     */
    private boolean checkNumberRange(int value){
        if(value < 0 || value > 2147483647){
            System.out.println("Factorial valid range is [0, 2147483647]");
            return false;
        }
        return true;
    }
}
