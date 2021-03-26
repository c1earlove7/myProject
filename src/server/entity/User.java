package server.entity;

public class User {
	private Integer id;
	private String name;
	private String password;
	private Integer age;
	private String email;
	private Integer deptId;

	public User() {
		super();
	}

	public User(Integer id, String name, String password, Integer age, String email, Integer deptId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.deptId = deptId;
	}
	
	public User(String name, String password, Integer age, String email, Integer departmentId) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.email = email;
		this.deptId = deptId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", email=" + email
				+ ", deptId=" + deptId + "]";
	}

}
