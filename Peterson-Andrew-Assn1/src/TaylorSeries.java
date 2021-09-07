import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class TaylorSeries {
    /**
     * this class will find the value of e using the taylor series
     */
    public TaylorSeries(){
    }

    /**
     * this will display the output to the user
     * @param n is the value given by the user
     */
    public void displayE(int n){
        if(checkNumberRange(n)){
            MathContext round = new MathContext(17);
            BigDecimal e = calculateE(n);
            System.out.println("Value of e using " + n + " iterations is " + e.round(round));
        }
    }

    /**
     * makes sure that the value is within allowable range
     * @param value is the value given by the user
     * @return true if it is in range and false if it is out of range
     */
    private boolean checkNumberRange(int value){
        if(value < 1 || value > 2147483647){
            System.out.println("Valid e iteration range is [1, 2147483647]");
            return false;
        }
        return true;
    }

    /**
     * this will calculate the value of e using the taylor series
     * @param n is number of iterations given by the user
     * @return the value of e based on the number of iterations
     */
    private BigDecimal calculateE(int n){
        if(n < 2){//base case
            return new BigDecimal("2");
        }
        Factorial factorial = new Factorial();
        BigDecimal e = new BigDecimal("2");
        for(int i = 2; i < n; i++){
            MathContext precision = new MathContext(100);
            BigInteger fact = factorial.calculateFactorial(i);
            //this is basically saying e = e + 1/i!
            e = e.add((new BigDecimal("1")).divide(new BigDecimal(fact.toString()), precision));
        }
        return e;
    }
}
