package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Calculator {

    public Calculator() {
    }
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        do {
            System.out.println("Scientific Calculator using DevOps. \n Choose operation:");
            System.out.print("1. Factorial\n2. Square root\n3. Power\n4. Natural Logarithm\n" +
                    "5. Sum\n6. Exit\nEnter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException error) {
                return;
            }
            //Test commit

            switch (choice) {
                case 1:
                    // Factorial
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Factorial of "+number1+" is : " + calculator.factorial(number1));
                    System.out.println("\n");


                    break;
                case 2:
                    // Square root
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Square root of "+number1+" is : " + calculator.squareRoot(number1));
                    System.out.println("\n");


                    break;
                case 3:
                    // Power
                    System.out.print("Enter the first number : ");
                    number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    number2 = scanner.nextDouble();
                    System.out.println(number1+ " raised to power "+number2+" is : " + calculator.power(number1, number2));
                    System.out.println("\n");
                    break;
                case 4:
                    // Natural log
                    System.out.print("Enter a number : ");
                    number1 = scanner.nextDouble();
                    System.out.println("Natural log of "+number1+" is : " + calculator.naturalLog(number1));
                    System.out.println("\n");

                    break;
                case 5:
                    // Sum just for checking
                    System.out.print("Enter two number : ");
                    number1 = scanner.nextDouble();
                    number2 = scanner.nextDouble();
                    System.out.println("Sum  of "+number1+" and "+number2+"is : " + calculator.add(number1,number2));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }


    public double factorial(double number1) {
        double result = fact(number1);
        return result;
    }



    public double squareRoot(double number1) {
        double result = Math.sqrt(number1);
        return result;
    }

//Testing Webhook COmment
    public double power(double number1, double number2) {
        double result = Math.pow(number1,number2);
        return result;
    }

    public double naturalLog(double number1) {
        double result = 0;
        try {

            if (number1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(number1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        return result;
    }
    public double fact(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }
    public double add(double n1,double n2)
    {
      double sum_i=n1+n2;
    return sum_i;
}

// Testing Webhook working or not

}
