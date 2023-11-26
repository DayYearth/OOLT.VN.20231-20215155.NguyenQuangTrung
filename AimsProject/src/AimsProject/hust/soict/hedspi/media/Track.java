package AimsProject.hust.soict.hedspi.media;

public class Track implements Playable{
    private int length;
    private String title;

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Track(int length, String title) {
        this.length = length;
        this.title = title;
    }

    public Track() {
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object obj){
        Track tmp = (Track) obj;
        int flag = 0;
        if(this.title == tmp.getTitle() && this.length == tmp.getLength()){
            flag = 1;
        }
        if(flag == 1){
            return true;
        } else return false;
    }
}
