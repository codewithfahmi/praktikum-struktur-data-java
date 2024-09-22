package controller;

import model.Biodata;
import util.Form;

public class Mahasiswa {
  public static Biodata[] insert(Biodata[] daftarMahasiswa, int position) {
    int daftarMahasiswaLength = daftarMahasiswa.length;
    int indexData = daftarMahasiswaLength == 0 ? 0 : daftarMahasiswaLength;
    Biodata[] result = new Biodata[daftarMahasiswaLength + 1];

    if (daftarMahasiswaLength == 0) {
      result[indexData] = new Biodata();
    }

    if (position == 0) {
      for (int i = 1; i < result.length; i++)
        result[i] = daftarMahasiswa[i];
      result[0] = new Biodata();
    } else if (position == -1) {
      for (int i = 0; i < daftarMahasiswaLength; i++)
        result[i] = daftarMahasiswa[i];
      result[indexData] = new Biodata();
    }

    result[indexData].namaMhs = Form.inputOnlyString("Nama");
    result[indexData].alamatMhs = "";

    return result;
  }

  public void show(Biodata[] daftarMahasiswa) {

  }
}
