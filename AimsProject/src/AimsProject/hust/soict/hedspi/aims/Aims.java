package AimsProject.hust.soict.hedspi.aims;

import java.util.Scanner;
import AimsProject.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.hust.soict.hedspi.aims.screen.StoreManagerScreen;
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
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
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
    public static void cart_menu(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                showMenu();
                menu(sc, anOrder, anStore);
                break;
            case 1:
                MenuFunction.filterMediaInCart(sc, anOrder);
                break;
            case 2:
                MenuFunction.sortMediaInCart(sc, anOrder);
                break;
            case 3:
                removeMediaFromCart(sc, anOrder);
                break;
            case 4:
                playMedia(sc, anOrder, anStore);
                break;
            case 5:
                placeOrder(sc, anOrder);
                break;
            default:
                break;
        }
    }
    public static void menu(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                System.out.println("Exit");
                return;
            case 1:
                anStore.printStore();
                storeMenu();
                store_menu_1(sc, anOrder, anStore);
                break;
            case 2:
                MenuFunction.UpdateStore(sc, anStore);
                break;
            case 3:
                anOrder.printCart();
                cartMenu();
                cart_menu(sc, anOrder, anStore);
                break;
            default:
                break;
        }
        showMenu();
        Scanner sc1 = new Scanner(System.in);
        Cart anOrder1 = new Cart();
        Store anStore1 = new Store();
        menu(sc1, anOrder1, anStore1);
        return;
    }
    public static void store_menu_1(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                showMenu();
                menu(sc, anOrder, anStore);
                break;
            case 1:
                seeAMediaDetails(sc, anOrder, anStore);
                mediaDetailsMenu();
                mediaDetails(sc, anOrder, anStore);
                break;
            case 2:
                MenuFunction.addToCart(sc, anOrder, anStore);
                anOrder.printLength();
                break;
            case 3:
                playMedia(sc, anOrder, anStore);
                break;
            case 4:
                anOrder.printCart();
                cartMenu();
                cart_menu(sc, anOrder, anStore);
                break;
            default:
                break;
        }
    }

    public static void mediaDetails(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k) {
            case 0:
                storeMenu();
                store_menu_1(sc, anOrder, anStore);
                break;
            case 1:
                playMedia(sc, anOrder, anStore);
                break;
            case 2:
                MenuFunction.addToCart(sc, anOrder, anStore);
            default:
                break;
        }
    }
    public void newMenu(){
        showMenu();
        Scanner sc = new Scanner(System.in);
        Cart anOrder = new Cart();
        Store anStore = new Store();
        menu(sc, anOrder, anStore);
    }
    public static void main(String[] args){
            showMenu();
            Scanner sc = new Scanner(System.in);
            Cart anOrder = new Cart();
            Store anStore = new Store();
            menu(sc, anOrder, anStore);
            sc.close();
            return;
    }
}