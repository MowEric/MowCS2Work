import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarshipTest {

    @Test
    void constructorAndGettersWork() {
        Starship ship = new Starship("Enterprise", new Vector(5, 4));
        assertEquals("Enterprise", ship.getName());
        assertEquals("<5.0, 4.0>", ship.getPosition().toString());
        assertEquals("<0.0, 0.0>", ship.getVelocity().toString());
    }

    @Test
    void toStringWorks() {
        Starship ship = new Starship("Millenium Falcon", new Vector(3, 2));
        assertEquals("Millenium Falcon at <3.0, 2.0> moving <0.0, 0.0>", ship.toString());
    }

    @Test
    void accelerateChangesVelocity() {
        Starship ship = new Starship("White Star", new Vector(7, 1));
        ship.accelerate(new Vector(3, -3));
        assertEquals("<3.0, -3.0>", ship.getVelocity().toString());
        ship.accelerate(new Vector(2, 9));
        assertEquals("<5.0, 6.0>", ship.getVelocity().toString());
    }

    @Test
    void accelerateDoesNotChangePosition() {
        Starship ship = new Starship("Red Dwarf", new Vector(2, 5));
        ship.accelerate(new Vector(4, 2));
        assertEquals("<2.0, 5.0>", ship.getPosition().toString());
    }


    @Test
    void driftChangesPosition() {
        Starship ship = new Starship("Rocinante", new Vector(2, 5));
        ship.accelerate(new Vector(4, 2));
        ship.drift();
        assertEquals("<6.0, 7.0>", ship.getPosition().toString());
        ship.drift();
        assertEquals("<10.0, 9.0>", ship.getPosition().toString());
    }

}