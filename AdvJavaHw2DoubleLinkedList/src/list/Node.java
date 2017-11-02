
package list;

/**
 *
 * @author borson
 */
public class Node<T> {

	T data;
	Node next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return data.toString();
	}
}
