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

        PingPongCounter counter = new PingPongCounter();

        Thread even = new Thread(() -> counter.printEven("Even Thread"));
        Thread odd = new Thread(() -> counter.printOdd("Odd Thread"));

        odd.start();
        even.start();

/*        PrintInSequence printInSequence = new PrintInSequence();
        Thread t1 = new Thread(printInSequence::print);
        Thread t2 = new Thread(printInSequence::print);
        Thread t3 = new Thread(printInSequence::print);

        t1.start();
        t2.start();
        t3.start();*/
    }


}
