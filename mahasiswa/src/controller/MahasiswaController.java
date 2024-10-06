package controller;

import model.MahasiswaModel;
import util.Env;
import util.Form;
import util.Util;

import java.util.Arrays;

public class MahasiswaController {
  RecordController recordController = new RecordController();
  private boolean is_continue       = true;

  private MahasiswaModel __form() {
    MahasiswaModel result   = new MahasiswaModel();
    result.name             = Form.input("name").required().to_alphabet();
    result.address          = Form.input("address").required().to_string();
    result.age              = Form.input("age").required().to_integer();
    result.gender           = Form.input("gender").required().to_alphabet().charAt(0);
    for (int i = 0;i < result.hobbies.length;i++)
      result.hobbies[i]     = Form.input("hobby - " + (i + 1)).required().to_alphabet();
    result.gpa              = Form.input("gpa").required().to_float();

    return result;
  }

  public int init() {
    Util.banner(Env.app_title, Env.app_menu, false);
    return Form.input(Env.app_option_label).required().to_integer();
  }

  /**
   * Method untuk menampilkan fitur penambahan data
   */
  public void insert() {
    while (this.is_continue) {
      Util.banner(Env.app_insert_label, Env.app_insert_menu, true);
      int record_length = recordController.length() + 1;

      switch(Form.input(Env.app_option_label)
              .required()
              .minmax(0, Env.app_insert_menu.length)
              .to_integer()) {
        case 1 -> {
          Util.banner(Env.app_prepend_op_label + record_length);
          recordController.refresh(recordController.prepend(
              recordController.all(),
              __form()
          ));
        }
        case 2 -> {
          Util.banner(Env.app_insert_op_label + record_length);
          if (recordController.length() == 0) {
            System.out.println(Env.app_insert_empty_record);
          } else {
            recordController.refresh(recordController.insert(
                recordController.all(),
                Form.input(Env.app_index_label)
                    .minmax(0, recordController.length())
                    .to_integer(),
                __form())
            );
          }
        }
        case 3 -> {
          Util.banner(Env.app_append_op_label + record_length);
          recordController.refresh(recordController.append(
              recordController.all(),
              __form()
          ));
        }
        case 0 -> { this.is_continue = false; }
      }
      if (!this.is_continue) break;
      this.is_continue = Util.confirmation_prompt();
    }
    this.is_continue = true;
  }

  /**
   * Method untuk menampilkan fitur penghapusan data
   */
  public void delete() {
    if (recordController.length() == 0) {
      System.out.println(Env.app_delete_empty_record);
    } else {
      while (this.is_continue) {
        Util.banner(Env.app_delete_label, new String[] { "by position", "by keyword"}, true);
        switch (Form.input(Env.app_option_label).required().minmax(0, 2).to_integer()) {
          case 1 -> {
            Util.banner("(delete by position)", Env.app_delete_menu, true);
            switch (Form.input(Env.app_option_label)
                        .required()
                        .minmax(0, Env.app_delete_menu.length)
                        .to_integer()
            ) {
              case 1 -> {
                Util.banner(Env.app_shift_op_label);
                recordController.refresh(recordController.shift(recordController.all()).results);
              }
              case 2 -> {
                Util.banner(Env.app_delete_op_label);
                recordController.refresh(recordController.delete(
                    recordController.all(),
                    Form.input(Env.app_index_label)
                        .required()
                        .minmax(0, recordController.length())
                        .to_integer()
                  ).results
                );
              }
              case 3 -> {
                Util.banner(Env.app_pop_op_label);
                recordController.refresh(recordController.pop(
                    recordController.all()
                  ).results
                );
              }
              case 0 -> { this.is_continue = false; }
            }
          }
          case 2 -> {
            Util.banner("delete by keyword");
            Util.banner("select category", Env.app_table_columns, true);
            int category = Form.input("category")
                               .required()
                               .minmax(0, Env.app_table_columns.length)
                               .to_integer();
            if(category == 0) {
              this.is_continue = false;
            } else {
              String keyword = Form.input("keyword").required().to_string();
              RecordController.SearchResult result = recordController.linear_search(
                  recordController.all(),
                  Env.app_table_columns[category - 1],
                  keyword
              );
              MahasiswaModel[] data_result = result.results;
              int[] indexes = result.indexes;

              if (indexes.length == 0) {
                System.out.printf("*) there is no data contains keyword \"" + keyword + "\"");
              } else {
                Util.banner(String.format("(%d data will be deleted)", indexes.length));
                recordController.show(data_result);
                for (int i = indexes.length - 1;i >= 0;i--) {
                  RecordController.DeleteResult delete = recordController.delete(
                      recordController.all(),
                      indexes[i]
                  );
                  recordController.refresh(delete.results);
                }
              }
            }
          }
          case 0 -> { this.is_continue = false; }
        }
        if (!this.is_continue) break;
        this.is_continue = Util.confirmation_prompt();
      }
    }
    this.is_continue = true;
  }

  /**
   * Method untuk menampilkan fitur edit
   */
  public void update() {
    if(recordController.length() == 0) {
      System.out.println(Env.app_edit_empty_record);
    } else {
      while(this.is_continue) {
        Util.banner(Env.app_edit_label);
        int index = Form.input(Env.app_index_label)
                        .required()
                        .minmax(0, recordController.length() - 1)
                        .to_integer();
        MahasiswaModel current = recordController.all()[index];

        Util.banner(Env.app_update_cur_label + index);
        String format = "%-10s : %s\n";
        System.out.printf(format, "name",       current.name);
        System.out.printf(format, "address",    current.address);
        System.out.printf(format, "age",        current.age);
        System.out.printf(format, "gender",     current.gender == 'l' ? "laki - laki" : "perempuan");
        System.out.printf(format, "hobbies",    String.join(", ", current.hobbies));
        System.out.printf(format, "gpa",        current.gpa);

        Util.banner(Env.app_update_upd_label + index);
        recordController.refresh(recordController.update(index, this.__form()));
        this.is_continue = Util.confirmation_prompt();
      }
      this.is_continue = true;
    }
  }

  /**
   * Method untuk menampilkan fitur penukaran data (swap)
   */
  public void swap() {
    if (recordController.length() == 0) {
      System.out.println(Env.app_swap_empty_record);
    } else {
      while(this.is_continue) {
        Util.banner(Env.app_swap_op_label);
        int record_length     = recordController.length() - 1;
        int source_index      = Form.input(Env.app_swap_source_label)
                                    .required()
                                    .minmax(0, record_length)
                                    .to_integer();
        int destination_index = Form.input(Env.app_swap_dest_label)
                                    .required()
                                    .minmax(0, record_length)
                                    .to_integer();
        if (source_index == destination_index) {
          System.out.println(Env.app_swap_index_warning);
        } else {
          recordController.refresh(recordController.swap(
                  source_index,
                  destination_index
          ));
        }

        if (!this.is_continue) break; this.is_continue = Util.confirmation_prompt();
      }
      this.is_continue = true;
    }
  }

  /**
   * Method untuk menampilkan fitur pengurutan data (sort)
   */
  public void sort() {
    if (recordController.length() == 0) {
      System.out.println(Env.app_sort_empty_record);
    } else {
      while (this.is_continue) {
        Util.banner(Env.app_sort_label);
        int category = 0;
        int algorithm = 0;

        Util.banner("select category", Env.app_table_columns, true);
        category = Form.input("category")
                       .required()
                       .minmax(0, Env.app_table_columns.length)
                       .to_integer();
        if (category == 0) {
          this.is_continue = false;
        } else {
          Util.banner("select algorithm", Env.app_sort_menu, true);
          String prop = Env.app_table_columns[category - 1];
          algorithm = Form.input("algorithm")
                          .required()
                          .minmax(0, Env.app_sort_menu.length)
                          .to_integer();
          switch (algorithm) {
            case 1 -> recordController.refresh(recordController.bubble_sort(
                          recordController.all(),
                          prop
                      ));
            case 2 -> recordController.refresh(recordController.selection_sort(
                          recordController.all(),
                          prop
                      ));
            case 0 -> { this.is_continue = false; }
          }
        }

        if (!this.is_continue) break; this.is_continue = Util.confirmation_prompt();
      }
      this.is_continue = true;
    }
  }

  /**
   * Method untuk menampilkan fitur pencarian data
   */
  public void search() {
    if (recordController.length() == 0) {
      System.out.print("*) there is no data to search");
    } else {
      while (this.is_continue) {
        MahasiswaModel[] results = null;
        int prop = 0;
        int algorithm = 0;

        Util.banner(Env.app_search_label);

        Util.banner("select categories", Env.app_table_columns, true);
        prop = Form.input("category").required().minmax(0, Env.app_table_columns.length).to_integer();

        if (prop == 0) break;

        Util.banner("select algorithm", Env.app_search_menu, true);
        algorithm = Form.input("algorithm").required().minmax(0, Env.app_search_menu.length).to_integer();

        switch (algorithm) {
          case 1 -> {
            Util.banner(Env.app_linear_op_label);
            results = recordController.linear_search(
                recordController.all(),
                Env.app_table_columns[prop - 1],
                Form.input("keyword").required().to_string()
            ).results;
          }
          case 2 -> {
            Util.banner(Env.app_binary_op_label);
            results = recordController.binary_search(recordController.all(),
                    Env.app_table_columns[prop - 1],
                    Form.input("keyword").required().to_string()
            );
          }
          case 0 -> { this.is_continue = false; }
        }

        if (results != null) recordController.show(results);
        if (!this.is_continue) break; this.is_continue = Util.confirmation_prompt();
      }
      this.is_continue = true;
    }
  }

  /**
   * Method untuk menampilkan fitur untuk menampilkan data yang tersimpan pada rekaman data utama
   */
  public void view() {
    recordController.show(recordController.all());
  }
}
