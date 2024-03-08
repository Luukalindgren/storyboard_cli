import java.util.Scanner;
import java.util.List;
import java.util.Arrays;


public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NoteManager noteManager = new NoteManager();

    public void start() {
        noteManager.loadNotesFromJSON();
        System.out.println("---------------------");
        System.out.println("Welcome to the Storyboard!");
        System.out.println("---------------------");
        displayMenu();
    
        while(true) {
            System.out.println("Please select an option:");
            System.out.println("---------------------");
            String input = scanner.nextLine().trim().toLowerCase();
            
            switch (input) {
                case "1":
                    addNote();
                    break;
                case "2":
                    removeNote();
                    break;
                case "3":
                    listAllNotes();
                    break;
                case "4":
                    searchByTitle();
                    break;
                case "5":
                    searchByText();
                    break;
                case "6":
                    searchByTag();
                    break;
                case "q":
                    noteManager.saveNotesToJSON();
                    System.out.println("Saving notes and exiting!");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("---------------------");
        System.out.println("1. Add note");
        System.out.println("2. Remove note");
        System.out.println("3. List all notes");
        System.out.println("4. Search by title");
        System.out.println("5. Search by text");
        System.out.println("6. Search by tag");
        System.out.println("Q. Exit");
    }

    private void addNote() {
        System.out.println("---------------------");
        System.out.println("Enter note title:");
        System.out.println("---------------------");
        String title = scanner.nextLine();
        System.out.println("---------------------");
        System.out.println("Enter note text:");
        System.out.println("---------------------");
        String text = scanner.nextLine();
        System.out.println("---------------------");
        System.out.println("Enter note tags (comma separated):");
        System.out.println("---------------------");
        String[] tags = scanner.nextLine().split(",");
        noteManager.addNote(new Note(title, text, Arrays.asList(tags)));
    }

    private void removeNote() {
        System.out.println("---------------------");
        System.out.println("Enter note title to remove:");
        System.out.println("---------------------");
        String title = scanner.nextLine();
        noteManager.deleteNote(title);
    }

    /* THESE SEARCHES WOULD BE BETTER DONE IN ONE METHOD THAT TAKES THE FIELD AS PARAMETER
     * for example: search(String field) => search("title"), search("text"), search("tag"
     */
    private void searchByTitle() {
        System.out.println("---------------------");
        System.out.println("Enter title to search:");
        System.out.println("---------------------");
        String title = scanner.nextLine();
        if (noteManager.searchByTitle(title).isEmpty()) {
            System.out.println("No notes found");
            return;
        }
        System.out.println("---------------------");
        System.out.println("Matching notes:");
        System.out.println("---------------------");
        for (Note note : noteManager.searchByTitle(title)) {
            System.out.println(note);
            System.out.println("---------------------");
        }
    }

    private void searchByText() {
        System.out.println("---------------------");
        System.out.println("Enter text to search:");
        System.out.println("---------------------");
        String text = scanner.nextLine();
        if (noteManager.searchByText(text).isEmpty()) {
            System.out.println("No notes found");
            return;
        }
        System.out.println("---------------------");
        System.out.println("Matching notes:");
        System.out.println("---------------------");
        for (Note note : noteManager.searchByText(text)) {
            System.out.println(note);
            System.out.println("---------------------");
        }
    }

    private void searchByTag() {
        System.out.println("---------------------");
        System.out.println("Enter tag to search:");
        System.out.println("---------------------");
        String tag = scanner.nextLine();
        if (noteManager.searchByTag(tag).isEmpty()) {
            System.out.println("No notes found");
            return;
        }
        System.out.println("---------------------");
        System.out.println("Matching notes:");
        System.out.println("---------------------");
        for (Note note : noteManager.searchByTag(tag)) {
            System.out.println(note);
            System.out.println("---------------------");
        }
    }



    private void listAllNotes() {
        if (noteManager.listAllNotes().isEmpty()) {
            System.out.println("No notes found");
            return;
        }
        System.out.println("---------------------");
        System.out.println("All notes:");
        System.out.println("---------------------");
        for (Note note : noteManager.listAllNotes()) {
            System.out.println(note);
            System.out.println("---------------------");
        }
    }
}
