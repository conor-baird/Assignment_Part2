package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    int carPosition;
    List<Integer> roads = new ArrayList<>();
    List<Integer> roadsDriven = new ArrayList<>();
    private boolean state=true;

    // This method returns the roads list and used in the main class main method to write
    // to the csv file.
    public List<Integer> roadsOutput(){
        return roads;
    }

    // THis method takes the roads index position on the gridlayout from the main class and
    // assigns it to the road list in this class.
    public void roadsChosen(int road){
        roads.add(road);
    }

    // This method takes in a position value and compares it against all of the list elements in
    // in the roads class and if a match is found it returns this found value.
    private int carRoadsLookUp(int lookUp) {
        int outPut = 25000;
        for (Integer road : roads) {
            if (road == lookUp) {
                outPut = lookUp;
                break;
            }
        }
        return outPut;
    }

    // This method does essentially the same thing as the carRoadsLookUp method but differs in the way
    // that it searches through the driven roads list to find a match and returns that match.
    private int carDrivenRoadsLookUp(int lookUp) {
        int outPut = 25000;
        for (Integer integer : roadsDriven) {
            if (integer == lookUp) {
                outPut = lookUp;
                break;
            }
        }
        return outPut;
    }

    // This method is used in the initalisation of the road maps and sets the cars position
    // to the first entered position in the roads array list.
    public int setOriginalPos(){
        carPosition = roads.get(0);
        return carPosition;
    }

    // This method takes in three different direction options and using a while loop and randomiser
    // it decides randomly which road the car will next go down based on the directions provided and will
    // also check if the car has already been down that road before it sets this new direction to the car positon
    private void multiRoadIntersection(int direction1, int direction2, int direction3){
        while(state) {
            Random random = new Random();
            int ints = random.nextInt(3);
            if ((carPosition + direction1) != carDrivenRoadsLookUp(carPosition + direction1)) {
                if (ints == 1) {
                    carPosition = carPosition + direction3;
                    state = false;
                }
            }
            if ((carPosition + direction2) != carDrivenRoadsLookUp(carPosition + direction2)) {
                if (ints == 2) {
                    carPosition = carPosition + direction2;
                    state = false;
                }
            }
            if ((carPosition + direction3) != carDrivenRoadsLookUp(carDrivenRoadsLookUp(carPosition + direction3))) {
                if (ints == 3) {
                    carPosition = carPosition + direction1;
                    state = false;
                }
            }
        }

    }

    // This method is back bone of this program and sorts through to find any possible direction the car can go
    // and determines if its multiple road intersection or straight ahead and uses the multi intersection method to handle
    // the cars movement as well as ensureing the car can move straight forward without back tracking.
    public int carMovement(){
         if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-4)==carRoadsLookUp(carPosition-4)) {
            System.out.println("Three Road Intersection");
            multiRoadIntersection(4, -4, 1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition-1)==carRoadsLookUp(carPosition-1)&&(carPosition-4)==carRoadsLookUp(carPosition-4)&&(carPosition+1)==carRoadsLookUp(carPosition+1)) {
            System.out.println("Three Road Intersection");
            multiRoadIntersection(-1, -4, 1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition-1)==carRoadsLookUp(carPosition-1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-4)==carRoadsLookUp(carPosition-4)) {
            System.out.println("Three Road Intersection");
            multiRoadIntersection(-1, 4, -4);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-1)==carRoadsLookUp(carPosition-1)) {
            System.out.println("Three Road Intersection");
            multiRoadIntersection(1, 4, -1);
            roadsDriven.add(carPosition);
        }
        else if((carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition+4)!=carDrivenRoadsLookUp(carPosition+4)){
            carPosition = carPosition + 4;
            roadsDriven.add(carPosition);
        }
        else if((carPosition-4)==carRoadsLookUp(carPosition-4)&&(carPosition-4)!=carDrivenRoadsLookUp(carPosition-4)){
            carPosition = carPosition -4;
            roadsDriven.add(carPosition);
        }
        else if((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+1)!=carDrivenRoadsLookUp(carPosition+1)){
            carPosition = carPosition +1;
            roadsDriven.add(carPosition);
        }
        else if((carPosition-1)==carRoadsLookUp(carPosition-1)&&(carPosition-1)!=carDrivenRoadsLookUp(carPosition-1)){
            carPosition = carPosition -1;
            roadsDriven.add(carPosition);
        }
        System.out.println(roadsDriven);
        return carPosition;
    }
    // this method simply displays the road list values and is used mainly for bug checking.
    public void displayRoads(){
        System.out.println(roads);
    }

    public Cars(){
    }

}
