package core.algorithm;

public class SingleLinkedList<T> {
	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T item) {
			this.data = item;
			this.next = null;
		}
	}

	private Node<T> head;

	public SingleLinkedList() {
		this.head = null;
	}

	public void add(T item, int index) {
		if (index < 0) {
			System.err.println("[WARN] index must be non-negative number!");
			return;
		}

		if (index == 0) {
			this.addFirst(item);
			return;
		}

		if (index == this.size()) {
			this.addLast(item);
			return;
		}

		Node<T> node = new Node<>(item);
		Node<T> current = this.head;
		int count = 0;

		while (current != null && count < index - 1) {
			current = current.next;
			count++;
		}

		if (current == null) {
			System.err.println("[WARN] index must be in range from 0 to " + this.size());
			return;
		}

		node.next = this.head;
		current.next = node;
	}

	public void addFirst(T item) {
		Node<T> node = new Node<>(item);
		node.next = this.head;
		this.head = node;
	}

	public void addLast(T item) {
		Node<T> node = new Node<>(item);
		if (this.head == null) {
			this.head = node;
		} else {
			Node<T> current = this.head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public T remove(int index) {
		if (this.head == null) {
			System.err.println("[WARN] list is empty!");
			return null;
		}

		if (index < 0) {
			System.err.println("[WARN] index must be non-negative number!");
			return null;
		}

		if (index == 0) {
			return this.removeFirst();
		}

		Node<T> current = this.head;
		int count = 0;

		while (current != null && count < index - 1) {
			current = current.next;
			count++;
		}

		if (current == null || current.next == null) {
			System.err.println("[WARN] index must be in range from 0 to " + this.size());
			return null;
		}

		T removed = current.next.data;
		current.next = current.next.next;
		return removed;
	}

	public T removeFirst() {
		if (this.head == null) {
			System.err.println("[WARN] list is empty!");
			return null;
		}

		T removed = this.head.data;
		this.head = this.head.next;
		return removed;
	}

	public T removeLast() {
		if (this.head == null) {
			System.err.println("[WARN] list is empty!");
			return null;
		}

		if (this.head.next == null) {
			T removed = this.head.data;
			this.head = null;
			return removed;
		}

		Node<T> current = this.head;

		while (current.next.next != null) {
			current = current.next;
		}

		T removed = current.next.data;
		current.next = null;
		return removed;
	}

	public int size() {
		int count = 0;
		Node<T> current = this.head;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public void display() {
		Node<T> current = this.head;
		int index = 0;
		while (current != null) {
			System.out.printf("%d : %s\n", index, current.data.toString());
			current = current.next;
			index++;
		}
		System.out.println();
	}
}