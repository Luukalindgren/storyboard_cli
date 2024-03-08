import java.util.ArrayList;
import java.util.List;

/** Singleton class, because only one instance is needed */
public class Storyboard {
    private static Storyboard instance;
    /** List because of its flexibility. Array would be more memory efficient, but not so flexible.   */
    private List<Note> notes;
    
    private Storyboard() {
        notes = new ArrayList<Note>();
    }

    public static Storyboard getInstance() {
        if (instance == null) {
            instance = new Storyboard();
        }
        return instance;
    }

    public List<Note> getNotes() {
        return notes;
    }
}
