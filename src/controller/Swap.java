package controller;

import java.util.Scanner;

import model.Mahasiswa;
import store.MahasiswaStore;

public class Swap {
  private final Scanner scanner = new Scanner(System.in);

  public Mahasiswa[] swap(Mahasiswa[] store, int from, int to) {
    Mahasiswa dataToMove = store[from];
    Mahasiswa dataFromIndexTarget = store[to];
    store[to] = dataToMove;
    store[from] = dataFromIndexTarget;
    return store;
  }

  public void run(MahasiswaStore mahasiswaStore) {
    System.out.println("\nPindahkan data");
    System.out.print("index dari data yang akan dipindahkan : ");
    int from = this.scanner.nextInt();
    System.out.print("lokasi index untuk data yang dipindahkan : ");
    int to = this.scanner.nextInt();
    mahasiswaStore.patch(this.swap(mahasiswaStore.subscribe(), from, to));
  }
}
