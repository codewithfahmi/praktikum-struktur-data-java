package util;

public class Banner {
  public static void create(String text) {
    System.out.println(text.toUpperCase());
    System.out.println("-".repeat(text.length()));
  }
}
