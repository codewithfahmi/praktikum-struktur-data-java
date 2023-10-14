package controller;

import model.Mahasiswa;

public class Swap {
  public Mahasiswa[] swap(Mahasiswa[] store, int from, int to) {
    Mahasiswa dataToMove = store[from];
    Mahasiswa dataFromIndexTarget = store[to];
    store[to] = dataToMove;
    store[from] = dataFromIndexTarget;
    return store;
  }
}
