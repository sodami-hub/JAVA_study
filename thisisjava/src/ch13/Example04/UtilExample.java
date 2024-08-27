package ch13.Example04;

public class UtilExample {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("홍길동",35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);

        Pair<String, Integer> childPair = new Pair<>("홍길똥",25);
        Integer childAge = Util.getValue(childPair, "홍길순");
        System.out.println(childAge);

//        OtherPair<String, Integer> otherPair = new OtherPair<>("홍",5);
//        Integer otherAge = Util.getValue(otherPair, "홍");
//        System.out.println(otherAge);
    }
}
