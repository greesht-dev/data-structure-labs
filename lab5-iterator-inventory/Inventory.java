import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // adds an item to the list
    public void addItem(Item item) {
        items.add(item);
    }

    // prints every item
    public void display() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println("- " + item);
        }
    }

    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (current.getName().equals(name1) && !found1) {
                found1 = true;
                iter.remove(); // safe removal with the iterator
            } else if (current.getName().equals(name2) && !found2) {
                found2 = true;
                iter.remove();
            }
        }

        // add the new item after the loop so we don't get a ConcurrentModificationException
        if (found1 && found2) {
            items.add(new Item("Magic Staff"));
            System.out.println("Combined " + name1 + " and " + name2 + " into Magic Staff!");
        } else {
            System.out.println("Could not find both items.");
        }
    }
}