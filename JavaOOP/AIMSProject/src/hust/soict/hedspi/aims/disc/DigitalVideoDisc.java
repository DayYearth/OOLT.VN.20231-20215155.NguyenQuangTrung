package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc  extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    private static int idCounter = 1;
    private String director = "";
    private int length = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(idCounter++, title, category, cost, length, director);

        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float costs) {
        super(idCounter++, title, category, costs, 0, director);
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

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
