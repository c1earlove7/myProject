package server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import server.entity.User;

// IUserDao
public interface UserMapper {
	public List<User> selectAll();

	public List<User> selectByPage(@Param(value = "offset")int offset,@Param(value = "limit") Integer limit);

	public int selectTotalCount();

	public void deleteById(Integer id);

	public void insert(User user);
}
