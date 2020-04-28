package com.devquest.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Test {
	
	public static void main(String[] args) {
	    CompletableFuture<Integer> resultFuture = CompletableFuture.supplyAsync(() -> compute(10));
	    resultFuture.thenAccept(System.out::println);
	}
	
	private static int compute(int n) {
		return n * 2;
	}


}
