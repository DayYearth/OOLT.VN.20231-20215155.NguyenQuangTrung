package AimsProject.hust.soict.hedspi.aims;


import javax.naming.LimitExceededException;
import java.util.Scanner;
import AimsProject.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void seeAMediaDetails(Scanner sc, Cart anOrder, Store anStore) {
        System.out.println("See A Media Details");
        System.out.print("Media Title is: ");
        String title = sc.next();
        System.out.println("");
        if (anStore.search(title)) {
            System.out.println(anStore.searchTitle(title).toString());
        } else {
            System.out.println("The Media title is not valid");
        }

    }

    public static void playMedia(Scanner sc, Cart anOrder, Store anStore) {
        System.out.println("Play");
        System.out.print("Media Title is: ");
        String title = sc.next();
        System.out.println("");
        if (anStore.search(title)) {
            anStore.searchTitle(title).playMedia();
        }

    }

    public static void removeMediaFromCart(Scanner sc, Cart anOrder) {
        System.out.println("Remove Media To Cart");
        System.out.print("Media title remove is: ");
        String title = sc.nextLine();
        if (!anOrder.search(title)) {
            System.out.println("The media doesn't exist");
        } else {
            anOrder.removeMedia(anOrder.searchTitle(title));
            System.out.println("The media has been removed");
        }

    }

    public static void placeOrder(Scanner sc, Cart anOrder) {
        System.out.print("Order Success");
        anOrder.removeMediaAll();
    }


    public static void main(String[] args){

    }
}