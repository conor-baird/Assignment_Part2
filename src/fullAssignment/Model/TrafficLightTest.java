package fullAssignment.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    void checkOperatorLight(){
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.operatorLight();
        int percentage = 20;
        if (percentage<30){
            assertEquals("Red",trafficLight.lightColour);
        }
        else{
            assertEquals("Green",trafficLight.lightColour);
        }
    }

}