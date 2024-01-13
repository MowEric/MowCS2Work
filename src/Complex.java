public class Complex {
    public double real;
    public double imaginary;

    public Complex(double r, double i) {
        real = r;
        imaginary = i;
    }

    public Complex(Complex c) {
        this(c.real, c.imaginary);
    }

    public Complex() {
        this(0.0,0.0);
    }

    public Complex add(Complex addend) {
        return new Complex(this.real + addend.real, this.imaginary + addend.imaginary);
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.real, real) == 0 && Double.compare(complex.imaginary, imaginary) == 0;
    }

    public boolean equals(Complex c) {
        return this.real == c.real && this.imaginary == c.imaginary;
    }
}
