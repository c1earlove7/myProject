package server.test.thread;

public class Demo {

	// 启动这个程序时候默认就有一个主线程
	public static void main(String[] args) {
//		while (true) {
//			System.out.println("Demo.main()");
//		}
		
		// 返回当前正在执行的线程的名字
		String name = Thread.currentThread().getName();
		System.out.println(name);//main
		for (int i = 0; i < 100; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(3);// milli seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	     }

		MyThread myThread = new MyThread("MyThread");
		// 这不是启动一个线程，这是调用对象里面一个普通方法run()方法
		// myThread.run();
		// 真正启动一个线程调用start()方法，执行的代码就是run()方法里面代码
		myThread.start();
		
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "MyRunnable");
		thread.start();
	}
}
