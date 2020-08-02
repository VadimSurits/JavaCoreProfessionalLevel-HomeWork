package homeWork5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainHW5 {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch cdlRaceStart = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch cdlRaceEnd = new CountDownLatch(CARS_COUNT);
    public static CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    public static Semaphore smp = new Semaphore(CARS_COUNT / 2);
    public static Lock winnerLock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (Car car : cars) {
            car = new Car(race, 20 + (int) (Math.random() * 10));
            new Thread(car).start();
        }
        try {
            cdlRaceStart.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            cdlRaceEnd.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


