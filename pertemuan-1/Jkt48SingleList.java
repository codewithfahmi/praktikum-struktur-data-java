import java.util.Scanner;

class Jkt48SingleList {
    public String[][][] data = {
        {
            {
                "1", "River", "11 Mei 2013"
            }, 
            {
                "River", 
                "Pembatas Buku Sakura", 
                "Buah Masa Depan", 
                "Jatuh Cinta Setiap Bertemu Denganmu"
            }
        },
        {
            {
                "2", "Apakah Kau Melihat Mentari Senja", "3 Juli 2013"
            }, 
            {
                "Apakah Kau Melihat Mentari Senja", 
                "Cahaya Panjang", 
                "1!2!3!4! Yoroshiku", 
                "Viva! Hurricane"
            }
        },
        {
            {
                "3", "Fortune Cookie Yang Mencinta", "21 Agustus 2013"
            }, 
            {
                "Fortune Cookie Yang Mencinta", 
                "First Rabbit", 
                "Baby! Baby! Baby!", 
                "Fortune Cookie (English ver.)"
            }
        }
    };
    
    public String title = "JKT48 Single List";

    public void makeBorder(String val) {
        System.out.println("-".repeat(val.length()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jkt48SingleList app = new Jkt48SingleList();

        char isExit = 'n';
        while(isExit != 'y') {
            System.out.println(app.title);
            app.makeBorder(app.title);

            for(int i = 0;i < app.data.length;i++) {
                System.out.println(app.data[i][0][0] + ". " + app.data[i][0][1]);
            }

            System.out.println("\nMasukkan nomor urut untuk detail single");
            System.out.print(">>> "); int opsi = scanner.nextInt();

            System.out.print("Keluar? (y/n)");
            isExit = Character.toLowerCase(scanner.next().charAt(0)); 
            System.out.println();
        }
    }
}