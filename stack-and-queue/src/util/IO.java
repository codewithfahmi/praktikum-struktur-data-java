package util;

import java.util.function.Supplier;

public class IO<T> {
  public static void puts(Object o) {
    System.out.println(o);
  }

  public static void puts(String format, Object... o) {
    System.out.printf(format + "\n", o);
  }

  public static void puts(boolean condition, Object o) {
    if (condition) {
      IO.puts(o);
    }
  }

  public static void vputs(boolean condition, Object o, Runnable elseCondition) {
    if (condition) {
      IO.puts(o);
    } else {
      elseCondition.run();
    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T tputs(boolean condition, Object o, Supplier<T> elseCondition) {
    if (condition) {
      return (T) o;
    } else {
      return elseCondition.get();
    }
  }

  public static void puts(boolean condition, String format, Object... o) {
    if (condition) {
      IO.puts(format, o);
    }
  }

  public static void print(Object o) {
    System.out.print(o);
  }

  public static void print(String format, Object... o) {
    System.out.printf(format, o);
  }

  public static void eputs(Object o) {
    System.err.println(o);
  }

  public static void eputs(boolean condition, Object o) {
    if (condition) {
      IO.puts(o);
    }
  }

  public static void eputs(String format, Object... o) {
    System.err.printf(format + "\n", o);
  }

  public static void eprint(Object o) {
    System.err.print(o);
  }

  public static void eprint(String format, Object... o) {
    System.err.printf(format, o);
  }
}
