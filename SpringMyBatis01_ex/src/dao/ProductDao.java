package dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Product;

@Component
public class ProductDao implements IProductDao{
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
			return session.getMapper(IProductDao.class).insertProduct(product);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
//			return session.update("product.update", product);
			return session.getMapper(IProductDao.class).updateProduct(product);
		}
		finally {
			session.close();
		}
	}

	@Override
	public int deleteProduct(int code) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
//			return session.delete("product.delete", code);
			return session.getMapper(IProductDao.class).deleteProduct(code);
		}
		finally {
			session.close();
		}
	}

	@Override
	public Product selectOne(int code) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
//			return session.selectOne("product.selectOne", code);
			return session.getMapper(IProductDao.class).selectOne(code);
		}
		finally {
			session.close();
		}
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		try{
//			return session.selectList("product.selectAll");
			return session.getMapper(IProductDao.class).selectAll();
		}
		finally {
			session.close();
		}
	}
	
}
