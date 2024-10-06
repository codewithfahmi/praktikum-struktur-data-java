package controller;

import java.util.Scanner;

import model.Mahasiswa;
import store.MahasiswaStore;

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
      for (int i = 0, j = 0; i < store.length; i++) {
        if (i != index) {
          temp[j++] = store[i];
        }
      }
    }
    return temp;
  }

  public void run(MahasiswaStore mahasiswaStore) {
    if (mahasiswaStore.subscribe().length == 0) {
      System.out.println("\nDelete inoperable, master record is empty");
    } else {
      int deleteOption = this.menus();
      boolean continued = true;
      while (continued) {
        switch (deleteOption) {
          case 1 -> mahasiswaStore.patch(this.shift(mahasiswaStore.subscribe()));
          case 2 -> {
            System.out.printf("%-10s : ", "Index");
            int index = this.scanner.nextInt();
            mahasiswaStore.patch(this.remove(mahasiswaStore.subscribe(), index));
          }
          case 3 -> mahasiswaStore.patch(this.pop(mahasiswaStore.subscribe()));
        }
        if (deleteOption > 0) {
          System.out.print("continue?");
          continued = this.scanner.next().toLowerCase().charAt(0) == 'y';
        } else {
          continued = false;
        }
      }
    }
  }
}
