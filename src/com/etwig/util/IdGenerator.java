package com.etwig.util;

public class IdGenerator {

	public static String generateCustomerId() {
		return "CUST" + System.currentTimeMillis();
	}
}
