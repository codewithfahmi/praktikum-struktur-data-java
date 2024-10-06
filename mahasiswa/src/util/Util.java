package util;

import java.util.logging.Logger;

public class Util {

    public static void banner(String s) {
        System.out.printf("\n%s\n%s\n", s, "-".repeat(s.length()));
    }

    public static void banner(String s, String[] menu, boolean back) {
        Util.banner(s);
        for (int i = 0; i < menu.length; i++) System.out.printf("%d. %s\n", (i + 1), menu[i]);
        if (back) System.out.println("0. back");
    }

    public static boolean confirmation_prompt() {
        char confirmation = Form.input("again").required().to_alphabet().charAt(0);
        return Character.toLowerCase(confirmation) == 'y';
    }

    public static void operation_time(String class_name, String method_name, long start, long end) {
        System.out.printf("*) %s.%s() completed in %.6f seconds\n", class_name, method_name,(float) (end - start) / 1_000_000_000);
    }
}
