public class HelloWorld2 {

    public static void main (String[] args) {
        int i = 4;



        Complex c;
        c = new Complex();
        c.real = 0.0;
        c.imaginary = 0.0;

        Complex c2 = new Complex();
        c2.real = 2.0;
        c2.imaginary = 20;

        Complex c3 = c;
        c = c.add(c2);
        Complex c4 = new Complex(0.0,0.0);

        StdOut.println("c3 = " + c3);
        StdOut.println("c4 = " + c4);
        if (c3.equals(c4)) {
            StdOut.println("equal!");
        } else {
            StdOut.println("bruh");
        }


    }
}