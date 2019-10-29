package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    int carPosition;
    List<Integer> roads = new ArrayList<Integer>();
    List<Integer> roadsDriven = new ArrayList<Integer>();
    private boolean state=true;

    public List<Integer> roadsOutput(){
        return roads;
    }


    public void roadsChosen(int road){
        roads.add(road);
    }

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

    public int setOriginalPos(){
        carPosition = roads.get(0);
        return carPosition;
    }


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

    public void displayRoads(){
        System.out.println(roads);
    }
    public Cars(){

    }

}
