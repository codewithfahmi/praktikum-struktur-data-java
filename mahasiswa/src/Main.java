import controller.MahasiswaController;

public class Main {
    public static void main(String[] args) {
        MahasiswaController mahasiswaController = new MahasiswaController();
        while(true) {
            switch (mahasiswaController.init()) {
                case 1 -> mahasiswaController.insert();
                case 2 -> mahasiswaController.view();
                case 3 -> mahasiswaController.delete();
                case 4 -> mahasiswaController.update();
                case 5 -> mahasiswaController.sort();
                case 6 -> mahasiswaController.swap();
                case 7 -> mahasiswaController.search();
                case 8 -> System.exit(0);
            }
        }
    }
}