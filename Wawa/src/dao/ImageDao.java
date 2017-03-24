package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Board;
import model.Image;

public class ImageDao {
	private SqlSessionFactory sqlSessionFactory;
	private static ImageDao instance;
	
	public static ImageDao getInstance() {
		if(instance == null)
			instance = new ImageDao();
		return instance;
	}

	private ImageDao(){
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//게시글 번호로 게시글 정보 가져오기
	public Image selectOne(int img_idx){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.selectOne("image.selectOne", img_idx);
		}
		finally {
			session.close();
		}
	}

}
