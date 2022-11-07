package modelo;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final String OUTPUT_FORMAT = "%-20s:%s";

	private static byte[] digest(byte[] input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		byte[] result = md.digest(input);
		return result;
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));

		}

		return sb.toString();

	}

	public String encriptar(String st) {
		return bytesToHex(digest(st.getBytes(MD5.UTF_8)));

	}

	public static String getOutputFormat() {
		return OUTPUT_FORMAT;
	}
}
