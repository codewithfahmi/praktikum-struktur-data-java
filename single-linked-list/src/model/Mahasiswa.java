package model;

import java.util.Arrays;

public class Mahasiswa {
  public String name;
  public String address;
  public int age;
  public char gender;
  public String[] hobbies = new String[3];
  public float gpa;

  public Mahasiswa(String name, String address, int age, char gender, String[] hobbies, float gpa) {
    this.name = name;
    this.address = address;
    this.age = age;
    this.gender = gender;
    this.hobbies = hobbies;
    this.gpa = gpa;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public char getGender() {
    return gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

  public String[] getHobbies() {
    return hobbies;
  }

  public void setHobbies(String[] hobbies) {
    this.hobbies = hobbies;
  }

  public float getGpa() {
    return gpa;
  }

  public void setGpa(float gpa) {
    this.gpa = gpa;
  }

  @Override
  public String toString() {
    return "Mahasiswa [name=" + name + ", address=" + address + ", age=" + age + ", gender=" + gender + ", hobbies="
        + Arrays.toString(hobbies) + ", gpa=" + gpa + "]";
  }
}
