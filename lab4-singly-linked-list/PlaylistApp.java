import java.util.Scanner;

public class PlaylistApp {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("===== Playlist Manager =====");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song");
            System.out.println("3. Play next song");
            System.out.println("4. Display playlist");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter song title: ");
                String title = input.nextLine();
                System.out.print("Enter artist: ");
                String artist = input.nextLine();
                playlist.addSong(new Song(title, artist));
            } else if (choice == 2) {
                System.out.print("Enter title to remove: ");
                String title = input.nextLine();
                playlist.removeSong(title);
            } else if (choice == 3) {
                playlist.playNext();
            } else if (choice == 4) {
                playlist.displayPlaylist();
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}