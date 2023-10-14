package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
// ввод данных
            String name1 = "Ivanov";
            String name2 = "Petrov";
            String name3 = "Sidorov";
            int phone1 = 123456;
            int phone2 = 654321;
            int phone3 = 654894;
            int phone4 = 696512;
            int phone5 = 985627;
            int phone6 = 987523;
            int phone7 = 987452;
//добавление номеров в книгу
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone3);
        myPhoneBook.add(name3, phone4);
        myPhoneBook.add(name3, phone5);
        myPhoneBook.add(name3, phone6);
//Вывод данных
        //System.out.println(myPhoneBook.find(name1));
        PhoneBook.getPhoneBook();
        //System.out.println(myPhoneBook.find("Me"));
    }
}

class PhoneBook {
    private static HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        //Добавлеие номера
        HashSet<Integer> list = new HashSet<>();
        if (phoneBook.containsKey(name)){
            list.addAll(phoneBook.get(name));
            list.add(phoneNum);
            phoneBook.put(name,list);

        }else {list.add(phoneNum);
            phoneBook.put(name, list);}
    }

    public HashSet<Integer> find(String name) {
// поиск номеров по имени
        HashSet<Integer> list = new HashSet<>();
        if (phoneBook.containsKey(name)){
            list.addAll(phoneBook.get(name));
            return list;}
        return list;
    }

    public static void getPhoneBook() {
// Ввывод всей телефонной книги (отсортирован)
        List<Map.Entry<String, HashSet<Integer>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort((a1, b1) -> b1.getValue().size() - a1.getValue().size());

        for (Map.Entry<String, HashSet<Integer>> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}