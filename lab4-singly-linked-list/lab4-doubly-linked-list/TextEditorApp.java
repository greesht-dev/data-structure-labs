import java.util.Scanner;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("===== Text Editor =====");
            System.out.println("1. Type text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show current text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter text to add: ");
                String text = input.nextLine();
                editor.add(text);
                System.out.print("Current text: ");
                editor.printCurrent();
            } else if (choice == 2) {
                String result = editor.undo();
                if (result != null) {
                    System.out.println("After undo: " + result);
                }
            } else if (choice == 3) {
                String result = editor.redo();
                if (result != null) {
                    System.out.println("After redo: " + result);
                }
            } else if (choice == 4) {
                System.out.print("Current text: ");
                editor.printCurrent();
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}