
public class MultithreadingDemo {

	public static void main(String[] args) {
		ThreadClassDemo t = new ThreadClassDemo();
		t.start();
		
		RunnableInterfaceDemo r = new RunnableInterfaceDemo();
		Thread rt = new Thread(r);
		rt.start();

	}

}
