package controller;

import java.util.Scanner;

public class App {
    private final String[] menus = { "input", "view", "update", "delete", "re-order", "search" };
    private Scanner scanner = new Scanner(System.in);

    public int menus() {
        System.out.println("\nDatabase mahasiswa");
        for (int i = 0; i < this.menus.length; i++)
            System.out.printf("%-1d) %-10s\n", (i + 1), this.menus[i]);
        System.out.print("~:$ ");
        return this.scanner.nextInt();
    }

    public int availableOptions() {
        return this.menus.length;
    }
}
