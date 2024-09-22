package util;

import java.util.Scanner;

public class Form {

  private Scanner scanner = new Scanner(System.in);
  private int labelFormatLength = 15;

  public int getLabelFormatLength() {
    return this.labelFormatLength;
  }

  public void setLabelFormatLength(int length) {
    this.labelFormatLength = length;
  }

  public final String labelFormat() {
    return "%-" + this.getLabelFormatLength() + "s : ";
  }

  public String inputOnlyString(String label) {
    String result = "";
    while (true) {
      System.out.print(String.format(this.labelFormat(), label));
      result = scanner.nextLine();
      if (result.isEmpty() || result.isBlank()) {
        System.out.println(String.format(Constanta.FORM_WARNING_FORMAT, label,
            Constanta.FORM_WARNING_EMPTY));
      } else if (!result.matches("[a-zA-Z]+")) {
        System.out.println(String.format(Constanta.FORM_WARNING_FORMAT, label,
            Constanta.FORM_WARNING_ONLY_LETTER));
      } else {
        break;
      }
    }
    return result;
  }

  public String inputString(String label) {
    String result = null;
    while (true) {
      System.out.print(String.format(this.labelFormat(), label));
      result = scanner.nextLine();
      if (result.isEmpty() || result.isBlank()) {
        System.out.println(String.format(Constanta.FORM_WARNING_FORMAT, label,
            Constanta.FORM_WARNING_EMPTY));
      } else {
        break;
      }
    }
    return result;
  }

  public int inputInteger(String label) {
    int result = 0;
    String temp = null;
    while (true) {
      System.out.print(String.format(this.labelFormat(), label));
      temp = scanner.nextLine();
      if (temp.isBlank() || temp.isEmpty()) {
        System.out.println(String.format(Constanta.FORM_WARNING_FORMAT,
            label, Constanta.FORM_WARNING_EMPTY));
      } else if (!temp.matches("-?\\d+")) {
        System.out.println(String.format(Constanta.FORM_WARNING_FORMAT,
            label, Constanta.FORM_WARNING_ONLY_NUMBER));
      } else {
        result = Integer.parseInt(temp);
        break;
      }
    }
    return result;
  }

  public float inputFloat(String label) {
    float result;
    String temp = null;
    while (true) {
      System.out.print(String.format(this.labelFormat(), label));
      temp = scanner.nextLine();
      if (temp.isBlank() || temp.isEmpty()) {
        System.out.println(String.format("[!] \"%s\" %s", label,
            Constanta.FORM_WARNING_EMPTY));
      } else if (!temp.matches("-?\\d+(\\.\\d+)?")) {
        System.out.println(String.format("[!] \"%s\" %s", label,
            Constanta.FORM_WARNING_ONLY_NUMBER));
      } else {
        result = Float.parseFloat(temp);
        break;
      }
    }
    return result;
  }

  public void close() {
    scanner.close();
  }
}
