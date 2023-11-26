package AimsProject.hust.soict.hedspi.media;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList();

    public String getArtist() {
        return artist;
    }

    public CompactDisc() {
    }
    public void addTrack(Track track) {
        Iterator tmp = this.tracks.iterator();
        while(tmp.hasNext()) {
            Track t = (Track)tmp.next();
            if (t.getTitle() == track.getTitle()) {
                System.out.println("The track already exists");
                return;
            }
        }
        System.out.println("The track has been added");
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        boolean k = false;
        Iterator tmp = this.tracks.iterator();
        while(tmp.hasNext()) {
            Track t = (Track)tmp.next();
            if (t.getTitle() == track.getTitle()) {
                k = true;
                break;
            }
        }
        if (k) {
            System.out.println("The track has been removed");
            this.tracks.remove(track);
        } else {
            System.out.println("The track does not exist");
        }
    }

    public float getLength() {
        float total_length = 0;
//        Track t;
//        for(Iterator tmp = this.tracks.iterator(); tmp.hasNext(); total_length += t.getLength()) {
//            t = (Track)tmp.next();
//        }
        for(Track tmp : tracks){
            total_length += tmp.getLength();
        }
        return total_length;
    }

    public void play(){
        for(Track tmp : tracks){
            tmp.play();
        }
    }
}
