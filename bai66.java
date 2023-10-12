import java.util.Scanner;

public class bai66 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Input row matrices: ");
        int n = sc.nextInt();

        System.out.println("Input column matrices: ");
        int m = sc.nextInt();

        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        int[][] ans = new int[n][m];
        System.out.println("Input matrice 1: ");
        for(int k = 0; k < n; k++){
            for(int i = 0; i < m; i++){
                A[k][i] = sc.nextInt();
            }
        }
        System.out.println("Input matrice 2: ");
        for(int k = 0; k < n; k++){
            for(int i = 0; i < m; i++){
                B[k][i] = sc.nextInt();
            }
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < m; i++){
                ans[k][i] = A[k][i] + B[k][i];
            }
        }

        System.out.println("Sum of two matrices:");
        for(int k = 0; k < n; k++){
            for(int i = 0; i < m; i++){
                System.out.print(ans[k][i] + " ");
            }
            System.out.print("\n");
        }
    }
}
