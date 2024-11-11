import core.algorithm.*;
import model.Mahasiswa;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("test!");
		SingleLinkedList<Mahasiswa> mahasiswaList = new SingleLinkedList<>();
		// Praktik - 1
		mahasiswaList.addFirst(new Mahasiswa("Agung BP", "Jakarta", 23, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 2.3F));
		mahasiswaList.addFirst(new Mahasiswa("Rulieta", "Kuala Kapuas", 19, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 3.3F));
		mahasiswaList.addFirst(new Mahasiswa("Karti", "Palembang", 26, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 1.9F));
		mahasiswaList.addFirst(new Mahasiswa("Handono", "Bekasi", 20, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 4F));
		mahasiswaList.add(new Mahasiswa("Anton", "Bogor", 25, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 3.5F), 1);
		mahasiswaList.addLast(new Mahasiswa("Hermon", "Banjarmasin", 31, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 1F));
		mahasiswaList.addLast(new Mahasiswa("Anis", "Surakarta", 17, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 1.2F));
		mahasiswaList.addLast(new Mahasiswa("Yanti", "Purwokerto", 19, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 1.5F));
		mahasiswaList.addLast(new Mahasiswa("Hermon", "Banjarmasin", 31, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 1F));
		
		mahasiswaList.display();

		// Pratik - 2
		// mahasiswaList.addFirst(new Mahasiswa("Satrio", "Yogyakarta", 19, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 1.3F));
		// mahasiswaList.addLast(new Mahasiswa("Anis", "Surakarta", 17, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 1.2F));
		// mahasiswaList.addLast(new Mahasiswa("Yanti", "Purwokerto", 19, 'P', new String[] {"Makan", "Tidur", "Ngoding"}, 1.5F));
		// mahasiswaList.addLast(new Mahasiswa("Satrio", "Yogyakarta", 19, 'L', new String[] {"Makan", "Tidur", "Ngoding"}, 1.3F));
		// mahasiswaList.display();
	}
}
