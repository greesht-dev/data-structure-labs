public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // add stops
        Position<String> eiffel = itinerary.addLast("Eiffel Tower");
        itinerary.addLast("Notre Dame");
        itinerary.addFirst("Arrive in Paris");

        System.out.println("Itinerary before:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }

        // insert a stop between Eiffel Tower and Notre Dame
        System.out.println();
        System.out.println("Adding Louvre Museum after Eiffel Tower...");
        itinerary.addAfter(eiffel, "Louvre Museum");
        System.out.println();

        System.out.println("Final itinerary:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}