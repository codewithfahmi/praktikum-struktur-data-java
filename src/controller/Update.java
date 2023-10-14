package controller;

import java.util.Scanner;

import model.Mahasiswa;
import store.MahasiswaStore;

public class Update {
  private final Scanner scanner = new Scanner(System.in);

  public Mahasiswa[] update(Mahasiswa[] store) {
    Mahasiswa[] result = store;
    System.out.println("\nPerbarui data mahasisawa");
    System.out.printf("%-10s : ", "Index");
    int index = this.scanner.nextInt();
    if (index > store.length - 1) {
      System.out.println("Update inoperable, Index out of range");
    } else {
      Mahasiswa current = store[index];
      System.out.println("\nData Mahasiswa");
      System.out.printf("%-10s : %-20s\n", "Name", current.name);
      System.out.printf("%-10s : %-10s\n", "Address", current.address);
      System.out.printf("%-10s : %-1d\n", "Age", current.age);
      System.out.printf("%-10s : %-1s\n", "Gender", current.gender);
      System.out.printf("%-10s : %-30s\n", "Hobbies", String.join(", ", current.hobbies));
      System.out.printf("%-10s : %-1.2f\n", "GPA", current.gpa);
      System.out.println("\nData baru untuk \"" + current.name + "\"");
      System.out.printf("%-10s : ", "Name");
      current.name = this.scanner.next();
      System.out.printf("%-10s : ", "Address");
      current.address = this.scanner.next();
      System.out.printf("%-10s : ", "Age");
      current.age = this.scanner.nextInt();
      System.out.printf("%-10s : ", "Gender");
      current.gender = this.scanner.next().charAt(0);
      System.out.printf("%-10s : \n", "Hobbies");
      for (int i = 0; i < current.hobbies.length; i++) {
        System.out.printf("%-10s : ", "- " + (i + 1));
        current.hobbies[i] = this.scanner.next();
      }
      System.out.printf("%-10s : ", "GPA");
      current.gpa = this.scanner.nextFloat();

      result[index] = current;
    }
    return result;
  }

  public void run(MahasiswaStore mahasiswaStore) {
    mahasiswaStore.patch(this.update(mahasiswaStore.subscribe()));
  }
}
