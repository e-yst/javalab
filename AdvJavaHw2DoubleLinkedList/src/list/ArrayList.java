package list;

/**
 *
 * @author borson
 */
public class ArrayList<T> implements List<T> {

	public static final int ARRAY_DEFAULT_MAX_CAPACITY = 100;
	int count;
	T entry[];

	public ArrayList() {
		entry = (T[]) new Object[ARRAY_DEFAULT_MAX_CAPACITY];
	}

	public ArrayList(int capacity) {
		entry = (T[]) new Object[capacity];
	}

	@Override
	public boolean insert(int index, T newEntry) {
		if (isFull()) {
			System.out.printf("list full\n");
			return false;
		}
		if (index < 0 || index > count) {
			System.out.printf("invalid position index\n");
			return false;
		}
		for (int i = count - 1; i >= index; i--) {
			entry[i + 1] = entry[i];
		}
		entry[index] = newEntry;
		count++;
		return true;
	}

	@Override
	public boolean add(T newEntry) {
		return insert(count, newEntry);
	}

	@Override
	public T remove(int index) {
		if (isEmpty()) {
			return null;
		}
		if (index < 0 || index >= count) {
			return null;
		}
		T removed = entry[index];
		for (int i = index + 1; i < count; i++) {
			entry[i - 1] = entry[i];
		}
		count--;
		return removed;
	}

	@Override
	public T get(int index) {
		return entry[index];
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return count == entry.length;
	}

	@Override
	public void forEach(Visit<T> visit) {
		for (int i = 0; i < count; i++)  {
			visit.todo(entry[i]);
		}
	}

}
