package ntust.mis.test;

import ntust.mis.oo.*;

/**
 * Created by eason.tse on 18/5/2017.
 */
public class DeliveryTest {
    public static void main(String[] args) {

        Goods newGoods = Goods.genGoods();
        Delivery d;
        Double weight = 0.0;
        do {
            d = new Delivery(
                    Person.genPerson(),
                    Person.genPerson(),
                    newGoods);

            if (weight != 0.0)
                d.setCurrentWeight(weight);

            System.out.print(String.format(
                    "減掉前，目前可用重量: %.1f%n",
                    d.getMaxWeight() - d.getCurrentWeight()));

            d.send();
            System.out.println(d);

            newGoods = Goods.genGoods();
            weight = d.getCurrentWeight();;
        } while (d.getMaxWeight() - d.getCurrentWeight() > newGoods.getWeight());
    }
}
