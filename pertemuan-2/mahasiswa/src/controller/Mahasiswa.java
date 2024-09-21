package controller;

import model.FormatBiodata;
import util.Form;
import util.Banner;
import util.Constanta;

public class Mahasiswa {
  public FormatBiodata actionInsert(FormatBiodata biodataMahasiswa, int counter) {
    Form form = new Form();

    Banner.create(String.format("mahasiswa [%d]", (counter + 1)));
    biodataMahasiswa.nama = form.inputOnlyString("nama");
    biodataMahasiswa.alamat = form.inputString("alamat");
    biodataMahasiswa.umur = form.inputInteger("umur");
    biodataMahasiswa.gender = form.inputOnlyString("jenis kelamin").charAt(0);
    for (int h = 0; h < biodataMahasiswa.hobi.length; h++) {
      biodataMahasiswa.hobi[h] = form.inputOnlyString("hobi - " + (h + 1));
    }
    biodataMahasiswa.ipk = form.inputFloat("ipk");
    System.out.print("\033[H\033[2J");
    System.out.flush();

    return biodataMahasiswa;
  }

  public void actionShow(FormatBiodata[] biodataMahasiswa) {
    StringBuilder result = new StringBuilder();
    result.append(String.format(Constanta.NAMA_STRING_FORMAT, Constanta.TABLE_LABEL_NAMA));
    result.append(String.format(Constanta.ALAMAT_STRING_FORMAT, Constanta.TABLE_LABEL_ALAMAT));
    result.append(String.format(Constanta.UMUR_STRING_FORMAT, Constanta.TABLE_LABEL_UMUR));
    result.append(String.format(Constanta.GENDER_STRING_FORMAT, Constanta.TABLE_LABEL_GENDER));
    result.append(String.format(Constanta.HOBI_STRING_FORMAT, Constanta.TABLE_LABEL_HOBI));
    result.append(String.format(Constanta.IPK_STRING_FORMAT, Constanta.TABLE_LABEL_IPK) + "\n");
    result.append("-".repeat(Constanta.NAMA_LENGTH_FORMAT + Constanta.ALAMAT_LENGTH_FORMAT
        + Constanta.UMUR_LENGTH_FORMAT + Constanta.GENDER_LENGTH_FORMAT + Constanta.HOBI_LENGTH_FORMAT
        + Constanta.IPK_LENGTH_FORMAT) + "\n");
    for (int i = 0; i < biodataMahasiswa.length; i++) {
      result.append(String.format(Constanta.NAMA_STRING_FORMAT, biodataMahasiswa[i].nama));
      result.append(String.format(Constanta.ALAMAT_STRING_FORMAT, biodataMahasiswa[i].alamat));
      result.append(String.format(Constanta.UMUR_STRING_FORMAT, biodataMahasiswa[i].umur));
      result.append(String.format(Constanta.GENDER_STRING_FORMAT, biodataMahasiswa[i].gender));
      result.append(String.format(Constanta.HOBI_STRING_FORMAT, String.join(", ", biodataMahasiswa[i].hobi)));
      result.append(String.format(Constanta.IPK_STRING_FORMAT, biodataMahasiswa[i].ipk));
      result.append("\n");
    }
    System.out.println();
    System.out.println(result);
  }
}
