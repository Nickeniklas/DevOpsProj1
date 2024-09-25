import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator\nWrite 1 for addition 2 for subtraction and 3 for multiplication 4 for division or 5 to quit");

        Scanner userInput = new Scanner(System.in);
        //  Ask user for type of calculation
        int userMathChoice = Integer.parseInt(userInput.nextLine());

        while(userMathChoice != 5) {
            //  Ask for the two numbers
            System.out.println("Write a number: ");
            int userN1 = Integer.parseInt(userInput.nextLine());
            System.out.println("Write another number: ");
            int userN2 = Integer.parseInt(userInput.nextLine());
            //  1. Addition
            if (userMathChoice == 1) {
                int mathSolved = userN1 + userN2;
                System.out.printf("%d + %d = %d\n",
                        userN1,
                        userN2,
                        mathSolved);
            }
            //  2. Subtraction
            if (userMathChoice == 2) {
                int mathSolved = userN1 - userN2;
                System.out.printf("%d - %d = %d\n",
                        userN1,
                        userN2,
                        mathSolved);
            }
            //  3. Multiplication
            if (userMathChoice == 3) {
                int mathSolved = userN1 * userN2;
                System.out.printf("%d * %d = %d\n",
                        userN1,
                        userN2,
                        mathSolved);
            }
            //  4. Multiplication
            if (userMathChoice == 4) {
                int mathSolved = userN1 / userN2;
                System.out.printf("%d / %d = %d\n",
                        userN1,
                        userN2,
                        mathSolved);
            }
            //  Ask Again user for type of calculation
            System.out.println("Write 1 for addition 2 for subtraction and 3 for multiplication 4 for division or 5 to quit");
            userMathChoice = Integer.parseInt(userInput.nextLine());
        }

    }
}