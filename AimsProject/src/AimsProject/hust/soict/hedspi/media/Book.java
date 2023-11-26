package AimsProject.hust.soict.hedspi.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    public Book(){

    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public List<String> getAuthors() {
        return this.authors;
    }
    public void addAuthor(String authorName){
        for(String tmp: authors){
            if(authorName == tmp){
                System.out.println("Author has been already");
                return;
            }
        }
        authors.add(authorName);
        System.out.println("Author has been added");
    }

    public void removeAuthors(String authors) {
        boolean flag = false;
        Iterator tmp = this.authors.iterator();

        while(tmp.hasNext()) {
            String s = (String)tmp.next();
            if (s == authors) {
                flag = true;
                break;
            }
        }

        if (flag) {
            this.authors.remove(authors);
            System.out.println("The author has been removed");
        } else {
            System.out.println("The author does not exist");
        }

    }
}
