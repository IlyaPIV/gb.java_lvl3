package hw4;

/* вариант решения по методичке */

public class Homework2 {

    public final Object monitor = new Object();
    public volatile char currentLetter = 'A';


    public static void main(String[] args) {
        Homework2 waitNotifyObj = new Homework2();

        Thread thread1 = new Thread(waitNotifyObj::printLetterA);
        Thread thread2 = new Thread(waitNotifyObj::printLetterB);
        Thread thread3 = new Thread(waitNotifyObj::printLetterC);

        thread1.start();
        thread2.start();
        thread3.start();

    }



    private void printLetterA(){
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++){
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printLetterB(){
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++){
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printLetterC(){
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++){
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
