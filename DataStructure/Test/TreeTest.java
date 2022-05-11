package DataStructure.test;

import java.util.Random;

import DataStructure.src.tree.CustomBinaryTree;

public class TreeTest {
    public static void main(String[] args) {
        CustomBinaryTree tree = new CustomBinaryTree();

        Random rand = new Random();
        for(int i = 0; i < 20; i++) {
            int temp = rand.nextInt(20);
            if(tree.insert(temp)) {
                System.out.println(temp);
            }
        }
        
        System.out.println("*******PreOrder*******");
        tree.preOrder();

        System.out.println("*******InOrder*******");
        tree.inOrder();

        System.out.println("*******PostOrder*******");
        tree.postOrder();
    }
}
