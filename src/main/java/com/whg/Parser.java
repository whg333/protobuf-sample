package com.whg;

public enum Parser {
	hex {
		public String parse(byte b) {
			int result = b & 0xff;
			String resutString = Integer.toHexString(result);
			return resutString.length() == 1 ? "0x0" + resutString : "0x" + resutString;
		}
	},
	Int {
		public String parse(byte b) {
			return (b & 0xff) + "";
		}
	},
	binary {
		public String parse(byte b) {
			int result = b & 0xff;
			StringBuilder sb = new StringBuilder(Integer.toBinaryString(result));
			while (sb.length() < 8) {
				sb.insert(0, "0");
			}
			return sb.toString();
		}
	};

	public abstract String parse(byte b);
	
	public static void printHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(hex.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}

	public static void printInt(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(Int.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}

	public static void printBinary(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(binary.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}
}