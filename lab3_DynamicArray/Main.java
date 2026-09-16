public class Main {
    public static void main(String[] args) {
        DynamicArray<String> list = new DynamicArray<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");

        System.out.println("Size after adding 3 elements: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        // add enough elements to trigger resize
        for (int i = 0; i < 10; i++) {
            list.add("item" + i);
        }
        System.out.println("Size after adding more elements: " + list.size());

        String removed = list.remove(1);
        System.out.println("Removed: " + removed);
        System.out.println("Size after remove: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        // test exception
        try {
            list.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}