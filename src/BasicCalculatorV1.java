import java.util.Scanner;

public class BasicCalculatorV1 {

    static Scanner scanner = new Scanner(System.in);
    static Scanner machine = new Scanner(System.in);

    static boolean recalc;
    static boolean finished;

    public static void main(String[] args) {

        while (finished == true) {

            if (recalc == true) {
                calcMachine();
                calcAgain();
            } else {
                calcMachine();
            }
        }

        beginPrompt();
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
            return;
        }

    }

    static void infoSpout() {
        System.out.println("This calculator works in the conventional fashion. Be sure to note the follwing:");
        System.out.println(
                "[1] You can only use this calculator with 2 numbers at the same time, e.g. 4+4. 4+4+4 Will Not Work!");
        System.out.println(
                "[2] This calculator can use the functions: Addition, Subtraction, Multiplication, Division, Modulo, Exponents, and Factorials.");
        System.out.println(
                "[3] When using either Exponents or Factorials, you may only use 1 whole number. For example: 4^2 | 4!. NOT 4^2 + 4^2 | 4.5! + 3.4!");
        System.out.println(
                "[4] By default, you will be asked if you want to keep calculating after each equation. To disable this, type 'Disable'. To keep this enabled, type 'Enable'");

        String calcprompt = scanner.nextLine();

        while (!"enable".equalsIgnoreCase(calcprompt) && !"disable".equalsIgnoreCase(calcprompt)) {
            System.out.println("Invalid Input! Type either 'Disable' or 'Enable'!");
            calcprompt = scanner.nextLine();
        }

        if (calcprompt.equalsIgnoreCase("Disable")) {
            System.out.println("Re-Calculation Prompt Disabled.");
            recalc = false;
        } else if (calcprompt.equalsIgnoreCase("Enable")) {
            System.out.println("Re-Calculation Prompt Enabled.");
            recalc = true;
        }
    }

    static void calcMachine() {

        if (finished != true) {
            System.out.println("Calculation Machine Initialized, Type in an equation to get started:");
        } else {
            System.out.println("─────────────────────");
        }

        String equation = machine.nextLine();

        if (equation.contains("+")) {
            String num1 = equation.split("\\+")[0];
            String num2 = equation.split("\\+")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = part1 + part2;

            System.out.println(num1 + " + " + num2 + " = " + ans);
            finished = true;

        } else if (equation.contains("-")) {
            String num1 = equation.split("\\-")[0];
            String num2 = equation.split("\\-")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = part1 - part2;

            System.out.println(num1 + " - " + num2 + " = " + ans);
            finished = true;

        } else if (equation.contains("*")) {
            String num1 = equation.split("\\*")[0];
            String num2 = equation.split("\\*")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = part1 * part2;

            System.out.println(num1 + " * " + num2 + " = " + ans);
            finished = true;

        } else if (equation.contains("/")) {
            String num1 = equation.split("\\/")[0];
            String num2 = equation.split("\\/")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = part1 / part2;

            System.out.println(num1 + " / " + num2 + " = " + ans);
            finished = true;

        } else if (equation.contains("%")) {
            String num1 = equation.split("\\%")[0];
            String num2 = equation.split("\\%")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = part1 % part2;

            System.out.println(num1 + " % " + num2 + " = " + ans);
            finished = true;

        } else if (equation.contains("!")) {
            String num1 = equation.split("\\!")[0];

            long part1 = Long.parseLong(num1);
            long ans = 1;

            for (int x = 1; x <= part1; x++) {

                ans = x * ans;
            }

            System.out.println(equation + " = " + ans);
            finished = true;

        } else if (equation.contains("^")) {
            String num1 = equation.split("\\^")[0];
            String num2 = equation.split("\\^")[1];

            double part1 = Double.parseDouble(num1);
            double part2 = Double.parseDouble(num2);

            double ans = Math.pow(part1, part2);

            System.out.println(equation + " = " + ans);
            finished = true;

        }

        else {
            System.out.println("Please enter a valid function! ( + | - | * | / | % )");

        }
    }

    static void calcAgain() {
        while (finished == true) {

            if (recalc == true) {
                System.out.println("Would you like to calculate another equation? (Yes/No)");

                String calc = scanner.nextLine();

                if (calc.equalsIgnoreCase("Yes")) {
                    main(null);
                } else if (calc.equalsIgnoreCase("No")) {
                    System.out.println("Calculator Shutting Down.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid Input! Enter either 'Yes' or 'No'.");
                    continue;
                }

            } else {
                main(null);
            }
        }
    }
}
