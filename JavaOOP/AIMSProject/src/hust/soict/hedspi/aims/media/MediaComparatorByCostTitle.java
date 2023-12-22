package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {
        // Compare by cost first
        int costComparison = Float.compare(media2.getCost(), media1.getCost());

        // If cost is the same, then compare by title
        if (costComparison == 0) {
            return media1.getTitle().compareToIgnoreCase(media2.getTitle());
        }

        return costComparison;
    }
}
