package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        List<Media> mediaList = new ArrayList<>();

        // Add some media (DVD, Book) into the list
        mediaList.add(new DigitalVideoDisc("Movie DVD", "Movie", "Director", 150f));
        mediaList.add(new Book("Java Book", "Programming", 29.99f, Arrays.asList("au1", "au2")));

        // Iterate through the list and print out the information of the media using toString()
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }

    }
}