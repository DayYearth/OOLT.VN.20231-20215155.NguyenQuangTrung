import java.util.Scanner;

public class SecondDegreeEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coefficient 'a' (a ≠ 0): ");
        double a = scanner.nextDouble();

        if (a == 0) {
            System.out.println("The coefficient 'a' cannot be zero for a quadratic equation.");
        } else {
            System.out.print("Enter the coefficient 'b': ");
            double b = scanner.nextDouble();
            System.out.print("Enter the coefficient 'c': ");
            double c = scanner.nextDouble();

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

                System.out.println("The roots of the quadratic equation are real and distinct:");
                System.out.println("Root 1: " + root1);
                System.out.println("Root 2: " + root2);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);

                System.out.println("The root of the quadratic equation is real and double:");
                System.out.println("Root: " + root);
            } else {
                System.out.println("The quadratic equation has no real roots.");
            }
        }

        scanner.close();
    }
}
