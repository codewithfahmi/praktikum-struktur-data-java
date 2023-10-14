import java.util.Scanner;

import model.Mahasiswa;

public class App {
	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		App main = new App();

		var app = new controller.App();
		var input = new controller.Input();
		var view = new controller.View();
		var update = new controller.Update();
		var delete = new controller.Delete();
		var swap = new controller.Swap();
		var search = new controller.Search();
		var sort = new controller.Sort();

		var mahasiswaStore = new store.MahasiswaStore();

		Mahasiswa[] mahasiswa = {
				new Mahasiswa().set("John", "New Jersey", 22, 'l', new String[] { "makan", "ngoding", "tidur" }, 2.24f),
				new Mahasiswa().set("Stefanie", "Colorado", 23, 'p', new String[] { "nyanyi", "masak", "makan" }, 3.4f),
				new Mahasiswa().set("George", "Georgia", 28, 'l', new String[] { "hiking", "joging", "menari" }, 4f)
		};

		mahasiswaStore.patch(mahasiswa);

		while (true) {
			int appOption = app.menus();

			if (appOption <= 0)
				break;

			switch (appOption) {
				case 1 -> input.run(mahasiswaStore);
				case 2 -> view.run(mahasiswaStore.subscribe());
				case 3 -> update.run(mahasiswaStore);
				case 4 -> delete.run(mahasiswaStore);
				case 5 -> swap.run(mahasiswaStore);
				case 6 -> search.run(mahasiswaStore);
			}
		}
	}
}
