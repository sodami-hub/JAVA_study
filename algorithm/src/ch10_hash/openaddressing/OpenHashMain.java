package ch10_hash.openaddressing;

public class OpenHashMain {
    public static void main(String[] args) {
        OpenAddressHash<Integer,String> oah = new OpenAddressHash<>(10);

        oah.add(1,"A");
        oah.add(11,"B");
        oah.add(21,"C");
        oah.add(3,"F");
        oah.add(4,"Z");
        oah.add(14,"V");
        oah.add(10,"D");

        oah.dump();

        System.out.println();
        oah.remove(11);


        oah.dump();
        oah.remove(21);
        System.out.println();
        oah.dump();
        System.out.println();
        oah.add(11,"ABC");
        oah.dump();

    }
}
