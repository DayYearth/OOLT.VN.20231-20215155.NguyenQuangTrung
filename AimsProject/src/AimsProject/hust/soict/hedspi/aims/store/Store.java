package AimsProject.hust.soict.hedspi.aims.store;

import AimsProject.hust.soict.hedspi.media.Media;
import java.util.ArrayList;
import java.util.Iterator;

public class Store extends Media{
    private ArrayList<Media> itemsInStore = new ArrayList();

    public void addMedia(Media tmp){
        for(Media x : itemsInStore){
            if(x.getTitle() == tmp.getTitle()){
                System.out.println("This media already stored");
                return;
            }
        }
        itemsInStore.add(tmp);
        System.out.println("Media has been stored");
    }

    public void removeMedia(Media tmp){
        for(Media x : itemsInStore){
            if(x.getTitle() == tmp.getTitle()){
                itemsInStore.remove(tmp);
                System.out.println("Media has been removed");
            }
        }
        System.out.println("Media does not exist");
    }
    public boolean search(int id) {
        Iterator var3 = this.itemsInStore.iterator();

        while(var3.hasNext()) {
            Media m = (Media)var3.next();
            if (m.getId() == id) {
                return true;
            }
        }

        return false;
    }

    public boolean search(String title) {
        Iterator var3 = this.itemsInStore.iterator();

        while(var3.hasNext()) {
            Media m = (Media)var3.next();
            if (m.getTitle() == title) {
                return true;
            }
        }

        return false;
    }

    public Media searchTitle(String title) {
        Iterator var3 = this.itemsInStore.iterator();

        while(var3.hasNext()) {
            Media m = (Media)var3.next();
            if (m.getTitle() == title) {
                return m;
            }
        }

        return null;
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        int i = 1;

        for(Iterator var3 = this.itemsInStore.iterator(); var3.hasNext(); ++i) {
            Media m = (Media)var3.next();
            System.out.println(i + ".DVD - " + m.getTitle() + " - " + m.getCategory() + " - " + m.getTitle() + " - " + m.getCost());
        }

        System.out.println("***************************************************");
    }
}
