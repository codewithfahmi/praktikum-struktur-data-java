package controller;

import model.BiodataMahasiswa;
import util.Form;

public class Mahasiswa {
  public BiodataMahasiswa[] actionInsert(BiodataMahasiswa[] daftarMahasiswa) {
    int daftarMahasiswaLength = daftarMahasiswa.length;
    int index = daftarMahasiswaLength == 0 ? 0 : daftarMahasiswaLength;
    BiodataMahasiswa[] result = new BiodataMahasiswa[daftarMahasiswaLength + 1];

    if (daftarMahasiswaLength == 0) {
      result[daftarMahasiswaLength] = new BiodataMahasiswa();
    } else {
      for (int i = 0; i < daftarMahasiswaLength; i++)
        result[i] = daftarMahasiswa[i];

      result[index] = new BiodataMahasiswa();
    }

    Form form = new Form();
    String formLabel = String.format("%s [%d]", "Mahasiswa", result.length);
    System.out.println("\n" + formLabel + "\n" + "-".repeat(formLabel.length()));
    result[index].namaMhs = form.inputOnlyString("nama mahasiswa");
    result[index].noMhs = form.inputInteger("nomor mahasiswa");
    result[index].nilaiUtsMhs = form.inputFloat("nilai uts");
    result[index].nilaiUasMhs = form.inputFloat("nilai uas");

    return result;
  }

  public void actionShow(BiodataMahasiswa[] daftarMahasiswa) {
    String labelTable = "Daftar Mahasiswa";
    System.out.println("\n" + labelTable + "\n" + "-".repeat(labelTable.length()) + "\n");
    StringBuilder result = new StringBuilder();
    String noMhsFmt = String.format("%-15s", "No. Mhs");
    String namaMhsFmt = String.format("%-15s", "Nama");
    String utsFmt = String.format("%-5s", "UTS");
    String uasFmt = String.format("%-5s", "UAS");
    result.append(noMhsFmt);
    result.append(namaMhsFmt);
    result.append(utsFmt);
    result.append(uasFmt);
    result.append("\n");
    result.append("-".repeat(noMhsFmt.length() +
        namaMhsFmt.length() +
        utsFmt.length() +
        uasFmt.length()) +
        "\n");
    for (BiodataMahasiswa mahasiswa : daftarMahasiswa) {
      result.append(String.format("%-15s", mahasiswa.noMhs));
      result.append(String.format("%-15s", mahasiswa.namaMhs));
      result.append(String.format("%-5s", mahasiswa.nilaiUtsMhs));
      result.append(String.format("%-5s", mahasiswa.nilaiUasMhs));
      result.append("\n");
    }
    System.out.print(result);
  }
}
