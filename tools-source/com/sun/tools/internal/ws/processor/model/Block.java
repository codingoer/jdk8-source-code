package com.sun.tools.internal.ws.processor.model;

import com.sun.tools.internal.ws.wsdl.framework.Entity;
import javax.xml.namespace.QName;

public class Block extends ModelObject {
   public static final int UNBOUND = 0;
   public static final int BODY = 1;
   public static final int HEADER = 2;
   public static final int ATTACHMENT = 3;
   private final QName name;
   private AbstractType type;
   private int location;

   public Block(QName name, AbstractType type, Entity entity) {
      super(entity);
      this.name = name;
      this.type = type;
   }

   public QName getName() {
      return this.name;
   }

   public AbstractType getType() {
      return this.type;
   }

   public void setType(AbstractType type) {
      this.type = type;
   }

   public int getLocation() {
      return this.location;
   }

   public void setLocation(int i) {
      this.location = i;
   }

   public void accept(ModelVisitor visitor) throws Exception {
      visitor.visit(this);
   }
}
