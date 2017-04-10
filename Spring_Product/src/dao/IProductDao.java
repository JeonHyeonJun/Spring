package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IProductDao {
	public int insertProduct(HashMap<String, Object> params);
	public int updateProduct(HashMap<String, Object> params);
	public int deleteProduct(int code);
	public List<HashMap<String, Object>> selectCode(int code);
	public List<HashMap<String, Object>> selectAll();
	public List<HashMap<String, Object>> selectName(String name);
}
