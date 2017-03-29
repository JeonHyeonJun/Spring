import java.util.HashMap;

import dao.BoardDao;
import dao.IBoardDao;

public class DaoTest {
	public static void main(String[] args) {
		IBoardDao bd = new BoardDao();
		HashMap<String, Object> params = new HashMap<>();
		params.put("skip", 10);
		params.put("count", 10);
		for(HashMap<String, Object> b : bd.selectBoardLimit(params))
			System.out.println(b);
		System.out.println("총게시물 : " +bd.getBoardCount());
	}
}
