import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import commons.Constant;
import dao.BoardDao;
import dao.IBoardDao;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Object> params = new HashMap<>();
		IBoardDao bd = new BoardDao();
		

//		params.put(Constant.PASS, "1234");
//		params.put(Constant.NAME, "홍1");
////		params.put(Constant.EMAIL, "1@naver.com");
//		params.put(Constant.TITLE, "제목1");
//		params.put(Constant.CONTENT, "3");
////		params.put(Constant.READCOUNT, "0");
//		params.put(Constant.WRITEDATE, new Date());
//		bd.insertBoard(params);
//		System.out.println(bd.selectOne(params.get(Constant.NUM)));
//		params.put("keyword", "목");
		Scanner scan = new Scanner(System.in);
		System.out.print("페이지수 입력 ");
		int page = scan.nextInt();
		int PAGECNT = 10;
		params.put("page", (page-1)*10);
		
		int first = (page-1)/PAGECNT*PAGECNT+1;
		int finish = (bd.selectAll().size()-1)/10+1;
		int last = first+(PAGECNT-1);
		if(last > finish)
			last = finish;
		if(page > finish)
			System.out.println("없는페이지");
		else{
			System.out.println("첫페이지 : 1");
			System.out.println("시작페이지 : " +first);
			System.out.println("끝페이지 : " + last);
			System.out.println("마지막페이지 : "+finish);
		}
//		System.out.println(params);
		
//		bd.updateBoard(params);
		for(HashMap<String, Object> h : bd.selectBySearch(params))
			System.out.println(h);
	}
}
