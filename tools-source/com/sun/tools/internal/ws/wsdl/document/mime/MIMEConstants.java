package com.sun.tools.internal.ws.wsdl.document.mime;

import javax.xml.namespace.QName;

public interface MIMEConstants {
   String NS_WSDL_MIME = "http://schemas.xmlsoap.org/wsdl/mime/";
   QName QNAME_CONTENT = new QName("http://schemas.xmlsoap.org/wsdl/mime/", "content");
   QName QNAME_MULTIPART_RELATED = new QName("http://schemas.xmlsoap.org/wsdl/mime/", "multipartRelated");
   QName QNAME_PART = new QName("http://schemas.xmlsoap.org/wsdl/mime/", "part");
   QName QNAME_MIME_XML = new QName("http://schemas.xmlsoap.org/wsdl/mime/", "mimeXml");
}
