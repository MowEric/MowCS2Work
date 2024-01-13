public class Starship {
    private String name;
    private Vector position, velocity;

    /** Makes a new starship with an appropriate name and position, as well as it sets its velocity to 0 */
    public Starship(String name, Vector vector) {
        this.name = name;
        this.position = vector;
        this.velocity = new Vector();
        this.velocity.setX(0);
        this.velocity.setY(0);
    }

    /** Returns a string with the name of a Starship its position and its velocity */
    public String toString() {
        String v = name + " at " + position + " moving " + velocity;
        return v;
    }

    /** Returns the name of a Starship */
    public String getName() {
        return this.name;
    }

    /** Returns the x and y position of a Starship */
    public Vector getPosition() {
        return this.position;
    }

    /** Returns the x and y velocity of a Starship */
    public Vector getVelocity() {
        return this.velocity;
    }

    /** Makes the Starship drift positions according to its x and y velocity */
    public void drift() {
        this.position.setX((int) (this.position.getX() + this.velocity.getX()));
        this.position.setY((int) (this.position.getY() + this.velocity.getY()));
    }

    /** Makes the Starship accelerate by changing its x and y velocity */
    public void accelerate(Vector v) {
        this.velocity.setX((int) (this.velocity.getX() + v.getX()));
        this.velocity.setY((int) (this.velocity.getY() + v.getY()));
    }
}
