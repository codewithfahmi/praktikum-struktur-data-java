package javaPointer;

class tipePointer {
	int angka;
	String teks;
}

public class App {
	public static void main(String[] args) throws Exception {
		App app = new App();
		app.praktek1_1();
		app.praktek1_2();
		app.praktek2_1();
		app.praktek2_2();
		app.praktek2_3();
		app.praktek3_1();
		app.praktek3_2();
		app.praktek3_3();
	}
	
	public void praktek1_1 () {
		tipePointer P;
		P = null;
		System.out.println("Nilai P adalah = " + P);
	}
	
	@SuppressWarnings("unused")
	public void praktek1_2 () {
		tipePointer P;
		P = null;
		if (P == null) {
			System.out.println("Pointer P menunjuk ke Null");
		} else {
			System.out.println("Pointer P mengarah ke tempat lain");
		}
	}
	
	public void praktek2_1 () {
		tipePointer P = new tipePointer();
		P.angka = 100;
		P.teks = "Halo";
		
		tipePointer Q = new tipePointer();
		Q.angka = 200;
		Q.teks = "Akakom";
		
		System.out.println("Nilai elemen P dan Q adalah : ");
		System.out.println("------------------------------");
		System.out.println("Nilai P.angka adalah = " + P.angka);
		System.out.println("Nilai P.teks adalah  = " + P.teks);
		System.out.println("Nilai Q.angka adalah = " + Q.angka);
		System.out.println("Nilai Q.teks adalah  = " + Q.teks);
	}
	
	public void praktek2_2 () {
		tipePointer P = new tipePointer();
		P.angka = 100;
		P.teks = "Halo";
		
		tipePointer Q = new tipePointer();
		Q.angka = 200;
		Q.teks = "Akakom";
		
		System.out.println("Nilai elemen P dan Q adalah : ");
		System.out.println("------------------------------");
		System.out.println("Nilai P.angka adalah = " + P.angka);
		System.out.println("Nilai P.teks adalah  = " + P.teks);
		System.out.println("Nilai Q.angka adalah = " + Q.angka);
		System.out.println("Nilai Q.teks adalah  = " + Q.teks);
		
		tipePointer R = P;
		System.out.println("Nilai elemen R adalah : ");
		System.out.println("------------------------");
		System.out.println("Nilai R.angka adalah = " + R.angka);
		System.out.println("Nilai R.teks adalah  = " + R.teks);
		
		R = Q;
		System.out.println("Nilai elemen R saat ini adalah : ");
		System.out.println("---------------------------------");
		System.out.println("Nilai R.angka adalah = " + R.angka);
		System.out.println("Nilai R.teks adalah  = " + R.teks);
	}
	
	public void praktek2_3 () {
		tipePointer P = new tipePointer();
		P.angka = 100;
		P.teks = "Halo";
		
		tipePointer Q = new tipePointer();
		Q.angka = 200;
		Q.teks = "Akakom";
		
		System.out.println("Nilai elemen P dan Q sebelum pointer dimanipulasi : ");
		System.out.println("----------------------------------------------------");
		System.out.println("Nilai P.angka adalah = " + P.angka);
		System.out.println("Nilai P.teks adalah  = " + P.teks);
		System.out.println("Nilai Q.angka adalah = " + Q.angka);
		System.out.println("Nilai Q.teks adalah  = " + Q.teks);
		
		tipePointer R;
		R = P;
		P = Q;
		Q = R;
		
		System.out.println("Nilai elemen P dan Q setelah pointer dimanipulasi : ");
		System.out.println("----------------------------------------------------");
		System.out.println("Nilai P.angka adalah = " + P.angka);
		System.out.println("Nilai P.teks adalah  = " + P.teks);
		System.out.println("Nilai Q.angka adalah = " + Q.angka);
		System.out.println("Nilai Q.teks adalah  = " + Q.teks);
	}
	
	static class TipePointer {
		String namaKota;
		TipePointer kiri;
		TipePointer kanan;
	}
	
	public void praktek3_1 () {
		TipePointer P = new TipePointer();
		P.namaKota = "Yogyakarta";
		
		TipePointer Q = new TipePointer();
		Q.namaKota = "Klaten";
		
		TipePointer R = new TipePointer();
		R.namaKota = "Solo";
		
		TipePointer S = new TipePointer();
		S.namaKota = "Sragen";
		
		TipePointer T = new TipePointer();
		T.namaKota = "Ngawi";
		
		P.kanan = Q;
		Q.kanan = R;
		R.kanan = S;
		S.kanan = T;
		T.kanan = null;
		
		System.out.println("Nilai - nilai yang dapat diakses dari pointer P adalah");
		System.out.println("------------------------------------------------------");
		System.out.println(P.namaKota);
		System.out.println(P.kanan.namaKota);
		System.out.println(P.kanan.kanan.namaKota);
		System.out.println(P.kanan.kanan.kanan.namaKota);
		System.out.println(P.kanan.kanan.kanan.kanan.namaKota);
		
		System.out.println("Nilai P.namaKota adalah = " + P.namaKota);
		System.out.println("Nilai Q.namaKota adalah = " + Q.namaKota);
		System.out.println("Nilai R.namaKota adalah = " + R.namaKota);
		System.out.println("Nilai S.namaKota adalah = " + S.namaKota);
		System.out.println("Nilai T.namaKota adalah = " + T.namaKota);

		System.out.println(R.namaKota);
		P.kanan.kanan.namaKota = "Surakarta";
		System.out.println(R.namaKota);
	}
	
	public void praktek3_2 () {
		TipePointer P = new TipePointer();
		P.namaKota = "Yogyakarta";
		
		TipePointer Q = new TipePointer();
		Q.namaKota = "Klaten";
		
		TipePointer R = new TipePointer();
		R.namaKota = "Solo";
		
		TipePointer S = new TipePointer();
		S.namaKota = "Sragen";
		
		TipePointer T = new TipePointer();
		T.namaKota = "Ngawi";
		
		P.kanan = Q;
		Q.kanan = R;
		R.kanan = S;
		S.kanan = T;
		T.kanan = null;
		
		System.out.println("Elemen namaKota unutk pointer P, Q, R, S, T adalah : ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Nilai P.namaKota adalah = " + P.namaKota);
		System.out.println("Nilai Q.namaKota adalah = " + Q.namaKota);
		System.out.println("Nilai R.namaKota adalah = " + R.namaKota);
		System.out.println("Nilai S.namaKota adalah = " + S.namaKota);
		System.out.println("Nilai T.namaKota adalah = " + T.namaKota);
		
		System.out.println("Elemen namaKota unutk pointer P, Q, R, S, T adalah : ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Nilai P.namaKota adalah = " + P.namaKota);
		System.out.println("Nilai Q.namaKota adalah = " + P.kanan.namaKota);
		System.out.println("Nilai R.namaKota adalah = " + P.kanan.kanan.namaKota);
		System.out.println("Nilai S.namaKota adalah = " + P.kanan.kanan.kanan.namaKota);
		System.out.println("Nilai T.namaKota adalah = " + P.kanan.kanan.kanan.kanan.namaKota);

		TipePointer BANTU;
		BANTU = P;
		while (BANTU != null) {
			System.out.println("Nilai BANTU.namaKota adalah = " + BANTU.namaKota);
			BANTU = BANTU.kanan;
		}
	}
	
	public void praktek3_3 () {
		TipePointer P = new TipePointer();
		P.namaKota = "Yogyakarta";
		
		TipePointer Q = new TipePointer();
		Q.namaKota = "Klaten";
		
		TipePointer R = new TipePointer();
		R.namaKota = "Solo";
		
		TipePointer S = new TipePointer();
		S.namaKota = "Sragen";
		
		TipePointer T = new TipePointer();
		T.namaKota = "Ngawi";
		
		System.out.println("Elemen namaKota unutk pointer P, Q, R, S, T adalah : ");
		System.out.println("-----------------------------------------------------");
		System.out.println("Nilai P.namaKota adalah = " + P.namaKota);
		System.out.println("Nilai Q.namaKota adalah = " + Q.namaKota);
		System.out.println("Nilai R.namaKota adalah = " + R.namaKota);
		System.out.println("Nilai S.namaKota adalah = " + S.namaKota);
		System.out.println("Nilai T.namaKota adalah = " + T.namaKota);
		
		P.kanan = Q;
		Q.kanan = R;
		R.kanan = S;
		S.kanan = T;
		T.kanan = null;
		
		P.kiri = null;
		Q.kiri = P;
		R.kiri = Q;
		S.kiri = R;
		T.kiri = S;
		
		System.out.println("Elemen namaKota untuk elemen P adalah : ");
		System.out.println("----------------------------------------");
		System.out.println(P.namaKota);
		System.out.println(P.kanan.kiri.namaKota);
		System.out.println(P.kanan.kanan.kiri.kiri.namaKota);
		
		TipePointer BANTU;
		BANTU = T;
		while (BANTU != null) {
			System.out.println("Nilai BANTU.namaKota adalah : " + BANTU.namaKota);
			BANTU = BANTU.kiri;
		}
	}
}
