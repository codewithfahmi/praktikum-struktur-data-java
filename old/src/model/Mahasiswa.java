package model;

public class Mahasiswa {
    public String name, address;
    public int age;
    public char gender;
    public String[] hobbies = new String[3];
    public float gpa;

    public Mahasiswa set(
            String name,
            String address,
            int age,
            char gender,
            String[] hobbies,
            float gpa) {
        Mahasiswa temp = new Mahasiswa();
        temp.name = name;
        temp.address = address;
        temp.age = age;
        temp.gender = gender;
        temp.hobbies = hobbies;
        temp.gpa = gpa;

        return temp;
    }

    public Mahasiswa[] initData() {
        Mahasiswa[] mahasiswa = {
                new Mahasiswa().set("George", "Georgia", 28, 'l', new String[] { "hiking", "jogin", "menari" }, 4f),
                new Mahasiswa().set("John", "New Jersey", 22, 'l', new String[] { "makan", "ngoding", "tidur" }, 2.24f),
                new Mahasiswa().set("Stefanie", "Colorado", 23, 'p', new String[] { "nyanyi", "masak", "makan" }, 3.4f)
        };

        return mahasiswa;
    }
}
