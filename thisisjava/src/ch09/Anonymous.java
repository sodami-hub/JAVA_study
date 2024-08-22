package ch09;

public class Anonymous {
    Vehicle field = new Vehicle() {
        @Override
        public void run() {
            System.out.println("run 자전거");
        }
    };

    void method1() {
        Vehicle localVar = new Vehicle() {
            @Override
            public void run() {
                System.out.println("run 승용차");
            }
        };
        localVar.run();
    }
    
    void method2(Vehicle v) {
        v.run();
    }
    
    public static void main(String[] args) {
        
        Anonymous anony = new Anonymous();
        
        anony.field.run();
        
        anony.method1();
        
        anony.method2(new Vehicle() {

            @Override
            public void run() {
                System.out.println("run 트럭");
            }
        });
    }
    
}

    
