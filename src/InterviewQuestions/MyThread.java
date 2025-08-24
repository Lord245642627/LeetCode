package InterviewQuestions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lord Camelot
 * @date 2025/8/24
 * @description
 */
public class MyThread {
    private static volatile int currentNumber = 1;
    private static volatile int currentPrinter = 1;

    private static final int N = 3;

    private static final Lock LOCK = new ReentrantLock();
    private static final Condition[] CONDITIONS = new Condition[3];


    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(0);
    private static Semaphore semaphore3 = new Semaphore(0);

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            CONDITIONS[i] = LOCK.newCondition();
        }
//        Thread thread1 = new Thread(() -> myThread.print2(1));
//        Thread thread2 = new Thread(() -> myThread.print2(2));
//        Thread thread3 = new Thread(() -> myThread.print2(3));
        Thread thread1 = new Thread(() -> print3(1, semaphore1, semaphore2));
        Thread thread2 = new Thread(() -> print3(2, semaphore2, semaphore3));
        Thread thread3 = new Thread(() -> print3(3, semaphore3, semaphore1));

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void print1(int printerId) {
        LOCK.lock();
        try {
            while (currentNumber <= 100) {
                while (currentPrinter != printerId) {
                    CONDITIONS[printerId - 1].await();
                }
                if (currentNumber <= 100) {
                    System.out.println("printer " + printerId + "-" + currentNumber);
                }

                currentNumber++;
                currentPrinter = currentPrinter % N + 1;
                CONDITIONS[currentPrinter - 1].signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private synchronized void print2(int printerId) {
        try {
            while (currentNumber <= 100) {
                while (currentPrinter != printerId) {
                    wait();
                }
                if (currentNumber <= 100) {
                    System.out.println("printer " + printerId + "-" + currentNumber);
                }
                currentNumber++;
                currentPrinter = currentPrinter % N + 1;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void print3(int printerId, Semaphore cur, Semaphore next) {
        try {
            while (currentNumber <= 100) {
                cur.acquire();
                if (currentNumber <= 100) {
                    System.out.println("Printer" + printerId + "-" + currentNumber);
                }
                currentNumber++;
                currentPrinter = (currentPrinter % 3) + 1;
                next.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
