package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Title1", "Category1", "Director1", 120, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Title2", "Category2", "Director2", 90, 14.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Title3", "Category3", "Director3", 100, 17.99f);

        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);

        myStore.listMedia();

        myStore.removeMedia(dvd2);

        myStore.listMedia();
    }
}