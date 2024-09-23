import controller.Mahasiswa;
import model.Biodata;
import util.Form;
import util.Menu;

public class App {
    private static String APP_TITLE = "Data Mahasiswa";
    private static String[] APP_INSERT_LABElS = { "Tambah Depan", "Tambah Tengah", "Tambah Belakang" };
    private static String[] APP_REMOVE_LABELS = { "Hapus Depan", "Hapus Tengah", "Hapus Belakang" };

    public static void main(String[] args) throws Exception {
        Biodata[] daftarMahasiswa = new Biodata[0];
        int menuOption = 0;
        int positionOption = 0;
        int dataPosition = 0;
        char isContinue = 'y';
        boolean isBreak = false;
        String banner = null;

        while (true) {
            System.out.println(String.format("\n%s\n%s", APP_TITLE,
                    "-".repeat(APP_TITLE.length())));

            Menu.showMenu();
            menuOption = Form.input("Pilih menu").toInt();

            switch (menuOption) {
                case 1:
                    while (true) {
                        banner = "Tambahkan Data";
                        System.out.println(String.format("\n%s\n%s", banner,
                                "-".repeat(banner.length())));

                        if (positionOption == 0) {
                            Menu.showSubMenu();
                            positionOption = Form.input("Pilih posisi").toInt();
                        }

                        dataPosition = positionOption == 1 ? 0 : -1;

                        banner = APP_INSERT_LABElS[positionOption - 1];
                        System.out.println(String.format("\n%s\n%s", banner,
                                "-".repeat(banner.length())));

                        if (positionOption == 2)
                            dataPosition = Form.input(
                                    String.format("Pilih posisi data antara 0 - %s",
                                            daftarMahasiswa.length))
                                    .toInt();

                        daftarMahasiswa = Mahasiswa.insert(daftarMahasiswa, dataPosition);
                        isContinue = Form.input("Lanjut?").toSingleAlphabet();

                        if (isContinue == 'n')
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\n--- Anda telah meninggalkan aplikasi ---");
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
