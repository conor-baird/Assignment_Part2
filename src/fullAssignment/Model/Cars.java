package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    int carPosition;
    String directionArray[] = {"UP","DOWN","STRAIGHT"};
    List<Integer> roads = new ArrayList<Integer>();


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

    public void setOriginalPos(){
        carPosition = roads.get(0);
    }

    public void twoIntersection(int direction,int direction2){
        Random random = new Random();
        Integer ints = random.nextInt(2);
        if ((carPosition+direction)==carRoadsLookUp(carPosition+direction)){
            System.out.println("Fuck this");
            if (ints== 1) {
                carPosition = carPosition + direction2;
            }
            if (ints ==2){
                carPosition = carPosition + direction;
            }
        }
    }
    public void threeIntersection(int direction1, int direction2,int direction3){
        Random random = new Random();
        Integer ints = random.nextInt(3);
        if ((carPosition+direction1)==carRoadsLookUp(carPosition+direction1)&&(carPosition+direction2)==carRoadsLookUp(carPosition+direction2)){
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
    }

    public int carMovement(){
        if ((carPosition+1)==carRoadsLookUp(carPosition+1)){
            twoIntersection(4,1);
            twoIntersection(-4,1);
            threeIntersection(4,-4,1);
            twoIntersection(1,1);
        }
        /*if ((carPosition-1)==carRoadsLookUp(carPosition-1)){
            twoIntersection(4,-1);
            twoIntersection(-4,-1);
            threeIntersection(4,-4,-1);
        }*/
        System.out.println(carPosition);
        return carPosition;
    }

    public void displayRoads(){
        System.out.println(roads);
    }
    public Cars(){

    }

}
