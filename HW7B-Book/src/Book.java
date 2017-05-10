/**
 * Created by eason.tse on 10/5/2017.
 */
public enum Book {

    Accounting(1, "會計學", 360.0),
    Statistics(2, "統計學", 245.0),
    Programming(3, "程式設計", 600.0),
    Economics(4, "經濟學", 445.0),
    History(5, "本國史", 180.0),
    English(6, "英文　", 350.0);

    Book(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private Integer id;
    private String name;
    private Double price;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public static Book getById(Integer id) {
        for (Book b: Book.values()) {
            if (b.id == id)
                return b;
        }
        return null;
    }
}
