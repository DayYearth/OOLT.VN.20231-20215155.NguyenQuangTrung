package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDER];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == MAX_NUMBERS_ORDER) {
            System.out.println("The cart is almost full");
            return;
        }

        itemOrdered[qtyOrdered] = disc;
        qtyOrdered++;

        System.out.println("The disc has been added");
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
            if (itemOrdered[i] == disc){
                idToMove = i;
                break;
            }
        }
        if (idToMove < 0) {
            System.out.println("System cannot find the disc, remove fail");
            return;
        }
        for (int i = idToMove; i < qtyOrdered - 1; i++){
            itemOrdered[i] = itemOrdered[i + 1];
        }
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }

    public float totalCost(){
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++){
            sum += itemOrdered[i].getCost();
        }

        return sum;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemOrdered[i]);
        }

        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }

    public void searchByID(int id) {
        boolean found = false;

        System.out.println("Search results for DVD with ID " + id + ":");

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println(itemOrdered[i]);
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
            if (itemOrdered[i].isMatch(title)) {
                System.out.println(itemOrdered[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No match found for DVDs with title '" + title + "'");
        }
    }
}
