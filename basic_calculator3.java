
/*
Author : Aditya Ranjan Samal
Github-ID : adityaranjansamal
Telegram-ID : Aditya Ranjan Samal @adityarnsamal
Registration Number : 2241019245
 */
import java.util.*;

public class basic_calculator3 {
    static double x = 0.0d, y = 0.0d, soln = 0.0d;
    static char opt = ' ';// option to store the operator input
    static String hist[];// array to store complete calculation history
    static int i = -1;// i is the iterator for the history array
    static int i2 = -1;// i2 is the control for switching between two input arguments and one input
                       // argument by the user

    public static void main(String args[]) throws InputMismatchException {
        hist = new String[1000];// max size of the array is declared here
        System.out.println(
                "This is a basic mathematical calculator. \nThis supports (+), (-), (*), (/), (%), (^) functions. \nEnter ($) to show history. \nEnter (A) to clear All and input from start. \nEnter (#) to exit the calculator.");
        System.out.println(
                "INSTRUCTIONS\nEnter the number and operator to calculate. This only supports two arguments & one operator. Enter them line by line.");
        System.out.println(
                "Enter in this way.\n 2 Press Enter \n + Press Enter \n 3 Press Enter \n Result=.... \n * Press Enter \n 4 Press Enter \n Result=....\n ***CALCULATOR IS READY***");
        startinput();// invokes the input function

    }

    public static void startinput() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        while (true) {
            opt = sc.next().charAt(0);
            if (opt == '+' || opt == '-' || opt == '*' || opt == '/' || opt == '%' || opt == '^')// when correct
                                                                                                 // operator is entered
            {
                if (i2 != -1)// this control statement is used to switch between two input and one input
                             // argument
                    x = soln;
                else
                    i2 = 1;
                y = sc.nextDouble();
                calc();
            } else if (opt == '$') {
                if (i2 != -1)
                    printhistory();
                else {
                    System.out.println("Do a minimum of one operation to invoke this function.");
                    i2 = -1;// restores the initial value of i2
                    continue;
                }
            } else if (opt == 'A') {
                System.out.println("All things are clear. Enter two arguments.");
                i2 = -1;// restores the initial value of i2 to accept two arguments
                x = sc.nextDouble();
                continue;
            } else if (opt == '#') {
                System.out.println("Thanks for using my Calculator. Exiting...");
                System.exit(0);// exits from the program
            } else {
                System.out.println("Enter the correct operator");
                continue;// loopback to enter the operator once again
            }

        }
    }

    public static void calc()// this function is used to calculate the operations
    {
        switch (opt) {
            case '+':
                soln = x + y;
                i++;
                break;
            case '-':
                soln = x - y;
                i++;
                break;
            case '*':
                soln = x * y;
                i++;
                break;
            case '/':
                soln = x / y;
                i++;
                break;
            case '%':
                soln = x % y;
                i++;
                break;
            case '^':
                soln = Math.pow(x, y);
                i++;
                break;
            case '$':
                printhistory();
                break;
        }
        System.out.println("Result=" + soln);
        hist[i] = String.valueOf(x) + opt + String.valueOf(y) + "=" + String.valueOf(soln);// stores the expression
    }

    public static void printhistory()// prints the calculation history
    {
        int k;
        for (k = 0; k <= i; k++) {
            System.out.println(hist[k]);
        }

    }

}
