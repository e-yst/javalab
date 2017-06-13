/**
 * Created by eason.tse on 2017/6/13.
 */

import java.util.Date;

public class Contact implements Comparable<Contact> {
    private String name;   // 姓名
    private Date birthday; // 出生日期
    private String phone;  // 電話號碼
    private String email;  // 電子郵件

    /**
     * Constructor
     *
     * @param String name
     * @param Date   birthday
     * @param String phone
     * @param String email
     */
    public Contact(String name, Date birthday, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    /**
     * 取得姓名
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 取得出生日期
     *
     * @return Date
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 取得電話號碼
     *
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 取得電子郵件
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * 實作 Comparable 介面 compareTo 方法
     */
    public int compareTo(Contact other) {
        return (this.birthday.compareTo(other.birthday));
    }

}

