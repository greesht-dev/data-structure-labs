import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);

        // 1. Create a new right node
        TwoFourNode right = new TwoFourNode();

        // 2. Promote middle key to parent
        int middle = node.keys.get(2);

        // if node is the root, make a new root
        if (node.parent == null) {
            TwoFourNode newRoot = new TwoFourNode();
            newRoot.children.add(node);
            node.parent = newRoot;
            root = newRoot;
        }
        TwoFourNode parent = node.parent;
        parent.insertKey(middle);

        // 3. Move keys and children appropriately
        right.keys.add(node.keys.get(3));
        node.keys.remove(3);
        node.keys.remove(2);

        if (!node.isLeaf()) {
            right.children.add(node.children.get(3));
            right.children.add(node.children.get(4));
            node.children.remove(4);
            node.children.remove(3);

            // 4. Update parent pointers
            for (TwoFourNode child : right.children) {
                child.parent = right;
            }
        }

        // add right node to parent right after the original node
        int index = parent.children.indexOf(node);
        parent.children.add(index + 1, right);
        right.parent = parent;
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}