package com.devquest.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * {@link CompletableFuture} with supplied {@link ThreadPoolExecutor}
 * @author Jaikumar
 *
 */
public class Sample2 {
	
public static void main(String[] args) {
	
		ForkJoinPool fjp = new ForkJoinPool();
		
		//define an empty future
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> ExternalService.getInteger(), fjp);
		
		//send it to process method, which will proecss the data when its available
		process(future);
		
	}
		
	/**
	 * The process method processes the data comes from the future.
	 *  
	 * @param future
	 */
	public static void process(CompletableFuture<Integer> future) {
		future.thenApply(n -> n * 2)
		.thenAccept(result -> System.out.println("Result: " + result));
	}

}
