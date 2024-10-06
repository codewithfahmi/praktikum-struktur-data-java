import java.util.Scanner;

class InputViaKeyboard {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name;
    String address;
    int age;
    char gender;
    String[] hobbies = new String[3];
    float gpa;

    System.out.print("name      : ");
    name = scanner.nextLine();
    System.out.print("address   : ");
    address = scanner.nextLine();
    System.out.print("age       : ");
    age = scanner.nextInt();
    System.out.print("gender    : ");
    gender = scanner.next().charAt(0);
    System.out.println("hobbies");
    scanner.nextLine();
    for (int i = 0; i < hobbies.length; i++) {
      System.out.print(String.format("hobby - %d : ", i + 1));
      hobbies[i] = scanner.nextLine();
    }
    System.out.print("gpa     : ");
    gpa = scanner.nextFloat();

    System.out.println("Your name       : " + name);
    System.out.println("Your address    : " + address);
    System.out.println("Your age        : " + age + " years old");
    System.out.println("Your gender     : " + (Character.toLowerCase(gender) == 'l'
        ? "Laki - laki"
        : "Perempuan"));
    for (int i = 0; i < hobbies.length; i++) {
      System.out.println("Your " + (i + 1) + "th hobby  : " + hobbies[i]);
    }
    System.out.println("Your gpa        : " + gpa);
    scanner.close();
  }
}