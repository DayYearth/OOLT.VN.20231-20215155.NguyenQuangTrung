import java.util.Scanner;

public class DisplayDaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysInMonth;

        do {
            System.out.print("Enter the month (1-12): ");
            int month = scanner.nextInt();

            System.out.print("Enter the year: ");
            int year = scanner.nextInt();

            switch (month) {
                case 1, 3, 5, 7, 8, 10, 12:
                    daysInMonth = 31;
                    break;
                case 4, 6, 9, 11:
                    daysInMonth = 30;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                        daysInMonth = 29;
                    } else {
                        daysInMonth = 28;
                    }
                    break;
                default:
                    daysInMonth = 0;
                    break;
            }

            if (daysInMonth == 0) {
                System.out.println("Invalid month. Please enter a valid month (1-12).");
            } else {
                System.out.println("Number of days in the month: " + daysInMonth);
            }

        } while (daysInMonth == 0);

        scanner.close();
    }
}
