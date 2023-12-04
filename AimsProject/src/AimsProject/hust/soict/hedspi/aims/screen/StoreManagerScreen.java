package AimsProject.hust.soict.hedspi.aims.screen;

import AimsProject.hust.soict.hedspi.aims.store.Store;
import AimsProject.hust.soict.hedspi.media.Media;
import AimsProject.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import AimsProject.hust.soict.hedspi.media.Playable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//This will be our view store screen while logging in with the role Store Manager.
public class StoreManagerScreen {
    Store store; //information on the items in the store to display them.
    public static class StoreScreen extends JFrame{
        private Store store;
        private JButton btnAddToCart, btnPlay;

        JPanel createNorth() {
            JPanel north = new JPanel();
            north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
            north.add(createMenuBar());
            north.add(createHeader());
            return north;
        }

        JMenuBar createMenuBar() {
            JMenu menu = new JMenu("Options");

            JMenu smUpdateStore = new JMenu("Update Store");
            smUpdateStore.add(new JMenuItem("Add Book"));
            smUpdateStore.add(new JMenuItem("Add CD"));
            smUpdateStore.add(new JMenuItem("Add DVD"));

            menu.add(smUpdateStore);
            menu.add(new JMenuItem("View Store"));
            menu.add(new JMenuItem("View Cart"));

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

            JButton cart = new JButton("View cart");
            cart.setPreferredSize(new Dimension(100, 50));
            cart.setMaximumSize(new Dimension(100, 50));

            header.add(Box.createRigidArea(new Dimension(10, 10)));
            header.add(title);
            header.add(Box.createHorizontalGlue());
            header.add(cart);
            header.add(Box.createRigidArea(new Dimension(10, 10)));

            return header;
        }

        JPanel createCenter() {
            JPanel center = new JPanel();
            center.setLayout(new GridLayout(3, 3, 2, 2));

            ArrayList<Media> mediaInStore = store.getItemsInStore();
            for(Media m: mediaInStore) {
                MediaStore cell = new MediaStore(m);
                center.add(cell);
            }

            return center;
        }

        public class MediaStore extends JPanel {
            private Media media;

            public MediaStore(Media media) {
                this.media = media;
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

                JLabel title = new JLabel(media.getTitle());
                title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
                title.setAlignmentX(CENTER_ALIGNMENT);

                JLabel cost = new JLabel("" + media.getCost() + " $");
                cost.setAlignmentX(CENTER_ALIGNMENT);

                JPanel container = new JPanel();
                container.setLayout(new FlowLayout(FlowLayout.CENTER));

                if(media instanceof Playable) {
                    JButton playButton = new JButton("Play");
                    container.add(playButton);
                }

                this.add(Box.createVerticalGlue());
                this.add(title);
                this.add(cost);
                this.add(Box.createVerticalGlue());
                this.add(container);

                this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }



        public StoreScreen(Store store) {
            this.store = store;
            Container cp = getContentPane();
            cp.setLayout(new BorderLayout());

            cp.add(createNorth(), BorderLayout.NORTH);
            cp.add(createCenter(), BorderLayout.CENTER);

            setVisible(true);
            setTitle("Store");
            setSize(1024, 768);
        }

        public static void main(String[] args) {
            Store store = new Store();
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
            store.addMedia(dvd1);
            new StoreManagerScreen();
        }
    }

}
