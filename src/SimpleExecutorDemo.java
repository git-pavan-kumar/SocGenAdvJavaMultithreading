import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleExecutorDemo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		//Runnable Demo:
		Runnable runnable = new Runnable() {	
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		};
		executorService.execute(runnable);
		
		
		
		//Callable Demo:
		Callable<Integer> callable = new Callable<Integer>() {
			@Override
			public Integer call() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 1000;
			}
		};
		Future<Integer> future = executorService.submit(callable);
		try {
			Integer retVal = future.get();
			System.out.println("Return value: " + retVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		executorService.shutdown();
	}

}
