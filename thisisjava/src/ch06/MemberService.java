package ch06;

//Example15
public class MemberService {

    public MemberService() {

    }

    boolean login(String id, String password) {
        if(id.equals("hong") && password.equals("12345")) {
            return true;
        }else {
            return false;
        }
    }

    void logout(String id) {
        System.out.println(id +" is logged out");
    }
}
