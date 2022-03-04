package hw1.task3;

import java.util.ArrayList;
import java.util.Objects;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    private String label;
    private String boxType;

    public Box(String label) {
        this.label = label;

    }

    public void addFruit(T fruit){
        fruits.add(fruit);
        boxType = fruit.getClass().toString();
    }

    public float getWeight(){
        float weight = 0;
        for (T fruit:
             fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public String getLabel() {
        return label;
    }

    public <E extends Fruit> boolean compare(Box<E> anotherBox){
        if (this.equals(anotherBox)) return true;

        return (this.getWeight()-anotherBox.getWeight())<0.001;
    }

    public <E extends Fruit> void removeFruits(Box<E> anotherBox) {
        if (!this.boxType.equalsIgnoreCase(anotherBox.boxType)) {
            System.out.printf("Нельзя пересыпать %s в коробку с %s\n",this.boxType, anotherBox.boxType);
            return;
        }

        if (fruits.isEmpty()) System.out.printf("В коробке %s нет фруктов\n",this.label);
        else {
            for (T fruit:
                 fruits) {
                anotherBox.addFruit((E) fruit);
            }

            this.fruits.clear();
            System.out.printf("Фрукты из %s пересыпаны успешно в %s.\n",this.label, anotherBox.label);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(fruits, box.fruits) && Objects.equals(label, box.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruits, label);
    }

    @Override
    public String toString() {
        return "Box{" +
                "label=" + label +
                ", fruits='" + fruits + '\'' +
                '}';
    }
}
