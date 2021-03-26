package server.test.thread;

public class JoinExample {
	public static void main(String[] args) throws InterruptedException {
//		// 匿名内部类
//		Thread thread = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//			}
//		});
//		thread.start();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("First task started");
				System.out.println("Sleeping for 2 seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task completed");
			}
		});
		t1.start();
		t1.join(); // Main线程等待t1线程执行完毕，在执行下面的操作
		t2.start();
	}
}
