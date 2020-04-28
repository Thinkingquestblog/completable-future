package com.devquest.completable;

public class ExternalService {
	public static Integer getInteger() {
		//System.out.println("ExternalService : " + Thread.currentThread().getName());
		return 10;
	}

}
