package com.hoolai;

import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.hoolai.protobuf.test.ComplexProtoBuf;

public class Complex {

	enum Parser {
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
	}

	public static void main(String[] args) throws InvalidProtocolBufferException {
		ComplexProtoBuf.Car.Vendor.Address.Builder address = ComplexProtoBuf.Car.Vendor.Address.newBuilder();
		address.setCountry("中国");
		ComplexProtoBuf.Car.Vendor.Builder vendor = ComplexProtoBuf.Car.Vendor.newBuilder();
		vendor.setName("宝马供应商");
		vendor.setAddress(address);
		ComplexProtoBuf.Car.Builder car = ComplexProtoBuf.Car.newBuilder();
		car.setModel("测试");
		car.setVendor(vendor);

		// studentProtoBuf.setSex(true);
		// studentProtoBuf.setName("test");

		byte[] bytes = car.build().toByteArray();
		printHex(bytes);
		printInt(bytes);
		printBinary(bytes);

		// System.out.println(varintKey(1, 0));

		List<FieldDescriptor> fields = car.getDescriptorForType().getFields();
		for (FieldDescriptor fieldDescriptor : fields) {
			System.out.println(fieldDescriptor.getIndex() + ":" + fieldDescriptor.getName());
		}

		car = ComplexProtoBuf.Car.newBuilder();
		car.mergeFrom(bytes);
		System.out.println(car.getVendor().getAddress().getCountry());
		System.out.println(car.getVendor().getName());
		System.out.println(car.getModel());
	}

	/*
	 * public static void main(String[] args) { byte val = -2; String
	 * binaryString = Integer.toBinaryString(val & 0xFF);
	 * System.out.println(binaryString); BigInteger bi = new
	 * BigInteger(binaryString, 2); System.out.println(bi.byteValue()); }
	 */

	private static void printHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(Parser.hex.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}

	private static void printInt(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(Parser.Int.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}

	private static void printBinary(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(Parser.binary.parse(b));
			builder.append(":");
		}
		System.out.println(builder.toString());
	}

	private static boolean isCurrentByteEnd(byte b) {
		return (b & 100000000) == 0;
	}

	public static String varintKey(int field_number, int wire_type) {
		int result = (field_number << 3) | wire_type;
		String resutString = Integer.toHexString(result);
		return resutString;
	}

}
