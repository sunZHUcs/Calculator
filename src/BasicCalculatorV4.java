import java.util.ArrayList;
import java.util.Scanner;

public class BasicCalculatorV4 {

    static final Scanner machine = new Scanner(System.in);

    public static void main(String[] args) {

        calcMachine();
    }

    static void calcMachine() {

        if (!finished) {
            System.out.println("Calculation Machine Initialized, Type in an equation to get started:");
        } else {
            System.out.println("─");
        }

        String equation = machine.nextLine();
        ArrayList<String> eq = new ArrayList<>();
        String[] nums = null;

    }
}
