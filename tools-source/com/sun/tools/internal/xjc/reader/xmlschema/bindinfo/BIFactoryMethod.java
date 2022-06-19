package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import com.sun.tools.internal.xjc.model.CPropertyInfo;
import com.sun.tools.internal.xjc.reader.Ring;
import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;
import com.sun.xml.internal.xsom.XSComponent;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement(
   name = "factoryMethod"
)
public class BIFactoryMethod extends AbstractDeclarationImpl {
   @XmlAttribute
   public String name;
   public static final QName NAME = new QName("http://java.sun.com/xml/ns/jaxb", "factoryMethod");

   public static void handle(XSComponent source, CPropertyInfo prop) {
      BIInlineBinaryData inline = (BIInlineBinaryData)((BGMBuilder)Ring.get(BGMBuilder.class)).getBindInfo(source).get(BIInlineBinaryData.class);
      if (inline != null) {
         prop.inlineBinaryData = true;
         inline.markAsAcknowledged();
      }

   }

   public final QName getName() {
      return NAME;
   }
}