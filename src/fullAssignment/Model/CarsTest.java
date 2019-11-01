package fullAssignment.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test void checkCarMovement(){
        Cars cars = new Cars();
        cars.roads.add(4);
        cars.roads.add(5);
        cars.roads.add(6);
        cars.roads.add(7);
        cars.carPosition = 6;
        cars.carMovement();
        assertEquals(7,cars.carPosition);
    }

    @Test void checkSetOriginalPos(){
        Cars cars = new Cars();
        cars.roads.add(4);
        cars.setOriginalPos();
        assertEquals(4,cars.carPosition);
    }

    @Test void checkRoadsLookUp(){
        Cars cars = new Cars();
        cars.roads.add(4);
        cars.roads.add(5);
        cars.roads.add(6);
        cars.roads.add(7);
        assertEquals(5,cars.carRoadsLookUp(5));
    }

    @Test void checkRoadsDriveLookUp(){
        Cars cars = new Cars();
        cars.roadsDriven.add(4);
        cars.roadsDriven.add(5);
        cars.roadsDriven.add(6);
        cars.roadsDriven.add(7);
        assertEquals(5,cars.carDrivenRoadsLookUp(5));
    }

    @Test void checkMultiRoadIntersection(){
        Cars cars = new Cars();
        cars.roads.add(4);
        cars.roads.add(0);
        cars.roads.add(5);
        cars.roads.add(8);
        cars.roadsDriven.add(0);
        cars.roadsDriven.add(5);
        cars.carPosition = 4;
        cars.multiRoadIntersection(1,-4,4);
        assertEquals(8,cars.carPosition);
    }





}