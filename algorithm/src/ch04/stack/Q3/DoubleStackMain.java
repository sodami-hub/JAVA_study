package ch04.stack.Q3;

public class DoubleStackMain {
    public static void main(String[] args) {
        DoubleStack ds = new DoubleStack(10);
        ds.fPush(1);
        ds.fPush(2);
        ds.fPush(3);
        ds.fPush(4);
        ds.fPush(5);

        ds.rPush(10);
        ds.rPush(9);
        ds.rPush(8);
        ds.rPush(7);
        ds.rPush(6);

        System.out.println("fPeek : "+ds.fPeek());
        System.out.println("rPeek : "+ds.rPeek());

        ds.fDump();
        ds.rDump();

        System.out.println("fPop : "+ds.fPop());
        System.out.println("fPop : "+ds.fPop());
        ds.fDump();

        System.out.println("rPop : "+ds.rPop());
        System.out.println("rPop : "+ds.rPop());
        ds.rDump();
    }
}
