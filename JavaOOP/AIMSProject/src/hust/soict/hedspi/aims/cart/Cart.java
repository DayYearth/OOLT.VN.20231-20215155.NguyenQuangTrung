package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;
    private List<Media> itemsOrdered = new ArrayList<>();
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBERS_ORDER) {
            System.out.println("The cart is almost full");
            return;
        }

        itemsOrdered.set(qtyOrdered, disc);
        qtyOrdered++;

        System.out.println("The disc has been added");
    }

    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println("The media has been added to the cart.");
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("Media not found in the cart. Remove failed.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
        for (int i = 0; i < disc.length; i++){
            addDigitalVideoDisc(disc[i]);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int idToMove = -1;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered.get(i) == disc){
                idToMove = i;
                break;
            }
        }
        if (idToMove < 0) {
            System.out.println("System cannot find the disc, remove fail");
            return;
        }
        for (int i = idToMove; i < qtyOrdered - 1; i++){
            itemsOrdered.set(i, itemsOrdered.get(i + 1));
        }
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void printOrder() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        int itemNumber = 1;
        for (Media media : itemsOrdered) {
            System.out.println(itemNumber + ". " + media.toString());
            itemNumber++;
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        boolean found = false;

        System.out.println("Search results for DVD with ID " + id + ":");

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println(itemsOrdered.get(i));
                found = true;
                break; // Stop searching once a match is found
            }
        }

        if (!found) {
            System.out.println("No match found for DVD with ID " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;

        System.out.println("Search results for DVDs with title '" + title + "':");

        for (int i = 0; i < qtyOrdered; i++) {
            if (title.equalsIgnoreCase(itemsOrdered.get(i).getTitle())) {
                System.out.println(itemsOrdered.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No match found for DVDs with title '" + title + "'");
        }
    }


}
