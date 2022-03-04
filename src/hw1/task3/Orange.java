package hw1.task3;

public class Orange extends Fruit{

    public Orange() {
    }

    public Orange(float weight){
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
