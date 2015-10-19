// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.hoolai.protobuf.test;

public final class StudentProtoBuf {
  private StudentProtoBuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface StudentOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // optional int64 id = 1;
    boolean hasId();
    long getId();
    
    // optional int32 age = 2;
    boolean hasAge();
    int getAge();
    
    // optional bool sex = 3;
    boolean hasSex();
    boolean getSex();
    
    // optional string name = 4;
    boolean hasName();
    String getName();
  }
  public static final class Student extends
      com.google.protobuf.GeneratedMessage
      implements StudentOrBuilder {
    // Use Student.newBuilder() to construct.
    private Student(Builder builder) {
      super(builder);
    }
    private Student(boolean noInit) {}
    
    private static final Student defaultInstance;
    public static Student getDefaultInstance() {
      return defaultInstance;
    }
    
    public Student getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hoolai.protobuf.test.StudentProtoBuf.internal_static_tutorial_Student_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hoolai.protobuf.test.StudentProtoBuf.internal_static_tutorial_Student_fieldAccessorTable;
    }
    
    private int bitField0_;
    // optional int64 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public long getId() {
      return id_;
    }
    
    // optional int32 age = 2;
    public static final int AGE_FIELD_NUMBER = 2;
    private int age_;
    public boolean hasAge() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public int getAge() {
      return age_;
    }
    
    // optional bool sex = 3;
    public static final int SEX_FIELD_NUMBER = 3;
    private boolean sex_;
    public boolean hasSex() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public boolean getSex() {
      return sex_;
    }
    
    // optional string name = 4;
    public static final int NAME_FIELD_NUMBER = 4;
    private Object name_;
    public boolean hasName() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          name_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      id_ = 0L;
      age_ = 0;
      sex_ = false;
      name_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, age_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBool(3, sex_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getNameBytes());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, age_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, sex_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getNameBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    @java.lang.Override
    protected Object writeReplace() throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.hoolai.protobuf.test.StudentProtoBuf.Student parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.hoolai.protobuf.test.StudentProtoBuf.Student prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.hoolai.protobuf.test.StudentProtoBuf.StudentOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.hoolai.protobuf.test.StudentProtoBuf.internal_static_tutorial_Student_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.hoolai.protobuf.test.StudentProtoBuf.internal_static_tutorial_Student_fieldAccessorTable;
      }
      
      // Construct using com.hoolai.protobuf.test.StudentProtoBuf.Student.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        id_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        age_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        sex_ = false;
        bitField0_ = (bitField0_ & ~0x00000004);
        name_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.hoolai.protobuf.test.StudentProtoBuf.Student.getDescriptor();
      }
      
      public com.hoolai.protobuf.test.StudentProtoBuf.Student getDefaultInstanceForType() {
        return com.hoolai.protobuf.test.StudentProtoBuf.Student.getDefaultInstance();
      }
      
      public com.hoolai.protobuf.test.StudentProtoBuf.Student build() {
        com.hoolai.protobuf.test.StudentProtoBuf.Student result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.hoolai.protobuf.test.StudentProtoBuf.Student buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        com.hoolai.protobuf.test.StudentProtoBuf.Student result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.hoolai.protobuf.test.StudentProtoBuf.Student buildPartial() {
        com.hoolai.protobuf.test.StudentProtoBuf.Student result = new com.hoolai.protobuf.test.StudentProtoBuf.Student(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.age_ = age_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.sex_ = sex_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.name_ = name_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.hoolai.protobuf.test.StudentProtoBuf.Student) {
          return mergeFrom((com.hoolai.protobuf.test.StudentProtoBuf.Student)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.hoolai.protobuf.test.StudentProtoBuf.Student other) {
        if (other == com.hoolai.protobuf.test.StudentProtoBuf.Student.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasAge()) {
          setAge(other.getAge());
        }
        if (other.hasSex()) {
          setSex(other.getSex());
        }
        if (other.hasName()) {
          setName(other.getName());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              age_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              sex_ = input.readBool();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              name_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // optional int64 id = 1;
      private long id_ ;
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public long getId() {
        return id_;
      }
      public Builder setId(long value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0L;
        onChanged();
        return this;
      }
      
      // optional int32 age = 2;
      private int age_ ;
      public boolean hasAge() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public int getAge() {
        return age_;
      }
      public Builder setAge(int value) {
        bitField0_ |= 0x00000002;
        age_ = value;
        onChanged();
        return this;
      }
      public Builder clearAge() {
        bitField0_ = (bitField0_ & ~0x00000002);
        age_ = 0;
        onChanged();
        return this;
      }
      
      // optional bool sex = 3;
      private boolean sex_ ;
      public boolean hasSex() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public boolean getSex() {
        return sex_;
      }
      public Builder setSex(boolean value) {
        bitField0_ |= 0x00000004;
        sex_ = value;
        onChanged();
        return this;
      }
      public Builder clearSex() {
        bitField0_ = (bitField0_ & ~0x00000004);
        sex_ = false;
        onChanged();
        return this;
      }
      
      // optional string name = 4;
      private Object name_ = "";
      public boolean hasName() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setName(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        name_ = value;
        onChanged();
        return this;
      }
      public Builder clearName() {
        bitField0_ = (bitField0_ & ~0x00000008);
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      void setName(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000008;
        name_ = value;
        onChanged();
      }
      
      // @@protoc_insertion_point(builder_scope:tutorial.Student)
    }
    
    static {
      defaultInstance = new Student(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:tutorial.Student)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Student_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_tutorial_Student_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rStudent.proto\022\010tutorial\"=\n\007Student\022\n\n\002" +
      "id\030\001 \001(\003\022\013\n\003age\030\002 \001(\005\022\013\n\003sex\030\003 \001(\010\022\014\n\004na" +
      "me\030\004 \001(\tB+\n\030com.hoolai.protobuf.testB\017St" +
      "udentProtoBuf"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_tutorial_Student_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_tutorial_Student_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_tutorial_Student_descriptor,
              new java.lang.String[] { "Id", "Age", "Sex", "Name", },
              com.hoolai.protobuf.test.StudentProtoBuf.Student.class,
              com.hoolai.protobuf.test.StudentProtoBuf.Student.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}