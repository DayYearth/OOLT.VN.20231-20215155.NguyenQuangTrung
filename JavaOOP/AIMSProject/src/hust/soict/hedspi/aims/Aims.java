package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
    }

    public static void viewStore() {
        store.displayStore();
        int choice;
        do {
            storeMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null) {
            System.out.println("Media Details:");
            System.out.println(media);
            int choice;
            do {
                mediaDetailsMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addToCart(media);
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        System.out.println("Returning to store menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addToCart() {
        System.out.print("Enter the title of the media to add to the cart: ");
        String title = scanner.nextLine();

        Media mediaToAdd = store.findMediaByTitle(title);
        if (mediaToAdd != null) {
            cart.addMedia(mediaToAdd);
            System.out.println("Media added to the cart successfully.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }
    public static void addToCart(Media media) {
        cart.addMedia(media);
        System.out.println("Media added to the cart.");
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    public static void updateStore() {
        // Implement functionality to add or remove media from the store
    }

    public static void seeCurrentCart() {
        int choice;
        do {
            cartMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterMediaInCart();
                    break;
                case 2:
                    sortMediaInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        } while (choice != 0);
    }

    public static void filterMediaInCart() {
        System.out.println("Choose a filter option:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        int filterOption = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (filterOption) {
            case 1:
                System.out.print("Enter the ID to filter by: ");
                int idFilter = scanner.nextInt();
                cart.filterMediaById(idFilter);
                break;
            case 2:
                System.out.print("Enter the title to filter by: ");
                String titleFilter = scanner.nextLine();
                cart.filterMediaByTitle(titleFilter);
                break;
            default:
                System.out.println("Invalid filter option.");
                break;
        }
    }

    public static void sortMediaInCart() {
        System.out.println("Choose a sorting option:");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        int sortOption = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (sortOption) {
            case 1:
                cart.sortMediaByTitle();
                break;
            case 2:
                cart.sortMediaByCost();
                break;
            default:
                System.out.println("Invalid sorting option.");
                break;
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove from the cart: ");
        String titleToRemove = scanner.nextLine();
        cart.removeMedia(titleToRemove);
    }

    public static void placeOrder() {
        System.out.println("Order placed successfully. Emptying the cart.");
        cart.clear();
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
