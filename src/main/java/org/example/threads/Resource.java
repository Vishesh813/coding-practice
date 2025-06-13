package org.example.threads;

public class Resource {

  boolean isMessagePublished;
  String message;


  public synchronized void publish(String message) throws InterruptedException {
    while (isMessagePublished) {
      wait();
    }
    this.message = message;
    System.out.println("Published message :" + this.message);
    isMessagePublished = true;
    notify();
  }

  public synchronized void consume() throws InterruptedException {
    while (!isMessagePublished) {
      wait();
    }
    System.out.println("Consumed message :" + this.message);
    isMessagePublished = false;
    notify();
  }

}
