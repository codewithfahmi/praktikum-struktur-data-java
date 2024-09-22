import controller.Mahasiswa;
import model.Biodata;
import util.Form;
import util.Menu;

public class App {
    private static String APP_TITLE = "Data Mahasiswa";

    public static void main(String[] args) throws Exception {
        Biodata[] daftarMahasiswa = new Biodata[0];
        int menuOption = 0;
        int positionOption = 0;
        int dataPosition = 0;
        String banner = null;
        boolean isBreak = false;
        char isContinue = 'y';

        while (true) {
            /** Application's Banner */
            System.out.println(String.format("\n%s\n%s", APP_TITLE,
                    "-".repeat(APP_TITLE.length())));

            /** Show application menu list */
            Menu.showMenu();

            /** Set menu option */
            menuOption = Form.inputNumber("Pilih menu");

            /** Run feature */
            switch (menuOption) {
                case 1:
                    banner = "Tambahkan Data";
                    System.out.println(String.format("\n%s\n%s", banner, "-".repeat(banner.length())));

                    /** Show application menu's subMenu */
                    Menu.showSubMenu();

                    /** Set subMenu option */
                    positionOption = Form.inputNumber("Pilih posisi");

                    if (positionOption == 1) {
                        banner = "Tambahkan data di Depan";
                        dataPosition = 0;
                    } else if (positionOption == 2) {
                        banner = "Tambahkan data di Tengah";
                    } else {
                        banner = "Tambahkan data di Belakang";
                        dataPosition = -1;
                    }

                    System.out.println(String.format("\n%s\n%s", banner,
                            "-".repeat(banner.length())));

                    if (positionOption == 2) {
                        dataPosition = Form.inputNumber(String.format("Pilih posisi data antara 0 - %s",
                                daftarMahasiswa.length));
                    }

                    Mahasiswa.insert(daftarMahasiswa, dataPosition);

                    break;
                case 2:
                    break;
                case 3:
                    isBreak = true;
                    break;
            }

            if (isBreak)
                break;
        }
    }
}
