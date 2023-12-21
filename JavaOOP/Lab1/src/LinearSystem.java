import java.util.Scanner;

public class LinearSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients for the first equation (a11x1 + a12x2 = b1):");
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();

        System.out.println("Enter coefficients for the second equation (a21x1 + a22x2 = b2):");
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a12 * a21;

        if (determinant != 0) {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;

            System.out.println("The solution to the system of equations is:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            if ((a11 / a21 == a12 / a22) && (a11 / b1 == a12 / b2)) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        }

        scanner.close();
    }
}
