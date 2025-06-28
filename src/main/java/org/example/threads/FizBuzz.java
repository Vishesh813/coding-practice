package org.example.threads;

public class FizBuzz {

    int i = 1;
    int N;

    public FizBuzz(int N) {
        this.N = N;
    }

    public void printFizz(String a) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (i <= N && !(i % 3 == 0 && i%5!=0)) {
                    wait();
                }
                if (i > N) break;
                System.out.println(Thread.currentThread().getName() + " Fizz");
                i++;
                notifyAll();
            }
        }
    }

    public void printBuzz(String t) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (i <= N && !(i % 5 == 0 && i%3!=0)) {
                    wait();
                }
                if (i > N) break;
                System.out.println(Thread.currentThread().getName() + " Buzz");
                i++;
                notifyAll();
            }
        }
    }

    public void printFizzBuzz(String t) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (i <= N && !(i % 5 == 0 && i % 3 == 0)) {
                    wait();
                }
                if (i > N) break;
                System.out.println(Thread.currentThread().getName() + " FizzBuzz");
                i++;
                notifyAll();
            }
        }
    }

    public void printNumber(String t) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (i <= N && !(i % 5 != 0 && i % 3 != 0)) {
                    wait();
                }
                if (i > N) break;
                System.out.println(Thread.currentThread().getName() + " " + i);
                i++;
                notifyAll();
            }
        }
    }

}
