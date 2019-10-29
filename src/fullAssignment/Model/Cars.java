package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    int carPosition;
    String directionArray[] = {"UP","DOWN","STRAIGHT"};
    List<Integer> roads = new ArrayList<Integer>();
    List<Integer> roadsDriven = new ArrayList<Integer>();


    public void carRoads(int road){
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

    public int cardDrivenRoadsLookUp(int lookUp) {
        int outPut = 25000;
        for (int i = 0; i < roadsDriven.size(); i++) {
            if (roadsDriven.get(i) == lookUp) {
                outPut = lookUp;
            }
        }
        return outPut;
    }

    public void setOriginalPos(){
        carPosition = roads.get(0);
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
        Random random = new Random();
        Integer ints = random.nextInt(3);
            if (ints== 1) {
                carPosition = carPosition + direction3;
            }
            if (ints ==2){
                carPosition = carPosition + direction2;
            }
            if (ints == 3){
                carPosition = carPosition + direction1;
            }

    }

    public int carMovement(){
        if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-4)!=carRoadsLookUp(carPosition-4)){
            System.out.println("Two Road Intersection");
            twoIntersection(4,1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition-4)==carRoadsLookUp(carPosition-4)&&(carPosition+4)!=carRoadsLookUp(carPosition+4)){
            System.out.println("Two Road Intersection");
            twoIntersection(-4,1);
            roadsDriven.add(carPosition);
        }
        else if ((carPosition+1)==carRoadsLookUp(carPosition+1)&&(carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition-4)==carRoadsLookUp(carPosition-4)){
            System.out.println("Three Road Intersection");
            threeIntersection(4,-4,1);
            roadsDriven.add(carPosition);
        }
        else if((carPosition+4)==carRoadsLookUp(carPosition+4)&&(carPosition+4)!=cardDrivenRoadsLookUp(carPosition+4)){
            carPosition = carPosition + 4;
            roadsDriven.add(carPosition);
        }
        else if((carPosition-4)==carRoadsLookUp(carPosition-4)&&(carPosition-4)!=cardDrivenRoadsLookUp(carPosition-4)){
            carPosition = carPosition -4;
            roadsDriven.add(carPosition);
        }
        else if((carPosition+1)==carRoadsLookUp(carPosition+1)){
            carPosition = carPosition +1;
            roadsDriven.add(carPosition);
        }


        System.out.println(carPosition);
        System.out.println(roadsDriven);
        return carPosition;
    }

    public void displayRoads(){
        System.out.println(roads);
    }
    public Cars(){

    }

}
