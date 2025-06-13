package org.example.stream;

import java.util.stream.Stream;

public class Runner {

  public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5)
        .filter(i -> i % 2 == 0)
        .map(i -> {
          System.out.println(i);
          i = i * 2;
          return i;
        });
  }

}
