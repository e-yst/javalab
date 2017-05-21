package ntust.mis.oo;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

/**
 * Created by eason.tse on 18/5/2017.
 */
public class Delivery {
    private Person sender, receiver;
    private Goods goods;
    private static final Double MAX_WEIGHT = 100.0;
    private static Double currentWeight = 0.0;
    private int no = -1;

    public Delivery(Person sender, Person receiver, Goods goods) {
        this.sender = sender;
        this.receiver = receiver;
        this.goods = goods;
    }

    private static Double getAvailableWeight() {
        return MAX_WEIGHT - currentWeight;
    }

    public int send() {
        if (this.goods.getWeight() > getAvailableWeight())
            return -1;
        else if (this.goods.getWeight() == -1)
            return -1;
        else {
            this.currentWeight += this.goods.getWeight();
            this.no = (int) (Math.random() * 10000 + 1);
            return this.no;
        }
    }

    public void addGoods(Person sender, Person receiver, Goods goods, int no) {
        assert (getAvailableWeight() < goods.getWeight()): "Overweight!";

        this.sender = sender;
        this.receiver = receiver;
        this.goods = goods;
        currentWeight += goods.getWeight();
        this.no = no;

    }

    public static Delivery genDelivery() {
        Person sender = Person.genPerson();
        Person receiver = Person.genPerson();
        Goods goods = Goods.genGoods();
        return new Delivery(sender, receiver, goods);
    }

    public String toString() {
        String info;
        info = String.format("減掉後，目前可用重量: %.1f%n", getAvailableWeight());
        info += String.format("No: %d%n", this.no);
        info += String.format("Sender: %s%n", this.sender.toString());
        info += String.format("Receiver: %s%n", this.receiver.toString());
        info += String.format("Goods: %s%n%n%n", this.goods.toString());

        return info;
    }

    public static Double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public static Double getCurrentWeight() {
        return currentWeight;
    }

    public static void setCurrentWeight(Double currentWeight) {
        Delivery.currentWeight = currentWeight;
    }
}
