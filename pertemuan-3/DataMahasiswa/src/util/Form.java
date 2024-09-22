package util;

import java.util.Scanner;

public class Form {
  private static Scanner scanner = new Scanner(System.in);

  public static int inputNumber(String label) {
    int result = 0;
    String temp = null;

    while (true) {
      System.out.print(String.format("%-15s : ", label));
      temp = scanner.nextLine();
      /** Validation */
      if (temp.isBlank() || temp.isEmpty()) {
        System.out.println(String.format("[!] input \"%s\" tidak boleh kosong", label));
      } else if (!temp.matches("\\d+")) {
        System.out.println(String.format("[!] input \"%s\" hanya boleh angka saja", label));
      } else {
        result = Integer.parseInt(temp);
        break;
      }
    }

    return result;
  }

  public static String inputOnlyString(String label) {
    String result = null;
    while (true) {
      System.out.print(String.format("%-15s : ", label));
      result = scanner.nextLine();
      /** Validation */
      if (result.isBlank() || result.isEmpty()) {
        System.out.println(String.format("[!] input \"%s\" tidak boleh kosong", label));
      } else if (!result.matches("[a-zA-Z]+")) {
        System.out.println(String.format("[!] input \"%s\" hanya boleh angka saja", label));
      } else {
        break;
      }
    }

    return result;
  }

  public static void formClose() {
    scanner.close();
  }
}
