import model.Mahasiswa;

public class App {
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
		Mahasiswa mahasiswa = new Mahasiswa();
		mahasiswaStore.patch(mahasiswa.initData());

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
