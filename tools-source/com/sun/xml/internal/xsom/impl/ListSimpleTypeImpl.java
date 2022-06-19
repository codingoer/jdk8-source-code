package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSFacet;
import com.sun.xml.internal.xsom.XSListSimpleType;
import com.sun.xml.internal.xsom.XSSimpleType;
import com.sun.xml.internal.xsom.XSVariety;
import com.sun.xml.internal.xsom.impl.parser.SchemaDocumentImpl;
import com.sun.xml.internal.xsom.visitor.XSSimpleTypeFunction;
import com.sun.xml.internal.xsom.visitor.XSSimpleTypeVisitor;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.xml.sax.Locator;

public class ListSimpleTypeImpl extends SimpleTypeImpl implements XSListSimpleType {
   private final Ref.SimpleType itemType;

   public ListSimpleTypeImpl(SchemaDocumentImpl _parent, AnnotationImpl _annon, Locator _loc, ForeignAttributesImpl _fa, String _name, boolean _anonymous, Set finalSet, Ref.SimpleType _itemType) {
      super(_parent, _annon, _loc, _fa, _name, _anonymous, finalSet, _parent.getSchema().parent.anySimpleType);
      this.itemType = _itemType;
   }

   public XSSimpleType getItemType() {
      return this.itemType.getType();
   }

   public void visit(XSSimpleTypeVisitor visitor) {
      visitor.listSimpleType(this);
   }

   public Object apply(XSSimpleTypeFunction function) {
      return function.listSimpleType(this);
   }

   public XSFacet getFacet(String name) {
      return null;
   }

   public List getFacets(String name) {
      return Collections.EMPTY_LIST;
   }

   public XSVariety getVariety() {
      return XSVariety.LIST;
   }

   public XSSimpleType getPrimitiveType() {
      return null;
   }

   public XSListSimpleType getBaseListType() {
      return this;
   }

   public boolean isList() {
      return true;
   }

   public XSListSimpleType asList() {
      return this;
   }
}
