package controller;

import model.MahasiswaModel;
import util.Env;
import util.Util;

import java.lang.reflect.Field;

public class RecordController {

  public static class SearchResult {
    public int[] indexes;
    public MahasiswaModel[] results;
  }

  public static class DeleteResult {
    public int index;
    public MahasiswaModel[] results;
  }

  private MahasiswaModel[] record;

  public RecordController() {
    this.record = new MahasiswaModel[] {
            new MahasiswaModel().set("agungbp", "jakarta",      28, 'l', new String[] { "musik",   "mancing", "touring" }, 3.5F),
            new MahasiswaModel().set("rulieta", "kualakapuas",  17, 'p', new String[] { "nari",    "rajut",   "jahit"   }, 3.0F),
            new MahasiswaModel().set("karti",   "palangkaraya", 18, 'p', new String[] { "renang",  "fban",    "masak"   }, 2.5F),
            new MahasiswaModel().set("hermon",  "banjarmasin",  25, 'l', new String[] { "kasti",   "bola",    "mancing" }, 3.4F),
            new MahasiswaModel().set("anis",    "surakarta",    30, 'p', new String[] { "jualan",  "drama",   "nonton"  }, 0.3F),
            new MahasiswaModel().set("yanti",   "purwokerto",   21, 'p', new String[] { "lukis",   "musik",   "selfi"   }, 2.0F),
            new MahasiswaModel().set("handono", "bekasi",       29, 'l', new String[] { "touring", "musik",   "hiking"  }, 3.1F),
            new MahasiswaModel().set("anton",   "jakarta",      17, 'l', new String[] { "dangdut", "jajan",   "turing"  }, 2.0F),
            new MahasiswaModel().set("mantri",  "magelang",     45, 'l', new String[] { "hiphop",  "wayang",  "game"    }, 3.1F),
            new MahasiswaModel().set("satrio",  "yogyakarta",   30, 'l', new String[] { "musik",   "drama",   "karate"  }, 3.3F)
    };
  }

  /**
   * Method untuk memperbarui nilai rekaman data utama
   *
   * @param record Rekaman data utama
   */
  public void refresh(MahasiswaModel[] record) {
    this.record = record;
  }

  /**
   * Method untuk menambahkan data pada bagian awal rekaman data utama
   *
   * @param record Rekaman data utama
   * @param data Data untuk ditambahkan
   * @return Rekaman data utama
   */
  public MahasiswaModel[] prepend(MahasiswaModel[] record, MahasiswaModel data) {
    long start_time         = System.nanoTime();
    int record_length       = record.length;
    MahasiswaModel[] result = new MahasiswaModel[record_length + 1];
    if(record_length > 0) System.arraycopy(record, 0, result, 1, record_length);
    result[0]               = data;
    long end_time           = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk menambahkan data ke rekaman data utama sesuai dengan index yang ditentukan
   *
   * @param record Rekaman data utama
   * @param position Posisi index untuk data baru
   * @param data Data untuk ditambahkan
   * @return Rekaman data utama
   */
  public MahasiswaModel[] insert(MahasiswaModel[] record, int position, MahasiswaModel data) {
    long start_time         = System.nanoTime();
    int record_length       = record.length;
    MahasiswaModel[] result = new MahasiswaModel[record_length + 1];

    if(position == 0) { result = this.prepend(record, data); }
    else if (position == record_length) { result = this.append(record, data); }
    else { for (int i = 0;i < result.length;i++) result[i] = i == position ? data : record[i < position ? i : i - 1]; }

    long end_time = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk menambahkan data pada bagian akhir rekaman data utama
   *
   * @param record Rekaman data utama
   * @param data Data untuk ditambahkan
   * @return Rekaman data utama
   */
  public MahasiswaModel[] append(MahasiswaModel[] record, MahasiswaModel data) {
    long start_time         = System.nanoTime();
    int record_length       = record.length;
    MahasiswaModel[] result = new MahasiswaModel[record_length + 1];
    if(record_length > 0) System.arraycopy(record, 0, result, 0, record_length);
    result[record_length]   = data;
    long end_time = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk menghapus data pada bagian awal rekaman data utama
   *
   * @param record Rekaman data utama
   * @return Rekaman data utama
   */
  public DeleteResult shift(MahasiswaModel[] record) {
    long start_time         = System.nanoTime();
    int record_length       = record.length - 1;
    MahasiswaModel[] temp   = new MahasiswaModel[record_length];
    System.arraycopy(record, 1, temp, 0, record_length);
    long end_time           = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    DeleteResult result = new DeleteResult();
    result.index        = 0;
    result.results      = temp;
    return result;
  }

  /**
   * Method untuk menghapus data dari rekaman data utama sesuai dengan index yang ditentukan
   * @param record Rekaman data utama
   * @param position Posisi index data
   * @return Rekaman data utama
   */
  public DeleteResult delete(MahasiswaModel[] record, int position) {
    int record_length       = record.length - 1;
    MahasiswaModel[] temp   = new MahasiswaModel[record_length];

    if (position == 0) { temp = this.shift(record).results; }
    else if (position == record_length) { temp = this.pop(record).results; }
    else {
      long start_time = System.nanoTime();
      for (int i = 0, j = 0;i < record.length;i++) if (i != position) temp[j++] = record[i];
      long end_time = System.nanoTime();
      Util.operation_time(this.getClass().getSimpleName(),
                          new Object(){}.getClass().getEnclosingMethod().getName(),
                          start_time,
                          end_time);
    }
    DeleteResult result = new DeleteResult();
    result.index        = position;
    result.results      = temp;
    return result;
  }

  /**
   * Method untuk menghapus data pada bagian akhir rekaman data utama
   *
   * @param record Rekaman data utama
   * @return Rekaman data utama
   */
  public DeleteResult pop(MahasiswaModel[] record) {
    long start_time         = System.nanoTime();
    int record_length       = record.length - 1;
    MahasiswaModel[] temp   = new MahasiswaModel[record_length];
    System.arraycopy(record, 0, temp, 0, record_length);
    long end_time           = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    DeleteResult result = new DeleteResult();
    result.index        = record_length;
    result.results      = temp;
    return result;
  }

  /**
   * Method untuk merubah data sesuai dengan index yang ditentukan
   *
   * @param position Index data yang ingin diubah
   * @param data Data baru untuk data yang sudah terimpan sebelumnya
   * @return Rekaman data utama
   */
  public MahasiswaModel[] update(int position, MahasiswaModel data) {
    long start_time         = System.nanoTime();
    MahasiswaModel[] result = this.all();
    result[position]        = data;
    long end_time           = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk menukar posisi data sesuai dengan index source dan destination
   *
   * @param source Index sumber
   * @param destination Index untuk menempatkan data dari index sumber
   * @return Rekaman data utama
   */
  public MahasiswaModel[] swap(int source, int destination) {
    long start_time         = System.nanoTime();
    MahasiswaModel[] result = this.all();
    MahasiswaModel temp     = result[source];
    result[source]          = result[destination];
    result[destination]     = temp;
    long end_time           = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  @SuppressWarnings("unchecked")
  private <T> T value_from_model_prop(String prop, MahasiswaModel mahasiswa) {
    T result = null;

    try {
      Field field = mahasiswa.getClass().getDeclaredField(prop);
      field.setAccessible(true);
      result = (T) field.get(mahasiswa);
    } catch (NoSuchFieldException e) {
      System.out.printf("*) Field %s not found", prop);
    } catch (IllegalAccessException e) {
      System.out.printf("*) Access denied for accessing property %s", prop);
    } catch (ClassCastException e) {
      System.out.printf("*) Casting failed for property %s", prop);
    }

    return result;
  }

  /**
   * Method untuk mencari data menggunakan algoritma linear-search
   *
   * @param record Rekaman data utama
   * @param prop Properti pada kelas model
   * @param keyword Data yang ingin dicari
   * @return Rekaman data utama
   * @param <T> String, Integer, Float, Character
   */
  @SuppressWarnings("unchecked")
  public <T> SearchResult linear_search(MahasiswaModel[] record, String prop, T keyword) {
    long start_time = System.nanoTime();
    SearchResult result        = new SearchResult();
    MahasiswaModel[] temp      = new MahasiswaModel[0];
    StringBuilder indexes_temp = new StringBuilder();

    for (int i = 0;i < record.length;i++) {
      T val = null;
      boolean is_match = false;

      if (prop.equals("hobbies")) {
        val = (T) String.join(",", (String[]) this.value_from_model_prop(prop, record[i]));
      } else {
        val = this.value_from_model_prop(prop, record[i]);
      }

      if (val instanceof String) {
        is_match = ((String) val).toLowerCase().contains(keyword.toString().toLowerCase());
      } else if (val instanceof Integer) {
        is_match = Integer.parseInt(val.toString()) == Integer.parseInt(keyword.toString());
      } else if (val instanceof Float) {
        is_match = Float.parseFloat(val.toString()) == Float.parseFloat(keyword.toString());
      } else if (val instanceof Character) {
        is_match = val.toString().toLowerCase().contains(keyword.toString().toLowerCase());
      }


      if (is_match) {
        temp = this.append(temp, record[i]);
        indexes_temp.append(i);
        if (i < record.length - 1) indexes_temp.append(" ");
      }
    }

    if (temp.length > 0) {
      String[] indexes_temp_split = indexes_temp.toString().split(" ");
      int[] indexes = new int[indexes_temp_split.length];

      for (int i = 0; i < indexes_temp_split.length; i++)
        indexes[i] = Integer.parseInt(indexes_temp_split[i]);

      result.indexes = indexes;
      result.results = temp;
    }

    long end_time = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk mencari data menggunakan algoritma binary-search
   *
   * @param record Rekaman data utama
   * @param prop Properti pada kelas model
   * @param keyword Data yang ingin dicari
   * @return Rekaman data utama
   * @param <T> String, Integer, Float, Character
   */
  @SuppressWarnings("unchecked")
  public <T> MahasiswaModel[] binary_search(MahasiswaModel[] record, String prop, T keyword) {
    long start_time = System.nanoTime();
    MahasiswaModel[] result = new MahasiswaModel[0];
    int low = 0;
    int high = record.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      T val = null;
      int comparison = 0;

      if (prop.equals("hobbies")) {
        val = (T) String.join(",", (String[]) this.value_from_model_prop(prop, record[mid]));
      } else { val = this.value_from_model_prop(prop, record[mid]); }

      comparison = val.toString().toLowerCase().compareTo(keyword.toString().toLowerCase());

      if(comparison == 0) {
        result = this.append(result, record[mid]);

        int temp = mid;
        while (--temp >= 0) {
          T left = this.value_from_model_prop(prop, record[temp]);
          if (left != null && left.toString().toLowerCase().compareTo(keyword.toString().toLowerCase()) == 0) {
            result = this.append(result, record[temp]);
          } else { break; }
        }

        temp = mid;
        while (++temp < record.length) {
          T right = this.value_from_model_prop(prop, record[temp]);
          if (right != null && right.toString().toLowerCase().compareTo(keyword.toString().toLowerCase()) == 0) {
            result = this.append(result, record[temp]);
          } else { break; }
        }

        break;
      }

      if (comparison < 0) { low = mid + 1; } else { high = mid - 1; }
    }

    long end_time = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    return result;
  }

  /**
   * Method untuk mengurutkan data menggunakan algoritma "bubble sort"
   *
   * @param record Rekaman data utama
   * @param prop Property pada kelas model dan kategori pengurutan data
   * @return Rekaman data utama
   * @param <T> String, Float, Integer, Character
   */
  @SuppressWarnings("unchecked")
  public <T> MahasiswaModel[] bubble_sort(MahasiswaModel[] record, String prop) {
    long start_time = System.nanoTime();
    int record_length = record.length - 1;
    for (int i = 0; i <= record_length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j <= record_length - 1 - i; j++) {
        T current, next = null;
        int comparison  = 0;

        if (prop.equals("hobbies")) {
          current = (T) String.join(", ", (String[]) this.value_from_model_prop(prop, record[j]));
          next = (T) String.join(", ", (String[]) this.value_from_model_prop(prop, record[j + 1]));
        } else {
          current = this.value_from_model_prop(prop, record[j]);
          next = this.value_from_model_prop(prop, record[j + 1]);
        }

        if (current instanceof String           && next instanceof String) {
          comparison = current.toString().compareTo(next.toString());
        } else if (current instanceof Float     && next instanceof Float) {
          comparison = ((Float) current).compareTo((Float) next);
        } else if (current instanceof Character && next instanceof Character) {
          comparison = ((Character) current).compareTo((Character) next);
        } else if (current instanceof Integer   && next instanceof Integer) {
          comparison = ((Integer) current).compareTo((Integer) next);
        }

        if (comparison > 0) {
          MahasiswaModel cell = record[j];
          record[j] = record[j + 1];
          record[j + 1] = cell;
          swapped = true;
        }
      }

      if (!swapped) break;
    }
    long end_time = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    this.show(record);
    return record;
  }

  /**
   * Method untuk mengurutkan data menggunakan algoritma "selection sort"
   *
   * @param record Rekaman data utama
   * @param prop Property pada kelas model dan kategori pengurutan data
   * @return Rekaman data utama
   * @param <T> String, Float, Integer, Character
   */
  @SuppressWarnings("unchecked")
  public <T> MahasiswaModel[] selection_sort(MahasiswaModel[] record, String prop) {
    long start_time   = System.nanoTime();
    int record_length = record.length;
    for (int i = 0;i < record_length - 1;i++) {
      int min_index = i;
      for (int j = i + 1;j < record_length;j++) {
        T current, next = null;
        int comparison  = 0;

        if (prop.equals("hobbies")) {
          current = (T) String.join(", ", (String[]) value_from_model_prop(prop, record[j]));
          next = (T) String.join(", ", (String[]) value_from_model_prop(prop, record[min_index]));
        } else {
          current = value_from_model_prop(prop, record[j]);
          next = value_from_model_prop(prop, record[min_index]);
        }

        if (current instanceof String           && next instanceof String) {
          comparison = current.toString().compareTo(next.toString());
        } else if (current instanceof Float     && next instanceof Float) {
          comparison = ((Float) current).compareTo((Float) next);
        } else if (current instanceof Character && next instanceof Character) {
          comparison = ((Character) current).compareTo((Character) next);
        } else if (current instanceof Integer   && next instanceof Integer) {
          comparison = ((Integer) current).compareTo((Integer) next);
        }

        if (comparison < 0) {
          min_index = j;
        }

        MahasiswaModel cell = record[min_index];
        record[min_index] = record[i];
        record[i] = cell;
      }
    }
    long end_time     = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    this.show(record);
    return record;
  }

  @SuppressWarnings("unchecked")
  public <T> MahasiswaModel[] insertion_sort(MahasiswaModel[] record, String prop) {
    long start_time   = System.nanoTime();
    int record_length = record.length;
    for (int i = 1;i < record_length;i++) {
      int j = i - 1;
      T key;

      if (prop.equals("hobbies")) {
        key = (T) String.join(", ", (String[]) value_from_model_prop(prop, record[i]));
      } else {
        key = value_from_model_prop(prop, record[i]);
      }

      MahasiswaModel tmp = record[i];

      while (j >= 0) {
        T current;

        if (prop.equals("hobbies")) {
          current = (T) String.join(", ", (String[]) value_from_model_prop(prop, record[j]));
        } else {
          current = value_from_model_prop(prop, record[j]);
        }

        int comparison = 0;

        if (current instanceof String           && key instanceof String) {
          comparison = current.toString().compareTo(key.toString());
        } else if (current instanceof Float     && key instanceof Float) {
          comparison = ((Float) current).compareTo((Float) key);
        } else if (current instanceof Character && key instanceof Character) {
          comparison = ((Character) current).compareTo((Character) key);
        } else if (current instanceof Integer   && key instanceof Integer) {
          comparison = ((Integer) current).compareTo((Integer) key);
        }

        if (comparison > 0) {
          record[j + 1] = record[j];
          j--;
        } else {
          break;
        }
      }

      record[j + 1] = tmp;
    }
    long end_time     = System.nanoTime();
    Util.operation_time(this.getClass().getSimpleName(),
                        new Object(){}.getClass().getEnclosingMethod().getName(),
                        start_time,
                        end_time);
    this.show(record);
    return record;
  }


  /**
   * Method untuk menampilkan data rekaman utama dengan format table
   *
   * @param record Rekaman data utama
   */
  public void show(MahasiswaModel[] record) {
    long start_time                 = System.nanoTime();
    StringBuilder table_result      = new StringBuilder();
    StringBuilder table_header      = new StringBuilder();
    StringBuilder table_body        = new StringBuilder();
    StringBuilder table_strip_line  = new StringBuilder();
    StringBuilder table_format      = new StringBuilder();
    int columns_length              = 0;

    // get columns length
    for (int i = 0;i < Env.app_table_columns_length.length;i++) {
      columns_length += Env.app_table_columns_length[i];
    }

    // create strip line
    for (int i = 0;i < Env.app_table_columns.length;i++) {
      int each_column_length = Env.app_table_columns_length[i];
      String format          = (i == Env.app_table_columns.length - 1)
        ? "+%-" + (each_column_length - 4) + "s+\n"
        : "+%-" + (each_column_length - 2) + "s";
      table_strip_line.append(String.format(format, "-".repeat(each_column_length)));
    }

    // create table header
    for (int i = 0;i < Env.app_table_columns.length;i++) {
      int each_column_length = Env.app_table_columns_length[i];
      String column_label    = Env.app_table_columns[i];
      String format          = (i == Env.app_table_columns.length - 1)
        ? "| %-" + (each_column_length - 2) + "s |\n"
        : "| %-" + (each_column_length - 1) + "s";
      table_format.append(format);
      table_header.append(String.format(format, column_label));
    }

    // create table body
    if(record.length == 0) {
      String format = "| %-" + (columns_length + 3) + "s |\n";
      table_body.append(String.format(format, "There is no available data"));
      table_body.append(table_strip_line);
    } else {
      for (MahasiswaModel mahasiswaModel : record) {
        table_body.append(String.format(table_format.toString(),
          mahasiswaModel.name,
          mahasiswaModel.address,
          mahasiswaModel.age,
          mahasiswaModel.gender,
          String.join(", ", mahasiswaModel.hobbies),
          mahasiswaModel.gpa
        ));
        table_body.append(table_strip_line);
      }
    }

    // append everything
    table_result.append(table_strip_line);
    table_result.append(table_header);
    table_result.append(table_strip_line);
    table_result.append(table_body);
    long end_time = System.nanoTime();

    Util.operation_time(
      this.getClass().getSimpleName(),
      new Object(){}.getClass().getEnclosingMethod().getName(),
      start_time,
      end_time
    );
    System.out.printf("*) displays %d data from the given record\n", record.length);
    System.out.println(table_result);
  }

  /**
   * Method untuk mendapatkan semua data yang tersimpan pada rekaman data utama
   *
   * @return Rekaman data utama
   */
  public MahasiswaModel[] all() {
    return this.record;
  }

  /**
   * Method untuk mendapatkan panjang rekaman data utama
   *
   * @return Panjang rekaman data utama
   */
  public int length() {
    return this.record.length;
  }
}
