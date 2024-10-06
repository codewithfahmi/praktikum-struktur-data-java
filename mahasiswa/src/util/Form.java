package util;

import java.util.Scanner;

public class Form {
    private final Scanner scanner = new Scanner(System.in);
    private String  input_label;
    private String  input_rule;
    private String  input_warning_message;
    private String  input_result;
    private int     input_ranged_min = 0;
    private int     input_ranged_max = 0;
    private boolean input_is_required = false;
    private boolean input_is_ranged = false;
    private boolean input_has_warning = false;

    public static Form input(String label) {
        Form form = new Form();
        form.input_label = label;
        return form;
    }

    private void run() {
        while (true) {
            System.out.printf("%-10s : ", this.input_label);
            String s = this.scanner.nextLine();
            if (this.input_is_required && (s.isEmpty() && s.isBlank())) {
                this.input_has_warning = true;
                System.out.printf("[!] %s %s.\n", this.input_label, "is required");
            } else if (this.input_is_ranged) {
                try {
                    int i = Integer.parseInt(s);
                    if (i < this.input_ranged_min || i > this.input_ranged_max) {
                        this.input_has_warning = true;
                        System.out.printf(
                            "[!] %s must be between %d - %d \n",
                            this.input_label,
                            this.input_ranged_min,
                            this.input_ranged_max
                        );
                    }
                } catch (NumberFormatException _) {}
            } else if (!s.matches(this.input_rule)) {
                this.input_has_warning = true;
                System.out.printf("[!] %s %s.\n", this.input_label, this.input_warning_message);
            } else {
                this.input_has_warning = false;
            }

            if (!this.input_has_warning) {
                this.input_result = s;
                break;
            }
        }
    }

    public Form required() {
        this.input_is_required = true;
        return this;
    }

    public Form minmax(int min, int max) {
        this.input_is_ranged  = true;
        this.input_ranged_min = min;
        this.input_ranged_max = max;
        return this;
    }

    /**
     * Method untuk merubah hasil masukkan menjadi String
     *
     * @return String
     */
    public String to_string() {
        this.input_warning_message = Env.app_form_string_warning;
        this.input_rule = Env.app_form_regex_string;
        this.run();
        return this.input_result;
    }

    /**
     * Method untuk merubah hasil masukkan menjadi String yang hanya alfabet
     *
     * @return String, hanya alfabet
     */
    public String to_alphabet() {
        this.input_warning_message = Env.app_form_alfabet_warning;
        this.input_rule = Env.app_form_regex_alfabet;
        this.run();
        return this.input_result;
    }

    /**
     * Method untuk merubah hasil masukkan menjadi angka desimal (float)
     *
     * @return float
     */
    public float to_float() {
        this.input_warning_message = Env.app_form_float_warning;
        this.input_rule = Env.app_form_regex_float;
        this.run();
        return Float.parseFloat(this.input_result);
    }

    /**
     * Method untuk merubah hasil masukkan menjadi integer
     *
     * @return integer
     */
    public int to_integer() {
        this.input_warning_message = Env.app_form_int_warning;
        this.input_rule = Env.app_form_regex_int;
        this.run();
        return Integer.parseInt(this.input_result);
    }
}
