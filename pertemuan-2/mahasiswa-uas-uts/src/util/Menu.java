package util;

public class Menu {
  public static void show() {
    for (int i = 0; i < Constanta.APP_MENUS.length; i++)
      System.out.println(String.format("%d. %s", (i + 1), Constanta.APP_MENUS[i]));
  }
}
