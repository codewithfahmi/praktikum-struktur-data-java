import java.io.IOException;
import java.util.Scanner;

class FormatBiodata {
  String nama;
  String alamat;
  int umur;
  char gender;
  String[] hobi = new String[3];
  float ipk;
}

public class StrukturRekamanDataModular {
  public int N = 1;

  public void entriData(FormatBiodata biodataMahasiswa[]) throws InterruptedException, IOException {
    String title = "Input Data Mahasiswa";
    System.out.println(title);
    System.out.println("-".repeat(title.length()) + "\n");

    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < biodataMahasiswa.length; i++) {
      /**
       * Banner
       */
      title = String.format("%-25s", "Mahasiswa (" + (i + 1) + ")");
      System.out.println(title);
      System.out.println("-".repeat(title.length()));

      /**
       * Form Field
       */
      System.out.print("Nama \t\t: ");
      biodataMahasiswa[i].nama = scanner.nextLine();
      System.out.print("Alamat \t\t: ");
      biodataMahasiswa[i].alamat = scanner.nextLine();
      System.out.print("Umur \t\t: ");
      biodataMahasiswa[i].umur = scanner.nextInt();
      System.out.print("Jenis Kelamin \t: ");
      biodataMahasiswa[i].gender = scanner.next().charAt(0);
      scanner.nextLine();
      for (int h = 0; h < biodataMahasiswa[i].hobi.length; h++) {
        System.out.print("Hobi - " + (h + 1) + " \t: ");
        biodataMahasiswa[i].hobi[h] = scanner.nextLine();
      }
      System.out.print("IPK \t\t: ");
      biodataMahasiswa[i].ipk = scanner.nextFloat();
      System.out.println();
      scanner.nextLine();

      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
      }

      if (i == biodataMahasiswa.length - 1) {
        scanner.close();
      }
    }
  }

  public void showData(FormatBiodata biodataMahasiswa[]) {
    String format = "%-25s";
    String result = "";

    String header = String.format(format, "Nama");
    header += String.format(format, "Alamat");
    header += String.format(format, "Umur");
    header += String.format(format, "Gender");
    header += String.format(format, "Hobi");
    header += String.format(format, "IPK");
    header += "\n";
    result += header;
    result += "-".repeat(header.length()) + "\n";
    for (int i = 0; i < biodataMahasiswa.length; i++) {
      String temp = String.format(format, biodataMahasiswa[i].nama);
      temp += String.format(format, biodataMahasiswa[i].alamat);
      temp += String.format(format, biodataMahasiswa[i].umur);
      temp += String.format(format, biodataMahasiswa[i].gender);
      temp += String.format(format, String.join(", ", biodataMahasiswa[i].hobi));
      temp += String.format(format, biodataMahasiswa[i].ipk);
      temp += "\n";
      result += temp;
    }

    System.out.println(result);
  }

  public static void main(String[] args) throws InterruptedException, IOException {
    StrukturRekamanDataModular app = new StrukturRekamanDataModular();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Masukkan jumlah data : ");
      app.N = scanner.nextInt();
      if (app.N > 15) {
        System.out.println("[!] Maksimal jumlah data adalah 15");
      } else if (app.N <= 0) {
        System.out.println("[!] Jumlah data tidak boleh kurang dari atau sama dengan 0");
      } else {
        FormatBiodata[] biodataMahasiswa = new FormatBiodata[app.N];
        /**
         * Inisiasi rekaman data sejumlah nilai N
         */
        for (int i = 0; i < biodataMahasiswa.length; i++) {
          biodataMahasiswa[i] = new FormatBiodata();
        }

        /**
         * Mengisi data untuk setiap rekaman data `biodataMahasiswa`
         */
        app.entriData(biodataMahasiswa);

        /**
         * Menampilkan data
         */
        app.showData(biodataMahasiswa);
        System.out.println("\n");

        break;
      }
    }
    scanner.close();
  }
}
