package AimsProject.hust.soict.hedspi.aims.disc;

import AimsProject.hust.soict.hedspi.media.Disc;
import AimsProject.hust.soict.hedspi.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    private String title;
    private String category;
    private String director;
    private float length;
    private float cost;

    //section 16
    /*
    ● Classifier/Class member:
        ○ Defined in a class of which a single copy exists regardless of how many instances of the
        class exist.
        ○ Objective: to have variables that are common to all objects
        ○ Any object of class can change the value of a class variable; that's why you should always
        be careful with the side effect of class member
        ○ Class variables can be manipulated without creating an instance of the class
    ● Instance/Object member:
        ○ Associated with only objects
        ○ Defined inside the class but outside of any method
        ○ Only initialized when the instance is created
        ○ Their values are unique to each instance of a class
        ○ Lives as long as the object does
     */
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getNbDigitalVideoDiscs(){
        return nbDigitalVideoDiscs;
    }
    public void setId(){
        id = getNbDigitalVideoDiscs();
        nbDigitalVideoDiscs++;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public float getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }

    public DigitalVideoDisc(String title){
        super();
        this.title = title;
    }
    public DigitalVideoDisc (String category, String title, float cost){
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc (String director, String category, String title, float cost){
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public  DigitalVideoDisc (String title, String category, String director, int length, float cost){
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.length = length;
    }
    public DigitalVideoDisc(){

    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
