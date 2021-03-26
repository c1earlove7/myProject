package server.test.thread.consumer;

import java.util.Random;

public class ConsumerThread extends Thread{
	private Panzi panzi;
	
	public ConsumerThread(String name, Panzi panzi) {
		super(name);
		this.panzi = panzi;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			// 消费者从盘子里面拿蛋糕吃
			Cake cake = panzi.getCake();
			System.out.println(Thread.currentThread().getName() + " getCake: " + cake);
			
			// 随机生成等待的时间，模拟生产蛋糕这个过程
			try {
				Thread.sleep(new Random().nextInt(5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
