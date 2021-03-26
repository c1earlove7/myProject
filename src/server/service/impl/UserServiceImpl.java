package server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.User;
import server.mapper.UserMapper;
import server.service.IUserService;
import server.util.LayUITableResult;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	public LayUITableResult selectByPage(Integer page, Integer limit) {
		int offset = (page - 1) * limit;
		List<User> list = userMapper.selectByPage(offset, limit);
		
		int count = userMapper.selectTotalCount();
		
		//LayUITableResult layUITableResult = new LayUITableResult(LayUITableResult.OK, count, limit);
		return LayUITableResult.ok(count, list);
	}

	@Override
	public void deleteById(Integer id) {
		userMapper.deleteById(id);
		
	}

	@Override
	public void insert(User user) {
		userMapper.insert(user);
	}

	@Override
	public void deleteAll(Integer[] ids) {
		for (Integer id : ids) {
			userMapper.deleteById(id);
		}
	}


}
