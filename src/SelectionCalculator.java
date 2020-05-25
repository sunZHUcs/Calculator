import java.util.Scanner;

public class SelectionCalculator {

    static final Scanner scanner = new Scanner(System.in);
    static final Scanner recalc = new Scanner(System.in);

    static String calcagain;
    static double num1;
    static double num2;
    static double ans;
    static boolean calc = false;

    public static void main(String[] args) {

        if (!calc) {
            beginPrompt();

        }
        infoSpout();
        calcMachine();
        calcAgain();
    }

    static void beginPrompt() {
        System.out.println("Calculator Program has initialized, would you like to continue? (Yes/No)");
        String yesno = scanner.nextLine();

        while (!"yes".equalsIgnoreCase(yesno) && !"no".equalsIgnoreCase(yesno)) {
            System.out.println("Invalid Input!");
            yesno = scanner.nextLine();

        }
        if (yesno.equalsIgnoreCase("no")) {
            System.out.println("Calculator shutting down.");
            System.exit(0);

        } else if (yesno.equalsIgnoreCase("yes")) {
            System.out.println("Calculator Started!");
        }

    }

    static void infoSpout() {
        System.out.println("Type in the number next to each function to use said function:");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Modulo");
    }

    static void calcMachine() {
        int function = scanner.nextInt();

        if (function == 1) {
            System.out.println("You have chosen 'ADDITION'. Please input 2 numbers to add:");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            ans = num1 + num2;

            System.out.println(num1 + " + " + num2 + " = " + ans);
        } else if (function == 2) {
            System.out.println("You have chosen 'SUBTRACTION'. Please input 2 numbers to subtract:");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            ans = num1 - num2;

            System.out.println(num1 + " - " + num2 + " = " + ans);
        } else if (function == 3) {
            System.out.println("You have chosen 'MULTIPLICATION'. Please input 2 numbers to multiply:");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            ans = num1 * num2;

            System.out.println(num1 + " * " + num2 + " = " + ans);
        } else if (function == 4) {
            System.out.println("You have chosen 'DIVISION'. Please input 2 numbers to divide:");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            ans = num1 / num2;

            System.out.println(num1 + " / " + num2 + " = " + ans);
        } else if (function == 5) {
            System.out.println("You have chosen 'MODULO'. Please input 2 numbers to modulo:");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            ans = num1 % num2;

            System.out.println(num1 + " % " + num2 + " = " + ans);
        } else {
            System.out.println("Invalid Input!");
        }
    }

    static void calcAgain() {
        System.out.println("Would you like to calculate another equation? (Yes/No)");

        calcagain = recalc.nextLine();

        while(calcagain.equalsIgnoreCase("yes")) {
            calc = true;
            main(null);
        }

        if (calcagain.equalsIgnoreCase("no")) {
            System.out.println("Calculator Shutting Down.");
            System.exit(0);
        }else {
            System.out.println("Please enter either `Yes` or `No`");
            calcAgain();
        }
    }
}
