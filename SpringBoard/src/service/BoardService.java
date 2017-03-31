package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import commons.Constant;
import dao.IBoardDao;


@Component
public class BoardService implements IBoardService{
	
	@Autowired
	IBoardDao dao;

	@Override
	public boolean insertBoard(String name, String pass, String content, String email, String title) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = new HashMap<>();
		params.put(Constant.NAME, name);
		params.put(Constant.PASS, pass);
		params.put(Constant.CONTENT, content);
		params.put(Constant.EMAIL, email);
		params.put(Constant.TITLE, title);
		int result = dao.insertBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean updateBoard(int num, String name, String pass, String content, String email, String title) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = dao.selectOne(num);
		params.put(Constant.NAME, name);
		params.put(Constant.PASS, pass);
		params.put(Constant.CONTENT, content);
		params.put(Constant.EMAIL, email);
		params.put(Constant.TITLE, title);
		int result = dao.updateBoard(params);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteBoard(int num) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = dao.selectOne(num);
		int result = dao.deleteBoard(num);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public HashMap<String, Object> readBoard(int num) {
		// TODO Auto-generated method stub
		HashMap<String, Object> params = dao.selectOne(num);
		return params;
	}

	@Override
	public List<HashMap<String, Object>> getBoardList(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
