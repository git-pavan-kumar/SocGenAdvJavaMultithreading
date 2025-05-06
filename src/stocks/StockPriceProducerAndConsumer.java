package stocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class StockPriceProducerAndConsumer {

	public static void main(String[] args) {
		
		ScheduledExecutorService producerExecutor = Executors.newScheduledThreadPool(2);
		ScheduledExecutorService consumerExecutor = Executors.newScheduledThreadPool(2);
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		List<Integer> amazon = new ArrayList<>();
		List<Integer> google = new ArrayList<>();
		
		Map<String, Integer> result = new HashMap<>();
		
		Callable<Map<String, Integer>> producer = new Callable<Map<String, Integer>>() {
			@Override
			public Map<String, Integer> call() {
				while(true) {
					System.out.println("Updating latest prices ...");
					int amazonLatestPrice = (int) (Math.random() * 1.14);
					int googleLatestPrice = (int) (Math.random() * 5.25);
					amazon.add(amazonLatestPrice);
					google.add(googleLatestPrice);
					return Map.of("amazon", amazonLatestPrice,
							"google", googleLatestPrice);
				}
				
			}
		};
		
		ScheduledFuture<Map<String, Integer>> future = producerExecutor.schedule(producer, 5, TimeUnit.SECONDS);
		//Future<Map<String, Integer>> future = executorService.submit(producer);
		try {
			Map<String, Integer> retVal = future.get();
			System.out.println("Return value: " + retVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		
		
		/*Runnable consRunnable = new Runnable() {
			@Override
			public void run() {
				//result.clear();
				//result.put("amazon", amazon.getLast());
				//result.put("google", google.getLast());

				System.out.println("amazon latest price: " + amazon.getLast());
				System.out.println("google latest price: " + google.getLast());
			
				
			}
		};
		

		producerExecutor.schedule(prodRunnable, 10, TimeUnit.SECONDS);
		//consumerExecutor.schedule(consRunnable, 5, TimeUnit.SECONDS);
		
		producerExecutor.shutdown();
		//consumerExecutor.shutdown();*/
	}

}
