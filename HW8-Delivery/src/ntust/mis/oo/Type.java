package ntust.mis.oo;

/**
 * Created by eason.tse on 18/5/2017.
 */
public enum Type {
    HOUSEWARESH,
    BUSSINESS;

    public static Type genType() {
        int index = (int) (Math.random() * 2);
        return Type.values()[index];
    }
}
