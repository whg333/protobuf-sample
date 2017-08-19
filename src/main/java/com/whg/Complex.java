package com.whg;

import java.util.List;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.whg.protobuf.ComplexProtoBuf;

public class Complex {

	public static void main(String[] args) throws InvalidProtocolBufferException {
		ComplexProtoBuf.Car.Vendor.Address.Builder address = ComplexProtoBuf.Car.Vendor.Address.newBuilder();
		address.setCountry("中国");
		ComplexProtoBuf.Car.Vendor.Builder vendor = ComplexProtoBuf.Car.Vendor.newBuilder();
		vendor.setName("宝马供应商");
		vendor.setAddress(address);
		ComplexProtoBuf.Car.Builder car = ComplexProtoBuf.Car.newBuilder();
		car.setModel("测试");
		car.setVendor(vendor);
		car.setSpeed(ComplexProtoBuf.Car.Speed.SUPERFAST);

		byte[] bytes = car.build().toByteArray();
		Parser.printHex(bytes);
		Parser.printInt(bytes);
		Parser.printBinary(bytes);

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
		System.out.println(car.getSpeed());
	}

	/*
	 * public static void main(String[] args) { byte val = -2; String
	 * binaryString = Integer.toBinaryString(val & 0xFF);
	 * System.out.println(binaryString); BigInteger bi = new
	 * BigInteger(binaryString, 2); System.out.println(bi.byteValue()); }
	 */

	private static boolean isCurrentByteEnd(byte b) {
		return (b & 100000000) == 0;
	}

	public static String varintKey(int field_number, int wire_type) {
		int result = (field_number << 3) | wire_type;
		String resutString = Integer.toHexString(result);
		return resutString;
	}

}
