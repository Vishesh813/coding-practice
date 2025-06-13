package org.example.threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapPractice {

  public static Map<Integer, Integer> map = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    new Thread(() -> put(1, 4)).start();
    new Thread(() -> put(1, 5)).start();

    System.out.println(map.get(1));
  }

  static void put(int x, int y) {
    if (map.containsKey(x)) {
      map.put(x, map.get(x) + y);
    } else {
      map.put(x, y);
    }
  }

}
