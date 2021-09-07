import java.io.IOException;

public class Assign1 {
    /**
     * Program starts here. Make sure that valid arguments have been called and then calls classes to perform computation
     * @param args contains the arguments given from the command line
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //in the case of no or invalid number of parameters
        if(args.length == 0 || args.length % 2 != 0){
            printHelpInstructions();
        } else {
            //this means that the argument is all good length wise.
            Fibonacci fib = new Fibonacci();
            Factorial fac = new Factorial();
            TaylorSeries e = new TaylorSeries();
            for (int i = 0; i < args.length; i += 2) {
                try {//in case it isnt an integer
                    int value = Integer.parseInt(args[i + 1]);
                    if (args[i].equals("-fib")) {
                        fib.display(value);
                    } else if (args[i].equals("-fac")) {
                        fac.display(value);
                    } else if (args[i].equals("-e")) {
                        e.displayE(value);
                    } else {//this is in case they use an argument other than fib, fac, or e.
                        printHelpInstructions();
                        System.out.println("--- Error: Must use the following for your arguments --- \n\t\t1.-fac \n\t\t2.-fib \n\t\t3.-e");
                        break;
                    }
                } catch (NumberFormatException ex) {//this is in case they used something other than a number for [n]
                    System.out.println("--- Error: Must insert an integer in place of [n] for -fib [n], -fac [n], -e [n] ---");
                }
            }
        }
    }

    /**
     * this will print out help instructions when called
     */
    public static void printHelpInstructions(){
        System.out.println("--- Assign 1 Help ---");
        System.out.println("\t-fib [n] : Compute the Fibonacci of [n]; valid range [0, 40]");
        System.out.println("\t-fac [n] : Compute the factorial of [n]; valid range [0, 2147483647]");
        System.out.println("\t-e [n] : Compute the value of 'e' using [n] iterations; valid range [1, 2147483647]");
    }

}
