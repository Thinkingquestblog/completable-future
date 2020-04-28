package com.devquest.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * {@link CompletableFuture} showing TimeOut feature
 *
 */
public class Sample4 {
	
public static void main(String[] args) {
	
		CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		
		//Complete with TimeoutException .
		future.orTimeout(2, TimeUnit.SECONDS);
		
		process(future);
		
		Integer data = ExternalService.getInteger();
		
		try {
			//Sleep for 3 seconds to timeout
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		future.complete(data);
		
		
	}
	
	/**
	 * The process method processes the data comes from the future.
	 *  
	 * @param future
	 */
	public static void process(CompletableFuture<Integer> future) {
		//when the future is completed apply a function to process the data
		//and then provide a Consumer to accept the processed data.
		future
			.exceptionally(throwable -> errorHandle(throwable))
			.thenApply(n -> n * 2)
			.thenAccept(System.out::println);
	}

	private static Integer errorHandle(Throwable throwable) {
		System.out.println("ERROR : " + throwable);
		throw new RuntimeException("Fatal error");
	}

}
