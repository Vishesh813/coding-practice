package org.example.threads;

public class ThreadPractice {

  public static void main(String[] args) throws InterruptedException {

    Resource resource = new Resource();

    Thread publisherThread = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          resource.publish("My Message :" + i);
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    Thread consumerThread = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          resource.consume();
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    publisherThread.start();
    consumerThread.start();

  }

}

class MyThread extends Thread {

  @Override
  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        Thread.sleep(2000);
        System.out.println("Method call from run method " + Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
