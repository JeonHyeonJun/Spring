package service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.Constant;
import dao.IProductDao;

@Service 
public class ProductService implements IProductService{
	@Autowired
	private IProductDao dao;
	
	public boolean insertProduct(String name, int price, String pictureurl, String description){
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.NAME, name);
		params.put(Constant.PRICE, price);
		params.put(Constant.PICTUREURL, pictureurl);
		params.put(Constant.DESCRIPTION, description);
		int result = dao.insertProduct(params);
		if(result > 0)
			return true;
		else
			return false;
	}
	public boolean updateProduct(int code, int price){
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.CODE, code);
		params.put(Constant.PRICE, price);
		int result = dao.updateProduct(params);
		if(result > 0)
			return true;
		else
			return false;
	}
	public boolean deleteProduct(int code){
		int result = dao.deleteProduct(code);
		if(result > 0)
			return true;
		else
			return false;
	}
	public List<HashMap<String, Object>> selectCode(int code){
		return dao.selectCode(code);
	}
	public List<HashMap<String, Object>> selectName(String name){
		return dao.selectName(name);
	}
	public List<HashMap<String, Object>> ProudctList(){
		return dao.selectAll();
	}
}
