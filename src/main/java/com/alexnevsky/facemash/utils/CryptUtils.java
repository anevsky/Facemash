package com.alexnevsky.facemash.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: Alex Nevsky
 * Date: 25.10.13
 */
public class CryptUtils {

	public static final String SOLT = "";


	/**
	 * Generate MD5 hash for the given String. MD5 is kind of an one-way encryption.
	 * Very useful for hashing passwords before saving in database. This function
	 * generates exactly the same hash as MySQL's own md5() function should do.
	 *
	 * @param string
	 *            The String to generate the MD5 hash for.
	 * @return The 32-char hexadecimal MD5 hash of the given String.
	 */
	public static String hashMD5(String string) {
		byte[] hash;

		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			// Unexpected exception. "MD5" is just hardcoded and supported.
			throw new RuntimeException("MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			// Unexpected exception. "UTF-8" is just hardcoded and supported.
			throw new RuntimeException("UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xff) < 0x10) {
				hex.append("0");
			}
			hex.append(Integer.toHexString(b & 0xff));
		}
		return hex.toString();
	}

	/**
	 * Generate SHA512 hash for the given String. SHA512 is kind of an one-way encryption.
	 *
	 * @param string
	 *            The String to generate the SHA512 hash for.
	 * @return The 128-char hexadecimal SHA512 hash of the given String.
	 */
	public static String hashSHA512(String string) {
		byte[] hash;

		try {
			hash = MessageDigest.getInstance("SHA-512").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			// Unexpected exception. "SHA-512" is just hardcoded and supported.
			throw new RuntimeException("SHA-512 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			// Unexpected exception. "UTF-8" is just hardcoded and supported.
			throw new RuntimeException("UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xff) < 0x10) {
				hex.append("0");
			}
			hex.append(Integer.toHexString(b & 0xff));
		}
		return hex.toString();
	}
}
