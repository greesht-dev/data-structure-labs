public class Item {
    String name;

    // constructor
    public Item(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }

    // returns the item name when printed
    public String toString() {
        return name;
    }
}