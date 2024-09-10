import java.util.Scanner;

class TipeData {
    public void charType() {
        char letter = 'C';
        System.out.println("Nilai Char      : " + letter);
    }

    public void stringType() {
        String name = "Fahmi Syahrul Yahya";
        System.out.println("Nilai String    : " + name);
    }

    public void alphanumericType() {
        byte __byte = 34;
        short __short = 714;
        int __int = 2235641;
        long __long = 546767226531L;

        System.out.println("Nilai Byte      : " + __byte);
        System.out.println("Nilai Short     : " + __short);
        System.out.println("Nilai Int       : " + __int);
        System.out.println("Nilai Long      : " + __long);
    }

    public void pecahanType() {
        float __float = 1.733F;
        double __double = 8.967;
        System.out.println("Nilai float     : " + __float);
        System.out.println("Nilai double    : " + __double);
    }

    public void booleanType() {
        boolean __false = false;
        boolean __true = true;

        System.out.println("Nilai Bool      : " + __false);
        System.out.println("Nilai bool      : " + __true);
    }

    public void arrayType() {
        Scanner scanner = new Scanner(System.in);
        String[] hobbies = new String[3];
        System.out.println(String.format("Silahkan masukkan hobi (maks %d) : ", hobbies.length));

        for (int i = 0; i < hobbies.length; i++) {
            System.out.print(String.format("Hobi ke - %d : ", i + 1));
            hobbies[i] = scanner.nextLine();
        }

        for (int i = 0; i < hobbies.length; i++) {
            System.out.println(String.format("Hobi ke - %d anda adalah %s", (i + 1), hobbies[i]));
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TipeData tipeData = new TipeData();
        tipeData.charType();
        tipeData.stringType();
        tipeData.alphanumericType();
        tipeData.pecahanType();
        tipeData.booleanType();
        tipeData.arrayType();
    }
}