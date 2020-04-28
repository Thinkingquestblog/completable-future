package com.devquest.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * Simple {@link CompletableFuture} example with default {@link ForkJoinPool}
 * 
 */
public class Sample1 {
	
	public static void main(String[] args) {
		
		//define an empty future
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> ExternalService.getInteger());
		
		//send it to process method, which will process the data when its available
		process(future);
		
	}
	
	/**
	 * The process method processes the data comes from the future.
	 *  
	 * @param future
	 */
	public static void process(CompletableFuture<Integer> future) {
		//when the future is completed apply a function to process the data
		//and then provide a Consumer to accept the processed data.
		future.thenApply(n -> n * 2)
		.thenAccept(d -> System.out.println("Restult: " + d));
	}
	
}
