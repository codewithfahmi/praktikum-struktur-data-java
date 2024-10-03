import java.util.Scanner;

class Mahasiswa {
	public String nama;
	public String alamat;
	public int umur;
	public char gender;
	public String[] hobi = new String[3];
	public float ipk;

	public Mahasiswa set(String nama, String alamat, int umur, char gender, String[] hobi, float ipk) {
		Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswa.nama = nama;
		mahasiswa.alamat = alamat;
		mahasiswa.umur = umur;
		mahasiswa.gender = gender;
		mahasiswa.hobi = hobi;
		mahasiswa.ipk = ipk;
		return mahasiswa;
	}
}

/**
 * @class Form
 */
class Form {
	private Scanner scanner = new Scanner(System.in);

	// Warning format
	private final String warning_format = "[!] \"%s\" %s";

	// Warning messages
	private final String warning_msg_required = "is required";
	private final String warning_msg_integer = "must be only integer";
	private final String warning_msg_string_only = "must no symbols or numbers";
	private final String warning_msg_string = "must be only string";
	private final String warning_msg_float = "must be decimal number";

	// Validation rules
	private final String integer_rule = "^-?\\d+$";
	private final String string_only_rule = "[a-zA-Z]+";
	private final String string_rule = "^[a-zA-Z0-9\\s.,@#$%^&*()_+]+$";
	private final String float_rule = "^[+-]?([0-9]*[.])?[0-9]+$";

	// Fields
	private String warning_message;
	private String input_result;
	private String input_label;
	private int input_label_length;
	private String input_rule;

	/**
	 * Membuat objek Form baru dengan label yang ditentukan
	 * 
	 * @param label Teks yang muncul ketika input dimulai
	 * @return Objek Form
	 */
	public static Form input(String label) {
		Form form = new Form();
		form.input_label = label;
		return form;
	}

	/**
	 * Membuat objek Form baru dengan label dan panjang label yang ditentukan
	 * 
	 * @param label  Teks yang muncul ketika input dimulai
	 * @param length Panjang label yang akan dimunculkan
	 * @return Objek Form
	 */
	public static Form input(String label, int length) {
		Form form = new Form();
		form.input_label = label;
		form.input_label_length = length;
		return form;
	}

	/**
	 * Menjalankan proses input pengguna dalam loop hingga input yang valid
	 * diberikan.
	 * 
	 * Metode ini akan terus meminta input dari pengguna sampai:
	 * 1) Input tidak kosong atau hanya berisi spasi.
	 * 2) Input memenuhi aturan yang telah ditentukan.
	 * 
	 * Jika input tidak valid, pesan peringatan akan ditampilkan kepada pengguna.
	 */
	private void run() {
		while (true) {
			String format = this.input_label_length != 0 ? "%-" + this.input_label_length + "s : " : "%s : ";
			System.out.print(String.format(format, this.input_label));
			this.input_result = scanner.nextLine();
			if (this.input_result.isBlank() || this.input_result.isEmpty()) {
				System.out.println(String.format(
						this.warning_format,
						this.input_label,
						this.warning_msg_required));
			} else if (!this.input_result.matches(this.input_rule)) {
				System.out.println(String.format(
						this.warning_format,
						this.input_label,
						this.warning_message));
			} else {
				break;
			}
		}
	}

	/**
	 * Merubah hasil masukan menjadi nilai integer
	 * 
	 * @return int
	 */
	public int to_int() {
		this.input_rule = this.integer_rule;
		this.warning_message = this.warning_msg_integer;
		this.run();
		return Integer.parseInt(this.input_result);
	}

	/**
	 * Merubah hasil masukan menjadi nilai String
	 * 
	 * @return String
	 */
	public String to_string() {
		this.input_rule = this.string_rule;
		this.warning_message = this.warning_msg_string;
		this.run();
		return this.input_result;
	}

	/**
	 * Merubah hasil masukan menjadi nilai String hanya huruf
	 * 
	 * @return
	 */
	public String to_only_string() {
		this.input_rule = this.string_only_rule;
		this.warning_message = this.warning_msg_string_only;
		this.run();
		return this.input_result;
	}

	/**
	 * Merubah hasil masukan menjadi nilai float
	 * 
	 * @return
	 */
	public float to_float() {
		this.input_rule = this.float_rule;
		this.warning_message = this.warning_msg_float;
		this.run();
		return Float.parseFloat(this.input_result);
	}

	public static void close() {
		new Form().scanner.close();
	}
}

class Record {
	/**
	 * Digunakan untuk menambahkan data ke rekaman data utama pada index ke 0
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param data      Data yang akan dimasukkan ke rekaman data utama
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] prepend(Mahasiswa[] mahasiswa, Mahasiswa data) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length + 1];
		if (record_length > 0)
			for (int i = 0; i < record_length; i++)
				temporary[i + 1] = mahasiswa[i];
		temporary[0] = data;
		return temporary;
	}

	/**
	 * Digunakan untuk menambahkan data ke rekaman data utama pada index terakhir
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param data      Data yang akan dimasukkan ke rekaman data utama
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] append(Mahasiswa[] mahasiswa, Mahasiswa data) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length + 1];
		if (record_length > 0)
			for (int i = 0; i < record_length; i++)
				temporary[i] = mahasiswa[i];
		temporary[record_length] = data;
		return temporary;
	}

	/**
	 * Digunakan untuk menambahkan data ke rekaman data utama pada index yang
	 * ditentukan
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param data      Data yang akan dimasukkan ke rekaman data utama
	 * @param position  Posisi index untuk data yang akan dimasukkan
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] insert(Mahasiswa[] mahasiswa, Mahasiswa data, int position) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length + 1];
		if (position == 0) {
			temporary = prepend(mahasiswa, data);
		} else if (position == (record_length - 1)) {
			temporary = append(mahasiswa, data);
		} else {
			for (int i = 0; i < temporary.length; i++) {
				temporary[i == position ? position : i] = i == position
						? data
						: mahasiswa[i < position ? i : i - 1];
			}
		}
		return temporary;
	}

	/**
	 * Digunakan untuk menghapus data pada index ke 0
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] shift(Mahasiswa[] mahasiswa) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length - 1];
		for (int i = 0; i < temporary.length; i++)
			temporary[i] = mahasiswa[i + 1];
		return temporary;
	}

	/**
	 * Digunakan untuk menghapus data pada index terakhir
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] pop(Mahasiswa[] mahasiswa) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length - 1];
		for (int i = 0; i < temporary.length; i++)
			temporary[i] = mahasiswa[i];
		return temporary;
	}

	/**
	 * Digunakan untuk menghapus data sesuai dengan index yang ditentukan
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param position  Posisi data index yang akan dihapus
	 * @return Mahasiswa[] Rekaman data
	 */
	public static Mahasiswa[] delete(Mahasiswa[] mahasiswa, int position) {
		int record_length = mahasiswa.length;
		Mahasiswa[] temporary = new Mahasiswa[record_length - 1];
		if (position == 0) {
			temporary = shift(mahasiswa);
		} else if (position == record_length - 1) {
			temporary = pop(mahasiswa);
		} else {
			for (int i = 0; i < temporary.length; i++) {
				if (i == position) {
					continue;
				} else {
					temporary[i < position ? i : i - 1] = mahasiswa[i];
				}
			}
		}

		return temporary;
	}

	/**
	 * Digunakan untuk menukar data
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param from      Index sumber
	 * @param to        Index target
	 * @return Mahasiswa[] Rekaman data utama
	 */
	public static Mahasiswa[] swap(Mahasiswa[] mahasiswa, int from, int to) {
		Mahasiswa temp = mahasiswa[from];
		mahasiswa[from] = mahasiswa[to];
		mahasiswa[to] = temp;
		return mahasiswa;
	}

	/**
	 * Digunakan untuk mencari data pada rekaman data utama menggunakan algoritma
	 * "linear search"
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param keyword   Kata kunci yang dicari
	 * @return Mahasiswa[]
	 */
	public static Mahasiswa[] linear_search(Mahasiswa[] mahasiswa, String keyword) {
		Mahasiswa[] result = new Mahasiswa[0];
		for (int i = 0; i < mahasiswa.length; i++) {
			if (mahasiswa[i].nama.toLowerCase().contains(keyword.toLowerCase())) {
				result = Record.append(result, mahasiswa[i]);
			}
		}
		return result;
	}

	/**
	 * Digunakan untuk mencari data pada rekaman data utama menggunakan algoritma
	 * "binary search"
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @param keyword   Kata kunci yang dicari
	 * @return Mahasiswa[]
	 */
	public static Mahasiswa[] binary_search(Mahasiswa[] mahasiswa, String keyword) {
		Mahasiswa[] result = new Mahasiswa[0];
		int low = 0, high = mahasiswa.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (mahasiswa[mid].nama.toLowerCase().contains(keyword.toLowerCase())) {
				result = Record.append(result, mahasiswa[mid]);

				int left = mid - 1;
				while (left >= 0 && mahasiswa[left].nama.toLowerCase().contains(keyword.toLowerCase())) {
					result = Record.append(result, mahasiswa[left]);
					left--;
				}

				int right = mid + 1;
				while (right < mahasiswa.length && mahasiswa[right].nama.toLowerCase().contains(keyword.toLowerCase())) {
					result = Record.append(result, mahasiswa[right]);
					right++;
				}

				break;
			}

			if (mahasiswa[mid].nama.compareToIgnoreCase(keyword) < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return result;
	}

	/**
	 * Digunakan untuk menampilkan data pada rekaman data utama
	 * 
	 * @param mahasiswa Rekaman data utama
	 */
	public static void show(Mahasiswa[] mahasiswa) {
		int name_format_length = 20;
		int alamat_format_length = 25;
		int umur_format_length = 8;
		int gender_format_length = 10;
		int hobi_format_length = 25;
		int ipk_format_length = 8;
		int[] format_lengths = { name_format_length, alamat_format_length, umur_format_length, gender_format_length,
				hobi_format_length, ipk_format_length };
		int total_format_lengths = 0;
		String[] headers = { "Nama", "Alamat", "Umur", "Gender", "Hobi", "Ipk" };
		String strip_line = "";
		String table = "\n";
		String header = "";
		String body = "";

		// Sum of format lengths
		for (int i = 0; i < format_lengths.length; i++)
			total_format_lengths += format_lengths[i];

		// Create strip line
		for (int i = 0; i < format_lengths.length; i++)
			strip_line += (i == format_lengths.length - 1)
					? String.format("+%s+\n", "-".repeat(format_lengths[i] - 2))
					: String.format("+%s", "-".repeat(format_lengths[i] - 1));

		// Create table header
		for (int i = 0; i < headers.length; i++)
			header += String.format(i == (headers.length - 1)
					? "| %-" + (format_lengths[i] - 4) + "s |\n"
					: "| %-" + (format_lengths[i] - 2) + "s",
					headers[i]);

		// Create table body
		if (mahasiswa.length == 0) {
			body += String.format("| %-" + (total_format_lengths - 4) + "s |\n" + strip_line, "Tidak ada data");
		} else {
			for (int i = 0; i < mahasiswa.length; i++) {
				body += String.format("| %-" + (name_format_length - 2) + "s",
						mahasiswa[i].nama.length() >= (name_format_length - 2)
								? mahasiswa[i].nama.substring(0, name_format_length - 6) + "..."
								: mahasiswa[i].nama);
				body += String.format("| %-" + (alamat_format_length - 2) + "s",
						mahasiswa[i].alamat.length() >= (alamat_format_length - 2)
								? mahasiswa[i].alamat.substring(0, alamat_format_length - 6) + "..."
								: mahasiswa[i].alamat);
				body += String.format("| %-" + (umur_format_length - 2) + "d", mahasiswa[i].umur);
				body += String.format("| %-" + (gender_format_length - 2) + "s", mahasiswa[i].gender);
				body += String.format("| %-" + (hobi_format_length - 2) + "s",
						String.join(", ", mahasiswa[i].hobi).length() >= (hobi_format_length - 2)
								? String.join(", ", mahasiswa[i].hobi).substring(0, hobi_format_length - 6) + "..."
								: String.join(", ", mahasiswa[i].hobi));
				body += String.format("| %-" + (ipk_format_length - 4) + ".2f |\n", mahasiswa[i].ipk);
				body += strip_line;
			}
		}

		// Build table
		table += strip_line;
		table += header;
		table += strip_line;
		table += body;

		System.out.println(table);
	}

	/**
	 * Pencarian data menggunakan algoritma Bubble Sort
	 * 
	 * @param mahasiswa Rekaman data utama
	 * @return Mahasiswa[]
	 */
	public static Mahasiswa[] bubble_sort(Mahasiswa[] mahasiswa) {
		Util.__("Starting \"Bubble Sort\"");
		long start_time = System.nanoTime();
		Mahasiswa[] result = mahasiswa;
		for (int i = 0; i < result.length - 1; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (result[i].nama.compareTo(result[j].nama) > 0) {
					System.out.println("[*] index " + i + " swapped with index " + j);
					Record.swap(result, i, j);
				}
			}
		}
		long end_time = System.nanoTime();
		float span_time = (end_time - start_time) / 1_000_000_000;
		System.out.println("[*] The records has been sorted using \"Bubble Sort\" algorithm in " + span_time + " seconds");
		return result;
	}
}

class Controller {
	private Mahasiswa __form() {
		Mahasiswa mahasiswa = new Mahasiswa();
		int format_length = 10;
		mahasiswa.nama = Form.input("nama", format_length).to_only_string();
		mahasiswa.alamat = Form.input("alamat", format_length).to_string();
		mahasiswa.umur = Form.input("umur", format_length).to_int();
		mahasiswa.gender = Form.input("gender", format_length).to_only_string().charAt(0);
		for (int i = 0; i < mahasiswa.hobi.length; i++)
			mahasiswa.hobi[i] = Form.input("hobi - " + (i + 1), format_length).to_only_string();
		mahasiswa.ipk = Form.input("ipk", format_length).to_float();
		return mahasiswa;
	}

	/**
	 * Method untuk menampilkan fitur "insert" atau menambahkan data ke rekaman data
	 * utama
	 */
	public static void action_insert() {
		Controller controller = new Controller();
		int menu_option = 0;

		while (true) {
			Util.__("Tambah Data");
			Util.__e(Env.insert_delete_menu, true);

			menu_option = Form.input("pilih").to_int();

			if (menu_option == 0)
				break;

			int mahasiswa_length = App.mahasiswa.length == 0
					? 0
					: App.mahasiswa.length + 1;
			Util.__("mahasiswa [" + mahasiswa_length + "]");
			switch (menu_option) {
				// Prepend operation
				case 1:
					App.mahasiswa = Record.prepend(App.mahasiswa, controller.__form());
					break;

				// Insert by index operation
				case 2:
					if (App.mahasiswa.length == 0) {
						Record.append(App.mahasiswa, controller.__form());
					} else {
						int position = 0;

						while (true) {
							position = Form.input("index").to_int();
							int record_length = App.mahasiswa.length;
							if (position > record_length - 1) {
								System.out.println("[!] index must be between 0 - " + record_length);
							} else {
								break;
							}
						}

						App.mahasiswa = Record.insert(App.mahasiswa, controller.__form(), position);
					}
					break;

				// Append operation
				case 3:
					App.mahasiswa = Record.append(App.mahasiswa, controller.__form());
					break;
			}

			if (Util.continue_prompt() == 'n') {
				break;
			}
		}
	}

	/**
	 * Method untuk menampilkan fitur "delete" atau menghapus data dari rekaman data
	 * utama
	 */
	public static void action_delete() {
		int menu_option = 0;
		while (true) {
			Util.__("Hapus Data");
			Util.__e(Env.insert_delete_menu, true);

			menu_option = Form.input("pilih").to_int();

			if (menu_option == 0)
				break;

			switch (menu_option) {
				// Shift operation
				case 1:
					App.mahasiswa = Record.shift(App.mahasiswa);
					break;

				// Delete by index operation
				case 2:
					int position = 0;

					while (true) {
						position = Form.input("index").to_int();
						int record_length = App.mahasiswa.length;
						if (position > record_length - 1) {
							System.out.println("[!] index must be between 0 - " + record_length);
						} else {
							break;
						}
					}

					App.mahasiswa = Record.delete(App.mahasiswa, position);
					break;

				// Pop operation
				case 3:
					App.mahasiswa = Record.pop(App.mahasiswa);
					break;
			}

			if (Util.continue_prompt() == 'n') {
				break;
			}
		}
	}

	/**
	 * Method untuk menampilkan data yang tersimpan pada rekaman data utama
	 */
	public static void action_view() {
		Record.show(App.mahasiswa);
	}

	/**
	 * Method untuk menampilkan fitur "edit" atau merubah data yang sudah tersimpan
	 * pada rekaman data utama
	 */
	public static void action_edit() {
		if (App.mahasiswa.length == 0) {
			System.out.println("\n[!] There is no data to edit");
		} else {
			while (true) {
				Util.__("Edit Data");
				System.out.println("[*] Ketik -1 untuk kembali");
				int index = 0;
				while (true) {
					index = Form.input("index").to_int();
					if (index == -1)
						break;

					if (index > (App.mahasiswa.length - 1)) {
						System.out.println("[!] index must be between 0 - " + (App.mahasiswa.length - 1));
					} else {
						break;
					}
				}

				if (index != -1) {
					Mahasiswa mahasiswa = App.mahasiswa[index];
					Util.__("Data Sekarang");
					System.out.println(String.format("%-10s : %s", "nama", mahasiswa.nama));
					System.out.println(String.format("%-10s : %s", "alamat", mahasiswa.alamat));
					System.out.println(String.format("%-10s : %d", "umur", mahasiswa.umur));
					System.out.println(String.format("%-10s : %s", "gender", mahasiswa.gender));
					System.out.println(String.format("%-10s : %s", "hobi", String.join(", ", mahasiswa.hobi)));
					System.out.println(String.format("%-10s : %s", "ipk", mahasiswa.ipk));

					Util.__("Ubah data sekarang");
					App.mahasiswa[index] = new Controller().__form();

					if (Util.continue_prompt() == 'n') {
						break;
					}
				} else {
					break;
				}
			}
		}
	}

	/**
	 * Method untuk menampilkan fitur "sort" atau pengurutan data sesuai dengan
	 * algoritma yang dipilih
	 */
	public static void action_sort() {
		if (App.mahasiswa.length == 0) {
			System.out.println("\n[!] There is no data to sort");
		} else {
			Util.__("Urutkan Data");
			Util.__e(Env.sort_menu, true);
			int menu_option = Form.input("pilih").to_int();
			switch (menu_option) {
				case 1:
					App.mahasiswa = Record.bubble_sort(App.mahasiswa);
					break;
				case 2:
					break;
			}
		}
	}

	/**
	 * Method untuk menampilkan fitur "search" atau mencari data berdasarkan keyword
	 */
	public static void action_search() {
		int menu_option = 0;
		Mahasiswa[] result = null;
		String keyword = null;

		while (true) {
			Util.__("Cari Data");
			Util.__e(Env.search_menu, true);
			menu_option = Form.input("pilih").to_int();
			if (menu_option == 0)
				break;

			switch (menu_option) {
				case 1:
					keyword = Form.input("keyword").to_string();
					result = Record.linear_search(App.mahasiswa, keyword);
					break;
				case 2:
					keyword = Form.input("keyword").to_string();
					result = Record.binary_search(Record.bubble_sort(App.mahasiswa), keyword);
					break;
			}

			if (menu_option != -1) {
				if (result != null) {
					Util.__(String.format("\n[*] Search completed (%d records found)", result.length));
					Record.show(result);
				} else {
					System.out.println("[!] There is no data to display");
				}

				if (Util.continue_prompt() == 'n') {
					break;
				}
			} else {
				break;
			}
		}
	}

	public static void action_swap() {
		int from_index = 0;
		int to_index = 0;
		while (true) {
			Util.__("Tukar Data");

			// Get "source index"
			while (true) {
				System.out.println("[*] Ketik -1 untuk kembali");
				from_index = Form.input("index source").to_int();
				if (from_index == -1)
					break;
				if (from_index > App.mahasiswa.length - 1 || from_index < 0) {
					System.out.println("[!] \"index source\" must be between 0 - " + (App.mahasiswa.length - 1));
				} else {
					break;
				}
			}

			if (from_index != -1) {
				// Get "target index"
				while (true) {
					to_index = Form.input("index target").to_int();
					if (to_index > App.mahasiswa.length - 1 || to_index < 0) {
						System.out.println("[!] \"index target\" must be between 0 - " + (App.mahasiswa.length - 1));
					} else if (to_index == from_index) {
						System.out.println("[!] source and target index cannot be the same");
					} else {
						break;
					}
				}

				App.mahasiswa = Record.swap(App.mahasiswa, from_index, to_index);

				if (Util.continue_prompt() == 'n') {
					break;
				}
			} else {
				break;
			}
		}
	}
}

class Util {
	public static void __(String text) {
		System.out.println(String.format("\n%s\n%s", text, "-".repeat(text.length())));
	}

	public static void __e(String[] list, boolean show_back_menu) {
		String format = "[%d]  %s";
		for (int i = 0; i < list.length; i++)
			System.out.println(String.format(format, (i + 1), list[i]));
		if (show_back_menu)
			System.out.println(String.format(format, 0, "Kembali"));
	}

	public static char continue_prompt() {
		char p = Form.input("lagi?").to_only_string().charAt(0);
		return p;
	}
}

class Env {
	public static String[] menu = { "Insert", "View", "Edit", "Delete", "Sort", "Swap", "Search", "Exit" };
	public static String[] insert_delete_menu = { "Depan", "Tengah", "Belakang" };
	public static String[] search_menu = { "Linear Search", "Binary Search" };
	public static String[] sort_menu = { "Bubble Sort", "Selection Sort" };
}

public class App {
	public static Mahasiswa[] mahasiswa = {
			new Mahasiswa().set("Fahmi Syahrul Yahya", "Jepara", 23, 'l', new String[] { "Makan", "Tidur", "Ngoding" },
					2.32F),
			new Mahasiswa().set("Fahmi Himawan", "Jepara", 23, 'l', new String[] { "Makan", "Tidur", "Ngoding" },
					2.32F),
			new Mahasiswa().set("Siska", "Jakarta", 25, 'p', new String[] { "Makan", "Tidur", "Ngoding" }, 3.4F),
			new Mahasiswa().set("Rudi", "Semarang", 20, 'l', new String[] { "Makan", "Tidur", "Ngoding" }, 4.00F)
	};
	public static int menu_option = 0;
	public static char is_continue = 'y';

	public static void main(String[] args) {
		while (true) {
			Util.__("Database Mahasiswa");
			Util.__e(Env.menu, false);
			menu_option = Form.input("pilih").to_int();

			switch (menu_option) {
				case 1:
					Controller.action_insert();
					break;
				case 2:
					Controller.action_view();
					break;
				case 3:
					Controller.action_edit();
					break;
				case 4:
					Controller.action_delete();
					break;
				case 5:
					Controller.action_sort();
					break;
				case 6:
					Controller.action_swap();
					break;
				case 7:
					Controller.action_search();
					break;
				case 8:
					System.out.println("\n[*] Anda telah keluar dari aplikasi");
					System.exit(0);
					break;
			}
		}
	}
}