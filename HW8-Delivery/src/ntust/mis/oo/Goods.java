package ntust.mis.oo;

/**
 * Created by eason.tse on 18/5/2017.
 */
public class Goods {
    private String name;
    private Double weight;
    private Type type;

    public Goods(String name, Double weight, Type type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    private void setWeight(Double weight) {
        if (weight < 30 && weight > 0)
            this.weight = weight;
        else
            this.weight = -1.0;
    }

    public Double getWeight() {
        return this.weight;
    }

    public static Goods genGoods() {
        int index = (int) (Math.random() * 26);
        Character c = Character.toChars(index + 'A')[0];

        String name = String.valueOf(c).toUpperCase();
        Double weight = Math.random() * 30;
        Type type = Type.genType();

        return new Goods(name, weight, type);
    }

    public String toString() {
        return String.format("%s-%.1f-%s", name, weight, type);
    }
}
