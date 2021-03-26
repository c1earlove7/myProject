package server.util;

// LayUI table需要返回的结构
public class LayUITableResult {
	public static final int ERROR = 1;
	public static final int OK = 0;
	public static final int NOT_LOGIN = 2;

	private Integer code;
	private String msg;
	private Object data;
	// 数据库中总的数量，layui table拿到数量之后自己算总的页数
	private Integer count;

	public LayUITableResult() {
	}

	public LayUITableResult(Integer code, Object data, Integer count) {
		super();
		this.code = code;
		this.data = data;
		this.count = count;
	}

	// 告诉前台成功：code、data、count
	public static LayUITableResult ok(Integer count, Object data) {
		return new LayUITableResult(OK, data, count);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
