import java.util.HashMap;

import service.BoardService;
import service.IBoardService;

public class ServiceTest {
	public static void main(String[] args) {
		IBoardService service = new BoardService();
//		service.writeBoard("123", "title", "content", "name", "email", 129);
		
		for(HashMap<String, Object> h : service.getBoardReple())
			System.out.println(h);
//		select * from board order by group_code desc, group_seq asc limit 0, 10;
		
//		for(HashMap<String, Object> h : service.getBoardList(1))
//			System.out.println(h);
//		System.out.println(service.getBoardList(11));
	}
}
