import controller.Mahasiswa;
import model.Biodata;
import util.Form;
import util.Menu;

public class App {
    private static String APP_TITLE = "Data Mahasiswa";
    private static String[] APP_INSERT_LABElS = {
            "Tambahkan data di Depan",
            "Tambahkan data di Tengah",
            "Tambahkan data di Belakang"
    };

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
                    while (true) {
                        banner = "Tambahkan Data";
                        System.out.println(String.format("\n%s\n%s", banner,
                                "-".repeat(banner.length())));

                        if (positionOption == 0) {
                            /** Show application menu's subMenu */
                            Menu.showSubMenu();

                            /** Set subMenu option */
                            positionOption = Form.inputNumber("Pilih posisi");
                        }

                        /** Set insert data position to 0 (front) or -1 (back) */
                        dataPosition = positionOption == 1 ? 0 : -1;

                        banner = APP_INSERT_LABElS[positionOption - 1];
                        System.out.println(String.format("\n%s\n%s", banner,
                                "-".repeat(banner.length())));

                        /** Set insert data position to entered position */
                        if (positionOption == 2) {
                            dataPosition = Form.inputNumber(String.format("Pilih posisi data antara 0 - %s",
                                    daftarMahasiswa.length));
                        }

                        /** Insert data */
                        Mahasiswa.insert(daftarMahasiswa, dataPosition);
                        isContinue = Form.inputOnlyString("Lanjut?").charAt(0);

                        if (isContinue == 'n') {
                            break;
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    isBreak = true;
                    break;
            }

            if (isContinue == 'n') {
                isContinue = 'y';
            }

            if (isBreak)
                break;
        }
    }
}
