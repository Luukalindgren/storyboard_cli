import java.util.ArrayList;
import java.util.List;

public class Note {

    private String title;
    private String text;
    private List<String> tags = new ArrayList<String>();
    
    public Note() {
    }

    public Note(String title, String text, List<String> tags) {
        this.title = title;
        this.text = text;
        this.tags = tags;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public void addTag(String tag) {
        tags.add(tag);
    }
    @Override
    public String toString() {
        return "Title: " + title + ", \nText: " + text + ", \nTags: " + tags;
    }
}
