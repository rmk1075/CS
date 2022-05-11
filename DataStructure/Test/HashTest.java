package DataStructure.test;

import DataStructure.src.hash.CustomHash;

public class HashTest {
    public static void main(String[] args) {
        CustomHash<Integer, Character> hash = new CustomHash<>();

        String str = "Hello World";
        for(int i = 0; i < str.length(); i++) {
            hash.put(i, str.charAt(i));
            System.out.println("size: " + hash.size());
        }

        for(int i = 0; i < str.length(); i++) {
            System.out.println(hash.get(i));
        }

        System.out.println("---------------------");

        CustomHash<Character, Integer> hash2 = new CustomHash<>();
        for(int i = 0; i < str.length(); i++) {
            hash2.put(str.charAt(i), i);
            System.out.println("size: " + hash2.size());
        }
        
        for(int i = 0; i < str.length(); i++) {
            System.out.println(hash2.get(str.charAt(i)));
        }
    }
}
