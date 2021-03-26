package server.mapper;

import java.util.List;

import server.entity.Department;
//  spring 整合mybatis的时候 用了mybatis这个包扫描指定路径下的配置文件来进行对应。    
public class DepartmentMapper {
	List<Department> selectAll;
}
