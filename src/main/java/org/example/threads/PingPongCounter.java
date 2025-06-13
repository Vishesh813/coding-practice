package org.example.threads;

public class PingPongCounter {

  private final Object lock = new Object();
  private int counter = 0;
  private boolean isEven = false; // start with Odd turn
  private final int MAX_COUNT = 10;

  public void printEven(String threadName) {
    while (counter <= MAX_COUNT) {
      synchronized (lock) {
        while (!isEven) {
          try {
            lock.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
        }

        System.out.println("Even No :" + counter++ + " using thread " + threadName);
        isEven = false;  // now it's odd's turn
        lock.notifyAll();
      }
    }
  }

  public void printOdd(String threadName) {
    while (counter <= MAX_COUNT) {
      synchronized (lock) {
        while (isEven) { // wait while it's even's turn
          try {
            lock.wait();
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
        }

        System.out.println("Odd No :" + counter++ + " using thread " + threadName);
        isEven = true; // now it's even's turn
        lock.notifyAll();
      }
    }
  }
}
