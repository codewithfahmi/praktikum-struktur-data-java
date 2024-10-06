package controller;

import java.util.Scanner;

import model.Mahasiswa;
import store.MahasiswaStore;

public class Search {
  private final String[] menus = { "linear search", "binary search" };
  private final Scanner scanner = new Scanner(System.in);

  public int menus() {
    System.out.println("\nPencarian data mahasiswa");
    for (int i = 0; i < this.menus.length; i++)
      System.out.printf("%-1d) %-10s\n", (i + 1), this.menus[i]);
    System.out.print("~:$ ");
    return this.scanner.nextInt();
  }

  public Mahasiswa[] linear(Mahasiswa[] mahasiswa, String keyword) {
    Mahasiswa[] temp = new Mahasiswa[mahasiswa.length];
    Mahasiswa[] results = new Mahasiswa[0];
    Input input = new Input();
    keyword = keyword.toLowerCase().trim();

    for (int i = 0; i < mahasiswa.length; i++) {
      if (keyword.equals(mahasiswa[i].name.trim().toLowerCase())
          || keyword.equals(mahasiswa[i].address.trim().toLowerCase())
          || keyword.equals(Integer.toString(mahasiswa[i].age))
          || keyword.equals(Character.toString(mahasiswa[i].gender).trim().toLowerCase())
          || String.join(", ", mahasiswa[i].hobbies).contains(keyword)
          || keyword.equals(Float.toString(mahasiswa[i].gpa))) {
        temp[i] = mahasiswa[i];
      }
    }

    for (int i = 0; i < mahasiswa.length; i++) {
      if (temp[i] != null) {
        results = input.push(temp[i], results);
      }
    }

    return results;
  }

  public Mahasiswa[] binary(Mahasiswa[] mahasiswa, String keyword) {
    Mahasiswa[] results = new Mahasiswa[0];
    boolean founded = false;
    int left = 0;
    int right = mahasiswa.length;
    int middle = (left + right) / 2;
    Input input = new Input();

    while (founded == false && (right - left) != 1) {
      keyword = keyword.toLowerCase().trim();
      String name = mahasiswa[middle].name.toLowerCase().trim();

      if (keyword.compareTo(name) < 0) {
        right = middle;
        middle = (left + right) / 2;
      } else if (keyword.compareTo(name) > 0) {
        left = middle;
        middle = (left + right / 2);
      } else {
        founded = true;
        results = input.push(mahasiswa[middle], results);
      }
    }

    return results;
  }

  private String prompt() {
    System.out.print("\nmasukkan kata kunci : ");
    return this.scanner.next().toLowerCase().trim();
  }

  public void run(MahasiswaStore mahasiswaStore) {
    int searchOption = this.menus();
    Mahasiswa[] results = null;
    switch (searchOption) {
      case 1 -> {
        results = this.linear(mahasiswaStore.subscribe(), this.prompt());
      }
      case 2 -> {
        results = this.binary(mahasiswaStore.subscribe(), this.prompt());
      }
    }

    if (results.length == 0) {
      System.out.println("Data tidak ditemukan");
    } else {
      new View().run(results);
    }
  }
}
