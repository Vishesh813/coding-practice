package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    throw new Error();
  }
}

class Parent {
  void test() throws IOException{
    System.out.println("Parent method");
  }
}
class Child extends Parent{
  @Override
  void test() {

  }
}
