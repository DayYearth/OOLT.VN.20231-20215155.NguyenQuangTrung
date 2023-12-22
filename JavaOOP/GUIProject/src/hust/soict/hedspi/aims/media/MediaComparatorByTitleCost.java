package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media media1, Media media2) {
        // Compare by title first
        int titleComparison = media1.getTitle().compareToIgnoreCase(media2.getTitle());

        // If title is the same, then compare by cost
        if (titleComparison == 0) {
            return Float.compare(media2.getCost(), media1.getCost());
        }

        return titleComparison;
    }
}
