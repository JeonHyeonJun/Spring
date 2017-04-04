package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import dao.IBoardDao;
import dao.IMemberDao;
import model.Board;
import model.Member;

//@Component - @Repository, @Service, @Controller 라는 3명의 자식이 있음. 의미부여용임. 걍 @Component 써도 됨.
@Service
public class MemberService{
	@Autowired
	private IBoardDao bDao;
	@Autowired
	private IMemberDao mDao;
	
	@Autowired
	private DataSourceTransactionManager txManager;
	
	public void join(String id, String pw, String name, String intro){
		
			
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		
		Board board = new Board();
		board.setContent(intro);
		board.setTitle(name + " 가입인사");
		board.setName(name);
		board.setPass(pw);
		board.setEmail("");
		
		bDao.insertBoard(board);
		mDao.insertMember(member);
		}

		//여기서 트랜잭션 활성화
//		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
//		dtd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		TransactionStatus status = txManager.getTransaction(dtd);
//		try{
//			//commit
//			txManager.commit(status);
//		}
//		catch (DataAccessException e) {
//			// TODO: handle exception
//			//rollback
//			txManager.rollback(status);
//		}
	
	
}
