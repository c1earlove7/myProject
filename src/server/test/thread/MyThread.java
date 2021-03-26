package server.test.thread;

public class MyThread extends Thread{

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 100; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(3);// milli seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	     }
	}
}
