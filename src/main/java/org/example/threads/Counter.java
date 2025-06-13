package org.example.threads;

public class Counter {

  public static final int MAX = 10;
  public final Object lock = new Object();
  public int counter = 0;

  public void printNumber() {
    while (true) {
      synchronized (lock) {
        if (counter > MAX) {
          lock.notify();
          break;
        }
        try {
          lock.notify();
          System.out.println(
              "Current Thread :" + Thread.currentThread().getName() + " with count : " + counter++);
          Thread.sleep(1000);
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
