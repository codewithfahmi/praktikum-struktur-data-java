package controller;

import model.Biodata;
import util.Form;

public class Mahasiswa {
  public static Biodata[] insert(Biodata[] daftarMahasiswa, int position) {
    int daftarMahasiswaLength = daftarMahasiswa.length;
    int indexData = daftarMahasiswaLength == 0 ? 0 : daftarMahasiswaLength;
    Biodata[] result = new Biodata[daftarMahasiswaLength + (position == 2 ? 2 : 1)];

    if (daftarMahasiswaLength == 0) {
      result[indexData] = new Biodata();
    } else {
      if (position == 0) {
        for (int i = 0; i < daftarMahasiswaLength; i++)
          result[i + 1] = daftarMahasiswa[i];
        result[0] = new Biodata();
        indexData = 0;
      } else if (position == -1) {
        for (int i = 0; i < daftarMahasiswaLength; i++)
          result[i] = daftarMahasiswa[i];
        result[indexData] = new Biodata();
      } else {
        indexData = position;
        for (int i = 0; i < result.length; i++) {
          if (i == indexData) {
            result[indexData] = new Biodata();
          } else {
            result[i] = daftarMahasiswa[i < indexData ? i : i - 1];
          }
        }
      }
    }

    result[indexData].namaMhs = Form.input("Nama").toAlphabet();
    result[indexData].alamatMhs = Form.input("Alamat").toAlphabet();
    result[indexData].umurMhs = Form.input("Umur").toInt();
    result[indexData].genderMhs = Form.input("Gender").toSingleAlphabet();
    for (int h = 0; h < result[indexData].hobiMhs.length; h++) {
      result[indexData].hobiMhs[h] = Form.input(String.format("Hobi ke %d", (h + 1))).toAlphabet();
    }
    result[indexData].ipkMhs = Form.input("Ipk").toFloat();

    return result;
  }

  public static Biodata[] delete(Biodata[] daftarMahasiswa, int position) {
    Biodata[] result = new Biodata[daftarMahasiswa.length - 1];
    if (daftarMahasiswa.length == 0) {
      result = new Biodata[0];
    } else {
      if (position == 0) {
        for (int i = 1; i < daftarMahasiswa.length; i++) {
          result[i - 1] = daftarMahasiswa[i];
        }
      } else if (position == -1) {
        for (int i = 0; i < result.length; i++) {
          result[i] = daftarMahasiswa[i];
        }
      } else {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
          if (i == position) {
            continue;
          } else {
            result[i] = daftarMahasiswa[i < position ? i : i + 1];
          }
        }
      }
    }

    return result;
  }

  public static void show(Biodata[] daftarMahasiswa) {
    StringBuilder result = new StringBuilder();
    String namaLabel = String.format("%-15s", "Nama");
    String alamatLabel = String.format("%-15s", "Alamat");
    String umurLabel = String.format("%-8s", "Umur");
    String genderLabel = String.format("%-15s", "Gender");
    String hobiLabel = String.format("%-25s", "Hobi");
    String ipkLabel = String.format("%-5s", "Ipk");
    int borderLength = namaLabel.length() + alamatLabel.length() + umurLabel.length() +
        genderLabel.length() + hobiLabel.length() + ipkLabel.length();

    result.append(namaLabel);
    result.append(alamatLabel);
    result.append(umurLabel);
    result.append(genderLabel);
    result.append(hobiLabel);
    result.append(ipkLabel);
    result.append(String.format("\n%s\n", "-".repeat(borderLength)));

    if (daftarMahasiswa.length == 0) {
      result.append("Tidak ada data");
    } else {
      for (int i = 0; i < daftarMahasiswa.length; i++) {
        result.append(String.format("%-15s", daftarMahasiswa[i].namaMhs));
        result.append(String.format("%-15s", daftarMahasiswa[i].alamatMhs));
        result.append(String.format("%-8s", daftarMahasiswa[i].umurMhs));
        result.append(String.format("%-15s",
            (Character.toLowerCase(daftarMahasiswa[i].genderMhs) == 'l' ? "Laki - laki" : "Perempuan")));
        result.append(String.format("%-25s", String.join(", ", daftarMahasiswa[i].hobiMhs)));
        result.append(String.format("%-5.2f\n", daftarMahasiswa[i].ipkMhs));
      }
    }

    System.out.println(result);
  }
}
