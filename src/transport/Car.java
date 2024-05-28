package transport;

public class Car {

    private int power;
    public final String number;

    public Car() {
        number = "";
    }

    public Car(int power, String number) {
        this.power = power;
        this.number = number;
    }

    public int getPower() {
        return power;
    }

    void setPower(int power) {
        this.power = power;
    }

    protected void printNumber() {
        System.out.println(number);
    }
}