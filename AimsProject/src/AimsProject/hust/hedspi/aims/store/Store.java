package AimsProject.hust.hedspi.aims.store;

import AimsProject.hust.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[1000];
    private int qtyOrdered = 0;
    // Get Number of List DVD
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int n) {
        qtyOrdered += n;
    }
    public void addDVD(DigitalVideoDisc disc) {
        if(qtyOrdered < 1000) {
            itemsInStore[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeDVD(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsInStore[i].getTitle() == disc.getTitle()) {
                for(int j = i; j < qtyOrdered; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                i--;
                qtyOrdered--;
                System.out.println("The disc has been removed");
            }
        }
    }
}
