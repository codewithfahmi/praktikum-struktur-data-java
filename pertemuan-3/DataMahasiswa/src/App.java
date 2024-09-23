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
			System.out.println(String.format("\n%s\n%s", APP_TITLE, "-".repeat(APP_TITLE.length())));
			Menu.showMenu();
			menuOption = Form.input("Pilih menu").toInt();

			switch (menuOption) {
				case 1:
					while (true) {
						banner = "Tambahkan Data";
						System.out.println(String.format("\n%s\n%s", banner, "-".repeat(banner.length())));

						if (positionOption == 0) {
							Menu.showSubMenu();
							positionOption = Form.input("Pilih posisi").toInt();
						}

						switch (positionOption) {
							case 1:
								dataPosition = 0;
								break;
							case 2:
								while (true) {
									dataPosition = Form
											.input(String.format("Pilih index antara 0 - %s", daftarMahasiswa.length))
											.toInt();
									if (dataPosition > daftarMahasiswa.length) {
										System.out.println(
												"[!] index tidak boleh lebih dari " + (daftarMahasiswa.length == 0 ? 0
														: daftarMahasiswa.length));
									} else if (dataPosition < 0) {
										System.out.println("[!] index tidak boleh kurang dari 0");
									} else {
										break;
									}
								}
								break;
							case 3:
								dataPosition = -1;
								break;
							default:
								System.out.println("[!] Hanya boleh memilih antara 1 - 3");
								break;
						}

						if (positionOption < 4 && positionOption >= 1) {
							banner = APP_INSERT_LABElS[positionOption - 1];
							System.out.println(String.format("\n%s\n%s", banner, "-".repeat(banner.length())));

							daftarMahasiswa = Mahasiswa.insert(daftarMahasiswa, dataPosition);

							isContinue = Form.input("Lanjut?").toSingleAlphabet();
						}

						if (isContinue == 'n')
							break;
					}
					break;
				case 2:
					while (true) {
						banner = "Penghapusan Data";
						System.out.println(String.format("\n%s\n%s", banner, "-".repeat(banner.length())));

						if (daftarMahasiswa.length == 0) {
							System.out.println("[!] Data Kosong, tidak bisa melakukan penghapusan");
							break;
						} else {
							if (positionOption == 0) {
								Menu.showSubMenu();
								positionOption = Form.input("Pilih posisi").toInt();
							}

							switch (positionOption) {
								case 1:
									dataPosition = 0;
									break;
								case 2:
									while (true) {
										dataPosition = Form
												.input(String.format("Pilih index antara 0 - %s",
														daftarMahasiswa.length))
												.toInt();
										if (dataPosition > daftarMahasiswa.length) {
											System.out.println("[!] index tidak boleh lebih dari "
													+ (daftarMahasiswa.length == 0 ? 0
															: daftarMahasiswa.length));
										} else if (dataPosition < 0) {
											System.out.println("[!] index tidak boleh kurang dari 0");
										} else {
											break;
										}
									}
									break;
								case 3:
									dataPosition = -1;
									break;
								default:
									System.out.println("[!] Hanya boleh memilih antara 1 - 3");
									break;
							}

						}

						if (positionOption < 4 && positionOption >= 1) {
							banner = APP_REMOVE_LABELS[positionOption - 1];
							System.out.println(String.format("\n%s\n%s", banner, "-".repeat(banner.length())));

							daftarMahasiswa = Mahasiswa.delete(daftarMahasiswa, dataPosition);

							isContinue = Form.input("Lanjut?").toSingleAlphabet();
						}

						if (isContinue == 'n')
							break;
					}
					break;
				case 3:
					banner = "Daftar Mahasiswa";
					System.out.println(String.format("\n%s\n%s\n", banner, "-".repeat(banner.length())));
					Mahasiswa.show(daftarMahasiswa);
					break;
				case 4:
					System.out.println("\n--- Anda telah meninggalkan aplikasi ---");
					isBreak = true;
					break;
			}

			positionOption = 0;
			isContinue = 'y';

			if (isBreak)
				break;
		}
	}
}
