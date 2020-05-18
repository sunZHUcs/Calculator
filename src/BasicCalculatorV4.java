import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BasicCalculatorV4 {

    static Scanner scanner = new Scanner(System.in);
    static Scanner machine = new Scanner(System.in);

    static boolean recalc;
    static boolean finished;
    static boolean quit;
    static boolean functionset = false;

    static final String add = "+";
    static final String sub = "-";
    static final String mul = "*";
    static final String div = "/";
    static final String mod = "%";
    static final String fact = "!";
    static final String exp = "^";
    static final String sqrt = "√";
    static String type;

    static List<Integer> func = new ArrayList<>();

    public static void main(String[] args) {

        calcMachine();
    }

    static void beginPrompt() {

        System.out.println("Calculator Program has initialized, would you like to continue? (Yes/No)");
        String yesno = scanner.nextLine();

        switch (yesno) {
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
                System.exit(0);
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

        switch (calcprompt) {
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
                System.exit(0);
            case "quit":
                System.exit(0);
        }
    }

    static void calcMachine() {

        if (finished != true) {
            System.out.println("Calculation Machine Initialized, Type in an equation to get started:");
        } else {
            System.out.println("─");
        }

        String equation = machine.nextLine();
        ArrayList<String> eq = new ArrayList<>();
        String[] nums = null;

        nums = equation.split("(?<=[-+*/%!^√])|(?=[-+*/%!^√])");

    }
}
