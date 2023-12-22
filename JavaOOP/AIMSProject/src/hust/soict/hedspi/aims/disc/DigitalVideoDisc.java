package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media {
    private static int nbDigitalVideoDiscs = 0;
    private static int idCounter = 1;
    private String director = "";
    private int length = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(idCounter++, title, category, cost);
        this.director = director;
        this.length = length;

        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title){
        super(idCounter++, title);
        
        nbDigitalVideoDiscs++;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d minutes: %.2f $",
                getTitle(), getCategory(), director, length, getCost());
    }

    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
}
