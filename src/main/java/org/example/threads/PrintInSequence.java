package org.example.threads;


public class PrintInSequence {

  final Object lock = new Object();
  char ch = 'A';


  public void print() {
    while (true) {
      synchronized (lock) {
        if (ch > 'C') {
          ch = 'A';
        }
        try {
          lock.notify();
          Thread.sleep(500);
          System.out.println(ch);
          ++ch;
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}
