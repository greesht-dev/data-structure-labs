public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 2);
        a.populateRandom();

        System.out.println("Matrix A:");
        System.out.println(a);

        Matrix b = new Matrix(2, 2);
        b.populateRandom();
        System.out.println("Matrix B:");
        System.out.println(b);

        Matrix sum = a.add(b);
        System.out.println("A + B:");
        System.out.println(sum);

        Matrix product = a.multiply(b);
        System.out.println("A * B:");
        System.out.println(product);

        // Demonstrate exception handling for add()
        try {
            Matrix c = new Matrix(3, 3);
            c.populateRandom();
            a.add(c);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception on add(): " + e.getMessage());
        }

        // Demonstrate exception handling for multiply()
        try {
            Matrix d = new Matrix(3, 3);
            d.populateRandom();
            a.multiply(d);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception on multiply(): " + e.getMessage());
        }
    }
}