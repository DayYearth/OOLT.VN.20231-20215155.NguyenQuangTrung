package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static final int MAX_ITEM_IN_STORE = 1000;
    private int nextAvailableIndex;
    private List<Media> itemsInStore = new ArrayList<>();


    public Store(){
        nextAvailableIndex = 0;
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("Media not found in the store. Remove failed.");
        }
    }

    public void listMedia() {
        System.out.println("*************** Items in the Store ***************");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("***************************************************");
    }

    public void displayStore() {
        System.out.println("Items in the Store:");
        for (Media media : itemsInStore) {
            System.out.println(media);
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return (ArrayList<Media>) itemsInStore;
    }
}
