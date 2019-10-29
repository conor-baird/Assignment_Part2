package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    int carPosition;
    List<Integer> roads = new ArrayList<Integer>();
    List<Integer> roadsDriven = new ArrayList<Integer>();
    boolean state=true;

    public List<Integer> roadsOutput(){
        return roads;
    }


    public void roadsChosen(int road){
        roads.add(road);
    }

    public int carRoadsLookUp(int lookUp) {
        int outPut = 25000;
        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i) == lookUp) {
                outPut = lookUp;
            }
        }
        return outPut;
    }

    public int carDrivenRoadsLookUp(int lookUp) {
        int outPut = 25000;
        for (int i = 0; i < roadsDriven.size(); i++) {
            if (roadsDriven.get(i) == lookUp) {
                outPut = lookUp;
            }
        }
        return outPut;
    }

    public int setOriginalPos(){
        carPosition = roads.get(0);
        return carPosition;
    }

    public void twoIntersection(int direction,int direction2){
        Random random = new Random();
        Integer ints = random.nextInt(2);

            if (ints== 1) {
                carPosition = carPosition + direction2;
            }
            if (ints ==2){
                carPosition = carPosition + direction;
            }

    }
    public void threeIntersection(int direction1, int direction2,int direction3){
        while(state==true) {
            Random random = new Random();
            Integer ints = random.nextInt(3);
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
            threeIntersection(4, -4, 1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition-1)==carRoadsLookUp(carPosition-1)&&(carPosition-4)==carRoadsLookUp(carPosition-4)&&(carPosition+1)==carRoadsLookUp(carPosition+1)) {
            System.out.println("Three Road Intersection");
            threeIntersection(-1, -4, 1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition-1)==carRoadsLookUp(carPosition-1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-4)==carRoadsLookUp(carPosition-4)) {
            System.out.println("Three Road Intersection");
            threeIntersection(-1, 4, -4);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-1)==carRoadsLookUp(carPosition-1)) {
            System.out.println("Three Road Intersection");
            threeIntersection(1, 4, -1);
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
