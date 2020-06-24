package structures;

import exceptions.ElementNotFound;
import iterator.Aggregate;

public interface MyList<T> extends Aggregate {
	void add(T data);
	void remove(int index);
	void remove(T data) throws ElementNotFound;
	void clear();
	int size();
	boolean empty();
	T get(int index);
	int indexOf(T data);
	boolean contains(T data);
	String toString();
	void insert(T data, int index);
}
