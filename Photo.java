import java.util.ArrayList;
import java.util.List;

public class Photo {
    private boolean VERTICAL = false;
    private int ID = 0;
    private boolean USED = false;
    List<String> tags=new ArrayList<>();
    public boolean isVERTICAL() {
        return VERTICAL;
    }

    public void setVERTICAL(boolean VERTICAL) {
        this.VERTICAL = VERTICAL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isUSED() {
        return USED;
    }

    public void setUSED(boolean USED) {
        this.USED = USED;
    }
    public void addTag(String tag){
        tags.add(tag);
    }
}
