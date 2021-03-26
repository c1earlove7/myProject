package server.test.thread.consumer;

import java.util.Random;

public class ProducerThread extends Thread{
	private Panzi panzi;
	
	public ProducerThread(String name, Panzi panzi) {
		super(name);
		this.panzi = panzi;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			Cake cake = new Cake("no:" + i);
			// 生产了一个蛋糕之后就放到盘子里
			panzi.putCake(cake);
			
			// 随机生成等待的时间，模拟生产蛋糕这个过程
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
