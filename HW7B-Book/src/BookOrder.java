import java.util.Date;

/**
 * Created by eason.tse on 10/5/2017.
 */
public class BookOrder {
    private Long orderId;
    private Integer quantity;
    private String customerName, phoneNum;
    private Order[] orderList;

    public BookOrder() {
        this.orderList = new Order[Book.values().length];

        for (int i = 0; i < orderList.length; i++) {
            Order o = new Order();
            o.bookId = Book.values()[i].getId();
            o.qty = 0;
            orderList[i] = o;
        }
    }

    private class Order {
        private Integer bookId, qty;
    }

    public void setOrderQty(Integer bookId, Integer qty) {
        for (Order o : orderList)
            if (bookId == o.bookId) {
                o.qty = qty;
                return;
            }
    }

    public Integer getOrderQty(Integer bookId) {
        for (Order o : orderList)
            if (bookId == o.bookId)
                return o.qty;
        return null;
    }

    public void printOrder() {
        Date dateTime = new Date();
        this.orderId = dateTime.getTime() / 1000;

        Double sum = 0.0;

        System.out.println("********** 訂購明細 **********");
        System.out.printf("訂單編號: %08d\t\t買家姓名: %s\t\t聯絡電話: %s\n",
                this.orderId, this.customerName, this.phoneNum);
        System.out.println("--------------------------------------------------");
        System.out.println("書藉名稱\t\t\t單價\t\t\t數量\t\t\t小計");

        for (Order o : orderList) {
            if (o.qty > 0) {
                Book b = Book.getById(o.bookId);
                System.out.printf("%s\t\t\t%.2f\t\t%4d\t\t%6.2f\n",
                        b.getName(), b.getPrice(), o.qty, b.getPrice() * o.qty);

                sum += b.getPrice() * o.qty;
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("應付金額:\t\t\t\t\t\t\t\t%6.2f 元\n", sum);
        System.out.printf("訂單成立時間: %1$tY-%1$tm-%1$td %1$tT", dateTime);
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
