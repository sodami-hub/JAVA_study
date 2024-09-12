package ch09_tree;

import java.util.Comparator;

public class BinaryTreeMain {
    public static class Comp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1>o2)?1:(o1<o2)?-1:0;
        }
    }
    public static final Comparator<Integer> compare = new Comp();

    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> tree = new BinarySearchTree<>();

        tree.add(6,6);
        tree.add(2,2);
        tree.add(3,3);
        tree.add(1,1);
        tree.add(10,10);
        tree.add(7,7);
        tree.add(4,4);
        tree.add(11,11);
        tree.add(8,8);
        tree.add(9,9);
        tree.add(12,12);

        tree.print();

        if(tree.remove(7)) {
            System.out.println("key 7 // 삭제 완료");
        }

        tree.print();
    }
}
