package controller;

import java.lang.reflect.Array;

public class Record<T> {
  T[] record = null;
  Class<T> c;

  @SuppressWarnings("unchecked")
  public Record(Class<T> c) {
    this.c = c;
    this.record = (T[]) Array.newInstance(c, 0);
  }

  @SuppressWarnings("unchecked")
  private T[] Temp() {
    return (T[]) Array.newInstance(this.c, this.Length() + 1);
  }

  public void Prepend(T record) {
    T[] temp = this.Temp();
    if (this.Length() > 0)
      for (int i = 0; i < this.Length(); i++)
        temp[i + 1] = this.GetByIndex(i);
    temp[0] = record;
    this.record = temp;
  }

  public void Append(T record) {
    T[] temp = this.Temp();
    if (this.Length() > 0) {
      for (int i = 0; i < this.Length(); i++)
        temp[i] = this.GetByIndex(i);
      temp[this.Length()] = record;

    } else {
      this.Prepend(record);
    }
    this.record = temp;
  }

  public void Push(T record, int position) {
    switch (position) {
      case 0:
        this.Prepend(record);
        break;
      case 1:
        this.Append(record);
        break;
      default:
        T[] temp = (T[]) Array.newInstance(this.c, this.Length() + 2);
        if (this.Length() > 0) {
          for (int i = 0; i < temp.length; i++) {
            if (i == position) {
              temp[position] = record;
            } else {
              temp[i] = this.GetByIndex(i < position ? i : i - 1);
            }
          }
        } else {
          temp[0] = record;
        }
        this.record = temp;
        break;
    }
  }

  public T[] All() {
    return this.record;
  }

  public T GetByIndex(int index) {
    return this.record[index];
  }

  public int Length() {
    return this.record.length;
  }

  public boolean IsEmpty() {
    return this.Length() == 0;
  }

  public void Print() {
    System.out.println(this.record);
  }
}
