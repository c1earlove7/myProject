package server.test.thread.consumer;

public class MainThread {
	
	public static void main(String[] args) {
		// 生产者和消费者使用同一个盘子
		Panzi panzi = new Panzi();
		// 启动生产者和消费者线程
		ConsumerThread consumerThread = new ConsumerThread("消费者线程", panzi);
		consumerThread.start();
		ProducerThread producerThread = new ProducerThread("生产者线程", panzi);
		producerThread.start();
	}
	
	
}
