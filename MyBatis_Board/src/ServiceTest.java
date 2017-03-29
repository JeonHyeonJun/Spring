import java.util.HashMap;

import service.BoardService;
import service.IBoardService;

public class ServiceTest {
	public static void main(String[] args) {
		IBoardService service = new BoardService();
		service.writeBoard("123", "title", "content", "name", "email", 121);
		for(HashMap<String, Object> h : service.getBoardList(11))
			System.out.println(h);
//		System.out.println(service.getBoardList(11));
	}
}
