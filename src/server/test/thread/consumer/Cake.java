package server.test.thread.consumer;

public class Cake {
	// 蛋糕的编号
	private String name;
	
	public Cake() {
		super();
	}

	public Cake(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cake [name=" + name + "]";
	}
	
	
	
}
