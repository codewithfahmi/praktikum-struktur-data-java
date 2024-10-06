package model;

public class MahasiswaModel {
    public String   name;
    public String   address;
    public int      age;
    public char     gender;
    public String[] hobbies = new String[3];
    public float    gpa;

    public MahasiswaModel set(String name, String address, int age, char gender, String[] hobbies, float gpa) {
        MahasiswaModel m = new MahasiswaModel();
        m.name       = name;
        m.address    = address;
        m.age        = age;
        m.gender     = gender;
        m.hobbies    = hobbies;
        m.gpa        = gpa;
        return m;
    }
}
