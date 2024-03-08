/** Jackson JSON library for easier JSON processing */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NoteManager {
    private List<Note> notes;
    private static final String NOTES_FILE_PATH = "data/notes.JSON";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public NoteManager() {
        this.notes = new ArrayList<>();
    }

    public void loadNotesFromJSON() {
        try {
            notes = objectMapper.readValue(new File(NOTES_FILE_PATH), new TypeReference<List<Note>>(){});
            System.out.println("Notes loaded from JSON");
        } catch (IOException e) {
            System.out.println("Error loading notes from JSON");
            e.printStackTrace();
        }
    }

    public void saveNotesToJSON() {
        try {
            objectMapper.writeValue(new File(NOTES_FILE_PATH), notes);
            System.out.println("Notes saved to JSON");
        } catch (IOException e) {
            System.out.println("Error saving notes to JSON" + e.getMessage());
        }
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
