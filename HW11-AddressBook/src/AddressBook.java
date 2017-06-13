/**
 * Created by eason.tse on 2017/6/13.
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddressBook {

    static String INPUT_FILEPATH = "D:\\Users\\eason.tse\\Documents\\Codes\\javalab\\HW11-AddressBook\\src\\data.txt";
    static String OUTPUT_FILEPATH = "D:\\Users\\eason.tse\\Documents\\Codes\\javalab\\HW11-AddressBook\\src\\contacts.txt";

    private Map<String, Contact> contacts = new TreeMap<String, Contact>(); // 聯絡人列表
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 程式進入點
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        String input;
        do {
            showMenu(); // 顯示選單
            input = scanner.next();
            System.out.println();

            switch (input) {
                case "1": // 新增聯絡人
                    addressBook.addContact();
                    break;
                case "2": // 顯示聯絡人列表
                    addressBook.showContacts();
                    break;
                case "3": // 編輯聯絡人
                    addressBook.editContacts();
                    break;
                case "4": // 刪除聯絡人
                    addressBook.delContacts();
                    break;
                case "5": // 匯入聯絡人
                    addressBook.importContacts();
                    break;
                case "6": // 匯出聯絡人
                    addressBook.exportContacts();
                    break;
                case "7": // 清除聯絡人列表
                    addressBook.clearList();
                    break;
            }

            System.out.println();
        } while (!input.equals("0"));
    }

    /**
     * 顯示選單
     */
    public static void showMenu() {
        System.out.println("***** Address Book *****");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit the Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contacts");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("************************");
        System.out.print("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }

    /**
     * 新增聯絡人
     */
    public void addContact() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Birthday(yyyy/MM/dd): ");
        String birthdayString = scanner.next();

        // 驗證輸入格式
        if (isValidFormat(name, birthdayString, phone, email)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            Date birthday = null; // 宣告Date物件
            try {
                birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                contacts.put(name, new Contact(name, birthday, phone, email)); // 加入聯絡人
                System.out.println("The contact has been added.");
            } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                e.printStackTrace(); // 顯示堆疊追蹤
            }
        }
    }

    /**
     * 顯示聯絡人列表
     */
    public void showContacts() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
        System.out.println("Name\tBirthday\tPhone\tE-mail");
        System.out.println("--------------------------------------------------");
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) { // 以加強版for迴圈走訪List
            Contact contact = entry.getValue();
            System.out.printf("%s\t%s\t%s\t%s\n", contact.getName(),
                    sdf.format(contact.getBirthday()), contact.getPhone(), contact.getEmail());
        }
    }

    /**
     * 編輯聯絡人
     */
    public void editContacts() {
        System.out.println("Please enter the name of contact that you want to edit.");
        System.out.print("Name: ");
        String name = scanner.next();
        Contact contact = contacts.get(name);
        if (contact == null) {
            System.out.println("Not found!");
        } else {
            System.out.print("Phone: ");
            String phone = scanner.next();
            System.out.print("E-mail: ");
            String email = scanner.next();
            System.out.print("Birthday(yyyy/MM/dd): ");
            String birthdayString = scanner.next();

            if (isValidFormat(contact.getName(), birthdayString, phone, email)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
                Date birthday = null; // 宣告Date物件
                try {
                    birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                    contacts.put(name, new Contact(name, birthday, phone, email)); // 加入聯絡人
                    System.out.println("The contact has been changed.");
                } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                    e.printStackTrace(); // 顯示堆疊追蹤
                }
            }
        }
    }

    /**
     * 刪除聯絡人
     */
    public void delContacts() {
        System.out.println("Please enter the name of contact that you want to delete.");
        System.out.print("Name: ");
        String name = scanner.next();
        Contact contact = contacts.get(name);

        if (contact == null) {
            System.out.println("Not found!");
        } else {
            contacts.remove(name);
            System.out.println("The contact has been deleted.");
        }
    }

    /**
     * 匯入聯絡人
     */
    public void importContacts() {
        try {
            FileReader fr = new FileReader(INPUT_FILEPATH);
            BufferedReader br = new BufferedReader(fr);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                String birthdayString = data[1];

                Contact newContact = new Contact(
                        data[0], sdf.parse(birthdayString), data[2], data[3]);

                contacts.put(data[0], newContact);
            }

            br.close();
            fr.close();

            System.out.println("All of the contacts have been imported.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 匯出聯絡人
     */
    public void exportContacts() {
        try {
            File file = new File(OUTPUT_FILEPATH);
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            bw.write("Name\tBirthday\tPhone\tE-mail\n");
            bw.write("--------------------------------------------------\n");

            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                Contact contact = entry.getValue();
                bw.write(contact.getName() + "\t" +
                        sdf.format(contact.getBirthday()) + "\t" +
                        contact.getPhone() + "\t" +
                        contact.getEmail()
                );
                bw.newLine();
            }

            bw.close();
            fw.close();

            System.out.println("The contact list has been exported.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 清除聯絡人列表
     */
    public void clearList() {
        contacts.clear(); // 移除contacts中的所有元素
        System.out.println("The contact list is empty.");
    }

    /**
     * 驗證輸入格式
     */
    public static boolean isValidFormat(String name, String birthday, String phone, String email) {
        boolean isValidFormat = true;

        // 驗證姓名格式
        if (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid name format!");
            isValidFormat = false;
        }

        // 驗證電話號碼格式
        if (!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$")) {
            System.out.println("Invalid phone format!");
            isValidFormat = false;
        }

        // 驗證電子郵件格式
        if (!email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
            System.out.println("Invalid email format!");
            isValidFormat = false;
        }

        // 驗證出生日期格式
        if (!birthday.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$")) {
            System.out.println("Invalid date format!");
            isValidFormat = false;
        }

        return isValidFormat;
    }

}
