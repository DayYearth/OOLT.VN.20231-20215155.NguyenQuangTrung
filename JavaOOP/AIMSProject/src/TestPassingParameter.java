import static java.util.Collections.swap;

public class TestPassingParameter {
    public static void main(String args[]){
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderella");

        swap(jungleDVD, cinderellaDVD);

        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());

    }

    private static void swap(Object jungleDVD, Object cinderellaDVD) {
        Object tmp = jungleDVD;
        jungleDVD = cinderellaDVD;
        cinderellaDVD = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTilte = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTilte);
    }
}
