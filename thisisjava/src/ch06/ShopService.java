package ch06;

public class ShopService {

    static ShopService singleton = new ShopService();

    static ShopService getInstance() {
        return singleton;
    }
}
