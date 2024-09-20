import java.util.Scanner;

class FormatBiodata {
  String nama;
  String alamat;
  int umur;
  char jenisKelamin;
  String hobi[] = new String[3];
  float ipk;

  public String getNama() {
    return nama;
  }

  public String getAlamat() {
    return alamat;
  }

  public int getUmur() {
    return umur;
  }

  public String[] getHobi() {
    return hobi;
  }

  public char getJenisKelamin() {
    return jenisKelamin;
  }

  public float getIpk() {
    return ipk;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public void setHobi(String[] hobi) {
    this.hobi = hobi;
  }

  public void setUmur(int umur) {
    this.umur = umur;
  }

  public void setJenisKelamin(char jenisKelamin) {
    this.jenisKelamin = jenisKelamin;
  }

  public void setIpk(float ipk) {
    this.ipk = ipk;
  }
}

public class StrukturRekamanData {
  public static void main(String[] args) {
    FormatBiodata biodata = new FormatBiodata();
    Scanner scanner = new Scanner(System.in);

    System.out.print("nama : ");
    biodata.setNama(scanner.nextLine());

    System.out.print("alamat : ");
    biodata.setAlamat(scanner.nextLine());

    System.out.print("umur : ");
    biodata.setUmur(scanner.nextInt());

    System.out.print("jenis kelamin : ");
    biodata.setJenisKelamin(scanner.next().charAt(0));
    scanner.nextLine();

    System.out.println("hobi : ");
    String tempHobi[] = new String[biodata.getHobi().length];
    for (int i = 0; i < biodata.getHobi().length; i++) {
      System.out.print("hobi - " + (i + 1) + " : ");
      tempHobi[i] = scanner.nextLine();
    }
    biodata.setHobi(tempHobi);

    System.out.print("ipk : ");
    biodata.setIpk(scanner.nextFloat());

    System.out.println("nama    : " + biodata.getNama());
    System.out.println("alamat  : " + biodata.getAlamat());
    System.out.println("umur    : " + biodata.getUmur());
    System.out.println(
        "jenis kelamin : " + (Character.toLowerCase(biodata.getJenisKelamin()) == 'l' ? "Laki - Laki" : "Perempuan"));
    System.out.println("hobi    : ");
    for (int i = 0; i < biodata.getHobi().length; i++)
      System.out.println("hobi - " + (i + 1) + " : " + biodata.getHobi()[i]);
    System.out.println("ipk    : " + biodata.getIpk());

    scanner.close();
  }
}
