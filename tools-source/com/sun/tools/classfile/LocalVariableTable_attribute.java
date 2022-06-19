package com.sun.tools.classfile;

import java.io.IOException;

public class LocalVariableTable_attribute extends Attribute {
   public final int local_variable_table_length;
   public final Entry[] local_variable_table;

   LocalVariableTable_attribute(ClassReader var1, int var2, int var3) throws IOException {
      super(var2, var3);
      this.local_variable_table_length = var1.readUnsignedShort();
      this.local_variable_table = new Entry[this.local_variable_table_length];

      for(int var4 = 0; var4 < this.local_variable_table_length; ++var4) {
         this.local_variable_table[var4] = new Entry(var1);
      }

   }

   public LocalVariableTable_attribute(ConstantPool var1, Entry[] var2) throws ConstantPoolException {
      this(var1.getUTF8Index("LocalVariableTable"), var2);
   }

   public LocalVariableTable_attribute(int var1, Entry[] var2) {
      super(var1, 2 + var2.length * LocalVariableTable_attribute.Entry.length());
      this.local_variable_table_length = var2.length;
      this.local_variable_table = var2;
   }

   public Object accept(Attribute.Visitor var1, Object var2) {
      return var1.visitLocalVariableTable(this, var2);
   }

   public static class Entry {
      public final int start_pc;
      public final int length;
      public final int name_index;
      public final int descriptor_index;
      public final int index;

      Entry(ClassReader var1) throws IOException {
         this.start_pc = var1.readUnsignedShort();
         this.length = var1.readUnsignedShort();
         this.name_index = var1.readUnsignedShort();
         this.descriptor_index = var1.readUnsignedShort();
         this.index = var1.readUnsignedShort();
      }

      public static int length() {
         return 10;
      }
   }
}