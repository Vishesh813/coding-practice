package org.example.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHasMap<K, V> {

  int totalBuckets;
  int totalElements;
  private LinkedList<Node<K, V>>[] buckets;

  public CustomHasMap(int totalBuckets) {
    this.totalBuckets = totalBuckets;
    this.buckets = new LinkedList[totalBuckets];

    for (int i = 0; i < totalBuckets; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  private int hasFunction(Object key) {
    return Math.abs(key.hashCode());
  }

  private int getBucketIndex(Object key) {
    int hasValue = hasFunction(key);
    return hasValue % totalBuckets;
  }

  private int searchInLinkedList(K key, int bucketIndex) {
    LinkedList<Node<K, V>> bucket = buckets[bucketIndex];
    for (int i = 0; i < bucket.size(); i++) {
      Node<K, V> kvNode = bucket.get(i);
      if (kvNode.key == key) {
        return i;
      }
    }
    return -1;
  }

  public void put(K key, V value) {
    int bucketIndex = getBucketIndex(key);
    int dataIndex = searchInLinkedList(key, bucketIndex);
    LinkedList<Node<K, V>> bucketLL = buckets[bucketIndex];

    if (dataIndex == -1) {
      bucketLL.add(new Node<>(key, value));
    } else {
      Node<K, V> node = bucketLL.get(dataIndex);
      node.value = value;
      totalElements++;

      double loadFactor = (double) totalElements / totalBuckets;
      if (loadFactor > 2.0) {
        rehash();
      }
    }
  }

  public Object remove(K key) {
    int bucketIndex = getBucketIndex(key);
    int dataIndex = searchInLinkedList(key, bucketIndex);

    if (dataIndex == -1) {
      return null;
    }

    LinkedList<Node<K, V>> bucket = buckets[bucketIndex];
    Node<K, V> removedValue = bucket.get(dataIndex);
    bucket.remove(dataIndex);
    totalElements--;
    return removedValue.value;
  }

  private void rehash() {
    LinkedList<Node<K, V>>[] oldBuckets = buckets;
    int updatedSize = totalElements * 2;

    buckets = new LinkedList[updatedSize];
    this.totalBuckets = updatedSize;
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new LinkedList<>();
    }

    for (LinkedList<Node<K, V>> oldBucket : oldBuckets) {
      for (Node<K, V> kvNode : oldBucket) {
        put(kvNode.key, kvNode.value);
      }
    }
  }

  public ArrayList<K> ketSet() {
    ArrayList<K> keySet = new ArrayList<>();
    for (LinkedList<Node<K, V>> bucket : buckets) {
      for (Node<K, V> node : bucket) {
        keySet.add(node.key);
      }
    }

    return keySet;

  }

  static class Node<K, V> {

    K key;
    V value;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

}
