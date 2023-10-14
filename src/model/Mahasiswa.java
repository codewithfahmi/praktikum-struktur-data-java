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
}
