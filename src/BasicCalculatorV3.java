import java.util.ArrayList;
import java.util.Scanner;

public class BasicCalculatorV3 {

    static final Scanner scanner = new Scanner(System.in);
    static final Scanner machine = new Scanner(System.in);

    static boolean recalc;
    static boolean finished;

    static final String add = "+";
    static final String sub = "-";
    static final String mul = "*";
    static final String div = "/";
    static final String mod = "%";
    static final String fact = "!";
    static final String exp = "^";
    static final String sqrt = "√";

    static int func = 0;

    public static void main(String[] args) {

        while (finished) {

            if (recalc) {
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

        switch (yesno.toLowerCase()) {
            default:
                while (!yesno.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid Input!");
                    yesno = scanner.nextLine();
                }
            case "yes":
                System.out.println("Calculator Started!");
                break;
            case "no":
                System.out.println("Calculator shutting down.");
                System.exit(0);
            case "stop":
            case "quit":
                System.exit(0);
        }
    }

    static void infoSpout() {
        System.out.println(
                "\n────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
        System.out.println("This calculator works in the conventional fashion. Be sure to note the follwing:");
        System.out.println(
                "[1] You can only use this calculator with any amount of numbers as long as the function remains the same. For exmaple: 4 + 4 + 4. NOT 4 + 4 * 4");
        System.out.println(
                "[2] This calculator can use the functions: Addition, Subtraction, Multiplication, Division, Modulo, Exponents, and Factorials.");
        System.out.println(
                "[3] When using either Exponents or Factorials, you may only use 1 whole number. For example: 4^2 | 4!. NOT 4^2 + 4^2 | 4.5! + 3.4!");
        System.out.println("[4] You can stop this program at any time by inputting either `Stop`, or `Quit`.");
        System.out.println(
                "[5] By default, you will be asked if you want to keep calculating after each equation. To disable this, type 'Disable'. To keep this enabled, type 'Enable'");
        System.out.println(
                "\n────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");

        String calcprompt = scanner.nextLine();

        switch (calcprompt.toLowerCase()) {
            default:
                while (!calcprompt.equalsIgnoreCase("disable")) {
                    System.out.println("Invalid Input!");
                    calcprompt = scanner.nextLine();
                }
            case "disable":
                System.out.println("Re-Calculation Prompt Disabled.");
                recalc = false;
                break;
            case "enable":
                System.out.println("Re-Calculation Prompt Enabled.");
                recalc = true;
                break;
            case "stop":
            case "quit":
                System.exit(0);
        }
    }

    static void calcMachine() {

        if (!finished) {
            System.out.println("Calculation Machine Initialized, Type in an equation to get started:");
        } else {
            System.out.println("─");
        }

        String equation = machine.nextLine();
        ArrayList<String> eq = new ArrayList<>();
        String[] nums;

        nums = equation.split("(?<=[-+*/%!^√])|(?=[-+*/%!^√])");


        while (func == 0) {

            for (int i = 0; i < nums.length; i++) {
                switch (nums[i]) {
                    case add -> {
                        func = 1;
                        i = nums.length;
                    }
                    case sub -> {
                        func = 2;
                        i = nums.length;
                    }
                    case mul -> {
                        func = 3;
                        i = nums.length;
                    }
                    case div -> {
                        func = 4;
                        i = nums.length;
                    }
                    case mod -> {
                        func = 5;
                        i = nums.length;
                    }
                    case fact -> {
                        func = 6;
                        i = nums.length;
                    }
                    case exp -> {
                        func = 7;
                        i = nums.length;
                    }
                    case sqrt -> {
                        func = 8;
                        i = nums.length;
                    }
                }
            }
        }

        for (String num : nums) {
            if (!num.equalsIgnoreCase(add) && !num.equalsIgnoreCase(sub) && !num.equalsIgnoreCase(mul)
                    && !num.equalsIgnoreCase(div) && !num.equalsIgnoreCase(mod)
                    && !num.equalsIgnoreCase(fact) && !num.equalsIgnoreCase(exp)
                    && !num.equalsIgnoreCase(sqrt)) {
                eq.add(num);
            }
        }

        double[] numbers = new double[eq.size()];
        double denum;
        double ans = 0;

        switch (func) {
            case 1 -> {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Double.parseDouble(eq.get(i));
                    ans += numbers[i];
                }
                System.out.println(equation + " = " + ans);
                finished = true;
                func = 0;
            }
            case 2 -> {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Double.parseDouble(eq.get(i));
                }
                for (int i = 1; i < numbers.length; i++) {

                    denum = numbers[i];
                    numbers[0] -= denum;

                }
                System.out.println(equation + " = " + numbers[0]);
                finished = true;
                func = 0;
            }
            case 3 -> {
                ans = 1;
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Double.parseDouble(eq.get(i));
                    ans *= numbers[i];
                }
                System.out.println(equation + " = " + ans);
                finished = true;
                func = 0;
            }
            case 4 -> {
                for (int y = 0; y < numbers.length; y++) {
                    numbers[y] = Double.parseDouble(eq.get(y));
                }
                for (int i = 1; i < numbers.length; i++) {

                    denum = numbers[i];
                    numbers[0] /= denum;

                }
                System.out.println(equation + " = " + numbers[0]);
                finished = true;
                func = 0;
            }
            case 5 -> {
                for (int y = 0; y < numbers.length; y++) {
                    numbers[y] = Double.parseDouble(eq.get(y));
                }
                for (int i = 1; i < numbers.length; i++) {

                    denum = numbers[i];
                    numbers[0] %= denum;

                }
                System.out.println(equation + " = " + numbers[0]);
                finished = true;
                func = 0;
            }
            case 6 -> {
                if (nums.length > 2) {
                    System.out.println("Invalid Input!");

                } else {
                    String num1 = nums[0];

                    long part1 = Long.parseLong(num1);
                    ans = 1;

                    for (int x = 1; x <= part1; x++) {

                        ans = x * ans;
                    }

                    System.out.println(equation + " = " + ans);
                }
                finished = true;
                func = 0;
            }
            case 7 -> {
                if (nums.length > 3) {
                    System.out.println("Invalid Input!");

                } else {
                    String num1 = nums[0];
                    String num2 = nums[2];

                    double part1 = Double.parseDouble(num1);
                    double part2 = Double.parseDouble(num2);

                    ans = Math.pow(part1, part2);

                    System.out.println(equation + " = " + ans);
                }
                finished = true;
                func = 0;
            }
            case 8 -> {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = Double.parseDouble(eq.get(i));
                    builder.append(numbers[i]);
                }
                String num1 = builder.toString();
                double part1 = Double.parseDouble(num1);
                ans = Math.sqrt(part1);
                System.out.println(equation + " = " + ans);
                finished = true;
                func = 0;
            }
        }
    }

    static void calcAgain() {

        while (finished) {

            if (recalc) {
                System.out.println("Would you like to calculate another equation? (Yes/No)");

                String calc = scanner.nextLine();

                if (calc.equalsIgnoreCase("Yes")) {
                    main(null);
                } else if (calc.equalsIgnoreCase("No")) {
                    System.out.println("Calculator Shutting Down.");
                    System.exit(0);
                } else {
                    System.out.println("Invalid Input! Enter either 'Yes' or 'No'.");
                }

            } else {
                main(null);
            }
        }
    }
}
