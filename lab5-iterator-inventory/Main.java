public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // add starting items
        inventory.addItem(new Item("Wooden Stick"));
        inventory.addItem(new Item("Magic Gem"));
        inventory.addItem(new Item("Health Potion"));

        System.out.println("Before combining:");
        inventory.display();

        System.out.println();
        inventory.combineItems("Wooden Stick", "Magic Gem");
        System.out.println();

        System.out.println("After combining:");
        inventory.display();
    }
}