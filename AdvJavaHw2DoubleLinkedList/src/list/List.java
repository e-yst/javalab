
package list;

/**
 * @author borson
 */
public interface List<T> {

    public boolean insert(int index, T newEntry);

    public boolean add(T newEntry);

    public T remove(int index);

    public T get(int index);

    public int size();

    public boolean isEmpty();

    public boolean isFull();

    public void forEach(Visit<T> visit);

}
