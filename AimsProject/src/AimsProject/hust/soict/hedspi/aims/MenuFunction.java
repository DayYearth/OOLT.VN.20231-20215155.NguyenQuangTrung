package AimsProject.hust.soict.hedspi.aims;

import java.util.Scanner;

import javax.naming.LimitExceededException;

import AimsProject.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.hust.soict.hedspi.media.Book;
import AimsProject.hust.soict.hedspi.media.CompactDisc;
import AimsProject.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import AimsProject.hust.soict.hedspi.media.Media;
import AimsProject.hust.soict.hedspi.aims.store.Store;

public class MenuFunction {

    public static void menuAddMedia() {
        System.out.println("Add media: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. Add CD");
        System.out.println("3. Add DVD");
        System.out.println("0. Cancel");
        System.out.println("--------------------------------");
    }

    public static void menuSortMedia() {
        System.out.println("Filter media: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Cancel");
        System.out.println("--------------------------------");
    }

    public static void menuFilterMedia() {
        System.out.println("Filter media: ");
        System.out.println("--------------------------------");
        System.out.println("1. Find by Id");
        System.out.println("2. Find by Title");
        System.out.println("0. Cancel");
        System.out.println("--------------------------------");
    }

    public static void menuUpdateStore() {
        System.out.println("Update media: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.println("0. Cancel");
        System.out.println("--------------------------------");
    }



    public static void addToCart(Scanner sc, Cart anOrder, Store anStore) {
        menuAddMedia();
        int input = sc.nextInt();
        switch (input) {
            case 0:
                System.out.println("Cancel");
                break;
            case 1:
                addBookToCart(sc, anOrder, anStore);
                break;
            case 2:
                addCDToCart(sc, anOrder, anStore);
                break;
            case 3:
                addDVDToCart(sc, anOrder, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }

    //	Add CD to Cart(Method in AddToCart)
    public static void addCDToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media cd = new CompactDisc();
        System.out.println("CD title: ");
        String title = sc.nextLine();
//		Check CD to Store and Add to Cart. But Store is null
        if(anStore.search(title)) {
            cd.setTitle(title);
            System.out.println("CD category: ");
            cd.setCategory(sc.nextLine());
            System.out.println("CD cost: ");
            cd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("CD id: ");
            cd.setId(sc.nextInt());
            anOrder.addMedia(cd);
            System.out.println("CD added");
        }
        else {
            System.out.println("The CD is not in the Store");
            return;
        }
    }

    //	Add DVD to Cart(Method in AddToCart)
    public static void addDVDToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media dvd = new DigitalVideoDisc();
        System.out.println("DVD title: ");
        String title = sc.next();
//		Check DVD to Store and Add to Cart.
        if(anStore.search(title)) {
            dvd.setTitle(title);
            System.out.println("DVD category: ");
            dvd.setCategory(sc.nextLine());
            System.out.println("DVD cost: ");
            dvd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("DVD id: ");
            dvd.setId(sc.nextInt());
            System.out.println("DVD added");
            anOrder.addMedia(dvd);
            System.out.println("DVD added");
        }
        else {
            System.out.println("The DVD is not in the Store");
            return;
        }
    }

    //	Add Book to Cart(Method in AddToCart)
    public static void addBookToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media book = new Book();
        System.out.println("Book title: ");
        String title = sc.nextLine();
//		Check Book to Store and Add to Cart.
        if(anStore.search(title)) {
            book.setTitle(title);
            System.out.println("Book category: ");
            book.setCategory(sc.nextLine());
            System.out.println("Book cost: ");
            book.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("Book id: ");
            book.setId(sc.nextInt());
            anOrder.addMedia(book);
            System.out.println("Book added");
        }
        else {
            System.out.println("The Book is not in the Store");
            return;
        }
    }

    //	Add Book to Store(Method in AddToStore)
    public static void addBookToStore(Scanner sc, Store anStore) {
        Media book = new Book();
        System.out.println("Book title: " );
        String title = sc.nextLine();
//		Check Book to Store.
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            book.setTitle(title);
            System.out.println("Book category: " );
            book.setCategory(sc.nextLine());
            System.out.println("Book cost: " );
            book.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("Book id: ");
            book.setId(sc.nextInt());
            System.out.println("Book added");
            anStore.addMedia(book);
        }
    }

    //	Add CD to Store(Method in AddToStore)
    public static void addCDToStore(Scanner sc, Store anStore) {
        Media cd = new CompactDisc();
        System.out.println("CD title: " );
        String title = sc.nextLine();
//		Check CD to Store
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            cd.setTitle(title);
            System.out.println("CD category: " );
            cd.setCategory(sc.nextLine());
            System.out.println("CD cost: " );
            cd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("CD id: ");
            cd.setId(sc.nextInt());
            anStore.addMedia(cd);
            System.out.println("CD added");
        }
    }

    //	Add DVD to Store(Method in AddToStore)
    public static void addDVDToStore(Scanner sc, Store anStore) {
        Media dvd = new DigitalVideoDisc();
        System.out.println("DVD title: " );
        String title = sc.nextLine();
//		Check DVD to Store
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            dvd.setTitle(title);
            System.out.println("DVD category: " );
            dvd.setCategory(sc.nextLine());
            System.out.println("DVD cost: " );
            dvd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("DVD id: ");
            dvd.setId(sc.nextInt());
            System.out.println("DVD added");
            anStore.addMedia(dvd);
            System.out.println("DVD added");
        }
    }

    public static void addToStore(Scanner sc, Store anStore) {
        menuAddMedia();
        int input = sc.nextInt();
        switch (input) {
            case 0:
                System.out.println("Cancel");
                break;
            case 1:
                addBookToStore(sc, anStore);
                break;
            case 2:
                addCDToStore(sc, anStore);
                break;
            case 3:
                addDVDToStore(sc, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }

    //	Remove Media To Store
    public static void removeToStore(Scanner sc, Store anStore) {
        System.out.println("Remove Media To Store");
        System.out.print("Media title remove is: ");
        String title = sc.nextLine();
        if(!anStore.search(title)) {
            System.out.println("The media doesn't exist");
        }
        else {
//			Remove Media title is "title"
//			Call Method search by title and return media.
            anStore.removeMedia(anStore.searchTitle(title));
            System.out.println("The media has been removed");
        }
    }

    public static void UpdateStore(Scanner sc, Store anStore) {
        menuUpdateStore();
        int input = sc.nextInt();
        switch (input) {
            case 0:
                System.out.println("Cancel");
                break;
            case 1:
                addToStore(sc, anStore);
                break;
            case 2:
                removeToStore(sc, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }


    public static void filterMediaInCart(Scanner sc, Cart anOrder) {
        menuFilterMedia();
        int k = sc.nextInt();
        switch (k){
            case 0:
                System.out.println("Cancel");
                break;
            case 1:
                int id = sc.nextInt();
                if(anOrder.search(id)) {
                    System.out.println(anOrder.searchId(id).toString());
                }
                else {
                    System.out.println("The Media id is not valid");
                }
                break;
            case 2:
                String title = sc.next();
                if(anOrder.search(title)) {
                    System.out.println(anOrder.searchTitle(title).toString());
                }
                else {
                    System.out.println("The Media title is not valid");
                }
                break;
            default:
                System.out.println("Not Corrected");
                break;
        }
    }

    public static void sortMediaInCart(Scanner sc, Cart anOrder) {
        menuSortMedia();
        int k = sc.nextInt();
        switch (k){
            case 0:
                System.out.println("Cancel");
                break;
            case 1:
                anOrder.sortByTitle();
                break;
            case 2:
                anOrder.sortByCost();
                break;
            default:
                System.out.println("Not Corrected");
                break;
        }
    }
}
