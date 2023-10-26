import java.util.Scanner;

public class bai65 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] my_array1 = new int[n];
        for(int i = 0; i < n; i++){
            my_array1[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(my_array1[i] > my_array1[j]){
                    int tmp = my_array1[i];
                    my_array1[i] = my_array1[j];
                    my_array1[j] = tmp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(my_array1[i] + " ");
        }
        System.out.println("\n");

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += my_array1[i];
        }
        double avg = (double)sum / (double)n;
        System.out.println("Tong: " + sum + "\n" + "Trung binh: " + avg);
    }
}
