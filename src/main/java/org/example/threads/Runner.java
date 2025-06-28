package org.example.threads;

public class Runner {

    public static void main(String[] args) {
/*   Counter counter = new Counter();
   Thread t1 = new Thread(counter::printNumber);
  Thread t2 = new Thread(counter::printNumber);
  Thread t3 = new Thread(counter::printNumber);*/
//
//    t1.start();
//    t2.start();
//    t3.start();

   /*     PingPongCounter counter = new PingPongCounter();

        Thread even = new Thread(() -> counter.printEven("Even Thread"));
        Thread odd = new Thread(() -> counter.printOdd("Odd Thread"));

        odd.start();
        even.start();*/

/*        PrintInSequence printInSequence = new PrintInSequence();
        Thread t1 = new Thread(printInSequence::print);
        Thread t2 = new Thread(printInSequence::print);
        Thread t3 = new Thread(printInSequence::print);

        t1.start();
        t2.start();
        t3.start();*/

        FizBuzz fizBuzz = new FizBuzz(10);

        Thread A = new Thread(() -> {
            try {
                fizBuzz.printFizz("A");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"A");


        Thread B = new Thread(() -> {
            try {
                fizBuzz.printBuzz("B");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"B");

        Thread C = new Thread(() -> {
            try {
                fizBuzz.printFizzBuzz("C");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"C");

        Thread D = new Thread(() -> {
            try {
                fizBuzz.printNumber("D");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"D");

        A.start();
        B.start();
        C.start();
        D.start();

    }


}
