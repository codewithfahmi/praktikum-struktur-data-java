package algorithm;

import java.util.StringJoiner;
import util.IO;

public class Queue<T> {
  private final String ERR_QUEUE_IS_FULL = "The queue is full!";
  private final String ERR_QUEUE_IS_EMPTY = "The queue is empty!";
  private final int limit;
  private final T[] queue;
  private int rear;

  @SuppressWarnings("unchecked")
  public Queue(int limit) {
    this.limit = limit;
    this.rear = -1;
    this.queue = (T[]) new Object[this.limit];
  }

  public void enqueue(T item) {
    IO.vputs(this.isFull(), this.ERR_QUEUE_IS_FULL, () -> {
      this.queue[++this.rear] = item;
    });
  }

  public T dequeue() {
    return IO.tputs(this.isEmpty(), this.ERR_QUEUE_IS_EMPTY, () -> {
      T value = this.queue[this.rear];
      this.queue[this.rear--] = null;
      return value;
    });
  }

  public T[] items() {
    return this.queue;
  }

  public boolean isFull() {
    return this.rear == this.limit - 1;
  }

  public boolean isEmpty() {
    return this.rear == -1;
  }

  public boolean isArrayIndexOutOfBond(int index) {
    return index < 0 || index > this.limit;
  }

  public T get(int index) {
    IO.eputs(this.isEmpty(), this.ERR_QUEUE_IS_EMPTY);
    IO.eputs(this.isArrayIndexOutOfBond(index), "Index must be between 0 - " + this.rear);
    return this.queue[index];
  }

  public void dump() {
    StringJoiner result = new StringJoiner(", ");
    for (int i = 0; i <= this.rear; i++) {
      result.add(String.format("%d: %s", i, this.get(i)));
    }
    System.out.println(result);
  }
}
