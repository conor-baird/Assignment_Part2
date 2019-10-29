package fullAssignment.Model;

import java.util.Random;

public class TrafficLight {
    String lightColour;

    // This method randomly selects a number less than 100 and if this number is less than 30 the light colour becomes Red else it is green
    public String operatorLight(){
        Random random = new Random();
        int percentage = random.nextInt(100);
        if (percentage<30){
            lightColour = "Red";
        }
        else{
            lightColour = "Green";
        }
        return lightColour;
    }

    public TrafficLight(){
    }

}
