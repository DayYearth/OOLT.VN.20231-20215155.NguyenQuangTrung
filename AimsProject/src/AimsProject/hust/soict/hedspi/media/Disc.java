package AimsProject.hust.soict.hedspi.media;

public class Disc extends Media{
    private float length;
    private String director;

    public void setLength(float length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(int id, String title, String category, float cost, float length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(){

    }
    public Disc(float length, String director) {
        this.length = length;
        this.director = director;
    }

}
