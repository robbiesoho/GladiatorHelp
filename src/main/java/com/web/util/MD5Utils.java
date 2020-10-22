package com.web.util;

//stolen from https://mkyong.com/java/java-md5-hashing-example/

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final String OUTPUT_FORMAT = "%-20s:%s";

	public static byte[] digest(byte[] input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		byte[] result = md.digest(input);
		return result;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		String pText = "pass";
		System.out.println(String.format(OUTPUT_FORMAT, "Input (string)", pText));
		System.out.println(String.format(OUTPUT_FORMAT, "Input (length)", pText.length()));

		byte[] md5InBytes = MD5Utils.digest(pText.getBytes(UTF_8));
		System.out.println(String.format(OUTPUT_FORMAT, "MD5 (hex) ", bytesToHex(md5InBytes)));
		// fixed length, 16 bytes, 128 bits.
		System.out.println(String.format(OUTPUT_FORMAT, "MD5 (length)", md5InBytes.length));

	}

}