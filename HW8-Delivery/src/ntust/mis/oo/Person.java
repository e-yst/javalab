package ntust.mis.oo;

/**
 * Created by eason.tse on 18/5/2017.
 */
public class Person {
    private String name, phoneNum;
    private City city;

    public Person(String name, String phoneNum, String city) {

        this.name = name;
        this.phoneNum = phoneNum;

        for (City c : City.values()) {
            if (city.toUpperCase().equals(c.toString()))
                this.city = c;
        }
    }

    public Person(String name, String phoneNum, City city) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.city = city;
    }

    public static Person genPerson() {
        String[] randName = {"peter", "mary", "paul", "billy", "tommy", "happy"};
        int index = (int) (Math.random() * randName.length);
        String name = randName[index];

        String phoneNum = String.valueOf((int) (Math.random() * 999999999 + 1));
        City city = City.genCity();

        return new Person(name, phoneNum, city);
    }

    public String toString() {
        return this.name + "-" + this.phoneNum + "-" + this.city;
    }
}
