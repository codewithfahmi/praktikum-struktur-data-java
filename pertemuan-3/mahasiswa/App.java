import java.util.Scanner;

class Mahasiswa {
	public String nama;
	public String alamat;
	public int umur;
	public char gender;
	public String[] hobi = new String[3];
	public float ipk;
}

public class App {
	/**
	 * Input untuk memasukkan data berjenis data String (hanya alfabet)
	 * 
	 * @param label
	 * @return String result
	 */
	private String inputOnlyString(String label) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String result = null;
		while (true) {
			System.out.print(String.format("%-10s : ", label));
			result = scanner.nextLine();
			if (!result.matches("[a-zA-Z]+")) {
				System.out.println(String.format("[!] %s hanya boleh huruf alfabet", label));
			} else if (result.isBlank() || result.isEmpty()) {
				System.out.println(String.format("[!] %s tidak boleh kosong", label));
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * Input untuk memasukkan data berjenis data String
	 * 
	 * @param label
	 * @return String result
	 */
	private String inputString(String label) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String result = null;
		while (true) {
			System.out.print(String.format("%-10s : ", label));
			result = scanner.nextLine();
			if (result.isBlank() || result.isEmpty()) {
				System.out.println(String.format("[!] %s tidak boleh kosong", label));
			} else {
				break;
			}
		}
		return result;
	}

	/**
	 * Input untuk memasukkan data berjenis data Integer
	 * 
	 * @param label
	 * @return Integer result
	 */
	private int inputNumber(String label) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String result = null;
		while (true) {
			System.out.print(String.format("%-10s : ", label));
			result = scanner.nextLine();
			if (!result.matches("\\d+")) {
				System.out.println(String.format("[!] %s hanya boleh angka", label));
			} else if (result.isBlank() || result.isEmpty()) {
				System.out.println(String.format("[!] %s tidak boleh kosong", label));
			} else {
				break;
			}
		}
		return Integer.parseInt(result);
	}

	/**
	 * Input untuk memasukkan data berjenis data Float
	 * 
	 * @param label
	 * @return Float result
	 */
	private float inputFloat(String label) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String result = null;
		while (true) {
			System.out.print(String.format("%-10s : ", label));
			result = scanner.nextLine();
			if (!result.matches("^-?\\d+(\\.\\d+)?$")) {
				System.out.println(String.format("[!] %s hanya boleh angka desimal", label));
			} else if (result.isBlank() || result.isEmpty()) {
				System.out.println(String.format("[!] %s tidak boleh kosong", label));
			} else {
				break;
			}
		}
		return Float.parseFloat(result);
	}

	/**
	 * Form untuk menambahkan data ke rekaman
	 * 
	 * @return Mahasiswa
	 */
	private Mahasiswa form() {
		Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswa.nama = this.inputOnlyString("Nama");
		mahasiswa.alamat = this.inputString("Alamat");
		mahasiswa.umur = this.inputNumber("Umur");
		mahasiswa.gender = this.inputOnlyString("Gender").charAt(0);
		for (int i = 0; i < mahasiswa.hobi.length; i++)
			mahasiswa.hobi[i] = this.inputOnlyString("hobi - " + (i + 1));
		mahasiswa.ipk = this.inputFloat("IPK");
		return mahasiswa;
	}

	/**
	 * Fungsi untuk menambahkan data ke index pertama rekaman
	 * 
	 * @param mahasiswa
	 * @param data
	 * @return Mahasiswa[] result
	 * 
	 */
	private Mahasiswa[] insertDepan(Mahasiswa[] mahasiswa, Mahasiswa data) {
		int mahasiswaLength = mahasiswa.length;
		Mahasiswa[] result = new Mahasiswa[mahasiswaLength + 1];
		if (mahasiswa.length > 0)
			for (int i = 0; i < mahasiswaLength; i++)
				result[i + 1] = mahasiswa[i];
		result[0] = data;
		return result;
	}

	/**
	 * Fungsi untuk menambahkan data ke index terakhir rekaman
	 * 
	 * @param mahasiswa
	 * @param data
	 * @return Mahasiswa[] result
	 */
	private Mahasiswa[] insertBelakang(Mahasiswa[] mahasiswa, Mahasiswa data) {
		int mahasiswaLength = mahasiswa.length;
		Mahasiswa[] result = new Mahasiswa[mahasiswaLength + 1];
		if (mahasiswa.length > 0)
			for (int i = 0; i < mahasiswaLength; i++)
				result[i] = mahasiswa[i];
		result[mahasiswaLength] = data;
		return result;
	}

	/**
	 * Fungsi untuk menambahkan data ke record dengan index yang disesuaikan
	 * 
	 * @param mahasiswa
	 * @param data
	 * @param position
	 * @return Mahasiswa[] result
	 */
	private Mahasiswa[] insertTengah(Mahasiswa[] mahasiswa, Mahasiswa data, int position) {
		int mahasiswaLength = mahasiswa.length;
		Mahasiswa[] result = new Mahasiswa[mahasiswaLength + 1];
		if (position == 0) {
			result = insertDepan(mahasiswa, data);
		} else if (position == mahasiswaLength) {
			result = insertBelakang(mahasiswa, data);
		} else {
			for (int i = 0; i < result.length; i++)
				result[i == position ? position : i] = i == position ? data : mahasiswa[i < position ? i : i - 1];
		}

		return result;
	}

	/**
	 * Fungsi untuk menghapus item pada index ke 0 dari rekaman
	 * 
	 * @param mahasiswa
	 * @return Mahasiswa[] result
	 */
	private Mahasiswa[] deleteDepan(Mahasiswa[] mahasiswa) {
		Mahasiswa[] result = new Mahasiswa[mahasiswa.length - 1];
		for (int i = 0; i < mahasiswa.length; i++)
			if (i == 0) {
				continue;
			} else {
				result[i - 1] = mahasiswa[i];
			}

		return result;
	}

	/**
	 * Fungsi untuk menghapus item pada index terakhir (array length - 1) dari
	 * rekaman
	 * 
	 * @param mahasiswa
	 * @return Mahasiswa[] result
	 */
	private Mahasiswa[] deleteBelakang(Mahasiswa[] mahasiswa) {
		Mahasiswa[] result = new Mahasiswa[mahasiswa.length - 1];
		for (int i = 0; i < result.length; i++)
			result[i] = mahasiswa[i];
		return result;
	}

	/**
	 * Fungsi untuk menghapus item dari rekaman dengan index yang ditentukan
	 * 
	 * @param mahasiswa
	 * @param position
	 * @return
	 */
	private Mahasiswa[] deleteTengah(Mahasiswa[] mahasiswa, int position) {
		Mahasiswa[] result = new Mahasiswa[mahasiswa.length - 1];
		if (position == 0) {
			result = this.deleteDepan(mahasiswa);
		} else if (position == mahasiswa.length - 1) {
			result = this.deleteBelakang(mahasiswa);
		} else {
			for (int i = 0; i < mahasiswa.length; i++)
				if (i == position) {
					continue;
				} else {
					int index = i < position ? i : i - 1;
					result[index] = mahasiswa[i];
				}
		}
		return result;
	}

	/**
	 * Operasi untuk menampilkan seluruh data yang tersimpan
	 * 
	 * @param mahasiswa
	 */
	private void showData(Mahasiswa[] mahasiswa) {
		String title = "Daftar Mahasiswa";
		StringBuilder result = new StringBuilder();
		StringBuilder header = new StringBuilder();
		StringBuilder format = new StringBuilder();
		StringBuilder borderSplit = new StringBuilder();
		String[] columns = { "Nama", "Alamat", "Umur", "Gender", "Hobi", "IPK" };
		int[] columnLength = { 20, 20, 8, 15, 25, 10 };
		System.out.println(String.format("\n%s\n%s\n", title, "-".repeat(title.length())));

		/** generate border split */
		for (int i = 0; i < columnLength.length; i++)
			borderSplit.append((i == columnLength.length - 1)
					? String.format("+%s+\n", "-".repeat(columnLength[i] - 2))
					: String.format("+%s", "-".repeat(columnLength[i] - 1)));

		/** generate format for each row */
		for (int j = 0; j < columnLength.length; j++)
			format.append((j == columnLength.length - 1)
					? "| %-" + (columnLength[j] - 4) + "s |\n" + borderSplit
					: "| %-" + (columnLength[j] - 2) + "s");

		header.append(borderSplit);

		/** header columns name */
		for (int i = 0; i < columns.length; i++)
			header.append(String.format((i == (columns.length - 1))
					? "| %-" + (columnLength[i] - 4) + "s |\n"
					: "| %-" + (columnLength[i] - 2) + "s", columns[i]));

		header.append(borderSplit);
		result.append(header);

		/** table content */
		if (mahasiswa.length > 0) {
			for (int i = 0; i < mahasiswa.length; i++)
				result.append(String.format(format.toString(),
						mahasiswa[i].nama,
						mahasiswa[i].alamat,
						Integer.toString(mahasiswa[i].umur),
						mahasiswa[i].gender,
						String.join(", ", mahasiswa[i].hobi),
						Float.toString(mahasiswa[i].ipk)));
		} else {
			int totalLength = 0;
			for (int i = 0; i < columnLength.length; i++)
				totalLength += columnLength[i];
			result.append(String.format("| %-" + (totalLength - 4) + "s |\n" + borderSplit, "Belum ada data"));
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String menu[] = { "Input", "View", "Edit", "Delete", "Reorder", "Exit" };
			String subMenu[] = { "Depan", "Tengah", "Belakang" };
			int option = 0;
			int subOption = 0;
			char isContinue = 'y';
			Mahasiswa[] mahasiswa = new Mahasiswa[0];
			App app = new App();
			while (true) {
				String appTitle = "Data Mahasiswa";
				System.out.println(String.format("\n%s\n%s", appTitle, "-".repeat(appTitle.length())));
				for (int i = 0; i < menu.length; i++)
					System.out.println(String.format("%d. %s", (i + 1), menu[i]));
				System.out.print(">>> ");
				option = scanner.nextInt();
				switch (option) {
					/** Insert Operation */
					case 1:
						String inserTitle = "Tambah Data Mahasiswa";
						System.out.println(String.format("\n%s\n%s", inserTitle, "-".repeat(inserTitle.length())));
						for (int i = 0; i < subMenu.length; i++)
							System.out.println(String.format("%d. %s", (i + 1), subMenu[i]));
						System.out.print(">>> ");
						subOption = scanner.nextInt();

						while (isContinue != 'n') {
							switch (subOption) {
								case 1:
									inserTitle = "Tambah Depan";
									System.out.println(String.format("\n%s\n%s", inserTitle, "-".repeat(inserTitle.length())));
									mahasiswa = app.insertDepan(mahasiswa, app.form());
									break;
								case 2:
									inserTitle = "Tambah Tengah";
									System.out.println(String.format("\n%s\n%s", inserTitle, "-".repeat(inserTitle.length())));
									String limitWarning = "index hanya boleh 0 - " + (mahasiswa.length == 0 ? 0 : (mahasiswa.length - 1));
									System.out.println(limitWarning);
									int index = 0;
									while (true) {
										index = app.inputNumber("index");
										if (index > mahasiswa.length) {
											System.out.println(limitWarning);
										} else {
											break;
										}
									}
									mahasiswa = app.insertTengah(mahasiswa, app.form(), index);
									break;
								case 3:
									inserTitle = "Tambah Belakang";
									System.out.println(String.format("\n%s\n%s", inserTitle, "-".repeat(inserTitle.length())));
									mahasiswa = app.insertBelakang(mahasiswa, app.form());
									break;
							}
							isContinue = Character.toLowerCase(app.inputOnlyString("Lagi").charAt(0));
						}
						break;
					/** End of Insert Operation */

					/** Show Data Operation */
					case 2:
						for (int i = 0; i < mahasiswa.length; i++) {
							System.out.println((i) + " => " + mahasiswa[i].nama);
						}
						app.showData(mahasiswa);
						break;
					/** End of Show Data Operation */

					/** Edit Operation */
					case 3:
						String editTitle = "Edit Data Mahasiswa";
						System.out.println(String.format("\n%s\n%s", editTitle, "-".repeat(editTitle.length())));
						if (mahasiswa.length == 0) {
							System.out.println("[!] Tidak ada data yang bisa diubah");
						} else {
							while (isContinue != 'n') {
								int index = 0;
								while (true) {
									index = app.inputNumber("index");
									if (index > mahasiswa.length - 1 || index < 0) {
										System.out.println("[!] index hanya boleh 0 - " + (mahasiswa.length - 1));
									} else {
										break;
									}
								}

								Mahasiswa current = mahasiswa[index];

								String editCurrentTitle = "Data Sekarang";
								System.out.println(String.format("\n%s\n%s", editCurrentTitle, "-".repeat(editCurrentTitle.length())));
								System.out.println(String.format("%-7s : %s", "Nama", current.nama));
								System.out.println(String.format("%-7s : %s", "Alamat", current.alamat));
								System.out.println(String.format("%-7s : %s", "Umur", Integer.toString(current.umur)));
								System.out.println(String.format("%-7s : %s", "Gender", current.gender));
								System.out.println(String.format("%-7s : %s", "Hobi", String.join(", ", current.hobi)));
								System.out.println(String.format("%-7s : %s", "IPK", Float.toString(current.ipk)));

								editCurrentTitle = "Ubah Data Sekarang";
								System.out.println(String.format("\n%s\n%s", editCurrentTitle, "-".repeat(editCurrentTitle.length())));
								Mahasiswa newData = app.form();
								mahasiswa[index] = newData;
								isContinue = Character.toLowerCase(app.inputOnlyString("Lagi").charAt(0));
							}
						}
						break;

					/** Delete Operation */
					case 4:
						String deleteTitle = "Hapus Data Mahasiswa";
						System.out.println(String.format("\n%s\n%s", deleteTitle, "-".repeat(deleteTitle.length())));
						if (mahasiswa.length == 0) {
							System.out.println("[!] Tidak ada data yang bisa dihapus");
						} else {
							for (int i = 0; i < subMenu.length; i++)
								System.out.println(String.format("%d. %s", (i + 1), subMenu[i]));
							System.out.print(">>> ");
							subOption = scanner.nextInt();

							while (isContinue != 'n') {
								switch (subOption) {
									case 1:
										deleteTitle = "Hapus Depan";
										System.out.println(String.format("\n%s\n%s", deleteTitle, "-".repeat(deleteTitle.length())));
										mahasiswa = app.deleteDepan(mahasiswa);
										break;
									case 2:
										deleteTitle = "Hapus Tengah";
										System.out.println(String.format("\n%s\n%s", deleteTitle, "-".repeat(deleteTitle.length())));
										String limitWarning = "index hanya boleh 0 - "
												+ (mahasiswa.length == 0 ? 0 : (mahasiswa.length - 1));
										System.out.println(limitWarning);
										int position = 0;
										while (true) {
											position = app.inputNumber("index");
											if (position > mahasiswa.length) {
												System.out.println(limitWarning);
											} else {
												break;
											}
										}
										mahasiswa = app.deleteTengah(mahasiswa, position);
										break;
									case 3:
										deleteTitle = "Hapus Belakang";
										System.out.println(String.format("\n%s\n%s", deleteTitle, "-".repeat(deleteTitle.length())));
										mahasiswa = app.deleteBelakang(mahasiswa);
										break;
								}
								isContinue = Character.toLowerCase(app.inputOnlyString("Lagi").charAt(0));
							}
						}
						break;
					/** End of Delete Operation */

					/** Reorder Operation */
					case 5:
						String reorderTitle = "Tukar Posisi Data";
						System.out.println(String.format("\n%s\n%s", reorderTitle, "-".repeat(reorderTitle.length())));

						while (isContinue != 'n') {
							int indexSource = 0;
							int indexTarget = 0;

							while (true) {
								indexSource = app.inputNumber("index source");
								if (indexSource > mahasiswa.length - 1 || indexSource < 0) {
									System.out.println("[!] Index hanya boleh 0 - " + (mahasiswa.length - 1));
								} else {
									break;
								}
							}

							while (true) {
								indexTarget = app.inputNumber("target index");
								if (indexTarget > mahasiswa.length - 1 || indexTarget < 0) {
									System.out.println("[!] Index hanya boleh 0 - " + (mahasiswa.length - 1));
								} else if (indexSource == indexTarget) {
									System.out.println("[!] \"Index target\" tidak boleh sama dengan \"Index source\"");
								} else {
									break;
								}
							}

							Mahasiswa temp = mahasiswa[indexTarget];
							mahasiswa[indexTarget] = mahasiswa[indexSource];
							mahasiswa[indexSource] = temp;

							isContinue = Character.toLowerCase(app.inputOnlyString("Lagi").charAt(0));
						}

						break;
					/** End of Reorder Operation */

					case 6:
						System.exit(0);
						break;
				}

				if (isContinue == 'n') {
					isContinue = 'y';
				}
			}
		}
	}
}