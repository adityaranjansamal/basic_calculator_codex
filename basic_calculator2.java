
/*
Author : Aditya Ranjan Samal
Github-ID : adityaranjansamal
Telegram-ID : Aditya Ranjan Samal
Registration Number : 2241019245
 */
import java.util.*;

public class basic_calculator2 {
    static double x = 0.0d, y = 0.0d, soln = 0.0d;
    static char c = '+';

    public static void main(String args[]) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "This is a basic mathematical calculator. \nThis supports (+), (-), (*), (/) functions. \nEnter ($) to show history. \nEnter (#) to exit the calculator.");
        System.out.println(
                "INSTRUCTIONS\nEnter the number and operator to calculate. This only supports two arguments & one operator. Enter them line by line.");
        System.out.println(
                "Enter in this way.\n 2 Press Enter \n + Press Enter \n 3 Press Enter \n Result=.... \n * Press Enter \n 4 Press Enter \n Result=....\n ***CALCULATOR IS READY***");
        int i = 0;
        String hist[];// Array that stores the complete history along with arguments & operator
        int j = 1;
        hist = new String[1000];// Maximum memory size of the array
        x = sc.nextDouble();// Accepts the first number
        for (; j > 0; j++) {// loopback to execute this block until termination using '#' or condition j>0
                            // is unsatisfied
            c = sc.next().charAt(0);
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '$' && c != '#') {
                System.out.println("Enter the correct operator!");
            } else {
                if (c == '#') {
                    System.out.println("Thanks for using my Calculator. Exiting...");
                    System.exit(0);// exits from the program
                }
                y = sc.nextDouble();// Accepts the second number
                System.out.println("_______");
                if (c == '+') {
                    soln = x + y;// Does the Addition
                    System.out.println("Result=" + soln);
                }
                if (c == '-') {
                    soln = x - y;// Does the Subtraction
                    System.out.println("Result=" + soln);
                }
                if (c == '*') {
                    soln = x * y;// Does the Multiplication
                    System.out.println("Result=" + soln);
                }
                if (c == '/') {
                    soln = x / y;// Does the Division
                    System.out.println("Result=" + soln);
                }
                hist[0] = String.valueOf(x) + c + String.valueOf(y) + "=" + String.valueOf(soln);// stores the solution
                                                                                                 // at the '0' location
                                                                                                 // of the hist array
                ++i;// increments i before execution
                j = -1;// forcefully unsatisfies the condition to get out of the loop
            }
        }
        for (; i >= 0; i++) {// this loop is used to calculate using the value of the 'soln' variable as the
                             // first number
            c = sc.next().charAt(0);
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '$' && c != '#') {
                System.out.println("Enter the correct operator!");
                --i;// decrements 'i' if operator is entered wrong to ensure there is no null point
                    // in the hist[]
            } else {
                if (c == '#') {
                    System.out.println("Thanks for using my Calculator. Exiting...");
                    System.exit(0);// exits the code
                }
                if (c != '$')// if history is not being checked then only program will ask for number input
                    y = sc.nextDouble();
                System.out.println("_______");
                if (c == '+') {
                    hist[i] = String.valueOf(soln) + c + String.valueOf(y) + "=";
                    soln = soln + y;// does the Addition
                    System.out.println("Result=" + soln);
                    hist[i] = hist[i] + String.valueOf(soln);
                }
                if (c == '-') {
                    hist[i] = String.valueOf(soln) + c + String.valueOf(y) + "=";
                    soln = soln - y;// does the Subtraction
                    System.out.println("Result=" + soln);
                    hist[i] = hist[i] + String.valueOf(soln);
                }
                if (c == '*') {
                    hist[i] = String.valueOf(soln) + c + String.valueOf(y) + "=";
                    soln = soln * y;// does the Multiplication
                    System.out.println("Result=" + soln);
                    hist[i] = hist[i] + String.valueOf(soln);
                }
                if (c == '/') {
                    hist[i] = String.valueOf(soln) + c + String.valueOf(y) + "=";
                    soln = soln / y;// does the Division
                    System.out.println("Result=" + soln);
                    hist[i] = hist[i] + String.valueOf(soln);
                }
                if (c == '$') {
                    System.out.println("***History***");
                    for (int k = 0; k < i; k++)
                        System.out.println(hist[k]);
                    --i;// decrements 'i' if operator is entered '$' to check history, to ensure there
                        // is no null point in the hist[]
                }
            }
        }
    }

}
