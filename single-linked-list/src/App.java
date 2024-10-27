import java.lang.reflect.*;

public class App {
	public static class MachineType {
		public String machineType;
	}

	public static class Vehicle {
		public int number;
		public String type;
		public MachineType machineType;
	}

	public static class Person {
		public String name;
		public String gender;
		public Vehicle vehicle;
		public String[] hobbies;
	}

	public void printAttributes(Class<?> c, int indent) {
		Field[] fields = c.getDeclaredFields();
		System.out.println(" ".repeat(indent) + c.getSimpleName() + " {");
		for (Field field : fields) {
			field.setAccessible(true);
			String formatName = " ".repeat(indent + 1)
					+ " " + field.getName() + ": "
					+ field.getType().getSimpleName();
			if (field.getType().equals(String.class) || field.getType().isPrimitive() || field.getType().isArray()) {
				System.out.println(formatName);
			} else {
				this.printAttributes(field.getType(), indent + 2);
			}
		}
		System.out.println(" ".repeat(indent) + "}");
	}

	public static void main(String[] args) throws Exception {
		App app = new App();
		app.printAttributes(Person.class, 0);
	}
}
