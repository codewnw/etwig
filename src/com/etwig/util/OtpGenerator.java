package com.etwig.util;

public class OtpGenerator {
	public static int getOtp() {
		return (int) (Math.random() * 10000);
	}
}
