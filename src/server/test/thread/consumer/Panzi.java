package server.test.thread.consumer;

import java.util.LinkedList;

public class Panzi {
	// 使用LinkedList来模拟队列的操作，队列的尾部添加，头部删除
	private LinkedList<Cake> list = new LinkedList<Cake>();
	
	/**
	 * 生产了蛋糕放到盘子里面
	 * @param cake
	 */
	public synchronized void putCake(Cake cake) {
		// 在队列的尾部添加蛋糕
		list.addLast(cake);
		notifyAll();// 生产了蛋糕之后要通知那些正在wait的消费者
		System.out.println("生产者线程 putCake notifyAll " + cake);
	}
	
	/**
	 * 从盘子里面拿出蛋糕来吃
	 * @return
	 */
	public synchronized Cake getCake() {
		if (list.size() <= 0) {// 盘子里面没有蛋糕
			try {
				System.out.println("消费者线程 getCake wait");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 删除队列头部的蛋糕
		Cake cake = list.removeFirst();
		return cake;
	}

}
