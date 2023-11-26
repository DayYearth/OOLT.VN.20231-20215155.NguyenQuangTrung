package AimsProject.hust.soict.hedspi.aims.cart;


import AimsProject.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import AimsProject.hust.soict.hedspi.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media tmp){
        for(Media x : itemsOrdered){
            if(tmp.getTitle() == x.getTitle()){
                System.out.println("Meida has been already exited");
                return;
            }
        }
        itemsOrdered.add(tmp);
    }

    public void removeMedia(Media tmp){
        itemsOrdered.remove(tmp);
        System.out.println("Media has been removed");
    }

    public float totalCost(){
        float sumCost = 0;
        for(Media x : itemsOrdered){
            sumCost += x.getCost();
        }
        return sumCost;
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public Media searchId(int id) {
        Iterator tmp = this.itemsOrdered.iterator();

        while(tmp.hasNext()) {
            Media m = (Media)tmp.next();
            if (m.getId() == id) {
                return m;
            }
        }

        return null;
    }

    public boolean search(String title) {
        Iterator tmp = this.itemsOrdered.iterator();

        while(tmp.hasNext()) {
            Media m = (Media)tmp.next();
            if (m.getTitle() == title) {
                return true;
            }
        }

        return false;
    }

    public Media searchTitle(String title) {
        Iterator tmp = this.itemsOrdered.iterator();

        while(tmp.hasNext()) {
            Media m = (Media)tmp.next();
            if (m.getTitle() == title) {
                return m;
            }
        }

        return null;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        int i = 1;

        for(Iterator tmp = this.itemsOrdered.iterator(); tmp.hasNext(); ++i) {
            Media m = (Media)tmp.next();
            System.out.println(i + ".DVD - " + m.getTitle() + " - " + m.getCategory() + " - " + m.getTitle() + " - " + m.getCost());
        }

        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }
    public void printLength() {
        System.out.println(this.itemsOrdered.size());
    }
    public void removeMediaAll() {
        this.itemsOrdered.removeAll(this.itemsOrdered);
    }
}