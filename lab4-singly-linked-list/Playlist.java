public class Playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.currentNode = null;
        this.size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        System.out.println("Added: " + song);
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        // case 1: removing the head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            if (currentNode == head) {
                currentNode = null;
            }
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            System.out.println("Removed: " + title);
            return;
        }

        // case 2: removing from elsewhere - find the predecessor
        Node prev = head;
        while (prev.next != null && !prev.next.song.getTitle().equalsIgnoreCase(title)) {
            prev = prev.next;
        }

        if (prev.next == null) {
            System.out.println("Song not found: " + title);
            return;
        }

        Node toRemove = prev.next;
        if (currentNode == toRemove) {
            currentNode = null;
        }
        prev.next = toRemove.next;
        if (toRemove == tail) {
            tail = prev;
        }
        size--;
        System.out.println("Removed: " + title);
    }

    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        } else if (currentNode.next == null) {
            currentNode = head;
        } else {
            currentNode = currentNode.next;
        }

        System.out.println("Now playing: " + currentNode.song);
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("--- Playlist (" + size + " songs) ---");
        Node current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i + ". " + current.song);
            current = current.next;
            i++;
        }
    }
}