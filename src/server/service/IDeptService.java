package server.service;

import java.util.List;

import server.entity.Dept;
import server.entity.User;
import server.util.LayUITableResult;

public interface IDeptService {

	List<Dept> selectAll();
	
	public LayUITableResult selectByPage(Integer page, Integer limit);

	public void deleteById(Integer id);

	public void insert(Dept dept);

	public void deleteAll(Integer[] ids);

}
