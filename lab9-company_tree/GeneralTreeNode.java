import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        System.out.println(name);
        for (Object c : children) {
            GeneralTreeNode child = (GeneralTreeNode) c;
            child.traversePreorder();
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        for (Object c : children) {
            GeneralTreeNode child = (GeneralTreeNode) c;
            child.traversePostorder();
        }
        System.out.println(name);
    }
}