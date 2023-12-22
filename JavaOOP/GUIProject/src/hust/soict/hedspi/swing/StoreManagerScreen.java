package hust.soict.hedspi.swing;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        // Create a sample store for testing
        Store sampleStore = new Store();
        sampleStore.addMedia(new Book("Sample Book", "Sample Category", 19.99f, Collections.singletonList("Sample Author")));
        sampleStore.addMedia(new DigitalVideoDisc("Sample DVD ", "SampleCategory","Sample Director", 29.99f));
        sampleStore.addMedia(new Book("Sample Book 2", "Sample Category", 19.99f, Collections.singletonList("Sample Author")));
        sampleStore.addMedia(new DigitalVideoDisc("Sample DVD 2 ", "SampleCategory","Sample Director", 29.99f));
        sampleStore.addMedia(new Book("Sample Book 3", "Sample Category", 19.99f, Collections.singletonList("Sample Author")));
        sampleStore.addMedia(new DigitalVideoDisc("Sample DVD 3 ", "SampleCategory","Sample Director", 29.99f));
        sampleStore.addMedia(new Book("Sample Book 4", "Sample Category", 19.99f, Collections.singletonList("Sample Author")));
        sampleStore.addMedia(new DigitalVideoDisc("Sample DVD 4", "SampleCategory","Sample Director", 29.99f));
        sampleStore.addMedia(new Book("Sample Book 5", "Sample Category", 19.99f, Collections.singletonList("Sample Author")));
        sampleStore.addMedia(new DigitalVideoDisc("Sample DVD 5", "SampleCategory","Sample Director", 29.99f));

        // Create the StoreManagerScreen
        new StoreManagerScreen(sampleStore);
    }
}
