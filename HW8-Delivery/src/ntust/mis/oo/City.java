package ntust.mis.oo;

/**
 * Created by eason.tse on 18/5/2017.
 */
public enum City {
    TAIPEI,
    TAICHUNG,
    KAOHSIUNG,
    HSINCHU,
    HUALIEN;

    public static City genCity() {
        int index = (int) (Math.random() * 5);
        return City.values()[index];
    }
}
