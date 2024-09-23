package util;

import java.util.Scanner;

public class Form {
  private static String fieldResult;
  private static String fieldLabel;
  private static Scanner scanner = new Scanner(System.in);

  public static Form input(String label) {
    fieldLabel = label;
    return new Form();
  }

  public static String run(String type) {
    String rules = null;
    String typeName = null;

    if (type != null) {
      switch (type) {
        case "number":
          typeName = "numbers";
          rules = "\\d+";
          break;
        case "alphabet":
          typeName = "alphabet (not numbers or symbols)";
          rules = "[a-zA-Z]+";
          break;
      }
    }

    while (true) {
      System.out.print(String.format("%s : ", fieldLabel));
      fieldResult = scanner.nextLine();

      if (fieldResult.isBlank() || fieldResult.isEmpty()) {
        System.out.println(String.format("[!] \"%s\" is required", fieldLabel));
      } else if (rules != null && !fieldResult.matches(rules)) {
        System.out.println(String.format("[!] \"%s\" can only be %s", fieldLabel, typeName));
      } else {
        break;
      }
    }

    return fieldResult;
  }

  public String toAlphabet() {
    return run("alphabet");
  }

  public char toSingleChar() {
    return run(null).charAt(0);
  }

  public char toSingleAlphabet() {
    return run("alphabet").charAt(0);
  }

  public int toInt() {
    return Integer.parseInt(run("number").toString());
  }
}
