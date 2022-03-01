package hw1;


import hw1.task3.Apple;
import hw1.task3.Box;
import hw1.task3.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        task1();

        task2();

        task3();
    }

    public static void task1(){

        System.out.println("============ TASK #1 ============");

        TasksForArray<Integer> tempArray1 = new TasksForArray<>(new Integer[]{1,2,3,4,5});
        TasksForArray<Character> tempArray2 = new TasksForArray<>(new Character[]{'a','b','c','d','e'});
        TasksForArray<String> tempArray3 = new TasksForArray<>(new String[]{"мама","мыла","раму"});

        tempArray1.exchangeTwo(3,5);
        tempArray2.exchangeTwo(2,4);
        tempArray3.exchangeTwo(1,3);

        System.out.println(Arrays.toString(tempArray1.getArray()));
        System.out.println(Arrays.toString(tempArray2.getArray()));
        System.out.println(Arrays.toString(tempArray3.getArray()));
    }

    public static void task2(){

        System.out.println("============ TASK #2 ============");

        TasksForArray<Integer> tempArray1 = new TasksForArray<>(new Integer[]{1,2,3,4,5});
        TasksForArray<Character> tempArray2 = new TasksForArray<>(new Character[]{'a','b','c','d','e'});
        TasksForArray<String> tempArray3 = new TasksForArray<>(new String[]{"мама","мыла","раму"});


        tempArray1.convertToArrayList();
        tempArray2.convertToArrayList();
        tempArray3.convertToArrayList();

        System.out.println(tempArray1.getArrayList().toString());
        System.out.println(tempArray2.getArrayList().toString());
        System.out.println(tempArray3.getArrayList().toString());
    }

    public static void task3(){

        System.out.println("============ TASK #3 ============");

        Box<Apple> box1 = new Box<>("Эпплы #1");
        Box<Apple> box2 = new Box<>("Эпплы #2");
        Box<Orange> box3 = new Box<>("Липисины #1");

        box1.addFruit(new Apple(0.3f));
        box1.addFruit(new Apple(0.17f));
        box1.addFruit(new Apple(0.16f));
        box1.addFruit(new Apple(0.3f));

        box2.addFruit(new Apple(0.23f));

        box3.addFruit(new Orange(0.11f));
        box3.addFruit(new Orange(0.12f));

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);

        System.out.printf("Коробка %s равна коробке %s? : %b\n",box1.getLabel(), box2.getLabel(), box1.compare(box2));
        System.out.printf("Коробка %s равна коробке %s? : %b\n",box2.getLabel(), box3.getLabel(), box2.compare(box3));

        box1.removeFruits(box3);
        box1.removeFruits(box2);

        System.out.println(box1);
        System.out.println(box2);
        System.out.println(box3);

    }

    public static class TasksForArray<T>{
        private T[] array;
        private ArrayList<T> arrayList;

        public TasksForArray(T[] array) {
            this.array = array;
        }

        /**
         * метод меняет два элемента массива местами
         * @param first - порядковый номер первого элемента (начинается с 1, заканчивая кол-вом элементов в массиве)
         * @param second - порядковый номер второго элемента (начиная с 1, заканчивая кол-вом элементов в массиве)
         */
        public void exchangeTwo(int first, int second){
            T temp = this.array[first-1];
            this.array[first-1] = this.array[second-1];
            this.array[second-1] = temp;
        }


        public void convertToArrayList(){

            arrayList = new ArrayList<>();

            arrayList.addAll(Arrays.asList(array));
        }

        public T[] getArray() {
            return this.array;
        }

        public ArrayList<T> getArrayList() {
            return arrayList;
        }
    }
}
