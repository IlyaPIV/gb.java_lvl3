package hw1.task3;

public class Apple extends Fruit{

    public Apple() {
    }

    public Apple(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
