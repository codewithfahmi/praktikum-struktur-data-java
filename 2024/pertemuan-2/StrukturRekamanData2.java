import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Mahasiswa {
  String nama;
  String alamat;
  int umur;
  char gender;
  String[] hobi = new String[3];
  float ipk;
}

public class StrukturRekamanData2 {
  public static void main(String[] args) throws InterruptedException, IOException {
    Mahasiswa[] daftarMahasiswa = new Mahasiswa[5];
    System.out.println("DAFTAR MAHASISWA\n");

    for (int i = 0; i < daftarMahasiswa.length; i++) {
      @SuppressWarnings("resource")
      Scanner scanner = new Scanner(System.in);

      /**
       * Form Header
       */
      String judul = "Mahasiwa Ke - " + (i + 1);
      System.out.println(judul);
      System.out.println("-".repeat(judul.length()));

      /**
       * Inisialisasi objek mahasiswa untuk menyimpan "mahasiswa" baru
       */
      Mahasiswa mahasiswa = new Mahasiswa();

      /**
       * Form field untuk memasukkan data mahasiswa dari user input
       */
      System.out.print(String.format("%-20s : ", "Nama"));
      mahasiswa.nama = scanner.nextLine();
      System.out.print(String.format("%-20s : ", "Alamat"));
      mahasiswa.alamat = scanner.nextLine();
      System.out.print(String.format("%-20s : ", "Umur"));
      mahasiswa.umur = scanner.nextInt();
      System.out.print(String.format("%-20s : ", "Jenis Kelamin (L/P)"));
      mahasiswa.gender = scanner.next().charAt(0);
      scanner.nextLine();
      for (int j = 0; j < mahasiswa.hobi.length; j++) {
        System.out.print(String.format("%-20s : ", "Hobi - " + (j + 1)));
        mahasiswa.hobi[j] = scanner.nextLine();
      }
      System.out.print(String.format("%-20s : ", "IPK"));
      mahasiswa.ipk = scanner.nextFloat();
      System.out.println();

      /**
       * Memasukkan data hasil inputan ke array `daftarMahasiswa`
       */
      daftarMahasiswa[i] = mahasiswa;

      /**
       * Membersihkan layar ketika selesai memasukkan data
       */

      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }
    }

    /**
     * Mendapatkan panjang maksimum dari daftar panjang tiap item
     */

    int[] lengths = {
        Arrays.stream(daftarMahasiswa)
            .mapToInt(item -> item.nama.length())
            .summaryStatistics()
            .getMax(),
        Arrays.stream(daftarMahasiswa)
            .mapToInt(item -> item.alamat.length())
            .summaryStatistics()
            .getMax(),
        Arrays.stream(daftarMahasiswa)
            .mapToInt(item -> String.join(", ", item.hobi).length())
            .summaryStatistics()
            .getMax()
    };

    /**
     * Mendapatkan nilai terpanjang dari array `lengths`
     */

    int getMaxLength = Arrays.stream(lengths).summaryStatistics().getMax() + 2;

    /**
     * Format untuk tiap data dan header form yang ditampilkan
     */
    String fString = "%-" + getMaxLength + "s";

    /**
     * Header untuk tabel data
     */

    String header = "";
    header += String.format(fString, "Nama");
    header += String.format(fString, "Alamat");
    header += String.format(fString, "Umur");
    header += String.format(fString, "Jenis Kelamin");
    header += String.format(fString, "Hobi");
    header += String.format(fString, "IPK");

    System.out.println(header);
    System.out.println("-".repeat(header.length()));

    /**
     * Data yang ditampilkan
     */

    for (int i = 0; i < daftarMahasiswa.length; i++) {
      String nama = String.format(fString, daftarMahasiswa[i].nama);
      String alamat = String.format(fString, daftarMahasiswa[i].alamat);
      String umur = String.format(fString, Integer.toString(daftarMahasiswa[i].umur));
      String gender = String.format(fString, (Character.toString(daftarMahasiswa[i].gender)
          .toUpperCase()
          .equals("L") ? "Laki - laki" : "Perempuan"));
      String hobi = String.format(fString, String.join(", ", daftarMahasiswa[i].hobi));
      String ipk = String.format(fString, Float.toString(daftarMahasiswa[i].ipk));
      System.out.println(nama + alamat + umur + gender + hobi + ipk);
    }

    System.out.println("\n");
  }
}
