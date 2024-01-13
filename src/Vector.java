public class Vector {
    private double x, y;

    /** Checks if two things are equal */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Double.compare(vector.x, x) == 0 && Double.compare(vector.y, y) == 0;
    }

    /** Returns a string that shows the x and y values of a vector */
    public String toString(){
        String v = "<" + x + ", " + y + ">";
        return v;
    }

    /** Makes a new vector with v as its x value and v1 as its y value */
    public Vector(double v, double v1) {
        this.x = v;
        this.y = v1;
    }

    /** Makes a new vector with 0 as its x and y value */
    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    /** Makes a new vector */
    public Vector Vector() {
        return new Vector();
    }

    /** Retrieves the x value of a vector */
    public double getX() {
        return this.x;
    }

    /** Retrieves the y value of a vector */
    public double getY() {
        return this.y;
    }

    /** Sets the x value of a vector to i */
    public void setX(int i) {
        this.x = i;
    }

    /** Sets the y value of a vector to i */
    public void setY(int i) {
        this.y = i;
    }

    /** Adds the x and y values of two vectors */
    public Vector plus(Vector b) {
        Vector v = new Vector();
        v.x = this.x + b.x;
        v.y = this.y + b.y;
        return v;
    }

    /** Subtracts the x and y values of two vectors */
    public Vector minus(Vector b) {
        Vector v = new Vector();
        v.x = this.x - b.x;
        v.y = this.y - b.y;
        return v;
    }

    /** Finds the dot product of two vectors */
    public int dot(Vector b) {
        return (int) (this.x * b.x + this.y * b.y);
    }

    /** Multiplies the x and y values of two vectors */
    public Vector times(int i) {
        Vector v = new Vector();
        v.x = this.x * i;
        v.y = this.y * i;
        return v;
    }

    /** Finds the distance between two vectors */
    public double distanceTo(Vector b) {
        double xDiff = this.x-b.x;
        double yDiff = this.y-b.y;
        return Math.sqrt((xDiff)*(xDiff)+(yDiff)*(yDiff));
    }
}
