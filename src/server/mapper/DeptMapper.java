package server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import server.entity.Dept;
import server.entity.User;

public interface DeptMapper {

	List<Dept> selectAll();
	
	public List<Dept> selectByPage(@Param(value = "offset")int offset,@Param(value = "limit") Integer limit);

	public int selectTotalCount();

	public void deleteById(Integer id);

	public void insert(Dept dept);

}
