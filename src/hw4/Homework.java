package hw4;

import java.util.ArrayList;
import java.util.List;

/* вариант решения с масштабированием на кол-во печатуемых символов */

public class Homework {

    public final Object monitor = new Object();
    public volatile char currentLetter = 'A';
    public static final int differentLetters = 4;

    public static void main(String[] args) {
        Homework waitNotifyObj = new Homework();

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < differentLetters; i++) {
            char printedLetter = (char) (65+i);
            Thread thread = new Thread(()->waitNotifyObj.printLetter(printedLetter));
            threadList.add(thread);
        }
        for (Thread thread:
             threadList) {
            thread.start();
        }

    }


    private void printLetter(char letter){
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++){
                    while (currentLetter != letter) {
                       monitor.wait();
                    }
                    System.out.print(letter);
                    currentLetter = (char)(65+(((letter+1)-65)%differentLetters));
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
