package server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.ws.developer.Serialization;

import server.entity.Dept;
import server.mapper.DeptMapper;
import server.service.IDeptService;
import server.util.LayUITableResult;

@Service
public class DeptSeriviceImpl implements IDeptService{
	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> selectAll() {
		return deptMapper.selectAll();
	}
	
	@Override
	public LayUITableResult selectByPage(Integer page, Integer limit) {
		int offset = (page - 1) * limit;
		List<Dept> list = deptMapper.selectByPage(offset, limit);
		
		int count = deptMapper.selectTotalCount();
		
		//LayUITableResult layUITableResult = new LayUITableResult(LayUITableResult.OK, count, limit);
		return LayUITableResult.ok(count, list);
	}

	@Override
	public void deleteById(Integer id) {
		deptMapper.deleteById(id);
		
	}

	@Override
	public void insert(Dept dept) {
		deptMapper.insert(dept);
	}

	@Override
	public void deleteAll(Integer[] ids) {
		for (Integer id : ids) {
			deptMapper.deleteById(id);
		}
	}

}
