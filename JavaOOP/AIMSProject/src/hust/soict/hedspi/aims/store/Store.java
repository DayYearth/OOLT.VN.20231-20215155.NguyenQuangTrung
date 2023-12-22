package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEM_IN_STORE = 1000;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEM_IN_STORE];
    private int nextAvailableIndex;

    public Store(){
        nextAvailableIndex = 0;
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (nextAvailableIndex < itemsInStore.length) {
            itemsInStore[nextAvailableIndex++] = disc;
            System.out.println("Added DVD to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        int indexToRemove = -1;
        for (int i = 0; i < nextAvailableIndex; i++) {
            if (itemsInStore[i] == disc) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < nextAvailableIndex - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[--nextAvailableIndex] = null;
            System.out.println("Removed DVD from the store.");
        } else {
            System.out.println("DVD not found in the store. Remove failed.");
        }
    }

    public void listItemsInStore() {
        System.out.println("DVDs available in the store:");
        for (int i = 0; i < nextAvailableIndex; i++) {
            System.out.println(itemsInStore[i]);
        }
    }
}
