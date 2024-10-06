import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

import controller.Mahasiswa;
import util.Banner;
import util.Constanta;
import util.Form;
import model.FormatBiodata;

public class App {
  private static int N = 20;

  public static void main(String[] args) throws InterruptedException, IOException {
    Scanner scanner = new Scanner(System.in);
    Mahasiswa mahasiswa = new Mahasiswa();
    Form form = new Form();

    FormatBiodata[] biodataMahasiswa = new FormatBiodata[N];
    for (int i = 0; i < biodataMahasiswa.length; i++) {
      biodataMahasiswa[i] = new FormatBiodata();
    }

    System.out.println();
    Banner.create(Constanta.APP_TITLE);

    char isContinue = 'y';
    int counter = 0;

    while (true) {
      System.out.println();
      biodataMahasiswa[counter] = mahasiswa.actionInsert(biodataMahasiswa[counter], counter);

      while (true) {
        isContinue = form.inputOnlyString("[?] masukkan data lagi (y/n) ? ")
            .toLowerCase().charAt(0);
        if (isContinue == 'y' || isContinue == 'n') {
          System.out.print("\033[H\033[2J");
          System.out.flush();
          break;
        } else {
          System.out.println("[!] pilihan hanya boleh Y atau N".toUpperCase());
        }
        System.out.println();
      }

      if (isContinue == 'n') {
        mahasiswa.actionShow(Arrays.copyOfRange(biodataMahasiswa, 0, (counter + 1)));
        break;
      } else if (counter == (N - 1)) {
        System.out.println("[!] penyimpanan data penuh".toUpperCase());
        System.out.println("[!] tidak bisa menyimpan data lagi".toUpperCase());
      } else {
        counter++;
      }
    }

    form.close();
    scanner.close();
  }
}
