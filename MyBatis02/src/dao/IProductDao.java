package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Product;

public interface IProductDao {
	@Insert("insert into product values(0,#{name},#{price},#{pictureurl},#{description})")
	public int insertProduct(Product product);
	@Update("update product set name=#{name}, price=#{price} where code=#{code}")
	public int updateProduct(Product product);
	@Delete("delete from product where code=#{code}")
	public int deleteProduct(int code);
	@Select("select * from product where code=#{code}")
	public Product selectOne(int code);
	@Select("select * from product")
	public List<Product> selectAll();
}
