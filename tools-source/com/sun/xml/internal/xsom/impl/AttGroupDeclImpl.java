package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSAttGroupDecl;
import com.sun.xml.internal.xsom.XSAttributeUse;
import com.sun.xml.internal.xsom.XSWildcard;
import com.sun.xml.internal.xsom.impl.parser.DelayedRef;
import com.sun.xml.internal.xsom.impl.parser.SchemaDocumentImpl;
import com.sun.xml.internal.xsom.visitor.XSFunction;
import com.sun.xml.internal.xsom.visitor.XSVisitor;
import java.util.Iterator;
import org.xml.sax.Locator;

public class AttGroupDeclImpl extends AttributesHolder implements XSAttGroupDecl {
   private WildcardImpl wildcard;

   public AttGroupDeclImpl(SchemaDocumentImpl _parent, AnnotationImpl _annon, Locator _loc, ForeignAttributesImpl _fa, String _name, WildcardImpl _wildcard) {
      this(_parent, _annon, _loc, _fa, _name);
      this.setWildcard(_wildcard);
   }

   public AttGroupDeclImpl(SchemaDocumentImpl _parent, AnnotationImpl _annon, Locator _loc, ForeignAttributesImpl _fa, String _name) {
      super(_parent, _annon, _loc, _fa, _name, false);
   }

   public void setWildcard(WildcardImpl wc) {
      this.wildcard = wc;
   }

   public XSWildcard getAttributeWildcard() {
      return this.wildcard;
   }

   public XSAttributeUse getAttributeUse(String nsURI, String localName) {
      UName name = new UName(nsURI, localName);
      XSAttributeUse o = null;

      for(Iterator itr = this.iterateAttGroups(); itr.hasNext() && o == null; o = ((XSAttGroupDecl)itr.next()).getAttributeUse(nsURI, localName)) {
      }

      if (o == null) {
         o = (XSAttributeUse)this.attributes.get(name);
      }

      return o;
   }

   public void redefine(AttGroupDeclImpl ag) {
      Iterator itr = this.attGroups.iterator();

      while(itr.hasNext()) {
         DelayedRef.AttGroup r = (DelayedRef.AttGroup)itr.next();
         r.redefine(ag);
      }

   }

   public void visit(XSVisitor visitor) {
      visitor.attGroupDecl(this);
   }

   public Object apply(XSFunction function) {
      return function.attGroupDecl(this);
   }
}
