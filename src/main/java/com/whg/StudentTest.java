package com.whg;

import java.util.List;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.whg.protobuf.StudentProtoBuf;

public class StudentTest {

	public static void main(String[] args) throws InvalidProtocolBufferException {
		StudentProtoBuf.StudentProto.Builder builder = StudentProtoBuf.StudentProto.newBuilder();
		builder.setId(300);
		builder.setAge(30);
		builder.setSex(true);
		// studentProtoBuf.setName("test");

		byte[] bytes = builder.build().toByteArray();
		Parser.printHex(bytes);
		Parser.printInt(bytes);
		Parser.printBinary(bytes);

		// System.out.println(varintKey(1, 0));

		List<FieldDescriptor> fields = builder.getDescriptorForType().getFields();
		for (FieldDescriptor fieldDescriptor : fields) {
			System.out.println(fieldDescriptor.getIndex() + ":" + fieldDescriptor.getName());
		}

		StudentProtoBuf.StudentProto.Builder builder2 = StudentProtoBuf.StudentProto.newBuilder();
		builder2.mergeFrom(bytes);
		System.out.println(builder2.getId());
		System.out.println(builder2.getAge());
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
