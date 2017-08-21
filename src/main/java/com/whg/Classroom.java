package com.whg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.protobuf.InvalidProtocolBufferException;
import com.whg.protobuf.StudentProtoBuf.ClassroomProto;

public class Classroom {

	private int id;
	private List<Student> students = new ArrayList<Student>();
	
	public Classroom() {
		
	}

	public Classroom(ClassroomProto proto){
		id = proto.getId();
		int c = proto.getStudentsCount();
		for(int i=0;i<c;i++){
			students.add(new Student(proto.getStudents(i)));
		}
	}
	
	public byte[] toByteArray(){
		ClassroomProto.Builder builder = ClassroomProto.newBuilder();
		builder.setId(id);
		for(Student student:students){
			builder.addStudents(student.toProto());
		}
		return builder.build().toByteArray();
	}
	
	public static Classroom parse(byte[] bytes){
		ClassroomProto proto = null;
		try {
			proto = ClassroomProto.parseFrom(bytes);
		} catch (InvalidProtocolBufferException ex) {
			throw new IllegalArgumentException(ex);
		}
		return new Classroom(proto);
	}
	
	@Override
	public String toString() {
		return "Classroom [id=" + id + ", students=" + Arrays.toString(students.toArray()) + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
