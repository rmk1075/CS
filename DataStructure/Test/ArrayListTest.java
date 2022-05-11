package DataStructure.test;

import DataStructure.src.list.CustomArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        System.out.println("**** size of list: " + list.size());

        System.out.println("**** add a, b, c to list");
        list.add("a");
        list.add("b");
        list.add("c");
        
        System.out.println("**** print elements in list");
        int size = list.size();
        for(int i = 0; i < size; i++) {
            System.out.println(i + ": " + list.get(i));
        }

        System.out.println("**** change a -> b");
        list.set(0, "b");
        size = list.size();
        for(int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("**** clear list");
        list.clear();
        size = list.size();
        System.out.println("**** size of list: " + size);

        System.out.println("**** add 1 to 11 to list");
        for(int i = 1; i < 12; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("**** print elements in list");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }
}
