import javax.swing.*;

public class bai225 {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "sum, difference, product and quotient: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number: ","Input the second number",
                JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;
        double quot = num1 / num2;
        strNotification += sum + " " + diff + " " + product + " " + quot;

        JOptionPane.showMessageDialog(null, strNotification,
                "Show sum, difference, product and quotient of 2 double numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
