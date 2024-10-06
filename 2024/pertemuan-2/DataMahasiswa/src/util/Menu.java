package util;

public class Menu {
  private static String[] menus = {
      "Insert", "Delete", "View", "Exit"
  };

  private static String[] subMenus = {
      "Depan", "Tengah", "Belakang"
  };

  public static void showMenu() {
    for (int i = 0; i < menus.length; i++) {
      System.out.println(String.format("%d. %s", (i + 1), menus[i]));
    }
  }

  public static void showSubMenu() {
    for (int i = 0; i < subMenus.length; i++) {
      System.out.println(String.format("%d. %s", (i + 1), subMenus[i]));
    }
  }
}
