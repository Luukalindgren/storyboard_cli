public class StoryboardUnitTests {
    public static void main(String[] args) {
        testAddNote();
        testRemoveNote();
        testSearchByTitle();
        testSearchByText();
        testSearchByTag();
        testListAllNotes();
    }

    public static void testAddNote() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        if (noteManager.listAllNotes().size() != 1) {
            System.out.println("testAddNote failed");
        }
    }

    public static void testRemoveNote() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        noteManager.deleteNote(note.getTitle());
        if (noteManager.listAllNotes().size() != 0) {
            System.out.println("testRemoveNote failed");
        }
    }

    public static void testSearchByTitle() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        if (noteManager.searchByTitle("Test Title").size() != 1) {
            System.out.println("testSearchByTitle failed");
        }
    }

    public static void testSearchByText() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        if (noteManager.searchByText("Test Text").size() != 1) {
            System.out.println("testSearchByText failed");
        }
    }

    public static void testSearchByTag() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        if (noteManager.searchByTag("Test Tag").size() != 1) {
            System.out.println("testSearchByTag failed");
        }
    }

    public static void testListAllNotes() {
        NoteManager noteManager = new NoteManager();
        Note note = new Note();
        note.setTitle("Test Title");
        note.setText("Test Text");
        note.addTag("Test Tag");
        noteManager.addNote(note);
        if (noteManager.listAllNotes().size() != 1) {
            System.out.println("testListAllNotes failed");
        }
    }
    
}
