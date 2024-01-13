// Letter Counter by Eric Mow and Andrew Fowler

public class LetterCounter {

    public static void main(String[] args) {
        In file = new In("para1.txt");
        // Counter spans from 0-25, because there are 26 letters in the alphabet.
        int alpha[] = new int[26];
        for (int x = 0; x <= 25; x++) {
            alpha[x] = 0;
        }

        // The number ranges below are derived from the ascii table.
        while (!file.isEmpty()) {
            char ch = file.readChar();

            // If statement below converts capital letter to lowercase, so they can be read by the program.
            if (ch <= 90 && ch >= 65) {
                alpha[ch - 65]++;
            }

            // Numbers below are the range of lower case letters from the ascii table, so it should skip over punctuation. Capital letters have already been converted to lowercase.
            if (ch >= 97 && ch <= 122) {
                alpha[ch - 97]++;

            }
        }

        // Print the letters followed by the number of times they occur, starting with 'a'.
        char c = 'a';
        int max = 0;
        for (int b = 0; b <= 25; b++) {
            StdOut.println(c + ": " + alpha[b]);
            if (max < alpha[b]) {
                max = alpha[b];
            }
            c++;
        }
        StdOut.println(max);
        // Draw the graph!

        // First, set the scale of the window.
        StdDraw.setXscale(0, 30);
        StdDraw.setYscale(0, 30);

        // Set the scale of the square for the graph.
        StdDraw.square(15, 15, 13);
        // Write the heading.
        StdDraw.text(15, 29, "Letter Distribution");
        // Label the axes.
        StdDraw.text(1, 2, "0");
        StdDraw.text(1, 28, "" + max);

        // Draw the bar graph.
        char p = 'a';
        for (int d = 0; d <= 25; d++) {
            // Label each letter beneath the x-axis.
            StdDraw.setPenColor(StdDraw.BLACK);
            //the "" initializes java to expect a string, and converts p from a character to a string.
            StdDraw.text(2.5 + d, 1, "" + p);
            p++;

            // Draw rectangles.
            StdDraw.setPenColor(StdDraw.RED);
            // Fill rectangles.
            StdDraw.filledRectangle(2.5+d, 2+ alpha[d]*26.0/max/2, .5,alpha[d]*26.0/max/2);
            StdDraw.setPenColor(StdDraw.BLACK);
            // Outline rectangles.
            StdDraw.rectangle(2.5+d, 2+ alpha[d]*26.0/max/2, .5,alpha[d]*26.0/max/2);
        }
    }
}
