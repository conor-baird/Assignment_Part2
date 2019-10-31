package fullAssignment.Model;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.CompletableFuture.anyOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

class CarsTest {

    @Test void checkCarMovement(){
        Cars cars = new Cars();
        cars.roads.set(0, 4);
        cars.roads.set(1,5);
        cars.roads.set(2,6);
        cars.roads.set(3,7);
        cars.roadsDriven.set(0,4);
        cars.roadsDriven.set(1,5);
        cars.carPosition = 6;
        cars.carMovement();
        assertEquals(7,cars.carPosition);
    }

    @Test void checkSetOriginalPos(){
        Cars cars = new Cars();
        cars.roads.set(0,4);
        cars.setOriginalPos();
        assertEquals(4,cars.carPosition);

    }



}