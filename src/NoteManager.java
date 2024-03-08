import java.util.ArrayList;
import java.util.List;

public class NoteManager {
    private List<Note> notes;

    public NoteManager(List<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    /** For simplicity remove works only with given Note title */
    public void deleteNote(String title) {
        for (Note note : notes) {
            if (note.getTitle().equals(title)) {
                notes.remove(note);
                break;
            }
        }
    }

    //** Needs to be List<Note> if there are many matching Notes */
    public List<Note> searchByTitle(String title) {
        List<Note> result = new ArrayList<Note>();
        for (Note note : notes) {
            if (note.getTitle().contains(title)) {
                result.add(note);
            }
        }
        return result;
    }

    public List<Note> searchByText(String text) {
        List<Note> result = new ArrayList<Note>();
        for (Note note : notes) {
            if (note.getText().contains(text)) {
                result.add(note);
            }
        }
        return result;
    }

    public List<Note> searchByTag(String tag) {
        List<Note> result = new ArrayList<Note>();
        for (Note note : notes) {
            if (note.getTags().contains(tag)) {
                result.add(note);
            }
        }
        return result;
    }

    public List<Note> listAllNotes() {
        /** Return a copy to prevent external modification, maybe waste of memory? */
        return new ArrayList<Note>(notes);
    }
}
