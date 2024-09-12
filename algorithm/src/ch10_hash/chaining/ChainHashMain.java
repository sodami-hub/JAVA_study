package ch10_hash.chaining;

public class ChainHashMain {
    public static void main(String[] args) {
        ChainingHash<Integer,String> ch = new ChainingHash<>(13);

        ch.add(14,"a");
        ch.add(29,"b");
        ch.add(69,"d");
        ch.add(17,"g");
        ch.add(5,"hi");
        ch.add(6,"hello");
        ch.add(20,"world");
        ch.add(33,"java");

        ch.dump();

        ch.remove(34);
        ch.remove(33);

        ch.dump();
    }
}
