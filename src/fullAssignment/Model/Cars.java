package fullAssignment.Model;

public class Cars {
    int carLength;
    int carStartPosition;
    int carEndPosition;

    public int getCarLength() {
        return carLength;
    }

    public int getCarEndPosition() {
        return carEndPosition;
    }
    public int getCarStartPosition() {
        return carStartPosition;
    }

    public void setCarLength(int carLength) {
        this.carLength = carLength;
    }

    public void setCarEndPosition(int carEndPosition) {
        this.carEndPosition = carEndPosition;
    }
    // This method sets the start position of the car depending on it length because if it has length of 1 its
    // start position needs to be in the 0 segements otherwise the start position can be equal to its length.
    public void setCarStartPosition(int carStartPosition) {
        if (carLength<=1){
            this.carStartPosition = 0;
        }
        else {
            this.carStartPosition = carStartPosition;
        }
    }

    public void moveCar(){
        carStartPosition += 1;
        carEndPosition += 1;
    }
    //This method sets the car positions at the start of new road depending on if it length is greater than 1
    public void setCarToOriginalPos(){
        if (carLength<=1){
            carStartPosition = 0;
            carEndPosition =0 ;
        }
        else {
            carStartPosition = carLength;
            carEndPosition = 0;
        }
    }

    public Cars(int carLength){
        setCarLength(carLength);
        setCarEndPosition(0);
        setCarStartPosition(carLength);
    }

}
