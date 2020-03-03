import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SlideShow {
    List<Photo> photos = new ArrayList<>();
    boolean isfull=false;
    Set<String> tags=new HashSet<>();
    public void add(Photo add){
        photos.add(add);
    }
    public void setFullTags(){
        for (int i=0; i<photos.size();i++){
            Photo photo= photos.get(i);
            for (int j=0; j<photo.tags.size();j++){
                tags.add(photo.tags.get(j));
            }
        }
    }
}
