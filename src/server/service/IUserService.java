package server.service;

import java.util.List;

import server.entity.User;
import server.util.LayUITableResult;

public interface IUserService {
	public List<User> selectAll();

	public LayUITableResult selectByPage(Integer page, Integer limit);

	public void deleteById(Integer id);

	public void insert(User user);

	public void deleteAll(Integer[] ids);
}
