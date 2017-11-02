package list;

/**
 *
 * @author borson
 */
public class ListTest {

	public static void main(String args[]) {
		list.LinkedList<String> fruits = new list.LinkedList();
		fruits.insert(0, "melon");
		fruits.insert(1, "banana");
		fruits.insert(2, "pear");
		fruits.insert(3, "apple");
		System.out.println(fruits);
		System.out.println("-----------");
//		Processor<String> processor = (String fruit) -> System.out.println(fruit.toUpperCase());
//		fruits.forEach(processor);
		fruits.forEach(fruit -> System.out.println(fruit.toUpperCase()));

		System.out.println("2 is " + fruits.get(2));
		System.out.println("size of fruits : " + fruits.size());
		String removed = fruits.remove(2);
		System.out.println("removed is " + removed);
		System.out.println(fruits);
		while (!fruits.isEmpty()) {
			System.out.println(fruits.remove(0));
		}
	}
}
