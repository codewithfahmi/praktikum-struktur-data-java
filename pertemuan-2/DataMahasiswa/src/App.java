import controller.Mahasiswa;
import controller.Record;
import model.Biodata;
import util.Form;
import util.Menu;

public class App {
	private static String APP_TITLE = "Data Mahasiswa";
	private static String[] APP_INSERT_LABElS = { "Tambah Depan", "Tambah Tengah", "Tambah Belakang" };
	private static String[] APP_REMOVE_LABELS = { "Hapus Depan", "Hapus Tengah", "Hapus Belakang" };

	public static void main(String[] args) throws Exception, ArrayStoreException {
		Record<Biodata> record = new Record<>(Biodata.class);

		Biodata[] daftarMahasiswa = new Biodata[0];
		int menuOption = 0;
		int positionOption = 0;
		int dataPosition = 0;
		char isContinue = 'y';
		boolean isBreak = false;
		String banner = null;

		while (true) {
			Biodata fahmi = new Biodata();
			Biodata john = new Biodata();
			Biodata doe = new Biodata();
			Biodata garfield = new Biodata();
			fahmi.namaMhs = "Fahmi";
			fahmi.alamatMhs = "Jepara";
			fahmi.genderMhs = 'l';
			fahmi.umurMhs = 24;
			fahmi.hobiMhs[0] = "Makan";
			fahmi.hobiMhs[1] = "Tidur";
			fahmi.hobiMhs[2] = "Ngoding";
			fahmi.ipkMhs = 2.4F;
			john.namaMhs = "John";
			john.alamatMhs = "Jepara";
			john.genderMhs = 'l';
			john.umurMhs = 24;
			john.hobiMhs[0] = "Makan";
			john.hobiMhs[1] = "Tidur";
			john.hobiMhs[2] = "Ngoding";
			john.ipkMhs = 2.4F;
			doe.namaMhs = "Doe";
			doe.alamatMhs = "Jepara";
			doe.genderMhs = 'l';
			doe.umurMhs = 24;
			doe.hobiMhs[0] = "Makan";
			doe.hobiMhs[1] = "Tidur";
			doe.hobiMhs[2] = "Ngoding";
			doe.ipkMhs = 2.4F;
			garfield.namaMhs = "Garfield";
			garfield.alamatMhs = "Jepara";
			garfield.genderMhs = 'l';
			garfield.umurMhs = 24;
			garfield.hobiMhs[0] = "Makan";
			garfield.hobiMhs[1] = "Tidur";
			garfield.hobiMhs[2] = "Ngoding";
			garfield.ipkMhs = 2.4F;
			record.Prepend(fahmi);
			record.Append(doe);
			record.Append(doe);
			record.Append(doe);
			record.Append(doe);
			record.Append(doe);
			record.Push(garfield, 1);

			for (int i = 0; i < record.Length(); i++) {
				System.out.println(record.GetByIndex(i).namaMhs);
			}
			System.out.println("Record length => " + record.Length());

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
														daftarMahasiswa.length - 1))
												.toInt();
										if (dataPosition > daftarMahasiswa.length - 1) {
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
