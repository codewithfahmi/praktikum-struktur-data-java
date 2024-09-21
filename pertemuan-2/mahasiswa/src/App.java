import java.io.IOException;
import java.util.Scanner;

import controller.Mahasiswa;
import util.Banner;
import util.Constanta;
import util.Form;
import model.FormatBiodata;

public class App {
  private static int N = 1;

  public static void main(String[] args) throws InterruptedException, IOException {
    Scanner scanner = new Scanner(System.in);
    Mahasiswa mahasiswa = new Mahasiswa();
    Form form = new Form();

    System.out.println();
    Banner.create(Constanta.APP_TITLE);

    while (true) {
      N = form.inputInteger("[?] atur ukuran rekaman data".toUpperCase());

      if (N > 15) {
        System.out.println("[!] maksimal ukuran rekaman data adalah 15".toUpperCase());
      } else if (N <= 0) {
        System.out.println("[!] minimal ukuran rekaman data adalah 1".toUpperCase());
      } else {
        System.out.println();
        FormatBiodata[] biodataMahasiswa = new FormatBiodata[N];
        for (int i = 0; i < biodataMahasiswa.length; i++) {
          biodataMahasiswa[i] = new FormatBiodata();
        }
        mahasiswa.actionInsert(biodataMahasiswa);
        mahasiswa.actionShow(biodataMahasiswa);
        System.out.println();
        break;
      }
    }
    form.close();
    scanner.close();
  }
}
