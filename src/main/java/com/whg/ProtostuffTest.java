package com.whg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.whg.protobuf.StudentProtoBuf;
import com.whg.protobuf.StudentProtoBuf.StudentProto;

import net.webby.protostuff.runtime.Generators;

public class ProtostuffTest {

	public static void main(String[] args) throws InvalidProtocolBufferException {
//		testStudent();
		testClassroom();
	}

	private static void testClassroom() {
		Schema<Classroom> schema = RuntimeSchema.getSchema(Classroom.class);
		
		String content = Generators.newProtoGenerator(schema).generate();
		System.out.println(content);

		Classroom classroom = new Classroom();
		classroom.setId(666);

		List<Student> students = new ArrayList<Student>();
		Student student = new Student();
		student.setId(300);
		student.setAge(30);
		student.setSex(true);
		student.setName("test123测试一下");
		students.add(student);

		student = new Student();
		student.setId(200);
		student.setAge(20);
		student.setSex(false);
		student.setName("20测试一下");
		students.add(student);

		classroom.setStudents(students);
		
		int testCount = 1000000;
		
		byte[] bytes = classroom.toByteArray();
		long begin = System.currentTimeMillis();
		for(int i=0;i<testCount;i++){
			bytes = classroom.toByteArray();
		}
		System.out.println("JavaClass序列化:"+(System.currentTimeMillis()-begin));
		//Parser.printHex(bytes);
		//Parser.printInt(bytes);
		//Parser.printBinary(bytes);

		//这里必须使用ProtobufIOUtil而不是ProtostuffIOUtil
		//因为使用ProtostuffIOUtil的话，涉及到repeated嵌套对象结构的protobuf，
		//其产生的字节码数组和原生protobuf文件工具类产生的不一致，这是个严重的问题！
		LinkedBuffer buffer = LinkedBuffer.allocate(512);
		
		byte[] bytes2 = null;
		begin = System.currentTimeMillis();
		for(int i=0;i<testCount;i++){
			bytes2 = ProtobufIOUtil.toByteArray(classroom, schema, buffer);
			buffer.clear();
		}
		System.out.println("Protostuff序列化:"+(System.currentTimeMillis()-begin));
		
		System.out.println(Arrays.equals(bytes, bytes2));
		
		Classroom classroom2 = null;
		begin = System.currentTimeMillis();
		for(int i=0;i<testCount;i++){
			classroom2 = Classroom.parse(bytes);
		}
		System.out.println("JavaClass反序列化"+(System.currentTimeMillis()-begin));
		System.out.println("JavaClass\n" + classroom2);
		
		Classroom classroom3 = null;
		begin = System.currentTimeMillis();
		for(int i=0;i<testCount;i++){
			classroom3 = schema.newMessage();
			ProtobufIOUtil.mergeFrom(bytes, classroom3, schema);
		}
		System.out.println("Protostuff反序列化"+(System.currentTimeMillis()-begin));
		System.out.println("Protostuff\n" + classroom3);
	}

	private static void testStudent() throws InvalidProtocolBufferException {
		Student student = new Student();
		student.setId(300);
		student.setAge(30);
		student.setSex(true);
		student.setName("test123测试一下");
		byte[] bytes = student.toByteArray();
		
		StudentProtoBuf.StudentProto.Builder builder = StudentProtoBuf.StudentProto.newBuilder();
		builder.setId(300);
		builder.setAge(30);
		builder.setSex(true);
		builder.setName("test123测试一下");
		byte[] bytes2 = builder.build().toByteArray();
		System.out.println(Arrays.equals(bytes, bytes2));
		
		Schema<Student> schema = RuntimeSchema.getSchema(Student.class);
		LinkedBuffer buffer = LinkedBuffer.allocate(512);
		byte[] bytes3 = ProtobufIOUtil.toByteArray(student, schema, buffer);
		System.out.println(Arrays.equals(bytes, bytes3));
		
		Parser.printHex(bytes);
		Parser.printInt(bytes);
		Parser.printBinary(bytes);

		// System.out.println(varintKey(1, 0));

		studentByProtoBuilder(bytes);
		studentByJavaClass(bytes);
		studentByProtostuff(schema, bytes);
	}

	private static void studentByProtoBuilder(byte[] bytes) throws InvalidProtocolBufferException {
		StudentProto.Builder builder = StudentProto.newBuilder();
		List<FieldDescriptor> fields = builder.getDescriptorForType().getFields();
		for (FieldDescriptor fieldDescriptor : fields) {
			System.out.println(fieldDescriptor.getIndex() + ":" + fieldDescriptor.getName());
		}

		builder.mergeFrom(bytes);
		String s = "Student [id=" + builder.getId() + ", age=" + builder.getAge() + ", sex=" + builder.getSex()
				+ ", name=" + builder.getName() + "]";
		System.out.println("ProtoBuilder\n" + s);
	}

	private static void studentByJavaClass(byte[] bytes) {
		Student student = Student.parse(bytes);
		System.out.println("JavaClass\n" + student);
	}

	private static void studentByProtostuff(Schema<Student> schema, byte[] bytes) {
		Student student = schema.newMessage();
		ProtobufIOUtil.mergeFrom(bytes, student, schema);
		System.out.println("Protostuff\n" + student);
	}

}
