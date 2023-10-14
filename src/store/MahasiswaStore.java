package store;

import model.Mahasiswa;

public class MahasiswaStore {
    private Mahasiswa[] mahasiswaStore = new Mahasiswa[0];

    public void patch(Mahasiswa[] mahasiswaList) {
        this.mahasiswaStore = mahasiswaList;
    }

    public Mahasiswa[] subscribe() {
        return this.mahasiswaStore;
    }
}
