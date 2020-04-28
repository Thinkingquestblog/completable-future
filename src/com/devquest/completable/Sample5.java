package com.devquest.completable;

import java.util.concurrent.CompletableFuture;

/**
 * Example showing combining two {@link CompletableFuture}
 *
 */
public class Sample5 {
	
	public static CompletableFuture<Integer> create (int n){
		return CompletableFuture.supplyAsync(() -> n);
	}
	
	public static void main(String[] args) {
		create(10).thenCombine(create(20), (x, y) -> x + y)
		.thenAccept(System.out::println);
	}
}
