import controller.Mahasiswa;
import model.BiodataMahasiswa;
import util.Constanta;
import util.Form;
import util.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        BiodataMahasiswa[] daftarMahasiswa = new BiodataMahasiswa[0];
        int option = 0;
        boolean isBreak = false;
        char isContinue = 'y';

        while (true) {
            System.out.println(String.format("\n%s\n%s", Constanta.APP_TITLE,
                    "-".repeat(Constanta.APP_TITLE.length())));

            Menu.show();

            Form form = new Form();
            Mahasiswa mahasiswa = new Mahasiswa();

            option = form.inputInteger("pilih salah satu nomor");

            switch (option) {
                case 1:
                    while (isContinue != 'n') {
                        daftarMahasiswa = mahasiswa.actionInsert(daftarMahasiswa);
                        isContinue = form.inputOnlyString("lagi?")
                                .charAt(0);
                    }
                    break;
                case 2:
                    mahasiswa.actionShow(daftarMahasiswa);
                    break;
                case 3:
                    isBreak = true;
                    break;
                default:
                    System.out.println("[!] pilih antara menu 1 sampai " + Constanta.APP_MENUS.length);
                    break;
            }

            if (isBreak) {
                System.out.println("\n[!] Anda keluar dari aplikasi");
                break;
            }

            if (isContinue == 'n') {
                isContinue = 'y';
            }
        }
    }
}
