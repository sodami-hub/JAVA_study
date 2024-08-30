package ch15.Q07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {

    List<Board> board;

    public BoardDao() {
        board = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            board.add(new Board("제목" + i, "내용" + i));
        }
    }

    public List<Board> getBoardList() {
        return board;
    }
}
