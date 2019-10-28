package fullAssignment.Model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    int carPosition;
    List<Integer> roads = new ArrayList<Integer>();

    public void carRoads(int road){
        roads.add(road);
    }

    public int carRoadsLookUp(int lookUp) {
        int outPut = 0;
        for (int i = 0; i < roads.size(); i++) {
            if (roads.get(i) == lookUp) {
                outPut = lookUp;
                System.out.println(outPut);
            }
        }
        return outPut;
    }

    public void setOriginalPos(){
        carPosition = roads.get(0);
    }

    public void carMovement(){
        if((carPosition+1)==carRoadsLookUp(carPosition+1)){
            carPosition = carPosition +1;
        }
    }


    public void displayRoads(){
        System.out.println(roads);
    }
    public Cars(){

    }

}
