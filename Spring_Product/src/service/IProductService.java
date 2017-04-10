package service;

import java.util.HashMap;
import java.util.List;

public interface IProductService {
	public boolean insertProduct(String name, int price, String pictureurl, String description);
	public boolean updateProduct(int code, int price);
	public boolean deleteProduct(int code);
	public List<HashMap<String, Object>> selectCode(int code);
	public List<HashMap<String, Object>> selectName(String name);
	public List<HashMap<String, Object>> ProudctList();
}
