package AimsProject.hust.hedspi.test.disc;

import AimsProject.hust.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main (String[] args){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }
    // Ham swap theo passing by reference
//    public static void swap(Object o1, Object o2){
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }

    // Ham swap sau khi dc sua -> pass by value
    public static void swap(DigitalVideoDisc a, DigitalVideoDisc b){
        String tmp = a.getTitle();
        a.setTitle(b.getTitle());
        b.setTitle(tmp);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
