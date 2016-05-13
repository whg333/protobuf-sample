package com.whg;

import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.whg.protobuf.StudentProtoBuf;
import com.whg.protobuf.StudentProtoBuf.StudentProto;

public class Student {

	private long id;
	private int age;
	private boolean sex;
	private String name;
	
	public Student() {
		
	}

	public Student(StudentProto proto){
		id = proto.getId();
		age = proto.getAge();
		sex = proto.getSex();
		if(proto.hasName()){
			name = proto.getName();
		}
	}
	
	public byte[] toByteArray(){
		StudentProto.Builder builder = StudentProto.newBuilder();
		builder.setId(id);
		builder.setAge(age);
		builder.setSex(sex);
		if(name != null){
			builder.setName(name);
		}
		return builder.build().toByteArray();
	}
	
	public static Student parse(byte[] bytes){
		StudentProto proto = null;
		try {
			proto = StudentProto.parseFrom(bytes);
		} catch (InvalidProtocolBufferException ex) {
			throw new IllegalArgumentException(ex);
		}
		return new Student(proto);
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", sex=" + sex + ", name=" + name + "]";
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(300);
		student.setAge(30);
		// student.setSex(true);
		// student.setName("test");

		byte[] bytes = student.toByteArray();
		Parser.printHex(bytes);
		Parser.printInt(bytes);
		Parser.printBinary(bytes);

		// System.out.println(varintKey(1, 0));

		StudentProtoBuf.StudentProto.Builder builder = StudentProtoBuf.StudentProto.newBuilder();
		List<FieldDescriptor> fields = builder.getDescriptorForType().getFields();
		for (FieldDescriptor fieldDescriptor : fields) {
			System.out.println(fieldDescriptor.getIndex() + ":" + fieldDescriptor.getName());
		}

		Student student2 = Student.parse(bytes);
		System.out.println(student2.getId());
		System.out.println(student2.getAge());
	}
	
}
