package DZ_05;

import java.util.ArrayList;
import java.util.HashMap;

// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре 
// будут повторяющиеся имена с разными телефонами, их необходимо считать, 
// как одного человека с разными телефонами. Вывод должен быть отсортирован 
// по убыванию числа телефонов.

public class PhoneBook {

    public static void main(String[] args) {
        String name1, name2, name3, name4, name5, name6, name7, name8, name9, name10, name11;
        int phone1, phone2, phone3, phone4, phone5, phone6, phone7, phone8, phone9, phone10, phone11; 

            name1 = "Sergey";
            name2 = "Misha";
            name3 = "Ivan";
            name4 = "Misha";
            name5 = "Katy";
            name6 = "Misha";
            name7 = "Masha";
            name8 = "Misha";
            name9 = "Katy";
            name10 = "Ivan";
            name11 = "Katy";

            phone1 = 57244;
            phone2 = 55836;
            phone3 = 51248;
            phone4 = 58713;
            phone5 = 59635;
            phone6 = 58789;
            phone7 = 52895;
            phone8 = 2896;
            phone9 = 52589;
            phone10 = 50023;
            phone11 = 52036;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name4, phone4);
        myPhoneBook.add(name5, phone5);
        myPhoneBook.add(name6, phone6);
        myPhoneBook.add(name7, phone7);
        myPhoneBook.add(name8, phone8);
        myPhoneBook.add(name9, phone9);
        myPhoneBook.add(name10, phone10);
        myPhoneBook.add(name11, phone11);
        

        sortByPhoneNumber();

    }

    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
            if (phoneBook.containsKey(name)) {
                ArrayList<Integer> list = phoneBook.get(name);
                list.add(phoneNum);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(phoneNum);
                phoneBook.put(name, list);
            }
        
    }
    
    public static void sortByPhoneNumber() {
        ArrayList<String> sortedNames = new ArrayList<>();
        sortedNames.addAll(phoneBook.keySet());
        // Сортируем список имен контактов по убыванию числа телефонов
        sortedNames.sort((name1, name2) -> {
            int phoneCount1 = phoneBook.get(name1).size();
            int phoneCount2 = phoneBook.get(name2).size();
            return phoneCount2 - phoneCount1;
        });
        for (String name : sortedNames) {
            System.out.println(name + ":" + phoneBook.get(name));
        }
    }

}
