/**
 * as the name implies this is the class for performing fibonacci calculations and displaying it
 */
public class Fibonacci {
    public Fibonacci(){
    }

    /**
     * performs fibonacci calculation
     * @param value is the value the user wanted to have fibonacci performed on
     * @return the calculated Fibonacci number
     */
    private int calculateFibonacci(int value){
        if(value < 2){//base case
            return 1;
        } else {
            return calculateFibonacci(value - 1) + calculateFibonacci(value - 2);
        }
    }

    /**
     * displays answer we output to user
     * @param value
     */
    public void display(int value){
        if(checkNumberRange(value)){
            int fibValue = calculateFibonacci(value);
            System.out.printf("Fibonacci of %d is %d \n", value, fibValue);
        }
    }

    /**
     * makes sure that the value is in valid range and prints output if it is not
     * @param value is the value given by the user
     * @return true if its in range and false if its out of range
     */
    private boolean checkNumberRange(int value){
        if(value < 0 || value > 40){
            System.out.println("Fibonacci valid range is [0, 40]");
            return false;
        }
        return true;
    }
}
