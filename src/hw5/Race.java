package hw5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Race {

    private Car winner;
    private final Lock lock = new ReentrantLock();

    private final ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public void checkWinner(Car car){

        lock.lock();
            if (this.winner==null) {
                this.winner = car;
                System.out.println(car.getName() + " - WIN!");
            }
        lock.unlock();

    }
}
