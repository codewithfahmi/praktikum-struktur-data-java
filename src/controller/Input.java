package controller;

import java.util.Scanner;

import model.Mahasiswa;
import store.MahasiswaStore;

public class Input {
    private final String[] menus = { "unshift", "insert at", "push" };
    private final Scanner scanner = new Scanner(System.in);

    public int menus() {
        System.out.println("\nTambahkan data mahasiswa");
        for (int i = 0; i < this.menus.length; i++)
            System.out.printf("%-1d) %-10s\n", (i + 1), this.menus[i]);
        System.out.print("~:$ ");
        return this.scanner.nextInt();
    }

    public Mahasiswa prompt() {
        Mahasiswa temp = new Mahasiswa();
        System.out.printf("%-10s : ", "Name");
        temp.name = this.scanner.next();
        System.out.printf("%-10s : ", "Address");
        temp.address = this.scanner.next();
        System.out.printf("%-10s : ", "Age");
        temp.age = this.scanner.nextInt();
        System.out.printf("%-10s : ", "Gender");
        temp.gender = this.scanner.next().charAt(0);
        System.out.printf("%-10s :\n", "Hobbies");
        for (int i = 0; i < temp.hobbies.length; i++) {
            System.out.printf("%-10s : ", "- " + (i + 1));
            temp.hobbies[i] = this.scanner.next();
        }
        System.out.printf("%-10s : ", "GPA");
        temp.gpa = this.scanner.nextFloat();
        return temp;
    }

    public Mahasiswa[] unshift(Mahasiswa data, Mahasiswa[] store) {
        Mahasiswa[] temp = new Mahasiswa[store.length + 1];
        temp[0] = data;
        System.arraycopy(store, 0, temp, 1, store.length);
        return temp;
    }

    public Mahasiswa[] push(Mahasiswa data, Mahasiswa[] store) {
        Mahasiswa[] temp = new Mahasiswa[store.length + 1];
        System.arraycopy(store, 0, temp, 0, store.length);
        temp[store.length] = data;
        return temp;
    }

    public Mahasiswa[] insert(Mahasiswa data, Mahasiswa[] store, int index) {
        Mahasiswa[] temp = new Mahasiswa[store.length + 1];
        if (store.length == 0) {
            temp[0] = data;
        } else {
            for (int i = 0; i < temp.length; i++)
                temp[i] = i == index ? data : store[i < index ? i : i - 1];
        }
        return temp;
    }

    public void unshiftView(MahasiswaStore mahasiswaStore) {
        System.out.println("\nUnshift");
        mahasiswaStore.patch(this.unshift(this.prompt(), mahasiswaStore.subscribe()));
    }

    public void insertView(MahasiswaStore mahasiswaStore) {
        System.out.println("\nInsert At");
        System.out.print("choose index position : ");
        int position = this.scanner.nextInt();

        if (position > mahasiswaStore.subscribe().length) {
            System.out.println("Out of the length of master record");
        } else if (position < 0) {
            System.out.println("Index less than 0 is inoperable position");
        } else {

            if (mahasiswaStore.subscribe().length > 0 || mahasiswaStore.subscribe().length == 0) {
                if (mahasiswaStore.subscribe().length == 0) {
                    System.out.println("\n[!] Data automatically moved to 0");
                }
                mahasiswaStore.patch(this.insert(this.prompt(), mahasiswaStore.subscribe(), position));
            }
        }
    }

    public void pushView(MahasiswaStore mahasiswaStore) {
        System.out.println("\nPush");
        mahasiswaStore.patch(this.push(this.prompt(), mahasiswaStore.subscribe()));
    }
}
