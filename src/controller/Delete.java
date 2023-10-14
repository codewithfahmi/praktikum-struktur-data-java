package controller;

import java.util.Scanner;

import model.Mahasiswa;

public class Delete {
  private final String[] menus = { "shift", "remove", "pop", "by name" };
  private final Scanner scanner = new Scanner(System.in);

  public int menus() {
    System.out.println("\nHapus data mahasiswa");
    for (int i = 0; i < this.menus.length; i++)
      System.out.printf("%-1d) %-10s\n", (i + 1), this.menus[i]);
    System.out.print("~:$ ");
    return this.scanner.nextInt();
  }

  public Mahasiswa[] shift(Mahasiswa[] store) {
    Mahasiswa[] temp = new Mahasiswa[store.length - 1];
    System.arraycopy(store, 1, temp, 0, temp.length);
    return temp;
  }

  public Mahasiswa[] pop(Mahasiswa[] store) {
    Mahasiswa[] temp = new Mahasiswa[store.length - 1];
    System.arraycopy(store, 0, temp, 0, temp.length);
    return temp;
  }

  public Mahasiswa[] remove(Mahasiswa[] store, int index) {
    Mahasiswa[] temp = new Mahasiswa[store.length - 1];
    if (store.length == 1) {
      temp = new Mahasiswa[0];
    }

    if (index == 0) {
      temp = this.shift(store);
    } else {
      for (int i = 0; i < store.length; i++) {
        if (i < index) {
          temp[i] = store[i];
        } else if(i == index) {
          continue;
        } else {
          temp[i] = store[i - 1];
        }
      }
    }
    return temp;
  }
}
