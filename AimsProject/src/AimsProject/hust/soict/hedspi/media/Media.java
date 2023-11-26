package AimsProject.hust.soict.hedspi.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(){

    }

    public void playMedia(){

    }

    public Media(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public boolean equals(Object obj){
        Media tmp = (Media) obj;
        int flag = 0;
        if(this.title == tmp.getTitle()){
            flag = 1;
        }
        if(flag == 1){
            return true;
        } else return false;
    }
    public String toString() {
        return "Media - " + this.title + " - " + this.category + " - " + this.cost + " $";
    }
}
