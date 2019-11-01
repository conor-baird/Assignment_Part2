package fullAssignment.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadsTest {

    @Test void checkSetterAndGetter(){
        Roads roads = new Roads();
        roads.setNumber(4);
        assertEquals(4,roads.getNumber());
    }

}