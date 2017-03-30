package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements IBoardDao{

	private SqlSessionFactory sqlSessionFactory;
	public BoardDao() {
		// TODO Auto-generated constructor stub
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).insertBoard(params);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int updateBoard(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).updateBoard(params);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).deleteBoard(num);
		}
		finally {
			session.close();
		}
	}

	@Override
	public HashMap<String, Object> selectOne(int num) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).selectOne(num);
		}
		finally {
			session.close();
		}
	}

	@Override
	public List<HashMap<String, Object>> selectBoardLimit(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).selectBoardLimit(params);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).getBoardCount();
		}
		finally {
			session.close();
		}
	}

	@Override
	public int updateGroup(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).updateGroup(params);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int increaseGroupSeq(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).increaseGroupSeq(params);
		}
		finally {
			session.close();
		}
	}

	@Override
	public List<HashMap<String, Object>> selectReple() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IBoardDao.class).selectReple();
		}
		finally {
			session.close();
		}
	}

	


	
}
