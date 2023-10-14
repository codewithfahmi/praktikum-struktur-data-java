package controller;

import model.Mahasiswa;

public class View {
    public void view(Mahasiswa[] mahasiswa) {
        System.out.println("\nDaftar mahasiswa (" + mahasiswa.length + ")");
        System.out.printf("%-2s %-15s %-20s %-9s %-9s %-30s %-3s\n",
                "",
                "Name",
                "Address",
                "Age",
                "Gender",
                "Hobbies",
                "GPA");
        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.printf("%-1d. %-15s %-20s %-9d %-9s %-30s %-1.2f\n",
                    i,
                    mahasiswa[i].name,
                    mahasiswa[i].address,
                    mahasiswa[i].age,
                    Character.toString(mahasiswa[i].gender).toUpperCase(),
                    String.join(", ", mahasiswa[i].hobbies),
                    mahasiswa[i].gpa);
        }
    }
}
