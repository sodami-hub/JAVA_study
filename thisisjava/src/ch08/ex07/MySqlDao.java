package ch08.ex07;

public class MySqlDao implements DataAccessObject{
    @Override
    public void select() {
        System.out.println("마이에스큐엘 디비에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("마이에스큐엘 디비에서 삽입");
    }

    @Override
    public void update() {
        System.out.println("마이에스큐엘 디비에서 수정");
    }

    @Override
    public void delete() {
        System.out.println("마이에스큐엘 디비에서 삭제");
    }
}
