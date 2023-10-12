import java.util.Scanner;

public class bai63 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input height:");
        int n = sc.nextInt();

        System.out.println("Tam giac can:");
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= (2*n-1)/2; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= 2*i-1; k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
