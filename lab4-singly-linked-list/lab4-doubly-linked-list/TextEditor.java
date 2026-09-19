public class TextEditor {
    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        // Start with an initial empty string state.
        Node initialNode = new Node("", null, null);
        this.currentNode = initialNode;
    }

    public void add(String newText) {
        String updated = currentNode.textState + newText;
        Node newNode = new Node(updated, currentNode, null);
        currentNode.next = newNode;   // this erases the redo history
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
            return currentNode.textState;
        } else {
            System.out.println("Nothing to undo.");
            return null;
        }
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
            return currentNode.textState;
        } else {
            System.out.println("Nothing to redo.");
            return null;
        }
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}