import java.util.Scanner;

class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainPassword = "AKAKOM";
        System.out.print("MASUKKAN PASSWORD : ");
        String password = scanner.nextLine();
        if(password.equals(mainPassword)) {
            System.out.println("=> PASSWORD ANDA BENAR");
        } else {
            System.out.println("=> PASSWORD ANDA SALAH");
        }
        scanner.close();
    }
}