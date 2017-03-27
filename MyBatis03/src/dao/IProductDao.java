package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Product;

public interface IProductDao {

	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(int code);
	public Product selectOne(int code);
	public List<Product> selectAll();
}
