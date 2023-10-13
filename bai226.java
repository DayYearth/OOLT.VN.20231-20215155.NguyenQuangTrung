import java.util.Scanner;
import java.lang.Math;
public class bai226 {
    public static void phuongtrinhbacnhat(double a, double b){
        if(a==0 && b==0) System.out.println("Phuong trinh vo so nghiem");
        else if(a == 0 && b != 0) System.out.println("Phuong trinh vo nghiem");
        else{
            double x = -b/a;
            System.out.println("Nghiem cua phuong trinh la: " + x);
        }
    }

    public static void phuongtrinhbachai(double a, double b, double c){
        if(a==0 && b !=0) System.out.println("Phuong trinh co nghiem la: " + Math.ceil((-c/b) * 1000)/1000);
        else if(a==0 && b==0 && c==0)
            System.out.println("Phuong trinh co vo so nghiem");
        else if(a==0 && b==0 && c!=0)
            System.out.println("Phuong trinh vo nghiem");
        else {
            double delta = b*b - 4*a*c;
            if(delta < 0) System.out.println("Phuong trinh vo nghiem");
            else if(delta == 0){
                double x1 = b / (2*a);
                double x2 = (-1) * b / (2*a);
                System.out.println("Phuong trinh co nghiem kep: " + x1 + " va " + x2);
            } else{
                double x1 = (-b+Math.sqrt(delta))/(2*a);
                double x2 = (-b-Math.sqrt(delta))/(2*a);
                System.out.println("Nghiem 1: x1 = " + x1 + "\nNghiem 2: x2 = " + x2);
            }
        }
    }

    public static void hephuongtrinh(double a1, double a2, double b1, double b2, double c1, double c2){
        double D = a1*b2-a2*b1;
        double Dx = c1*b2-c2*b1;
        double Dy = a1*c2-a2*c1;
        if(D==0 && Dx == 0 && Dy == 0) System.out.println("He phuong trinh co vo so nghiem\n");
        else if((D==0 && Dx!= 0) || (D==0 && Dy!= 0)) System.out.println("He phuong trinh vo nghiem");
        else System.out.println("x: " + (Dx/D) + " y: " + (Dy/D) + "\n");
    }

    public static void main(String[] args){
        while(true){
            System.out.println("1) Phuong trinh bac nhat\n2) Phuong trinh bac hai\n3) He phuong trinh");
            Scanner sc = new Scanner(System.in);

            int key = sc.nextInt();
            switch(key){
                case 1:
                    System.out.println("Nhap he so ax + b = 0");
                    System.out.print("Nhap a = "); double a = sc.nextDouble();
                    System.out.print("Nhap b = "); double b = sc.nextDouble();
                    phuongtrinhbacnhat(a,b);
                    break;
                case 2:
                    System.out.println("Nhap he so ax^2 + bx + c = 0");
                    System.out.print("Nhap a = "); double m = sc.nextDouble();
                    System.out.print("Nhap b = "); double n = sc.nextDouble();
                    System.out.print("Nhap c = "); double p = sc.nextDouble();
                    phuongtrinhbachai(m, n, p);
                    break;
                case 3:
                    double a1,a2,b1,b2,c1,c2;
                    System.out.println("Nhap he so a1x + b1y = c1, a2x + b2y =c2");
                    System.out.print("Nhap a1 = "); a1=sc.nextDouble();
                    System.out.print("Nhap b1 = "); b1=sc.nextDouble();
                    System.out.print("Nhap c1 = "); c1=sc.nextDouble();
                    System.out.print("Nhap a2 = "); a2=sc.nextDouble();
                    System.out.print("Nhap b2 = "); b2=sc.nextDouble();
                    System.out.print("Nhap c2 = "); c2=sc.nextDouble();
                    hephuongtrinh(a1, a2, b1, b2, c1, c2);
                    break;
            }
        }
    }
}
