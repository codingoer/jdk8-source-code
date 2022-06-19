package com.sun.tools.internal.ws.wsdl.parser;

import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensible;
import com.sun.tools.internal.ws.api.wsdl.TWSDLExtensionHandler;
import com.sun.tools.internal.ws.api.wsdl.TWSDLParserContext;
import com.sun.tools.internal.ws.util.xml.XmlUtil;
import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.NamespaceVersion;
import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken;
import org.w3c.dom.Element;

public class Policy15ExtensionHandler extends TWSDLExtensionHandler {
   public String getNamespaceURI() {
      return NamespaceVersion.v1_5.toString();
   }

   public boolean handlePortTypeExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleDefinitionsExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleBindingExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleOperationExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleInputExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleOutputExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleFaultExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handleServiceExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   public boolean handlePortExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return this.handleExtension(context, parent, e);
   }

   private boolean handleExtension(TWSDLParserContext context, TWSDLExtensible parent, Element e) {
      return XmlUtil.matchesTagNS(e, NamespaceVersion.v1_5.asQName(XmlToken.Policy)) || XmlUtil.matchesTagNS(e, NamespaceVersion.v1_5.asQName(XmlToken.PolicyReference)) || XmlUtil.matchesTagNS(e, NamespaceVersion.v1_5.asQName(XmlToken.UsingPolicy));
   }
}
