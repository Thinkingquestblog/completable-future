package com.devquest.completable;

import java.util.concurrent.CompletableFuture;

/**
 * {@link CompletableFuture} that completed exceptionally
 *
 */
public class Sample3 {
	
public static void main(String[] args) {
	
		CompletableFuture<Integer> future = new CompletableFuture<Integer>();
		process(future);
		//complete the future with an exception
		future.completeExceptionally(new RuntimeException("Error from external service"));
		
	}
	
	/**
	 * The process method processes the data comes from the future.
	 *  
	 * @param future
	 */
	public static void process(CompletableFuture<Integer> future) {
		future
			.exceptionally(throwable -> errorHandle(throwable))
			.thenApply(n -> n * 2)
			.thenAccept(System.out::println);
	}

	private static Integer errorHandle(Throwable throwable) {
		System.out.println("ERROR : " + throwable.getMessage());
		return 100;
	}

}
