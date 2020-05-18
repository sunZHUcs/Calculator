import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BasicCalculatorV2 {

    static Scanner scanner = new Scanner(System.in);
    static Scanner machine = new Scanner(System.in);

    static boolean recalc;
    static boolean finished;
    static boolean quit;

    static String add = "+";
    static String sub = "-";
    static String mul = "*";
    static String div = "/";
    static String mod = "%";
    static String fact = "!";
    static String exp = "^";
    static String sqrt = "√";

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
        } else if (yesno.equalsIgnoreCase("quit") || yesno.equalsIgnoreCase("stop")) {
            System.exit(0);
        }
    }

    static void infoSpout() {
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
        System.out.println("\n───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");

        String calcprompt = scanner.nextLine();

        while (!"enable".equalsIgnoreCase(calcprompt) && !"disable".equalsIgnoreCase(calcprompt)
                && !"stop".equalsIgnoreCase(calcprompt) && !"quit".equalsIgnoreCase(calcprompt)) {
            System.out.println("Invalid Input! Type either 'Disable' or 'Enable'!");
            calcprompt = scanner.nextLine();
        }

        if (calcprompt.equalsIgnoreCase("Disable")) {
            System.out.println("Re-Calculation Prompt Disabled.");
            recalc = false;
        } else if (calcprompt.equalsIgnoreCase("Enable")) {
            System.out.println("Re-Calculation Prompt Enabled.");
            recalc = true;
        } else if (calcprompt.equalsIgnoreCase("quit")) {
            System.exit(0);
        } else if (calcprompt.equalsIgnoreCase("stop")) {
            System.exit(0);
        }
    }

    static void calcMachine() {

        if (finished != true) {
            System.out.println("Calculation Machine Initialized, Type in an equation to get started:");
        } else {
            System.out.println("─\n");
        }

        String equation = machine.nextLine();
        ArrayList<String> eq = new ArrayList<>();
        String[] nums = null;

        nums = equation.split("(?<=[-+*/%])|(?=[-+*/%])");
        List<String> funcheck = Arrays.asList(nums);

        if (funcheck.contains(add) && !funcheck.contains(sub) && !funcheck.contains(mul) && !funcheck.contains(div)
                && !funcheck.contains(mod) && !funcheck.contains(fact) && !funcheck.contains(sqrt)) {
            for (int i = 0; i < nums.length; i++) {
                if (!nums[i].equalsIgnoreCase(add)) {
                    eq.add(nums[i]);
                } else {
                    ;
                }
            }

            double[] numbers = new double[eq.size()];
            double ans = 0;

            for (int i = 0; i < eq.size(); i++) {
                numbers[i] = Double.parseDouble(eq.get(i));
                ans += numbers[i];
            }

            System.out.println(equation + " = " + ans);
            finished = true;

        } else if (funcheck.contains(sub) && !funcheck.contains(add) && !funcheck.contains(mul)
                && !funcheck.contains(div) && !funcheck.contains(mod) && !funcheck.contains(fact) && !funcheck.contains(sqrt)) {
            for (int i = 0; i < nums.length; i++) {
                if (!nums[i].equalsIgnoreCase(sub)) {
                    eq.add(nums[i]);
                } else {
                    ;
                }
            }

            double[] numbers = new double[eq.size()];
            double ans = 0;

            for (int i = 0; i < eq.size(); i++) {
                numbers[i] = Double.parseDouble(eq.get(i));
                ans = numbers[i] - ans;
            }

            System.out.println(equation + " = " + ans);
            finished = true;

        } else if (funcheck.contains(mul) && !funcheck.contains(add) && !funcheck.contains(sub)
                && !funcheck.contains(div) && !funcheck.contains(mod) && !funcheck.contains(fact) && !funcheck.contains(sqrt)) {
            for (int i = 0; i < nums.length; i++) {
                if (!nums[i].equalsIgnoreCase(mul)) {
                    eq.add(nums[i]);
                } else {
                    ;
                }
            }

            double[] numbers = new double[eq.size()];
            double ans = 1;

            for (int i = 0; i < eq.size(); i++) {
                numbers[i] = Double.parseDouble(eq.get(i));
                ans *= numbers[i];
            }

            System.out.println(equation + " = " + ans);
            finished = true;

        } else if (funcheck.contains(div) && !funcheck.contains(add) && !funcheck.contains(sub)
                && !funcheck.contains(mul) && !funcheck.contains(mod) && !funcheck.contains(fact) && !funcheck.contains(sqrt)) {
            for (int i = 0; i < nums.length; i++) {
                if (!nums[i].equalsIgnoreCase(div)) {
                    eq.add(nums[i]);
                } else {
                    ;
                }
            }

            double[] numbers = new double[eq.size()];
            double denum = 0.0;

            for (int y = 0; y < numbers.length; y++) {
                numbers[y] = Double.parseDouble(eq.get(y));
            }

            for (int i = 1; i < numbers.length; i++) {

                denum = numbers[i];
                numbers[0] /= denum;

            }

            System.out.println(equation + " = " + numbers[0]);
            finished = true;

        } else if (funcheck.contains(mod) && !funcheck.contains(add) && !funcheck.contains(sub)
                && !funcheck.contains(mul) && !funcheck.contains(div) && !funcheck.contains(fact) && !funcheck.contains(sqrt)) {
            for (int i = 0; i < nums.length; i++) {
                if (!nums[i].equalsIgnoreCase(mod)) {
                    eq.add(nums[i]);
                } else {
                    ;
                }
            }

            double[] numbers = new double[eq.size()];
            double denum = 0.0;

            for (int y = 0; y < numbers.length; y++) {
                numbers[y] = Double.parseDouble(eq.get(y));
            }

            for (int i = 1; i < numbers.length; i++) {

                denum = numbers[i];
                numbers[0] %= denum;

            }

            System.out.println(equation + " = " + numbers[0]);
            finished = true;

        }else if (funcheck.contains("quit") || funcheck.contains("stop")) {
            System.exit(0);
        }
        else {
            System.out.println("Please enter a valid input! (Infinite digits, but only 1 function)");
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
