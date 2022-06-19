package com.sun.xml.internal.rngom.nc;

import javax.xml.namespace.QName;

final class NullNameClass extends NameClass {
   protected NullNameClass() {
   }

   public boolean contains(QName name) {
      return false;
   }

   public int containsSpecificity(QName name) {
      return -1;
   }

   public int hashCode() {
      return NullNameClass.class.hashCode();
   }

   public boolean equals(Object obj) {
      return this == obj;
   }

   public Object accept(NameClassVisitor visitor) {
      return visitor.visitNull();
   }

   public boolean isOpen() {
      return false;
   }

   private Object readResolve() {
      return NameClass.NULL;
   }
}
