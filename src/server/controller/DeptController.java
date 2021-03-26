package server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import server.entity.Dept;
import server.service.IDeptService;
import server.util.JSONResult;
import server.util.LayUITableResult;
// @Controller @Service  注解的开发方式 上一层只能看到下一层的接口
// @Autowired 匹配的是数据类型   如果有多个实现类 .通过@Qualifier注解来指明使用哪一个实现类，实际上也是通过byName的方式实现
@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private IDeptService deptService;
	

	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<Dept> selectAll() {
		List<Dept> list = deptService.selectAll();
		return list;
	}
	
	// /dept/selectByPage?page=1&limit=10
	@RequestMapping("/selectByPage")
	@ResponseBody
	public LayUITableResult selectByPage(Integer page, Integer limit) {
		System.out.println("DeptController.selectByPage()");
		LayUITableResult layUITableResult = deptService.selectByPage(page, limit);
		return layUITableResult;
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public JSONResult deleteById(Integer id) {
		System.out.println("DeptController.deleteById()");
		deptService.deleteById(id);
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public JSONResult deleteAll(Integer[] ids) { // "1,2"
		System.out.println("DeptController.deleteAll()");
		deptService.deleteAll(ids);
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/getDeptInsertPage")
	public String getDeptInsertPage(Model model) {
		return "/dept_insert.jsp";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public JSONResult insert(Dept dept) {
		deptService.insert(dept);
		return JSONResult.ok("删除成功");
	}
}
