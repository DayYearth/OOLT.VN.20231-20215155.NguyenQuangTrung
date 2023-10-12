import java.util.Scanner;

public class bai64 {
    public static int exchange(String t){
        if (t.equals("Jan.") || t.equals("Jan") || t.equals("January") || t.equals("1")) return 1;
        if (t.equals("Feb.") || t.equals("Feb") || t.equals("February") || t.equals("2")) return 2;
        if (t.equals("Mar.") || t.equals("Mar") || t.equals("March") || t.equals("3")) return 3;
        if (t.equals("Apr.") || t.equals("Apr") || t.equals("April") || t.equals("4")) return 4;
        if (t.equals("May.")  || t.equals("May") || t.equals("5")) return 5;
        if (t.equals("Jun.") || t.equals("Jun") || t.equals("June") || t.equals("6")) return 6;
        if (t.equals("Jul.") || t.equals("Jul") || t.equals("July") || t.equals("7")) return 7;
        if (t.equals("Aug.") || t.equals("Aug") || t.equals("August") || t.equals("8")) return 8;
        if (t.equals("Sep.") || t.equals("Sep") || t.equals("September") || t.equals("9")) return 9;
        if (t.equals("Oct.") || t.equals("Oct") || t.equals("October") || t.equals("10")) return 10;
        if (t.equals("Nov.") || t.equals("Nov") || t.equals("November") || t.equals("11")) return 11;
        if (t.equals("Dec.") || t.equals("Dec") || t.equals("December") || t.equals("12")) return 12;
        return 0;
    }

    // check leap year
    public static int check(int year){
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return 1;
                }
            } else {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String m;
        int y;

        do{
            System.out.println("Input month: ");
            m = sc.nextLine(); // nhap thang
        } while(exchange(m) > 12 || exchange(m) < 1);

        do{
            System.out.println("Input year: ");
            y = sc.nextInt(); // nhap nam
        }while(y <= 0);

        switch ((exchange(m))){
            case 1: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 2: break;
            case 3: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 4: System.out.println(m + "/" + y + " co 30 ngay"); break;
            case 5: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 6: System.out.println(m + "/" + y + " co 30 ngay"); break;
            case 7: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 8: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 9: System.out.println(m + "/" + y + " co 30 ngay"); break;
            case 10: System.out.println(m + "/" + y + " co 31 ngay"); break;
            case 11: System.out.println(m + "/" + y + " co 30 ngay"); break;
            case 12: System.out.println(m + "/" + y + " co 31 ngay"); break;
        }
        if(exchange(m) == 2){
            if(check(y)==1) System.out.println(m + "/" + y + " co 29 ngay");
            else System.out.println(m + "/" + y + " co 28 ngay");
        }
    }
}
