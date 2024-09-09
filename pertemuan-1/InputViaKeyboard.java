import java.util.Scanner;

class InputViaKeyboard {
    public void __1(Scanner scanner) {
        System.out.print("Masukkan sebuah huruf : ");
        char letter = scanner.next().charAt(0);
        System.out.println("Huruf yang anda entri adalah : " + letter);
    }

    public void __2(Scanner scanner) {
        System.out.println("Silahkan masukkan sebuah kalimat : ");
        String kalimat = scanner.nextLine();
        System.out.println("Kalimat yang anda entri adalah : " + kalimat);
    }

    public void __3(Scanner scanner) {
        byte    __byte;
        short   __short;
        int     __int;
        long    __long;

        System.out.print("Masukkan bilangan byte    : ");
        __byte = scanner.nextByte();

        System.out.print("Masukkan bilangan short   : ");
        __short = scanner.nextShort();

        System.out.print("Masukkan bilangan int     : ");
        __int = scanner.nextInt();

        System.out.print("Masukkan bilangan long    : ");
        __long = scanner.nextLong();

        System.out.println("Bilangan byte yang anda entry   : " + __byte);
        System.out.println("Bilangan short yang anda entry  : " + __short);
        System.out.println("Bilangan int yang anda entry    : " + __int);
        System.out.println("Bilangan long yang anda entry   : " + __long);
    }
    
    public void __4(Scanner scanner) {
        String   name;
        String   address;
        int      age;
        char     gender;
        String[] hobbies = new String[3];
        float    gpa;

        System.out.print("name      : "); name = scanner.nextLine();
        System.out.print("address   : "); address = scanner.nextLine();
        System.out.print("age       : "); age = scanner.nextInt();
        System.out.print("gender    : "); gender = scanner.next().charAt(0);
        System.out.println("hobbies");
        scanner.nextLine();
        for(int i = 0;i < hobbies.length;i++) {
            System.out.print(String.format("hobby - %d : ", i + 1));
            hobbies[i] = scanner.nextLine();
        }
        System.out.print("gpa       : "); gpa = scanner.nextFloat();

        System.out.println("Your name       : " + name);
        System.out.println("Your address    : " + address);
        System.out.println("Your age        : " + age + " years old");
        System.out.println("Your gender     : " + gender);
        for(int i = 0;i < hobbies.length;i++) {
            System.out.println("Your " + (i + 1) + "th hobby  : " + hobbies[i]);
        }
        System.out.println("Your gpa        : " + gpa);
    }

    public static void main(String[] args) {
        InputViaKeyboard inputViaKeyboard = new InputViaKeyboard();
        Scanner scanner = new Scanner(System.in);
        // inputViaKeyboard.__1(scanner);
        // inputViaKeyboard.__2(scanner);
        // inputViaKeyboard.__3(scanner);
        inputViaKeyboard.__4(scanner);
        scanner.close();
    }
}