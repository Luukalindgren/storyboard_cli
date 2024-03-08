import java.util.Scanner;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NoteManager noteManager = new NoteManager();

    public void start() {
        noteManager.loadNotesFromJSON();
        System.out.println("Welcome to the Storyboard!");
        displayMenu();
    
        while(true) {
            System.out.println("Please select an option:");
            String input = scanner.nextLine().trim().toLowerCase();
            
            switch (input) {
                case "1":
                    //addNote();
                    break;
                case "2":
                    //removeNote();
                    break;
                case "3":
                    listAllNotes();
                    break;
                case "4":
                    //searchByTitle();
                    break;
                case "5":
                    //searchByText();
                    break;
                case "6":
                    //searchByTag();
                    break;
                case "q":
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
        System.out.println("1. Add note");
        System.out.println("2. Remove note");
        System.out.println("3. List all notes");
        System.out.println("4. Search by title");
        System.out.println("5. Search by text");
        System.out.println("6. Search by tag");
        System.out.println("Q. Exit");
    }

    private void listAllNotes() {
        if (noteManager.listAllNotes().isEmpty()) {
            System.out.println("No notes found");
            return;
        }
        for (Note note : noteManager.listAllNotes()) {
            System.out.println(note);
        }
    }
}
