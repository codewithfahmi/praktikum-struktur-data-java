package algorithm;

import util.IO;

public class Stack<T> {

  private final String ERR_STACK_IS_FULL = "The stack is full!";
  private final String ERR_STACK_IS_EMPTY = "The stack is empty!";
  private final int limit;
  private final T[] stack;
  private int top;

  @SuppressWarnings("unchecked")
  public Stack(int limit) {
    this.limit = limit;
    this.top = -1;
    this.stack = (T[]) new Object[this.limit];
  }

  public void push(T item) {
    IO.vputs(this.isFull(), this.ERR_STACK_IS_FULL, () -> {
      this.stack[++this.top] = item;
    });
  }

  public T pop() {
    return IO.tputs(this.isEmpty(), this.ERR_STACK_IS_EMPTY, () -> {
      T value = this.stack[this.top];
      this.stack[this.top--] = null;
      return value;
    });
  }

  public T[] items() {
    return this.stack;
  }

  public boolean isFull() {
    return this.top == this.limit - 1;
  }

  public boolean isEmpty() {
    return this.top < 0;
  }

  public boolean isArrayIndexOutOfBond(int index) {
    return index < 0 || index > this.limit;
  }

  public T get(int index) {
    IO.eputs(this.isEmpty(), this.ERR_STACK_IS_EMPTY);
    IO.eputs(this.isArrayIndexOutOfBond(index), "Index must be between 0 - " + this.top);
    return this.stack[index];
  }

  public void dump() {
    for (int i = this.top; i >= 0; i--) {
      IO.puts("%d: %s", i, this.get(i));
    }
  }
}
