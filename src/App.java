import java.util.Scanner;

import model.Mahasiswa;

public class App {
	private final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		App main = new App();

		controller.App app = new controller.App();
		controller.Input input = new controller.Input();
		controller.View view = new controller.View();
		controller.Update update = new controller.Update();
		controller.Delete delete = new controller.Delete();
		controller.Swap swap = new controller.Swap();
		controller.Search search = new controller.Search();
		controller.Sort sort = new controller.Sort();

		store.MahasiswaStore mahasiswaStore = new store.MahasiswaStore();

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
				case 1 -> {
					int inputOption = input.menus();
					boolean continued = true;
					while (continued) {
						switch (inputOption) {
							case 1 -> input.unshiftView(mahasiswaStore);
							case 2 -> input.insertView(mahasiswaStore);
							case 3 -> input.pushView(mahasiswaStore);
						}

						if (inputOption > 0) {
							System.out.print("continue?");
							continued = main.scanner.next().toLowerCase().charAt(0) == 'y';
						}
					}
				}
				case 2 -> view.view(mahasiswaStore.subscribe());
				case 3 -> mahasiswaStore.patch(update.update(mahasiswaStore.subscribe()));
				case 4 -> {
					if (mahasiswaStore.subscribe().length == 0) {
						System.out.println("\nDelete inoperable, master record is empty");
					} else {
						int deleteOption = delete.menus();
						boolean continued = true;
						while (continued) {
							switch (deleteOption) {
								case 1 -> mahasiswaStore.patch(delete.shift(mahasiswaStore.subscribe()));
								case 2 -> {
									System.out.printf("%-10s : ", "Index");
									int index = main.scanner.nextInt();
									mahasiswaStore.patch(delete.remove(mahasiswaStore.subscribe(), index));
								}
								case 3 -> mahasiswaStore.patch(delete.pop(mahasiswaStore.subscribe()));
							}
							if (deleteOption > 0) {
								System.out.print("continue?");
								continued = main.scanner.next().toLowerCase().charAt(0) == 'y';
							} else {
									continued = false;
							}
						}
					}
				}
				case 5 -> {
					System.out.println("\nPindahkan data");
					System.out.print("index dari data yang akan dipindahkan : ");
					int from = main.scanner.nextInt();
					System.out.print("lokasi index untuk data yang dipindahkan : ");
					int to = main.scanner.nextInt();
					mahasiswaStore.patch(swap.swap(mahasiswaStore.subscribe(), from, to));
				}
				case 6 -> {

				}
			}
		}
	}
}
