package AimsProject.hust.hedspi.test.cart;

import AimsProject.hust.hedspi.aims.cart.Cart;
import AimsProject.hust.hedspi.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new Cart
        Cart cart = new Cart();
        // Create new dvd Object and add them to the Cart
        // Create new dvd1
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        // Create new dvd2
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        // Create new dvd3
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the method print Cart
        cart.printNewCart();
        // To-do: Test the search methods here
    }
}
