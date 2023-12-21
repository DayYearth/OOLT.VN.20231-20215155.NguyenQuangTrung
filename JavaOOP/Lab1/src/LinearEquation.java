import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of 'a' (a ≠ 0): ");
        double a = scanner.nextDouble();

        if (a == 0) {
            System.out.println("The coefficient 'a' cannot be zero for a first-degree equation.");
        } else {
            System.out.print("Enter the value of 'b': ");
            double b = scanner.nextDouble();

            double solution = -b / a;

            System.out.println("The solution to the equation " + a + "x + " + b + " = 0 is x = " + solution);
        }

        scanner.close();
    }
}
