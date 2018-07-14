package comn.th.demo;

public class MyThread2 extends Thread {

	@Override
	public void run() {
		System.out.println("In Thread 2");
	}

	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();
		th1.start();
		MyThread2 th2 = new MyThread2();
		th2.start();
		MyThread3 th3 = new MyThread3();
		th3.start();
	}
}
