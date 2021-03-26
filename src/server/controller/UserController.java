package server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import server.entity.Dept;
import server.entity.User;
import server.service.IDeptService;
import server.service.IUserService;
import server.util.JSONResult;
import server.util.LayUITableResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IDeptService deptService;
	

	
	@RequestMapping("/selectAll")
	@ResponseBody
	public List<User> selectAll() {
		List<User> list = userService.selectAll();
		return list;
	}
	
	// /user/selectByPage?page=1&limit=10
	@RequestMapping("/selectByPage")
	@ResponseBody
	public LayUITableResult selectByPage(Integer page, Integer limit) {
		System.out.println("UserController.selectByPage()");
		LayUITableResult layUITableResult = userService.selectByPage(page, limit);
		return layUITableResult;
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public JSONResult deleteById(Integer id) {
		System.out.println("UserController.deleteById()");
		userService.deleteById(id);
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public JSONResult deleteAll(Integer[] ids) { // "1,2"
		System.out.println("UserController.deleteAll()");
		userService.deleteAll(ids);
		return JSONResult.ok("删除成功");
	}
	
	@RequestMapping("/getUserInsertPage")
	public String getUserInsertPage(Model model) {
		List<Dept> list = deptService.selectAll();
		model.addAttribute("list", list);
		return "/user_insert.jsp";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public JSONResult insert(User user) {
		userService.insert(user);
		return JSONResult.ok("删除成功");
	}
}
